package com.gabriel.augusto.infocopa

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DB(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, NOMEDB, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {

        val query = ("CREATE TABLE " + TBTimes.TABLE_TIMES + " ("
                + TBTimes.ID_TIME_COL + " INTEGER PRIMARY KEY, " +
                TBTimes.NOME_TIME_COL + " TEXT)")

        val query2 = ("CREATE TABLE " + TBJogadores.TABLE_JOGADORES + " ("
                + TBJogadores.ID_JOGADOR_COL + " INTEGER PRIMARY KEY, " +
                TBJogadores.NOME_JOGADOR_COL + " TEXT," +
                TBJogadores.ID_TIME_COL + " INTEGER" + ")")

        db.execSQL(query)
        db.execSQL(query2)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TBJogadores.TABLE_JOGADORES)
        onCreate(db)
    }

    fun addTime(idTime: Int, nomeTime: String) {
        val values = ContentValues()

        values.put(TBTimes.NOME_TIME_COL, nomeTime)
        values.put(TBTimes.ID_TIME_COL, idTime)

        val db = this.writableDatabase

        db.insert(TBTimes.TABLE_TIMES, null, values)

        db.close()
    }

    fun addJogador(idJogador: Int, nomeJogador: String, idTime: Int) {
        val values = ContentValues()

        values.put(TBJogadores.ID_JOGADOR_COL, idJogador)
        values.put(TBJogadores.NOME_JOGADOR_COL, nomeJogador)
        values.put(TBJogadores.ID_TIME_COL, idTime)

        val db = this.writableDatabase

        db.insert(TBTimes.TABLE_TIMES, null, values)

        db.close()
    }

    companion object {

        private const val NOMEDB = "INFO_COPA"

        private const val DATABASE_VERSION = 1

    }

    object TBJogadores {

        const val TABLE_JOGADORES = "jogadores"

        const val ID_JOGADOR_COL = "id"

        const val NOME_JOGADOR_COL = "nome"

        const val ID_TIME_COL = "idTime"
    }

    object TBTimes {

        const val TABLE_TIMES = "times"

        const val ID_TIME_COL = "id"

        const val NOME_TIME_COL = "nomeTime"

    }
}