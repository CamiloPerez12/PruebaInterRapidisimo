package com.jcpd.pruebainterrapidisimo.data.models

import com.google.gson.annotations.SerializedName

data class TableModel(
    @SerializedName("NombreTabla") val tableName : String,
    @SerializedName("Pk") val primaryKey : String,
    @SerializedName("QueryCreacion") val queryCreation : String,
    @SerializedName("BatchSize") val batchSize : Int,
    @SerializedName("Filtro") val filter : String,
    @SerializedName("Error") val error: String?,
    @SerializedName("NumeroCampos") val numberField : Int,
    @SerializedName("MetodoApp") val appMethod : String?,
    @SerializedName("FechaActualizacionSincro") val updatedDateSync : String,
)

