package com.gabriel.augusto.infocopa

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.gabriel.augusto.infocopa.databinding.FragmentJogadorBinding

class JogadorFragment : Fragment() {

    private var _binding: FragmentJogadorBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJogadorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments;

        if (bundle == null) {
            Log.d("impossivel", "eita")
            return
        }

        val args = JogadorFragmentArgs.fromBundle(bundle)

        val idJogador = args.idJogador

        println(idJogador)

        val db = DB(view.context, null);

        val jogador = db.getJogadorById(idJogador)

        val nome: TextView = view.findViewById(R.id.textView) as TextView
        val idadeJogador: TextView = view.findViewById(R.id.textView2) as TextView
        val posicao: TextView = view.findViewById(R.id.textView3) as TextView
        val titulos: TextView = view.findViewById(R.id.textView4) as TextView
        val clubes: TextView = view.findViewById(R.id.textView5) as TextView

        nome.setText(jogador.nomeJogador)
        idadeJogador.setText(jogador.idade)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}