package com.example.listadecompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listadecompras.model.ItemMercado
import androidx.appcompat.app.ActionBarDrawerToggle as ActionBarDrawerToggle1

class MainActivity : AppCompatActivity() {

    private var adapter = ListaAdapter()
    private val listadeCompras : RecyclerView by lazy{
        findViewById(R.id.rv_principal)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        initDrawer()
        setBindView()
        setListeners()
        updateList()

    }

    private fun initDrawer(){
        val drawable_Layout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toolbar = findViewById<Toolbar>(R.id.toolbar_main) as Toolbar
        setSupportActionBar(toolbar)
        showToast("Entrou na função initdrawer")

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
}