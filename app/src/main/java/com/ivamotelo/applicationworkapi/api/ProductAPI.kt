/**
 * Esta pacote terá uma anotação será o método utilizado no 'getdata.PHP' que recebe e envia
 * as informações através dos pacotes Json.
 * A função 'getProductApi, retorna o método 'Call', que é uma chamada da biblioteca 'retrofilt'
 * O retorno Json é feito dentro de um array de String, logo, é uma LISTA do tipo Json, oriunda
 * do 'Product', que é o Model do App
 *
 */
package com.ivamotelo.applicationworkapi.api

import com.ivamotelo.applicationworkapi.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductAPI {
    @GET("getdata.php")
    fun getProductApi(): Call<List<Product>>
}