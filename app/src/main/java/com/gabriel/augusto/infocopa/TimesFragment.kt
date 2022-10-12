package com.gabriel.augusto.infocopa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gabriel.augusto.infocopa.databinding.FragmentTimeBinding

class TimesFragment : Fragment() {

    private var _binding: FragmentTimeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonBrazil.setOnClickListener {
            findNavController().navigate(TimesFragmentDirections.escolherTime(1))
        }
        binding.buttonServia.setOnClickListener {
            findNavController().navigate(TimesFragmentDirections.escolherTime(2))
        }
        binding.buttonSuica.setOnClickListener {
            findNavController().navigate(TimesFragmentDirections.escolherTime(3))
        }
        binding.buttonCamaroes.setOnClickListener {
            findNavController().navigate(TimesFragmentDirections.escolherTime(4))
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}