package com.example.listadecompras

import android.content.Context

class Dados_ListadeCompras(val context: Context) {

    //retorna a lista presente no documento strings
    fun getListaDeCompras(): Array<String> {
        return context.resources.getStringArray(R.array.itens_array)
    }
}