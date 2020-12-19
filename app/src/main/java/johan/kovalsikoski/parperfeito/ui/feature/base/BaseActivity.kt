package johan.kovalsikoski.parperfeito.ui.feature.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.LabelVisibilityMode.LABEL_VISIBILITY_SELECTED
import johan.kovalsikoski.parperfeito.R
import johan.kovalsikoski.parperfeito.databinding.ActivityBaseBinding
import johan.kovalsikoski.parperfeito.utils.extensions.gone
import johan.kovalsikoski.parperfeito.utils.extensions.reconfigureBottomNavigation
import johan.kovalsikoski.parperfeito.utils.extensions.visible

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigationView()
    }

    private fun setupNavigationView() {
        val navController = findNavController(R.id.host_fragment)

        binding.bottomNavigation.apply {
            setupWithNavController(navController)
            labelVisibilityMode = LABEL_VISIBILITY_SELECTED

            setOnNavigationItemSelectedListener { menuItem ->
                handleBottomNavigationItemClick(menuItem.title.toString())
                true
            }
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.searchFragment, R.id.announcementFragment -> {
                    showBottomNavigation()
                }
                else -> {
                    hideBottomNavigation()
                }
            }
        }

    }

    private fun handleBottomNavigationItemClick(itemName: String) {
        when (itemName) {
            "Anunciar" -> reconfigureBottomNavigation(R.id.announcementFragment)
            else -> reconfigureBottomNavigation(R.id.searchFragment)
        }
    }

    private fun showBottomNavigation() {
        binding.bottomNavigation.visible()
    }

    private fun hideBottomNavigation() {
        binding.bottomNavigation.gone()
    }

}
