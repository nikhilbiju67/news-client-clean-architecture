package com.kotlin.news_api

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.news_api.data.utils.Resource
import com.kotlin.news_api.databinding.FragmentNewsBinding
import com.kotlin.news_api.presentation.adapter.NewsAdapter
import com.kotlin.news_api.presentation.viewmodel.NewsViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsFragment : Fragment() {

    private lateinit var viewModel: NewsViewModel
    private lateinit var fragmentNewsBinding: FragmentNewsBinding;
    private lateinit var newsAdapter: NewsAdapter
    private var country = "us"
    private var page = 1;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentNewsBinding = FragmentNewsBinding.bind(view);
        viewModel = (activity as MainActivity).viewModal
        initRecyclerView();
        viewNewsList();
    }

    private fun viewNewsList() {
        viewModel.getNewsHeadLines(country, page)
        viewModel.newsHeadLines.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar();
                    response.data?.let {
                        newsAdapter.differ.submitList(it.articles)
                        newsAdapter.notifyDataSetChanged()
                    }
                }
                is Resource.Error->{
                    hideProgressBar();
                    response.message?.let {
                        Toast.makeText(activity,"An error occured",Toast.LENGTH_SHORT)
                    }
                }

                is Resource.Loading -> {
                    showProgressBar();
                }

                else -> {}
            }
        }
    }

    private fun initRecyclerView() {
        newsAdapter = NewsAdapter();
        fragmentNewsBinding.newsList.apply {
            adapter =(activity as MainActivity).newsAdapter;
            layoutManager = LinearLayoutManager(
                activity
            )
        }
    }

    private fun showProgressBar() {
        fragmentNewsBinding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        fragmentNewsBinding.progressBar.visibility = View.GONE
    }

}