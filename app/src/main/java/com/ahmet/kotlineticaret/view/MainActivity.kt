package com.ahmet.kotlineticaret.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.ahmet.kotlineticaret.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // url =  https://raw.githubusercontent.com/atilsamancioglu/BTK23-DataSet/main/products.json


/*
        val navController= findNavController(this,R.id.fragment)
        bottomNavigationView.setupWithNavController(navController)
 */
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)




    }
}