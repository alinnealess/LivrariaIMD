package com.example.livrariaimd

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.livrariaimd.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    // Variável do Binding
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar o Binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root) // Usar o layout inflado do Binding

        // Configuração do botão de login
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (username == "admin" && password == "admin") {
                Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
                // Navegar para a tela principal
                startActivity(Intent(this, MenuActivity::class.java))
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show()
            }
        }

        // Configuração do botão de cadastro
        binding.btnRegister.setOnClickListener {
            Toast.makeText(this, "Navegando para a tela de cadastro...", Toast.LENGTH_SHORT).show()
            // Navegar para a tela de cadastro (implementar futuramente)
            //startActivity(Intent(this, RegisterActivity::class.java))
        }

        // Configuração do texto "Esqueceu a senha?"
        binding.tvForgotPassword.setOnClickListener {
            Toast.makeText(this, "Redefinição de senha em breve!", Toast.LENGTH_SHORT).show()
            // Navegar para a tela de redefinição de senha (implementar futuramente)
            //startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }
}
