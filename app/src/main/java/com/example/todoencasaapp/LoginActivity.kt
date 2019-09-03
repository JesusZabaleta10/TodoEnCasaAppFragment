package com.example.todoencasaapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.b_registrar

class LoginActivity : AppCompatActivity() {

    var correo = ""
    var contraseña = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        b_login.setOnClickListener {

            if((et_correo.text.toString() == "") && (et_contraseña.text.toString() == "")){
                Toast.makeText(this, "Ingrese correo y contraseña", Toast.LENGTH_SHORT).show()
            }else if(et_correo.text.toString() == ""){
                Toast.makeText(this, "Ingrese correo electrónico", Toast.LENGTH_SHORT).show()
            }else if(et_contraseña.text.toString() == ""){
                Toast.makeText(this, "Ingrese contraseña", Toast.LENGTH_SHORT).show()
            }else if((et_correo.text.toString() == correo) && (et_contraseña.text.toString() == contraseña)){
                var intent = Intent(this@LoginActivity, MainActivity::class.java)
                //---------------- Envio de datos ----------------
                intent.putExtra("correo", correo)
                intent.putExtra("contraseña", contraseña)
                // ------------------------------------------------
                startActivityForResult(intent,5678)
                Toast.makeText(this, "Sesion Iniciada", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Correo o contraseña incorrecta", Toast.LENGTH_SHORT).show()
            }
        }

        b_registrar.setOnClickListener {
            var intent = Intent(this@LoginActivity, RegistroActivity::class.java)
            Toast.makeText(this, "Registro", Toast.LENGTH_SHORT).show()
            startActivityForResult(intent,1234)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1234 && resultCode == Activity.RESULT_OK){
             correo = data!!.extras.getString("correo")
             contraseña = data!!.extras.getString("contraseña")
        }

        if(requestCode == 5678 && resultCode == Activity.RESULT_CANCELED){
            finish()
        }
    }
}
