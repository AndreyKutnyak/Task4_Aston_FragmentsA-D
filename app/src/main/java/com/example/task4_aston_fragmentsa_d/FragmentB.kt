package com.example.task4_aston_fragmentsa_d

import android.os.Bundle
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf

class FragmentB : Fragment(R.layout.fragment_b) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonToC = view.findViewById<Button>(R.id.buttonToC)
        val buttonBack = view.findViewById<Button>(R.id.buttonBack)

        buttonToC.setOnClickListener {
            (requireActivity() as? NextButtonClickListener)?.onNextButtonClickListenerBtoC("Hello Fragment C")

        }
       buttonBack.setOnClickListener {
            (requireActivity() as? BackButtonClickListener)?.OnBackButtonClickListenerBtoA()
        }
    }

    companion object {
        const val Fragment_B_TAG = "FRAGMENT_B_TAG"
        fun newInstance() = FragmentB()
    }

    interface NextButtonClickListener {
        fun onNextButtonClickListenerBtoC(message: String)
    }
    interface BackButtonClickListener {
        fun OnBackButtonClickListenerBtoA()
    }


}
