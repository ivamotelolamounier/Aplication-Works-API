/**
 * Toda RecyclerView possui um ADAPTER
 * Todos Adapter, possui obrigatóriamente um ViewHolder
 * Todos ViewHolder possui obrigatóriamente BinderHolder
 * Também é necessaŕio a criação de um layout para exibir os dados do adapter.
 * Para manipular IMAGENS, será utilizada a biblioteca framework de carregamento de imagens
 * em backgraound, sem interferir no funcionamento do APP .'glide'.
 *
 */
package com.ivamotelo.applicationworkapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ivamotelo.applicationworkapi.model.Product

class ProductAdapter(
    private val context: Context,
    private val productList: List<Product>,
) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false))

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = productList[position]
        holder.productName.text = item.prName
        holder.productPrice.text = item.prPrice
        Glide.with(context).load(item.prImage).into(holder.productImage)

    }

}

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val productImage: ImageView = itemView.findViewById(R.id.product_image)
    val productName: TextView = itemView.findViewById(R.id.product_name)
    val productPrice: TextView = itemView.findViewById(R.id.product_price)
}

