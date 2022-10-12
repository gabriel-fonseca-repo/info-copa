package com.gabriel.augusto.infocopa

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        println(args.idTime)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.escolher_jogador)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}