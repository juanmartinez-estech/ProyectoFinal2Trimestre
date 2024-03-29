package com.example.proyectofinal2trimestre

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectofinal2trimestre.databinding.LoginBinding
import com.example.proyectofinal2trimestre.databinding.PopupOlvidarcontrasenaBinding

class LoginActivity : AppCompatActivity(){
    private lateinit var binding: LoginBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val misPreferencias = getSharedPreferences("myprefs", MODE_PRIVATE)
        val usersaved = misPreferencias.getString("user", "")
        val passaved = misPreferencias.getString("pass", "")
        val checkboxsaved = misPreferencias.getBoolean("chbox", false)



//      Si abres la aplicacion por primera vez (Nunca has introducido un usuario) entonces el placeholder del tvUsuario es "Usuario", al contrario seria el ultimo usuario introducido
        if (usersaved != null) {
            if (usersaved.isEmpty()){
                binding.tvUsuario.setText("")
            }else{
                binding.tvUsuario.setText(usersaved)
            }
        }


        binding.btLogin.setOnClickListener {
            val user = binding.tvUsuario.text.toString()
            val pass = binding.tvContrasena.text.toString()
            compruebaLogin(user, pass)

            val usersaved = misPreferencias.edit()
            usersaved.putString("user", user)
            usersaved.apply()

            val passsaved = misPreferencias.edit()
            passsaved.putString("pass", pass)
            passsaved.apply()

            if (binding.checkBox.isChecked){
                val checkboxsaved = misPreferencias.edit()
                checkboxsaved.putBoolean("chbox", true)
                checkboxsaved.apply()
            }
        }

        if (checkboxsaved == true){
            binding.tvContrasena.setText(passaved)
        }else{
            binding.tvContrasena.setText("")
        }

        binding.btOlvidarcontrasena.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            val dialogBinding = PopupOlvidarcontrasenaBinding.inflate(layoutInflater)
            builder.setView(dialogBinding.root)
            builder.setNegativeButton("Cancelar") { dialog, which ->
                Toast.makeText(this, "Se ha cancelado",
                    Toast.LENGTH_SHORT).show()
            }
            val dialog = builder.create()
            dialog.show()
        }


        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel: 953 636 000")
            }
            try {
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(this, "La aplicacion de Telefono no esta instalada", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun compruebaLogin(user: String, pass: String) {
        val misPreferencias = getSharedPreferences("myprefs", MODE_PRIVATE)
        val usersaved = misPreferencias.getString("user", "")
        val passaved = misPreferencias.getString("pass", "")

        var usuarioinvitado = "invitado"
        var passinvitado = "estech1234"
        var usuarioalumno = "alumno"
        var passalumno = "alumno1234"
        var usuarioprofesor = "profesor"
        var passprofesor = "profesor1234"

        if (user.isEmpty() && pass.isEmpty()) {
            binding.tvUsuario.error = "El campo está vacío"
            binding.tvContrasena.error = "El campo está vacío"
            return
        }

        if (user == usuarioinvitado && pass == passinvitado || user == usuarioalumno && pass == passalumno || user == usuarioprofesor && pass == passprofesor){
            val usersaved = misPreferencias.edit()
            usersaved.putString("user", user)
            usersaved.apply()

            val passsaved = misPreferencias.edit()
            passsaved.putString("user", pass)
            passsaved.apply()
          openNextScreen()
        }else{
            binding.tvUsuario.error = "El usuario o la contraseña es incorrecta"
            binding.tvContrasena.error = "El usuario o la contraseña es incorrecta"
            return
        }
        openNextScreen()
    }

    private fun openNextScreen(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}