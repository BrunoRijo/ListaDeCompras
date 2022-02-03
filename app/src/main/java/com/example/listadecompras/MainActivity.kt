package com.example.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listadecompras.model.ItemMercado

class MainActivity : AppCompatActivity() {

    private var adapter = ListaAdapter()
    private val listadeCompras : RecyclerView by lazy{
        findViewById(R.id.rv_principal)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setBindView()
        updateList()
    }

    private fun setBindView() {
        listadeCompras.adapter = adapter
        listadeCompras.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList(){
        adapter.updateList(
            arrayListOf(
                ItemMercado("Arroz", 10),
                ItemMercado("Feijão", 10),
                ItemMercado("Batata", 10)
            )
        )
    }
}