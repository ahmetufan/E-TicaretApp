package com.ahmet.kotlineticaret.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmet.kotlineticaret.R
import com.ahmet.kotlineticaret.model.Product
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.basketrow.view.*

class BasketAdapter(val basketList:List<Product>):RecyclerView.Adapter<BasketAdapter.BasketHolder> (){
    class BasketHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.basketrow,parent,false)
        return BasketHolder(view)
    }

    override fun onBindViewHolder(holder: BasketHolder, position: Int) {
        holder.itemView.basketProductNameText.text=basketList[position].name
        holder.itemView.basketPriceText.text=basketList[position].price
        holder.itemView.basketCountText.text="Adet: ${basketList[position].count}"
        Glide.with(holder.itemView.context).load(basketList[position].url).into(holder.itemView.basketImageview)
    }

    override fun getItemCount(): Int {
        return basketList.size
    }
}