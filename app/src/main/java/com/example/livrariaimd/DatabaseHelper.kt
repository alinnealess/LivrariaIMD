package com.example.livrariaimd

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "books.db", null, 2) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            """
            CREATE TABLE books (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                titulo TEXT NOT NULL,
                autor TEXT NOT NULL,
                editora TEXT,
                isbn TEXT NOT NULL UNIQUE,
                descricao TEXT,
                imagem_url TEXT
            )
            """.trimIndent()
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS books")
        onCreate(db)
    }

    fun insertBook(
        titulo: String,
        autor: String,
        editora: String?,
        isbn: String,
        descricao: String?,
        imagemUrl: String?
    ): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("titulo", titulo)
            put("autor", autor)
            put("editora", editora)
            put("isbn", isbn)
            put("descricao", descricao)
            put("imagem_url", imagemUrl)
        }
        val result = db.insert("books", null, values)
        db.close()
        return result != -1L
    }

    fun listarTodosLivros(): List<Livro> {
        val db = readableDatabase
        val cursor = db.query(
            "books",
            arrayOf("id", "titulo", "autor", "editora", "descricao", "isbn", "imagem_url"),
            null,
            null,
            null,
            null,
            null
        )
        val livros = mutableListOf<Livro>()
        while (cursor.moveToNext()) {
            livros.add(
                Livro(
                    id = cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                    titulo = cursor.getString(cursor.getColumnIndexOrThrow("titulo")),
                    autor = cursor.getString(cursor.getColumnIndexOrThrow("autor")),
                    editora = cursor.getString(cursor.getColumnIndexOrThrow("editora")),
                    descricao = cursor.getString(cursor.getColumnIndexOrThrow("descricao")),
                    isbn = cursor.getString(cursor.getColumnIndexOrThrow("isbn")),
                    urlCapa = cursor.getString(cursor.getColumnIndexOrThrow("imagem_url"))
                )
            )
        }
        cursor.close()
        db.close()
        return livros
    }

    fun buscarLivroPorIsbn(isbn: String): Livro? {
        val db = readableDatabase
        val cursor = db.query(
            "books",
            arrayOf("id", "titulo", "autor", "editora", "descricao", "isbn", "imagem_url"),
            "isbn = ?",
            arrayOf(isbn),
            null,
            null,
            null
        )

        return if (cursor.moveToFirst()) {
            Livro(
                id = cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                titulo = cursor.getString(cursor.getColumnIndexOrThrow("titulo")),
                autor = cursor.getString(cursor.getColumnIndexOrThrow("autor")),
                editora = cursor.getString(cursor.getColumnIndexOrThrow("editora")),
                descricao = cursor.getString(cursor.getColumnIndexOrThrow("descricao")),
                isbn = cursor.getString(cursor.getColumnIndexOrThrow("isbn")),
                urlCapa = cursor.getString(cursor.getColumnIndexOrThrow("imagem_url"))
            )
        } else {
            null
        }.also { cursor.close() }
    }

    fun atualizarLivro(isbn: String, titulo: String, autor: String, editora: String, descricao: String, imagemUrl: String?): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("titulo", titulo)
            put("autor", autor)
            put("editora", editora)
            put("descricao", descricao)
            put("imagem_url", imagemUrl)
        }
        val rowsAffected = db.update("books", values, "isbn = ?", arrayOf(isbn))
        db.close()
        return rowsAffected > 0
    }

    fun excluirLivroPorIsbn(isbn: String): Boolean {
        val db = writableDatabase
        val rowsDeleted = db.delete("books", "isbn = ?", arrayOf(isbn))
        db.close()
        return rowsDeleted > 0
    }
}
