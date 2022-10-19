package com.gabriel.augusto.infocopa

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DB(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, NOMEDB, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {

    }

    fun init() {
        val query = ("CREATE TABLE " + TBTimes.TABLE_TIMES + " (" +
                TBTimes.ID_TIME_COL + " INTEGER PRIMARY KEY, " +
                TBTimes.NOME_TIME_COL + " TEXT, " +
                TBTimes.COR_TIME_PRIMARIA_COL + " INTEGER, " +
                TBTimes.COR_TIME_SECUNDARIA_COL + " INTEGER)")

        val query2 = ("CREATE TABLE " + TBJogadores.TABLE_JOGADORES + " (" +
                TBJogadores.ID_JOGADOR_COL + " INTEGER PRIMARY KEY, " +
                TBJogadores.NOME_JOGADOR_COL + " TEXT, " +
                TBJogadores.ID_TIME_COL + " INTEGER, " +
                TBJogadores.IDADE_JOGADOR_COL + " INTEGER, " +
                TBJogadores.PARTICIPACOES_COL + " INTEGER, " +
                TBJogadores.CLUBES_JOGADOR_COL + " TEXT, " +
                TBJogadores.TITULOS_JOGADOR_COL + " TEXT, " +
                TBJogadores.POS_JOGADOR_COL + " TEXT, " +
                TBJogadores.STRING_FOTO_COL + " TEXT)")

        val db = this.writableDatabase

        with(db) {
            execSQL("DROP TABLE IF EXISTS " + TBJogadores.TABLE_JOGADORES)
            execSQL("DROP TABLE IF EXISTS " + TBTimes.TABLE_TIMES)

            execSQL(query)
            execSQL(query2)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TBJogadores.TABLE_JOGADORES)
        db.execSQL("DROP TABLE IF EXISTS " + TBTimes.TABLE_TIMES)
        onCreate(db)
    }

    fun addTime(idTime: Int, nomeTime: String, corTimePrimaria: Int, corTimeScundaria: Int) {
        val values = ContentValues()

        values.put(TBTimes.NOME_TIME_COL, nomeTime)
        values.put(TBTimes.ID_TIME_COL, idTime)
        values.put(TBTimes.COR_TIME_PRIMARIA_COL, corTimePrimaria)
        values.put(TBTimes.COR_TIME_SECUNDARIA_COL, corTimeScundaria)

        val db = this.writableDatabase

        db.insert(TBTimes.TABLE_TIMES, null, values)

        db.close()
    }

    fun addJogador(idJogador: Int, nomeJogador: String, idTime: Int, titulos: String, clubes: String, idade: Int, participacoesCopa: Int, posicao: String, fotoJogador: String) {
        val values = ContentValues()

        values.put(TBJogadores.ID_JOGADOR_COL, idJogador)
        values.put(TBJogadores.NOME_JOGADOR_COL, nomeJogador)
        values.put(TBJogadores.ID_TIME_COL, idTime)
        values.put(TBJogadores.CLUBES_JOGADOR_COL, clubes)
        values.put(TBJogadores.IDADE_JOGADOR_COL, idade)
        values.put(TBJogadores.PARTICIPACOES_COL, participacoesCopa)
        values.put(TBJogadores.POS_JOGADOR_COL, posicao)
        values.put(TBJogadores.TITULOS_JOGADOR_COL, titulos)
        values.put(TBJogadores.STRING_FOTO_COL, fotoJogador)

        val db = this.writableDatabase

        db.insert(TBJogadores.TABLE_JOGADORES, null, values)

        db.close()
    }

    @SuppressLint("Range", "Recycle")
    fun getJogadorByTime(idTime: Int): Array<Jogador> {

        val db = this.readableDatabase

        var arrayJogadores = arrayOf<Jogador>()

        with(db) {
            val cursor = rawQuery(
                "SELECT * FROM " + TBJogadores.TABLE_JOGADORES + " WHERE " + TBJogadores.ID_TIME_COL + " = " + idTime,
                null
            )

            while (cursor.moveToNext()) {
                val jogador = Jogador(
                    cursor.getString(cursor.getColumnIndex(TBJogadores.NOME_JOGADOR_COL)),
                    cursor.getInt(cursor.getColumnIndex(TBJogadores.ID_JOGADOR_COL)),
                    cursor.getInt(cursor.getColumnIndex(TBJogadores.ID_TIME_COL)),
                    cursor.getInt(cursor.getColumnIndex(TBJogadores.IDADE_JOGADOR_COL)),
                    cursor.getString(cursor.getColumnIndex(TBJogadores.POS_JOGADOR_COL)),
                    cursor.getInt(cursor.getColumnIndex(TBJogadores.PARTICIPACOES_COL)),
                    cursor.getString(cursor.getColumnIndex(TBJogadores.TITULOS_JOGADOR_COL)),
                    cursor.getString(cursor.getColumnIndex(TBJogadores.CLUBES_JOGADOR_COL)),
                    cursor.getString(cursor.getColumnIndex(TBJogadores.STRING_FOTO_COL))

                )
                arrayJogadores = arrayJogadores.plus(jogador)
            }
        }
        db.close()

        return arrayJogadores

    }

    @SuppressLint("Range")
    fun getJogadorById(idJogador: Int): Jogador {

        val db = this.readableDatabase

        var arrayJogadores = arrayOf<Jogador>()

        with(db) {
            val cursor = rawQuery(
                "SELECT * FROM " + TBJogadores.TABLE_JOGADORES + " WHERE " + TBJogadores.ID_JOGADOR_COL + " = " + idJogador,
                null
            )

            while (cursor.moveToNext()) {
                val jogador = Jogador(
                    cursor.getString(cursor.getColumnIndex(TBJogadores.NOME_JOGADOR_COL)),
                    cursor.getInt(cursor.getColumnIndex(TBJogadores.ID_JOGADOR_COL)),
                    cursor.getInt(cursor.getColumnIndex(TBJogadores.ID_TIME_COL)),
                    cursor.getInt(cursor.getColumnIndex(TBJogadores.IDADE_JOGADOR_COL)),
                    cursor.getString(cursor.getColumnIndex(TBJogadores.POS_JOGADOR_COL)),
                    cursor.getInt(cursor.getColumnIndex(TBJogadores.PARTICIPACOES_COL)),
                    cursor.getString(cursor.getColumnIndex(TBJogadores.TITULOS_JOGADOR_COL)),
                    cursor.getString(cursor.getColumnIndex(TBJogadores.CLUBES_JOGADOR_COL)),
                    cursor.getString(cursor.getColumnIndex(TBJogadores.STRING_FOTO_COL))

                )
                arrayJogadores = arrayJogadores.plus(jogador)
            }
        }
        db.close()

        return arrayJogadores[0]
    }

    @SuppressLint("Range", "Recycle")
    fun getTimeByNome(nomeTime: String): Time {

        val db = this.readableDatabase

        val cursor = db.rawQuery(
            "SELECT * FROM " + TBTimes.TABLE_TIMES + " WHERE " + TBTimes.NOME_TIME_COL + " = " + nomeTime,
            null
        )

        var arrayTimes = arrayOf<Time>()

        while (cursor.moveToNext()) {
            val time = Time(
                cursor.getString(cursor.getColumnIndex(TBTimes.NOME_TIME_COL)),
                cursor.getInt(cursor.getColumnIndex(TBTimes.ID_TIME_COL)),
                cursor.getInt(cursor.getColumnIndex(TBTimes.COR_TIME_PRIMARIA_COL)),
                cursor.getInt(cursor.getColumnIndex(TBTimes.COR_TIME_SECUNDARIA_COL))
            )
            arrayTimes = arrayTimes.plus(time)
        }

        db.close()

        return arrayTimes[0]

    }

    @SuppressLint("Range")
    fun getTimeById(idTime: Int): Time {

        val db = this.readableDatabase

        val cursor = db.rawQuery(
            "SELECT * FROM " + TBTimes.TABLE_TIMES + " WHERE " + TBTimes.ID_TIME_COL + " = " + idTime,
            null
        )

        var arrayTimes = arrayOf<Time>()

        while (cursor.moveToNext()) {
            val time = Time(
                cursor.getString(cursor.getColumnIndex(TBTimes.NOME_TIME_COL)),
                cursor.getInt(cursor.getColumnIndex(TBTimes.ID_TIME_COL)),
                cursor.getInt(cursor.getColumnIndex(TBTimes.COR_TIME_PRIMARIA_COL)),
                cursor.getInt(cursor.getColumnIndex(TBTimes.COR_TIME_SECUNDARIA_COL))
            )
            arrayTimes = arrayTimes.plus(time)
        }

        db.close()

        return arrayTimes[0]

    }

    @SuppressLint("Range", "Recycle")
    fun getTimes(): Array<Time> {

        val db = this.readableDatabase

        var arrayTimes = arrayOf<Time>()

        val cursor = db.rawQuery("SELECT * FROM " + TBTimes.TABLE_TIMES, null)

        while (cursor.moveToNext()) {
            val time = Time(
                cursor.getString(cursor.getColumnIndex(TBTimes.NOME_TIME_COL)),
                cursor.getInt(cursor.getColumnIndex(TBTimes.ID_TIME_COL)),
                cursor.getInt(cursor.getColumnIndex(TBTimes.COR_TIME_PRIMARIA_COL)),
                cursor.getInt(cursor.getColumnIndex(TBTimes.COR_TIME_SECUNDARIA_COL))
            )
            arrayTimes = arrayTimes.plus(time)
        }

        db.close()

        return arrayTimes

    }


    companion object {

        private const val NOMEDB = "INFO_COPA"

        private const val DATABASE_VERSION = 1

    }

    object TBJogadores {

        const val TABLE_JOGADORES = "jogadores"

        const val ID_JOGADOR_COL = "idJogador"

        const val NOME_JOGADOR_COL = "nomeJogador"

        const val ID_TIME_COL = "idTime"

        const val POS_JOGADOR_COL = "posicao"

        const val TITULOS_JOGADOR_COL = "titulos"

        const val CLUBES_JOGADOR_COL = "clubes"

        const val IDADE_JOGADOR_COL = "idade"

        const val PARTICIPACOES_COL = "participacoes"

        const val STRING_FOTO_COL = "fotoJogador"
    }

    object TBTimes {

        const val TABLE_TIMES = "times"

        const val ID_TIME_COL = "idTime"

        const val NOME_TIME_COL = "nomeTime"

        const val COR_TIME_PRIMARIA_COL = "corTimePrimaria"

        const val COR_TIME_SECUNDARIA_COL = "corTimeSecundaria"

    }
}