package com.franlopez.mvpkotlin.view.home.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.franlopez.mvpkotlin.R
import com.franlopez.mvpkotlin.view.base.activity.BaseActivity
import com.franlopez.mvpkotlin.view.home.fragment.HomeFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.mainFragmentContainer, HomeFragment())
        transaction.commit()
    }
}
