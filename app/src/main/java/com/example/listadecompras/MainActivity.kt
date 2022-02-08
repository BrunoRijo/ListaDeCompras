package com.example.listadecompras

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.edit
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listadecompras.interfaces.ClickItemMercadoListener
import com.example.listadecompras.model.ItemMercado
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import androidx.appcompat.app.ActionBarDrawerToggle as ActionBarDrawerToggle1

class MainActivity : AppCompatActivity(), ClickItemMercadoListener {

    private var adapter = ListaAdapter(this)
    private val listadeCompras : RecyclerView by lazy{
        findViewById(R.id.rv_principal)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        initDrawer()
        fecthListItems()
        setBindView()
        setListeners()
    }

    private fun fecthListItems() {
        var list = arrayListOf(
            ItemMercado("Arroz FecthList 1", 40),
            ItemMercado("Feijão FecthList 2", 15),
            ItemMercado("Batata FecthList 3", 4)
        )
        getInstanceSharedPreferences()?.edit {
            putString("Items", Gson().toJson(list))
        }
    }

    private fun getInstanceSharedPreferences(): SharedPreferences? {
        return getSharedPreferences("br.com.listadecompras.PREFERENCES", Context.MODE_PRIVATE)
    }

    private fun initDrawer(){
        val drawable_Layout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toolbar = findViewById<Toolbar>(R.id.toolbar_main) as Toolbar
        setSupportActionBar(toolbar)

        val toogle = ActionBarDrawerToggle1(this, drawable_Layout, toolbar, R.string.abrir, R.string.fechar)
        drawable_Layout.addDrawerListener(toogle)
        toogle.syncState()
    }

    private fun setListeners() {
        //startActivity(Intent(this, addItem_activity::class.java))
    }

    private fun setBindView() {
        listadeCompras.adapter = adapter
        listadeCompras.layoutManager = LinearLayoutManager(this)
        updateList()
    }

    private fun getListItems(): List<ItemMercado>{
        var list = getInstanceSharedPreferences()?.getString("Items", "[]")
        var formatType = object  : TypeToken<List<ItemMercado>>(){}.type
        return Gson().fromJson(list, formatType)
    }

    private fun updateList(){
        adapter.updateList(getListItems())
    }

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater :MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_item, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.edit_item -> {
                showToast("Clicou no editar")
                return true
            }

            R.id.delete_item -> {
                showToast("Clicou no Remover")
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun clickItemMercado(item: ItemMercado) {
        val intent = Intent(this, addItem_activity::class.java)
        intent.putExtra("EXTRA_ITEM", item)
        startActivity(intent)
    }
}