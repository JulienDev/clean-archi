package julien.vermet.techtest.presentation.features.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import julien.vermet.techtest.designsystem.AlbumListItemView
import julien.vermet.techtest.designsystem.EmptyViewModel
import julien.vermet.techtest.designsystem.gone
import julien.vermet.techtest.designsystem.utils.GridSpacingDecoration
import julien.vermet.techtest.designsystem.visible
import julien.vermet.techtest.presentation.R
import julien.vermet.techtest.presentation.arch.EventObserver
import julien.vermet.techtest.presentation.databinding.FragmentAlbumsListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class AlbumsListFragment : Fragment(R.layout.fragment_albums_list) {

    private val viewModel: ListViewModel by viewModel()
    private val binding by viewBinding(FragmentAlbumsListBinding::bind)
    private val recyclerView get() = binding.listRecyclerview
    private val emptyView get() = binding.listEmptyview
    private lateinit var adapter: ListAlbumAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postponeEnterTransition()

        setupList()
        lifecycle.addObserver(viewModel)
        observeListState()
        observeNavigateToDetails()
        emptyView.setOnRetryClickListener {
            viewModel.onRetryClick()
        }
    }

    private fun setupList() {
        adapter = ListAlbumAdapter(requireContext()) { album ->
            viewModel.onAlbumSelected(album)
        }
        recyclerView.post { startPostponedEnterTransition() }
        recyclerView.addItemDecoration(
            GridSpacingDecoration(requireContext(), R.dimen.albums_list_spacing)
        )
        recyclerView.adapter = adapter
    }

    private fun observeListState() {
        viewModel.listStateLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ListStateLoading -> {
                    emptyView.visible()
                    recyclerView.gone()
                    emptyView.setModel(EmptyViewModel(R.string.list_loading))
                }
                is ListStateReady -> {
                    emptyView.gone()
                    recyclerView.visible()
                    adapter.submitList(state.albums)
                }
                is ListStateError -> {
                    emptyView.visible()
                    recyclerView.gone()
                    emptyView.setModel(EmptyViewModel(R.string.list_error, showRetry = true))
                }
            }
        }
    }

    private fun observeNavigateToDetails() {
        viewModel.showAlbumDetailsEvent.observe(viewLifecycleOwner, EventObserver { album ->
            val action = AlbumsListFragmentDirections.actionHomeToDetails(album)
            val clickedAlbumImageView = requireView().findViewWithTag<View>(album)
            val extras = FragmentNavigatorExtras(clickedAlbumImageView to clickedAlbumImageView.transitionName)
            findNavController().navigate(action, extras)
        })
    }

}

