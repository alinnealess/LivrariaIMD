package com.example.livrariaimd

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.livrariaimd.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar o View Binding
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar o DatabaseHelper
        val dbHelper = DatabaseHelper(this)

        // Configurar o botão "Salvar Livro"
        binding.btnSalvar.setOnClickListener {
            val titulo = binding.etTitulo.text.toString().trim()
            val autor = binding.etAutor.text.toString().trim()
            val editora = binding.etEditora.text.toString().trim()
            val isbn = binding.etIsbn.text.toString().trim()
            val descricao = binding.etDescricao.text.toString().trim()
            val imagemUrl = binding.etImagemUrl.text.toString().trim()

            // Validação
            if (titulo.isNotBlank() && autor.isNotBlank() && isbn.isNotBlank() && imagemUrl.isNotBlank()) {
                // Verificar se o ISBN já existe
                val livroExistente = dbHelper.buscarLivroPorIsbn(isbn)
                if (livroExistente != null) {
                    // ISBN já existe
                    Toast.makeText(this, "ISBN já cadastrado!", Toast.LENGTH_SHORT).show()
                } else {
                    // Salvar os dados no banco de dados
                    val result = dbHelper.insertBook(titulo, autor, editora, isbn, descricao, imagemUrl)

                    if (result) {
                        Toast.makeText(this, "Livro salvo com sucesso!", Toast.LENGTH_SHORT).show()
                        finish() // Retorna para a tela anterior
                    } else {
                        Toast.makeText(this, "Erro ao salvar o livro!", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Preencha todos os campos obrigatórios!", Toast.LENGTH_SHORT).show()
            }
        }

        // Configurar o botão "Voltar"
        binding.btnVoltar.setOnClickListener {
            finish() // Retorna à tela anterior
        }
    }
}
