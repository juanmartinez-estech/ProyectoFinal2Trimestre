package com.example.proyectofinal2trimestre.Jugadores

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Jugador(
    var imagen: Int,
    var apodo: String,
    var posicion: String,
    var nombre: String,
    var apellidos: String,
    var fecha: String,
    var numero: Int,
    var peso: Int,
    var altura: Int,
    var observaciones: String,
) : Parcelable
