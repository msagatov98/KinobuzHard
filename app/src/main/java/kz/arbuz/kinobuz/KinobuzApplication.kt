package kz.arbuz.kinobuz

import android.app.Application
import kz.arbuz.kinobuz.di.module
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class KinobuzApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KinobuzApplication)
            modules(module)
        }
    }
}