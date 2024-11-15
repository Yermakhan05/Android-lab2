package com.example.celebrity.view.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.celebrity.databinding.FragmentCelebrityListBinding
import com.example.celebrity.model.datasource.ApiSource
import com.example.celebrity.model.entity.Celebrity
import com.example.celebrity.view.adapter.CelebrityAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class CelebrityListFragment : Fragment() {

    private var _binding: FragmentCelebrityListBinding? = null
    private val binding: FragmentCelebrityListBinding get() = _binding!!


    companion object {
        fun newInstance() = CelebrityListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCelebrityListBinding.inflate(inflater, container, false)
        return binding.root

    }

    private var adapter: CelebrityAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CelebrityAdapter()
        binding.recyclerView.adapter = adapter

        fetchData("andres")

        binding.search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                fetchData(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun fetchData(query: String) {
        ApiSource.instance.fetchCelebrityList(query).enqueue(object : Callback<List<Celebrity>> {
            override fun onResponse(call: Call<List<Celebrity>>, response: Response<List<Celebrity>>) {
                println("RetrofitRequest: ${response.body()}")

                val celebrityList = response.body()

                if (celebrityList != null) {
                    adapter?.submitList(celebrityList)
                }
            }

            override fun onFailure(call: Call<List<Celebrity>>, t: Throwable) {
                println("RetrofitRequest failed: $t")
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}