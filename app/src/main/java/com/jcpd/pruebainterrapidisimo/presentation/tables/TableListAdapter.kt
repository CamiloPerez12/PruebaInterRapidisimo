package com.jcpd.pruebainterrapidisimo.presentation.tables

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jcpd.pruebainterrapidisimo.R
import com.jcpd.pruebainterrapidisimo.data.models.TableModel

class TableListAdapter(private val tableList: List<TableModel>) :
    RecyclerView.Adapter<TableListAdapter.TableViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.tables_item, parent, false)
        return TableViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        val currentItem = tableList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = tableList.size

    inner class TableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tableName: TextView = itemView.findViewById(R.id.tableName)
        private val primaryKey: TextView = itemView.findViewById(R.id.primaryKey)
        private val queryCreation: TextView = itemView.findViewById(R.id.queryCreation)
        private val batchSize: TextView = itemView.findViewById(R.id.batchSize)
        private val filter: TextView = itemView.findViewById(R.id.filter)
        private val error: TextView = itemView.findViewById(R.id.error)
        private val numberField: TextView = itemView.findViewById(R.id.numberField)
        private val appMethod: TextView = itemView.findViewById(R.id.appMethod)
        private val updatedDateSync: TextView = itemView.findViewById(R.id.updatedDateSync)



        fun bind(tableModel: TableModel) {
            tableName.text = tableModel.tableName
            primaryKey.text = tableModel.primaryKey
            queryCreation.text = tableModel.queryCreation
            batchSize.text = tableModel.batchSize.toString()
            filter.text = tableModel.filter
            error.text = tableModel.error
            numberField.text = tableModel.numberField.toString()
            appMethod.text = tableModel.appMethod
            updatedDateSync.text = tableModel.updatedDateSync

        }
    }
}