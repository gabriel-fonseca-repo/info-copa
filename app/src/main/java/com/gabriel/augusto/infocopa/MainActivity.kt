package com.gabriel.augusto.infocopa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gabriel.augusto.infocopa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = DB(this, null);

        db.addTime(1, getString(R.string.brazil))
        db.addTime(2, "Sérvia");
        db.addTime(3, "Suíça");
        db.addTime(4, "Camaroes");

        db.addJogador(1, "Brazil-10", 1)
        db.addJogador(2, "Brazil-11", 1)
        db.addJogador(3, "Brazil-12", 1)
        db.addJogador(4, "Brazil-13", 1)

        db.addJogador(1, "Sérvia-10", 2)
        db.addJogador(2, "Sérvia-11", 2)
        db.addJogador(3, "Sérvia-12", 2)
        db.addJogador(4, "Sérvia-13", 2)

        db.addJogador(1, "Suíça-10", 3)
        db.addJogador(2, "Suíça-11", 3)
        db.addJogador(3, "Suíça-12", 3)
        db.addJogador(4, "Suíça-13", 3)

        db.addJogador(1, "Camaroes-10", 4)
        db.addJogador(2, "Camaroes-11", 4)
        db.addJogador(3, "Camaroes-12", 4)
        db.addJogador(4, "Camaroes-13", 4)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}