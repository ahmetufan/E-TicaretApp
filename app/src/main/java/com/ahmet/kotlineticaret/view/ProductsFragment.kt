package com.ahmet.kotlineticaret.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.ahmet.kotlineticaret.R
import com.ahmet.kotlineticaret.model.Product
import com.ahmet.kotlineticaret.service.ProductAPI
import com.ahmet.kotlineticaret.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.fragment_products.*
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductsFragment : Fragment(),ProductAdapter.Listener {
    private val productViewModel:ProductViewModel by activityViewModels()
    private var productAdapter:ProductAdapter?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager=GridLayoutManager(activity?.baseContext,2)

        productViewModel.downloadlData()
        productViewModel.productLit.observe(viewLifecycleOwner, Observer {
            productAdapter= ProductAdapter(it,this)
            recyclerView.adapter=productAdapter
        })

    }

    override fun onItemClick(product: Product) {
    //Sepete Ekleme
        productViewModel.addToBasket(product)
    }


}