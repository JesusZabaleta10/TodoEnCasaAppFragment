package com.example.todoencasaapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.b_registrar
import kotlinx.android.synthetic.main.activity_login.et_contraseña
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        b_registrar.setOnClickListener {

            //------ Condiciones de contraseña -------------------
            if((et_correo2.text.toString() == "") || (et_contraseña2.text.toString() == "") || (et_repetir_contraseña.text.toString() == "")){
                Toast.makeText(this, "Hay campos sin llenar", Toast.LENGTH_SHORT).show()
            }else if((et_contraseña2.length() < 6)){
                Toast.makeText(this, "La contraseña no tiene los 6 caracteres mínimos", Toast.LENGTH_LONG).show()
            }
            else if(et_contraseña2.text.toString() != et_repetir_contraseña.text.toString()){
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show()
            }
            else{
                var intent = Intent(this@RegistroActivity, LoginActivity::class.java)
                //---------------- Envio de datos ----------------
                var correo = et_correo2.text.toString()
                var contraseña = et_contraseña2.text.toString()
                intent.putExtra("correo", correo)
                intent.putExtra("contraseña", contraseña)
                // ------------------------------------------------
                setResult(Activity.RESULT_OK,intent)
                Toast.makeText(this, "Te has registrado con éxito", Toast.LENGTH_LONG).show()
                finish()
            }
            //----------------------------------------------------
        }
    }
}
