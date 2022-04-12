package com.guleryigitcan.beerexpert.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.guleryigitcan.beerexpert.R
import com.guleryigitcan.beerexpert.viewModel.BeerViewModel


class BeerDetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val beerViewModel by viewModels<BeerViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_beer_detail, container, false)

        val beerDetailPageImage=view.findViewById<ImageView>(R.id.beer_detailpage_image)
        val beerDetailPageName=view.findViewById<TextView>(R.id.beer_detailpage_beer_name)
        val beerDetailPageTagline=view.findViewById<TextView>(R.id.beer_detailpage_tagline)
        val beerDetailPageDescription=view.findViewById<TextView>(R.id.beer_detailpage_description)
        val beerDetailPageBrewerTips=view.findViewById<TextView>(R.id.beer_detailpage_brewer_tips)
        val beerDetailPageContributor=view.findViewById<TextView>(R.id.beer_detailpage_contributor)
        val backToListButton=view.findViewById<Button>(R.id.back_to_list_arrow)

        backToListButton.setOnClickListener {
            fragmentManager?.popBackStack()

        }
        val id=arguments?.getInt("id")

        if (id != null) {
            beerViewModel.getById(id)
        }

        beerViewModel.beerDetailList.observe(requireActivity()){list->
            Glide.with(requireContext())
                .load(list[0].image_url)
                .into(beerDetailPageImage)

            beerDetailPageName.text=list[0].name.toString()
            beerDetailPageTagline.text=list[0].tagline.toString()
            beerDetailPageDescription.text=list[0].description.toString()
            beerDetailPageBrewerTips.text=list[0].brewers_tips.toString()
            beerDetailPageContributor.text=list[0].contributed_by.toString()

        }

        return view
    }


}