package com.usamacreation.assignment3implicit_intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.usamacreation.assignment3implicit_intents.databinding.FragmentCallBinding
import com.usamacreation.assignment3implicit_intents.databinding.FragmentCameraBinding

class callFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    var binding: FragmentCallBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflater?.let { FragmentCallBinding.inflate(it, container, false) }

        binding!!.btn2.setOnClickListener(View.OnClickListener {

            if(binding!!.numberBox.text.length==11)
            {
                val intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:" + binding!!.numberBox.text)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(context,"Please Enter Correct number", Toast.LENGTH_LONG).show()
            }

        })

        // Inflate the layout for this fragment
        return binding!!.getRoot()
    }


}