package login.dara.loginactivity

import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etUser: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        etUser = findViewById(R.id.etUser)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener() {
           var intent = Intent (this,WelcomePageActivity::class.java)
            startActivity(intent)
            val nUsername = etUser.text.toString()
            val nPassword = etPassword.text.toString()
            intent.putExtra("username",nUsername)
            intent.putExtra("password",nPassword)

            startActivity(intent)


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
            btnLogin.setOnClickListener {
                val username = etUser.text.toString()
                val password = etPassword.text.toString()
                // Implementasikan logika login Anda di sini
                println("Username: $username")
                println("Password: $password")

            }

        }
    }
}

