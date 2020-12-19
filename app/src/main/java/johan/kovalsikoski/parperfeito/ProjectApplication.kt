package johan.kovalsikoski.parperfeito

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ProjectApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        loadModules()
    }

    private fun loadModules() {
        startKoin {
            androidContext(this@ProjectApplication)
            modules(

            )
        }
    }
}
