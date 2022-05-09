package com.ahmet.kotlineticaret.service

import com.ahmet.kotlineticaret.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductAPI {

    // url =  https://raw.githubusercontent.com/atilsamancioglu/BTK23-DataSet/main/products.json

    @GET("atilsamancioglu/BTK23-DataSet/main/products.json")
    suspend fun getData(): Response<List<Product>>

}