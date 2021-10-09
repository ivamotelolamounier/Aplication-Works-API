/**
 * "RETROFIT", é um framework desenvolvido pela Square, que possibilidade conexões em APIs
 * orientadas ao protocolo HTTPS
 * a notação '@get:Synchronized', é utilizada para fazer uma requisição em segundo plano
 * onde será verificado se a mesma é nula. se nula, então irá receber o proṕrio Retrofit()
 * caso não seja nulo, então retorna a variável myRetorfit, que será a instância da val
 * "instance".
 * Isso feito, o 'init' converterá o Json para a classe 'Product' do app, possibilitando que
 * os dados sejam manipulados pela RecyclerView, pela lista criada na função 'getProductApi()'
 * na Interface "ProductAPI"
 *
 */
package com.ivamotelo.applicationworkapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {
    private val retrofit: Retrofit
    fun productApi(): ProductAPI {
        return retrofit.create(ProductAPI::class.java)
    }

    companion object {
        private const val BASE_URL =
            "https://uniqueandrocode.000webhostapp.com/hiren/androidtutorial/mycart/"

        var myRetrofit: MyRetrofit? = null

        @get:Synchronized
        val instance: MyRetrofit?
            get() {
                if (myRetrofit == null) {
                    myRetrofit = MyRetrofit()
                }
                return myRetrofit
            }
    }

    init {
        retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}