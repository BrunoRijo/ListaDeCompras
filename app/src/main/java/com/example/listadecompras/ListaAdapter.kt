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
import com.example.listadecompras.interfaces.ClickItemMercadoListener
import com.example.listadecompras.model.ItemMercado

class ListaAdapter(var listener:ClickItemMercadoListener)
    : RecyclerView.Adapter<ListaAdapter.ListaDeComprasViewHolder>()
{
    private val listaDeCompras : MutableList<ItemMercado> = mutableListOf()


    //Retorna uma nova ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaDeComprasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ListaDeComprasViewHolder(view, listaDeCompras, listener)
    }

    //Coloca os do item da lista na itemViews
    override fun onBindViewHolder(holder: ListaDeComprasViewHolder, position: Int) {
        holder.bind(listaDeCompras[position])
    }

    override fun getItemCount() = listaDeCompras.size

    //Função de passa uma lista de outra clase para dentro do adapter
    fun updateList(new_list: List<ItemMercado>){
        listaDeCompras.clear()
        listaDeCompras.addAll(new_list)
        notifyDataSetChanged()
    }

    class ListaDeComprasViewHolder(
        itemView: View,
        list: List<ItemMercado>,
        var listener: ClickItemMercadoListener) : RecyclerView.ViewHolder(itemView){

        private var nomeItem: TextView = itemView.findViewById(R.id.tv_item)
        private var qtdItem: TextView = itemView.findViewById(R.id.tv_qtdd)

        //Tornar o meu item clicável e com uma ação
        init{
            itemView.setOnClickListener(){
                listener.clickItemMercado(list[adapterPosition])
            }
        }

        fun bind(itemMercado : ItemMercado){
            nomeItem.text = itemMercado.name
            qtdItem.text = itemMercado.qtd.toString()
        }
    }


}