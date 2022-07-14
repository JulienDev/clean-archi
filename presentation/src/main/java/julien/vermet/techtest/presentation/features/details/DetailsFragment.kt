package julien.vermet.techtest.presentation.features.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.transition.ChangeBounds
import androidx.transition.TransitionInflater
import coil.load
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import julien.vermet.techtest.presentation.R
import julien.vermet.techtest.presentation.databinding.FragmentDetailsBinding
import julien.vermet.techtest.presentation.features.list.ListViewModel
import julien.vermet.techtest.presentation.model.getTransitionName
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val args: DetailsFragmentArgs by navArgs()
    private val viewModel: DetailsViewModel by viewModel { parametersOf(args.album) }
    private val binding by viewBinding(FragmentDetailsBinding::bind)
    private val imageView get() = binding.albumImage
    private val titleView get() = binding.albumTitle

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move).apply {
            sharedElementEnterTransition = this
            sharedElementReturnTransition = this
        }

        val album = viewModel.album
        imageView.transitionName = album.getTransitionName()
        imageView.load(album.url)
        titleView.text = album.title
    }

}