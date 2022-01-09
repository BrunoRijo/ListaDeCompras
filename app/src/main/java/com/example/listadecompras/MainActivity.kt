package com.example.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listaDeCompras = Dados_ListadeCompras(this).getListaDeCompras()

        val recyclerView: RecyclerView = findViewById(R.id.rv_principal)
        recyclerView.adapter = ListaAdapter(listaDeCompras)
    }
}