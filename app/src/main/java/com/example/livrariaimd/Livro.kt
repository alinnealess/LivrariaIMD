package com.example.livrariaimd

import android.os.Parcel
import android.os.Parcelable

data class Livro(
    val id: Int,
    val titulo: String,
    val autor: String,
    val editora: String?,
    val descricao: String?,
    val isbn: String,
    val urlCapa: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString(),
        parcel.readString(),
        parcel.readString() ?: "",
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(titulo)
        parcel.writeString(autor)
        parcel.writeString(editora)
        parcel.writeString(descricao)
        parcel.writeString(isbn)
        parcel.writeString(urlCapa)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Livro> {
        override fun createFromParcel(parcel: Parcel): Livro {
            return Livro(parcel)
        }

        override fun newArray(size: Int): Array<Livro?> {
            return arrayOfNulls(size)
        }
    }
}
