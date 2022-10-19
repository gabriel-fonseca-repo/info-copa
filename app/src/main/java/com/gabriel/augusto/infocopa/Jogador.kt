package com.gabriel.augusto.infocopa

class Jogador(
    var nomeJogador: String,
    var idJogador: Int,
    var idTime: Int,
    var idade: Int,
    var posicao: String,
    var participacoes: Int,
    var titulos: String,
    var clubes: String,
    var fotoJogador: String
) {

    override fun toString(): String {
        return "nome: $nomeJogador, id: $idJogador, idTime: $idTime, idade: $idade, posicao: $posicao, participacoes: $participacoes, titulos: $titulos, clubes: $clubes, fotoJogador: $fotoJogador";
    }

}