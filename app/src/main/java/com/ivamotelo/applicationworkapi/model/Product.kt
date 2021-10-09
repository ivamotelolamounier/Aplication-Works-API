/**
 * Pacote responsável pelo mapeamento de retorno da API
 * A classe é do tipo 'data' para que seja possível o 'get' e o 'set' automáticamente
 * é utilizada uma 'serialização (@)' do tipo SerializeName
 * è realizado o mapeamento geral do objeto Json
 */

package com.ivamotelo.applicationworkapi.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id")
    val iD: String,

    @SerializedName("prname")
    val prName: String,

    @SerializedName("primage")
    val prImage: String,

    @SerializedName("prprice")
    val prPrice: String,
)