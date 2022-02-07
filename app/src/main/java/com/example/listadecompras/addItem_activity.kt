package com.example.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.listadecompras.model.ItemMercado

class addItem_activity : AppCompatActivity() {

    private var item : ItemMercado? = null

    companion object{
        const val EXTRA_ITEM: String = "EXTRA_ITEM"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        loadToolBar()
        getExtras()
        bindListeners()
        bindViews()
    }

    private fun loadToolBar(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar_add) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun getExtras(){
        item = intent.getParcelableExtra<ItemMercado>(EXTRA_ITEM)
    }

    private fun bindViews(){
        findViewById<TextView>(R.id.new_item_name).text = item?.name
        findViewById<TextView>(R.id.new_item_qtt).text = item?.qtd.toString()
    }

    private fun bindListeners() {
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}