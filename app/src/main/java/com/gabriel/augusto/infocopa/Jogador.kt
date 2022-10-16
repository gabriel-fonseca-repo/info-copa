package com.gabriel.augusto.infocopa

class Jogador(var nomeJogador: String, var idJogador: Int, var idTime: Int) {

    override fun toString(): String {
        return "nome: $nomeJogador, id: $idJogador, idTime: $idTime";
    }

}