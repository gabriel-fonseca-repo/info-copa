package com.gabriel.augusto.infocopa

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gabriel.augusto.infocopa.databinding.FragmentSelecaoBinding

class SelecaoFragment : Fragment() {

    private var _binding: FragmentSelecaoBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelecaoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments;

        if (bundle == null) {
            Log.d("impossivel", "eita")
            return
        }

        val args = SelecaoFragmentArgs.fromBundle(bundle)

        val db = DB(view.context, null);

        val jogadores = db.getJogadorByTime(args.idTime)
        val time = db.getTimeById(args.idTime)

        var button: Button;

        jogadores.forEach { e ->
            button = Button(view.context)
            with(button) {
                setOnClickListener {
                    findNavController().navigate(SelecaoFragmentDirections.escolherJogador(e.idJogador))
                }
                text = e.nomeJogador
                setBackgroundColor(view.context.getColor(time.corTimePrimaria))
                setTextColor(view.context.getColor(time.corTimeSecundaria))
            }
            binding.JogadorFragment.addView(button)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}