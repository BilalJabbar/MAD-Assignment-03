package com.usamacreation.assignment3implicit_intents

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.usamacreation.assignment3implicit_intents.databinding.FragmentCameraBinding
import java.util.*

class cameraFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    var binding: FragmentCameraBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflater?.let { FragmentCameraBinding.inflate(it, container, false) }

        binding!!.btn1.setOnClickListener(View.OnClickListener {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(intent)
        })

        // Inflate the layout for this fragment
        return binding!!.getRoot()
    }


}