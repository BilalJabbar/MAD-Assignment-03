package com.usamacreation.assignment3implicit_intents

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.usamacreation.assignment3implicit_intents.databinding.FragmentCameraBinding
import com.usamacreation.assignment3implicit_intents.databinding.FragmentGalleryBinding

@Suppress("DEPRECATION")
class galleryFragment : Fragment() {
    private val pickImage = 100
    private var imageUri: Uri? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    var binding: FragmentGalleryBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflater?.let { FragmentGalleryBinding.inflate(it, container, false) }

        binding!!.btn1.setOnClickListener(View.OnClickListener {

            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            gallery.type = "image/*"
            startActivityForResult(gallery, pickImage)
        })


        // Inflate the layout for this fragment
        return binding!!.getRoot()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        var image=binding!!.image
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            image.setImageURI(imageUri)

        }
    }


}