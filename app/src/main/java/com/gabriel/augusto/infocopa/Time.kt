package com.gabriel.augusto.infocopa

class Time(
    var nome: String,
    var idTime: Int,
    var corTimePrimaria: Int,
    var corTimeSecundaria: Int
) {

    override fun toString(): String {
        return "nome: $nome, id: $idTime";
    }

}