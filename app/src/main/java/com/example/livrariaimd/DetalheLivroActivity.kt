package com.example.livrariaimd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.livrariaimd.databinding.ActivityDetalheLivroBinding

class DetalheLivroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalheLivroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetalheLivroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val livro = intent.getParcelableExtra<Livro>("livro")
        if (livro != null) {
            binding.tvTituloLivro.text = livro.titulo
            binding.tvAnoLivro.text = "Autor: ${livro.autor}"
            binding.tvEditoraLivro.text = "Editora: ${livro.editora}"
            binding.tvIsbn.text = "ISBN: ${livro.isbn}"
            binding.tvDescricaoLivro.text = livro.descricao

            // Carregar imagem da capa com Glide
            Glide.with(this).load(livro.urlCapa).into(binding.ivCapaLivro)
        }

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }
}
