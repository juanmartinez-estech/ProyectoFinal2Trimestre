package com.example.proyectofinal2trimestre

import android.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.proyectofinal2trimestre.databinding.AyudaLayoutBinding


class AyudaFragment : Fragment() {

    private lateinit var binding: AyudaLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AyudaLayoutBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botonmaps.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("geo:38.09434215597427, -3.6312645311104648?z=16&q=38.09434215597427, -3.6312645311104648(Linares)")
            )
            intent.setClassName(
                "com.google.android.apps.maps",
                "com.google.android.maps.MapsActivity"
            )
            startActivity(intent)
        }




//        binding.botonemail1.setOnClickListener {
//            fun composeEmail(addresses: Array<String>, subject: String) {
//                val intent = Intent(Intent.ACTION_SENDTO).apply {
//                    data = Uri.parse("mailto: info@escuelaestech.es")
//                    putExtra(Intent.EXTRA_EMAIL, addresses)
//                    putExtra(Intent.EXTRA_SUBJECT, subject)
//                }
//                if (intent.resolveActivity(packageManager) != null) {
//                    startActivity(intent)
//                }
//            }
//        }


    }


}