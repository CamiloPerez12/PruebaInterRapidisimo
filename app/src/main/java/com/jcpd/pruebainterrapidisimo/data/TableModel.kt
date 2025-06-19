package com.jcpd.pruebainterrapidisimo.data

data class TableModel(
    val tableName : String,
    val primaryKey : String,
    val queryCreation : String,
    val batchSize : Int,
    val filter : String,
    val error: String?,
    val numberField : Int,
    val appMethod : String?,
    val updatedDateSync : String,
)

