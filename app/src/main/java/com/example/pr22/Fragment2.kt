package com.example.pr22

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment() {
    private lateinit var Text: TextView
    private lateinit var Image: ImageView
    private lateinit var Descriptions: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment2, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Text = view.findViewById(R.id.textView)
        Image = view.findViewById(R.id.imageView)
        Descriptions = resources.getStringArray(R.array.array)
    }
    fun setDescription(buttonIndex: Int) {
        val description: String = Descriptions[buttonIndex]
        Text.text = description
        when (buttonIndex) {
            1 -> Image.setImageResource(R.drawable.ozy)
            2 -> Image.setImageResource(R.drawable.intel)
            3 -> Image.setImageResource(R.drawable.hdd)
        }
    }

}