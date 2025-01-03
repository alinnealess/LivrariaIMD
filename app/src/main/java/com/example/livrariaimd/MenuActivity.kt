package com.example.livrariaimd

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.livrariaimd.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    // Variável do Binding
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar o Binding
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar ação do botão "Cadastrar Livro"
        binding.btnAddBook.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }

        // Configurar ação do botão "Listar Livros"
        binding.btnListBooks.setOnClickListener {
            startActivity(Intent(this, ListagemActivity::class.java))
        }

        // Configurar ação do botão "Excluir Livro"
        binding.btnDeleteBook.setOnClickListener {
            startActivity(Intent(this, ExcluirLivroActivity::class.java))
        }

        // Configurar ação do botão "Atualizar Livro"
        binding.btnUpdateBook.setOnClickListener {
            startActivity(Intent(this, AlterarLivroActivity::class.java))
        }
    }
}
