/**
 * Ciração e instanciamento das variáveis RecyclerView
 * Chamada do frameworks "RETROFIT", através do layoutManager
 * Cria-se uma função 'getData' para receber os dados oriundos do servidor remoto
 * Através da criação de uma variável retrofit do tipo 'Call', que recebe uma lista de
 * produtos da lista 'ProductApi', será criada uma FILA para exibição da mesma nos CardsView
 * Dentro da chamada 'Call', são criados dois métodos obrigatórios  'onResponse'  e 'onFailue'
 * para tratar as respostas positivas e as falhas de requisição
 */
package com.ivamotelo.applicationworkapi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ivamotelo.applicationworkapi.api.MyRetrofit
import com.ivamotelo.applicationworkapi.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerProducts: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerProducts = findViewById(R.id.recycler_products)
        recyclerProducts.layoutManager = LinearLayoutManager(this)
        getData()
    }

    private fun getData() {
        val call: Call<List<Product>> =
            MyRetrofit.instance?.productApi()?.getProductApi() as Call<List<Product>>
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                val adapter =
                    ProductAdapter(this@MainActivity, response.body()?.toList() as List<Product>)
                recyclerProducts.adapter = adapter
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}