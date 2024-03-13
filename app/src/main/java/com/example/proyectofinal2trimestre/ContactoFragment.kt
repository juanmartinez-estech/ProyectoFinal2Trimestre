package com.example.proyectofinal2trimestre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.proyectofinal2trimestre.databinding.ContactoLayoutBinding
import com.example.proyectofinal2trimestre.databinding.PlantillaLayoutBinding

class ContactoFragment : Fragment() {

    private lateinit var binding: ContactoLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ContactoLayoutBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){

    }

}