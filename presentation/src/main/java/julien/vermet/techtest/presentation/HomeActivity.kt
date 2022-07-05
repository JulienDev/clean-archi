package julien.vermet.techtest.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import julien.vermet.techtest.presentation.databinding.ActivityHomeBinding
import julien.vermet.techtest.presentation.extensions.viewBinding

class HomeActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityHomeBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}