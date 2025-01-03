package com.example.livrariaimd

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.livrariaimd.databinding.ActivityAlterarLivroBinding

class AlterarLivroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlterarLivroBinding
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar View Binding
        binding = ActivityAlterarLivroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar o banco de dados
        dbHelper = DatabaseHelper(this)

        // Configurar o botão de busca
        binding.btnBuscar.setOnClickListener {
            val isbn = binding.etIsbnBusca.text.toString().trim()

            if (isbn.isNotBlank()) {
                val livro = dbHelper.buscarLivroPorIsbn(isbn)

                if (livro != null) {
                    preencherCamposEdicao(livro)
                } else {
                    Toast.makeText(this, "Livro não encontrado!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Digite um ISBN válido!", Toast.LENGTH_SHORT).show()
            }
        }

        // Configurar o botão de salvar alterações
        binding.btnSalvar.setOnClickListener {
            val titulo = binding.etTitulo.text.toString().trim()
            val autor = binding.etAutor.text.toString().trim()
            val editora = binding.etEditora.text.toString().trim()
            val descricao = binding.etDescricao.text.toString().trim()
            val imagemUrl = binding.etImagemUrl.text.toString().trim()
            val isbn = binding.etIsbnBusca.text.toString().trim()

            if (titulo.isNotBlank() && autor.isNotBlank()) {
                if (dbHelper.atualizarLivro(isbn, titulo, autor, editora, descricao, imagemUrl)) {
                    Toast.makeText(this, "Livro atualizado com sucesso!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Erro ao atualizar o livro!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Preencha os campos obrigatórios!", Toast.LENGTH_SHORT).show()
            }
        }

        // Configurar o botão "Voltar"
        binding.btnVoltar.setOnClickListener {
            finish() // Retorna à tela anterior
        }
    }

    private fun preencherCamposEdicao(livro: Livro) {
        binding.etTitulo.setText(livro.titulo)
        binding.etAutor.setText(livro.autor)
        binding.etEditora.setText(livro.editora ?: "")
        binding.etDescricao.setText(livro.descricao ?: "")
        binding.etImagemUrl.setText(livro.urlCapa ?: "")

        // Tornar os campos de edição visíveis
        binding.etTitulo.visibility = View.VISIBLE
        binding.etAutor.visibility = View.VISIBLE
        binding.etEditora.visibility = View.VISIBLE
        binding.etDescricao.visibility = View.VISIBLE
        binding.etImagemUrl.visibility = View.VISIBLE
        binding.btnSalvar.visibility = View.VISIBLE
    }
}
