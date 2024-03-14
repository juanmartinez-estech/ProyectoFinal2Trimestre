package com.example.proyectofinal2trimestre.Galeria

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.proyectofinal2trimestre.R
import com.example.proyectofinal2trimestre.databinding.GaeriaBinding

class GaeriaFragment : Fragment() {

    private lateinit var binding: GaeriaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = GaeriaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val imagen1 = GaeriaData(R.drawable.villacarrillvillanueva)
        val imagen2 = GaeriaData(R.drawable.villacarrillochurriana1)
        val imagen3 = GaeriaData(R.drawable.villacarrillochurriana)


//        val arrayImagenes = ArrayList<GaeriaData>()
//
//        arrayImagenes.add(imagen1)

        val listaImagenes = arrayListOf(imagen1, imagen2, imagen3)

        val adaptador = AdaptadorGaeria(listaImagenes)
        binding.viewPager2.adapter = adaptador
    }
}