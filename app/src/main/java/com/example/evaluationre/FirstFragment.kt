package com.example.evaluationre


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {
    private lateinit var sourceEditText: EditText
    private lateinit var countryEditText: EditText
    private lateinit var showNewsButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sourceEditText = view.findViewById(R.id.news_source_edit_txt)
        countryEditText = view.findViewById(R.id.country_edit_txt)
        showNewsButton = view.findViewById(R.id.show_news_button)

        showNewsButton.setOnClickListener {
            val source = sourceEditText.text.toString()
            val country = countryEditText.text.toString()

            //null check
            if (source.isNotEmpty() && country.isNotEmpty()) {
                val secondFragment = SecondFragment().apply {
                    arguments = Bundle().apply {
                        putString("source", source)
                        putString("country", country)
                    }
                }
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, secondFragment)
                    .addToBackStack(null)
                    .commit()
            } else {
                Toast.makeText(context, "Please enter both source and country", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
