package com.kotlin.news_api

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.kotlin.news_api.databinding.ActivityMainBinding
import com.kotlin.news_api.presentation.adapter.NewsAdapter
import com.kotlin.news_api.presentation.viewmodel.NewsViewModel
import com.kotlin.news_api.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var viewModal: NewsViewModel;

    @Inject
    lateinit var factory: NewsViewModelFactory;
    private lateinit var binding: ActivityMainBinding;
    @Inject
     lateinit var  newsAdapter: NewsAdapter
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
        viewModal = ViewModelProvider(this, factory).get(NewsViewModel::class.java)

    }
}