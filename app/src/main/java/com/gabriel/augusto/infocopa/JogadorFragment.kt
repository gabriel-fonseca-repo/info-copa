package com.gabriel.augusto.infocopa

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}