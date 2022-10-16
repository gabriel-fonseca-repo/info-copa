package com.gabriel.augusto.infocopa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

        var button: Button;

        val db = DB(view.context, null);

        val times = db.getTimes()

        times.forEach { e ->
            button = Button(view.context)
            with(button) {
                setOnClickListener {
                    findNavController().navigate(TimesFragmentDirections.escolherTime(e.idTime))
                }
                text = e.nome
                setBackgroundColor(view.context.getColor(e.corTimePrimaria))
                setTextColor(view.context.getColor(e.corTimeSecundaria))
            }
            binding.TimeFragment.addView(button)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}