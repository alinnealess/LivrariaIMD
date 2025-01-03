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

        // Ordenar livros por título
        val livrosOrdenados = livros.sortedBy { it.titulo }

        // Configurar RecyclerView
        if (livrosOrdenados.isEmpty()) {
            Toast.makeText(this, "Nenhum livro encontrado.", Toast.LENGTH_SHORT).show()
        } else {
            binding.rvLivros.layoutManager = LinearLayoutManager(this)
            binding.rvLivros.adapter = LivroAdaptador(livrosOrdenados) { livro ->
                val intent = Intent(this, DetalheLivroActivity::class.java)
                intent.putExtra("livro", livro)
                startActivity(intent)
            }
        }

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }
}
