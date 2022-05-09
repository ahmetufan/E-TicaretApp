package com.ahmet.kotlineticaret.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ahmet.kotlineticaret.R
import com.ahmet.kotlineticaret.model.Product
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row.view.*

class ProductAdapter(val productList:List<Product>,private val listener:Listener):RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    class ProductHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return ProductHolder(view)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.itemView.productName.text=productList[position].name
        holder.itemView.productPrice.text=productList[position].price
        Glide.with(holder.itemView.context).load(productList[position].url).into(holder.itemView.productImage)

        holder.itemView.addBasketButton.setOnClickListener {
            Toast.makeText(it.context,"Sepete Eklendi ${productList[position].name}",Toast.LENGTH_SHORT).show()
            listener.onItemClick(productList.get(position))
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    interface Listener {
        fun onItemClick(product: Product)
    }
}