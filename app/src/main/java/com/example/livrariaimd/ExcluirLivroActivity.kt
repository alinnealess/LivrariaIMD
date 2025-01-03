package com.example.livrariaimd

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.livrariaimd.databinding.ActivityExcluirLivroBinding

class ExcluirLivroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExcluirLivroBinding
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar View Binding
        binding = ActivityExcluirLivroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar o helper de banco de dados
        dbHelper = DatabaseHelper(this)

        // Configurar botão "Excluir Livro"
        binding.btnExcluir.setOnClickListener {
            val isbn = binding.etIsbn.text.toString()

            if (isbn.isNotBlank()) {
                val resultado = dbHelper.excluirLivroPorIsbn(isbn)
                if (resultado) {
                    Toast.makeText(this, "Livro excluído com sucesso!", Toast.LENGTH_SHORT).show()
                    binding.etIsbn.text.clear() // Limpar o campo
                } else {
                    Toast.makeText(this, "Erro: Livro não encontrado!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Digite um ISBN válido!", Toast.LENGTH_SHORT).show()
            }
        }

        // Configurar botão "Voltar"
        binding.btnVoltar.setOnClickListener {
            finish() // Voltar para a tela anterior
        }
    }
}
