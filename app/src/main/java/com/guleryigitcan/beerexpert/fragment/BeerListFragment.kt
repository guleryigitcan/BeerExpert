package com.guleryigitcan.beerexpert.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.guleryigitcan.beerexpert.Comminicator
import com.guleryigitcan.beerexpert.R
import com.guleryigitcan.beerexpert.adapter.CustomBeerAdapter
import com.guleryigitcan.beerexpert.viewModel.BeerViewModel


class BeerListFragment : Fragment(),Comminicator {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val beerViewModel by viewModels<BeerViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_beer_list, container, false)
        val recyclerView=view.findViewById<RecyclerView>(R.id.recycler_view_beer_list)
        beerViewModel.beerList.observe(requireActivity()){list->
            val adapter=CustomBeerAdapter(list,this@BeerListFragment)
            recyclerView.adapter=adapter

        }
        beerViewModel.getData()

        return view
    }

    //Passing id for detail page
    override fun passData(id: Int) {
        val bundle = Bundle()
        bundle.putInt("id", id)

        val transaction = this.parentFragmentManager.beginTransaction()
        val frag2 = BeerDetailFragment()
        frag2.arguments = bundle

        transaction.replace(R.id.fragmentContainerView,frag2)
        transaction.addToBackStack(null)
        transaction.commit()


    }


}