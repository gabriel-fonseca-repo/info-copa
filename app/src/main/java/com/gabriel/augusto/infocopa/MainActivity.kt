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

            addJogador(1, "Raphinha", 1, "Taça de Portugal(2019), Taça da Liga de Portugal(18/19)",
                "Vitória SC, Sporting CP, Rennes, Leeds, Barcelona", 25, 0, "PD", "")
            addJogador(2, "Neymar", 1, "Copa do Brasil(2010), Libertadores(2011), Recopa Sulamericana(2012), Copa das Confederações(2013), Supercopa da Espanha(13/14), La Liga(14/15, 15/16), Copa do Rei(14/15, 15/16), Champions League(14/15), Supercopa da UEFA(15/16)", "Santos, Barcelona, Paris Saint-Germain", 30, 2, "PE", "")
            addJogador(3, "Vinícius Júnior", 1, "La Liga(19/20, 21/22), Supercopa da Espanha(19/20, 21/22), Copa do Mundo de Clubes(2019), Champions League(21/22), Supercopa da UEFA(22/23)", "Flamengo, Real Madrid", 22, 0, "PE", "")
            addJogador(4, "Richarlison", 1, "Copa América(2019)", "América-MG, Fluminense, Watford, Everton, Tottenham", 25, 0, "CA", "")

            addJogador(5, "Aleksandar Mitrović", 2, "Campeonato Sérvio(12/13), Campeonato Belga(13/14), Belgian Super Cup(14/15), EFL Championship(16/17, 21/22)", "Teleoptik, Partizan, RSC Anderlecht, Newcastle, Fulham", 28, 1, "CA", "")
            addJogador(6, "Dušan Vlahović", 2, "Campeonato Sérvio(16/17), Taça da Sérvia(15/16, 16/17), Coppa Italia Primavera(18/19)", "Partizan, Fiorentina, Juventus", 22, 0, "CA", "")
            addJogador(7, "Sergej Milinković-Savić", 2, "Taça da Sérvia(13/14), Coppa Italia(18/19), Supercoppa Italiana(17/18, 19/20)", "Vojvidina, KRC Genk, Lazio", 27, 1, "MEI", "")
            addJogador(8, "Dušan Tadić", 2, "Eredivisie(18/19, 20/21, 21/22), Copa da Holanda(18/19, 20/21), Supercopa da Holanda(2020)", "Vojvidina, FC Groningen, FC Twente, Southampton, Ajax", 33, 2, "PE", "")

            addJogador(9, "Xherdan Shaqiri", 3, "Liga da Suíça(09/10, 10/11, 11/12), Taça da Suíça(2010, 2012), DFB Pokal(12/13, 13/14), Bundesliga(12/13, 13/14, 14/15), Champions League(12/13, 18/19), Supercopa da UEFA(13/14, 19/20), Copa do Mundo de Clubes(2014, 2020), Premier League(20/21)", "FC Basel, Bayern Munchen, Inter, Stoke City, Liverpool, Olympique Lyon, Chicago", 31, 2, "PD", "")
            addJogador(10, "Granit Xhaka", 3, "Liga da Suíça(10/11, 11/12), Taça da Suíça(2012), FA Cup(2017, 2020), Community Shield(2018, 2021)", "FC Basel, Borussia M'gladbach, Arsenal", 30, 2, "MEI", "")
            addJogador(11, "Haris Seferović", 3, "Liga NOS(18/19), Supertaça de Portugal(2018, 2020), Coppa Italia Primavera(10/11)", "Grasshoppers, Fiorentina, Neuchâtel Xamax, Lecce, Novara Calcio, Real Sociedad, Frankfurt, Benfica, Galatasaray", 30, 2, "CA", "")
            addJogador(12, "Yann Sommer", 3, "Liga da Suíça(10/11, 11/12, 12/13, 13/14), Taça da Suíça(2007, 2012)", "FC Basel, FC Vaduz, Grasshoppers, Borussia M'gladbach", 33, 2, "GOL", "")

            addJogador(13, "Vincent Aboubakar", 4, "Liga NOS(17/18, 19/20), Taça de Portugal(2020), Supertaça de Portugal(2019), Campeonato Turco(16/17, 20/21), Taça da Turquia(20/21), Copa Africana(2017)", "Coton Sport, Valenciennes, Lorient, Porto, Besikmtas, Al-Nassr", 30, 2, "CA", "")
            addJogador(14, "André Onana", 4, "Eredivisie(18/19, 20/21, 21/22), Taça da Holanda(18/19, 20/21), Supertaça da Holanda(2020)", "Ajax, Inter", 26, 0, "GOL", "")
            addJogador(15, "André-Frank Zambo Anguissa", 4, "", "Coton Sport, Olympique Marseille, Fulham, Villareal, Napoli", 26, 0, "VOL", "")
            addJogador(16, "Eric Maxim Choupo-Moting", 4, "Ligue 1(18/19, 19/20), Coupe de Ligue(19/20), Coupe de France(19/20), Supercopa da França(19/20), Bundesliga(20/21, 21/22), Supercopa da Alemanha(21/22), Copa do Mundo de Clubes(2021)", "Hamburgo, Nurenberg, Mainz, Schalke, Stoke City, Paris Saint-Germain, Bayern Munchen", 33, 1, "CA", "")
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}