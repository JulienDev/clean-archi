package julien.vermet.techtest.presentation.features.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import julien.vermet.techtest.presentation.databinding.FragmentListBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import julien.vermet.techtest.presentation.R
import julien.vermet.techtest.presentation.arch.EventObserver
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment(R.layout.fragment_list) {

    private val binding by viewBinding(FragmentListBinding::bind)
    private val viewModel: ListViewModel by viewModel()
    private lateinit var adapter: ListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(viewModel)
        adapter = ListAdapter(requireContext()) { album ->
           viewModel.onAlbumSelected(album)
        }
        binding.listRecyclerview.adapter = adapter
        viewModel.albumsLiveData.observe(viewLifecycleOwner) { albums ->
            adapter.items = albums
        }
        viewModel.showAlbumDetailsEvent.observe(viewLifecycleOwner, EventObserver { album ->
            //findNavController().navigate(R.id.action_home_to_details)
            val action = ListFragmentDirections.actionHomeToDetails(album)
            findNavController().navigate(action)
        })
    }

}