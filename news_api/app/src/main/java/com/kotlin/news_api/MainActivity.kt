package com.kotlin.news_api

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.kotlin.news_api.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root);
        val navHostFragment = supportFragmentManager
            .findFragmentById(com.kotlin.news_api.R.id.fragmentContainerView) as NavHostFragment?
        if (navHostFragment != null) {
            binding.bnvNews.setupWithNavController(
                navHostFragment.findNavController()
            )
        }

    }
}