package julien.vermet.techtest.presentation.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import julien.vermet.techtest.presentation.databinding.FragmentListBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import julien.vermet.techtest.presentation.R

class ListFragment : Fragment(R.layout.fragment_list) {

    private val binding by viewBinding(FragmentListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listNext.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_details)
        }
    }

}