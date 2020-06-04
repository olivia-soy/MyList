package net.soy.mylist

import android.app.Application
import org.koin.android.ext.android.startKoin

/**
 * Class: MyApplication
 * Created by leesoyoung on 2020/06/04.
 *
 * Description: Application class
 */
class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin(androidContext = applicationContext,
        modules = myDiModule)
    }
}