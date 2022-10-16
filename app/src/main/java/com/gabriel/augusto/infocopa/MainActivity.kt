package com.gabriel.augusto.infocopa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gabriel.augusto.infocopa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = DB(this, null);

        db.init()

        with(db) {
            addTime(1, "Brazil", R.color.brazilPrimary, R.color.brazilSecondary)
            addTime(2, "Sérvia", R.color.serviaPrimary, R.color.serviaSecondary)
            addTime(3, "Suíça", R.color.swissPrimary, R.color.swissSecondary)
            addTime(4, "Camaroes", R.color.camaroesPrimary, R.color.camaroesSecondary)

            addJogador(1, "Raphinha", 1)
            addJogador(2, "Neymar", 1)
            addJogador(3, "Vinícius Júnior", 1)
            addJogador(4, "Richarlison", 1)

            addJogador(5, "Aleksandar Mitrović", 2)
            addJogador(6, "Dušan Vlahović", 2)
            addJogador(7, "Sergej Milinković-Savić", 2)
            addJogador(8, "Dušan Tadić", 2)

            addJogador(9, "Xherdan Shaqiri", 3)
            addJogador(10, "Granit Xhaka", 3)
            addJogador(11, "Haris Seferović", 3)
            addJogador(12, "Yann Sommer", 3)

            addJogador(13, "Vincent Aboubakar", 4)
            addJogador(14, "André Onana", 4)
            addJogador(15, "André-Frank Zambo Anguissa", 4)
            addJogador(16, "Eric Maxim Choupo-Moting", 4)
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}