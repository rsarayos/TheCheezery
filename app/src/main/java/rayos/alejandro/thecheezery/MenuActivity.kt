package rayos.alejandro.thecheezery

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        var btnCold: Button = findViewById(R.id.button_cold_drinks) as Button
        var btnHot: Button = findViewById(R.id.button_hot_drinks) as Button
        var btnSweets: Button = findViewById(R.id.sweets) as Button
        var btnSalties: Button = findViewById(R.id.salties) as Button

        btnCold.setOnClickListener {
            abrirProductos("coldDrinks")
        }

        btnHot.setOnClickListener {
            abrirProductos("hotDrinks")
        }

        btnSweets.setOnClickListener {
            abrirProductos("sweets")
        }

        btnSalties.setOnClickListener {
            abrirProductos("salties")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun abrirProductos(categoria: String) {
        val intent = Intent(this, ProductosActivity::class.java)
        intent.putExtra("categoria", categoria)
        startActivity(intent)
    }

}