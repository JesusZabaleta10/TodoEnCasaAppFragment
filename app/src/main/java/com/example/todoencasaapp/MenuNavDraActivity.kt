package com.example.todoencasaapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.widget.Toast

class MenuNavDraActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_nav_dra)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        val InicioFragment = InicioFragment()
        transaction.add(R.id.frameLayout, InicioFragment).commit()
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_nav_dra, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId){
            R.id.action_settings -> {
                var intent = Intent(this, LoginActivity::class.java) // Lanzar actividades o servicios
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        when (item.itemId) {
            R.id.nav_inicio -> {
                val inicioFragment = InicioFragment()
                transaction.replace(R.id.frameLayout, inicioFragment).commit()
            }
            R.id.nav_categorias -> {
                val categoriasFragment = CategoriasFragment()
                transaction.replace(R.id.frameLayout, categoriasFragment).commit()
            }
            R.id.nav_historial -> {
                val historialFragment = HistorialFragment()
                transaction.replace(R.id.frameLayout, historialFragment).commit()
            }
            R.id.nav_mi_cuenta -> {
                var intent = Intent(this, LoginActivity::class.java) // Lanzar actividades o servicios
                startActivity(intent)
                finish()
            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
