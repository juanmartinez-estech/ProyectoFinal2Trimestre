package com.example.proyectofinal2trimestre

import android.content.DialogInterface
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.text.format.DateFormat
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proyectofinal2trimestre.databinding.ActivityMainBinding
import com.example.proyectofinal2trimestre.databinding.HeaderLayoutBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHost
        navController = navHost.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.clasificacionFragment,
                R.id.plantillaFragment,
                R.id.gaeriaFragment,
                R.id.contactoFragment,
            ), binding.drawerlayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navigationview.setupWithNavController(navController)

        val headerBinding = HeaderLayoutBinding.inflate(layoutInflater)
        binding.navigationview.addHeaderView(headerBinding.root)

        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_superior, menu)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.bt_logout -> {
                        val builder = AlertDialog.Builder(this@MainActivity)
                        builder.setTitle("Mensaje del sistema")
                        builder.setMessage("¿Desea salir de la aplicación?")
                        builder.setPositiveButton("Si", DialogInterface.OnClickListener {
                                dialog, i ->
                            finish()
                        })
                        builder.setNeutralButton("Nada", { dialog, which ->
                            Toast.makeText(this@MainActivity, "Has elegido nada", Toast.LENGTH_SHORT).show()
                        })
                        builder.setNegativeButton("Cancelar", null)
                        val dialog = builder.create() //AlertDialog
                        dialog.show()
                        return true
                    }
                    else -> return false
                }
            }
        })


        val misPreferencias = getSharedPreferences("myprefs", MODE_PRIVATE)
        val usersaved = misPreferencias.getString("user", "")
        headerBinding.usuario.text = usersaved


        val df: SimpleDateFormat = SimpleDateFormat("dd/MM/yy")
        val calendario = Calendar.getInstance()
        val hora: String = df.format(calendario.time)
        headerBinding.hora.text = hora
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }
}