package julien.vermet.techtest.presentation.features.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import julien.vermet.techtest.designsystem.utils.GridSpacingDecoration
import julien.vermet.techtest.presentation.R
import julien.vermet.techtest.presentation.arch.EventObserver
import julien.vermet.techtest.presentation.databinding.FragmentAlbumsListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class AlbumsListFragment : Fragment(R.layout.fragment_albums_list) {

    private val binding by viewBinding(FragmentAlbumsListBinding::bind)
    private val viewModel: ListViewModel by viewModel()
    private lateinit var adapter: ListAlbumAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
        lifecycle.addObserver(viewModel)
        viewModel.albumsLiveData.observe(viewLifecycleOwner) { albums ->
            adapter.submitList(albums)
        }
        viewModel.showAlbumDetailsEvent.observe(viewLifecycleOwner, EventObserver { album ->
            val action = AlbumsListFragmentDirections.actionHomeToDetails(album)
            findNavController().navigate(action)
        })
    }

    private fun setupList() {
        adapter = ListAlbumAdapter(requireContext()) { album ->
            viewModel.onAlbumSelected(album)
        }
        binding.listRecyclerview.addItemDecoration(
            GridSpacingDecoration(requireContext(), R.dimen.albums_list_spacing)
        )
        binding.listRecyclerview.adapter = adapter
    }

}

