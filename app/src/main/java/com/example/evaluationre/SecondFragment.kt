package com.example.evaluationre

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.evaluationre.recyclerview.NewsAdapter
import com.example.evaluationre.viewmodel.NewsViewModel

class SecondFragment : Fragment(), NewsAdapter.ItemClickListener
{
    private lateinit var recyclerView: RecyclerView
    private var mAdapter: NewsAdapter = NewsAdapter(this)
    private val viewModel by viewModels<NewsViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val source = arguments?.getString("source") ?: "empty"
        val country = arguments?.getString("country") ?: "empty"

//        viewModel= ViewModelProvider(requireActivity())[NewsViewModel::class.java]
        viewModel.fetchNews(source,country)

        viewModel.newsLiveData.observe(viewLifecycleOwner){
            mAdapter.updateData(it)
        }

        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.list_recycle_view)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
            adapter = mAdapter
        }
    }
    override fun onItemClick(view: View?, position: Int) {

    }
}