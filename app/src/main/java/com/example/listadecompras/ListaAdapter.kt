package com.example.listadecompras
/*
 O Adapter cria objetos viewHolder dinamicamente, conforme a necessidade
 e associa os dados para a visualização deles. Esse processo se chama vinculação.
*/

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaAdapter (val listaDeCompras: Array<String>) :
    RecyclerView.Adapter<ListaAdapter.ListaDeComprasViewHolder>()
{
    class ListaDeComprasViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){

        private var nomeItem: TextView = itemView.findViewById(R.id.tv_item)

        fun bind(nome: String){
            nomeItem.text = nome

        }
    }

    //Retorna uma nova ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaDeComprasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ListaDeComprasViewHolder(view)
    }

    //Coloca os dados na posição correta da lista.
    override fun onBindViewHolder(holder: ListaDeComprasViewHolder, position: Int) {
        holder.bind(listaDeCompras[position])
    }

    override fun getItemCount(): Int {
        return listaDeCompras.size
    }
}