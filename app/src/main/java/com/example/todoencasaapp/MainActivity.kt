package com.example.todoencasaapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //------ Recibir datos ----------------------------
        var DatosRecibidos = intent.extras
        tv_correo.text = DatosRecibidos.getString("correo")
        tv_contraseña.text = DatosRecibidos.getString("contraseña")
        //-------------------------------------------------
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean { //Para que me muestre el icono como menú
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.menu_overflow -> {
                var intent = Intent(this, LoginActivity::class.java) // Lanzar actividades o servicios
                setResult(Activity.RESULT_OK,intent)
                Toast.makeText(this, "Sesion Cerrada", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        var intent = Intent(this, LoginActivity::class.java)
        Toast.makeText(this, "Gracias por usar nuestra app", Toast.LENGTH_SHORT).show()
        setResult(Activity.RESULT_CANCELED,intent)
        finish()
    }
}
