package com.example.livrariaimd

import LivroAdaptador
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livrariaimd.databinding.ActivityListagemBinding

class ListagemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListagemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListagemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperar dados do banco
        val dbHelper = DatabaseHelper(this)
        val livros = dbHelper.listarTodosLivros()

        // Configurar RecyclerView
        if (livros.isEmpty()) {
            Toast.makeText(this, "Nenhum livro encontrado.", Toast.LENGTH_SHORT).show()
        }
        if (livros.isNotEmpty()) {
            binding.rvLivros.layoutManager = LinearLayoutManager(this)
            binding.rvLivros.adapter = LivroAdaptador(livros) { livro ->
                val intent = Intent(this, DetalheLivroActivity::class.java)
                intent.putExtra("livro", livro)
                startActivity(intent)
            }
        } else {
            Toast.makeText(this, "Nenhum livro cadastrado!", Toast.LENGTH_SHORT).show()
        }

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }
}
