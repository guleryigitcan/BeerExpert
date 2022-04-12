package com.guleryigitcan.beerexpert.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.guleryigitcan.beerexpert.Comminicator
import com.guleryigitcan.beerexpert.databinding.ItemProductBinding
import com.guleryigitcan.beerexpert.model.BeerModel


class CustomBeerAdapter(private val list: List<BeerModel>,private val listener:Comminicator): RecyclerView.Adapter<CustomBeerAdapter.BeerViewHolder> (){

    private var listData: MutableList<BeerModel> = list as MutableList<BeerModel>

    inner class BeerViewHolder(private val binding: ItemProductBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener{

        fun bind(beer:BeerModel,index: Int){
            binding.beer=beer

            Glide.with(binding.beerListImage.context)
                .load(beer.image_url)
                .into(binding.beerListImage)

            binding.beerNameTextview.text=beer.name.toString()
            binding.beerTaglineTextview.text=beer.tagline.toString()
            binding.deleteButton.setOnClickListener {
                deleteItem(index)
            }



        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position=adapterPosition
            val id=listData[position].id
            if (position != RecyclerView.NO_POSITION) {
                if (id != null) {
                    listener.passData(id)
                }
            }
        }


    }

    fun deleteItem(index: Int){
        listData.removeAt(index)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        return BeerViewHolder(ItemProductBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        holder.bind(listData[position],position)
    }


    override fun getItemCount(): Int {
        return listData.size
    }



}