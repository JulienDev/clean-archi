package julien.vermet.techtest.presentation.features.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import julien.vermet.techtest.presentation.R
import julien.vermet.techtest.presentation.databinding.FragmentDetailsBinding
import julien.vermet.techtest.presentation.features.list.ListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val binding by viewBinding(FragmentDetailsBinding::bind)
    private val args: DetailsFragmentArgs by navArgs()
    private val viewModel: DetailsViewModel by viewModel { parametersOf(args.album) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.detailsBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.detailsBack.text = viewModel.album.title
    }

}