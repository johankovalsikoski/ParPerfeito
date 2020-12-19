package johan.kovalsikoski.parperfeito.ui.feature.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import johan.kovalsikoski.parperfeito.databinding.ActivitySplashBinding
import johan.kovalsikoski.parperfeito.ui.feature.base.BaseActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        startActivity(Intent(this, BaseActivity::class.java))
        finish()
    }
}
