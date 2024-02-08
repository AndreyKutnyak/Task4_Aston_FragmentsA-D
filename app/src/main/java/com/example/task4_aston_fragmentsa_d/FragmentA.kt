package com.example.task4_aston_fragmentsa_d

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentA : Fragment(R.layout.fragment_a) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonToB = view.findViewById<Button>(R.id.buttonToB)

        buttonToB.setOnClickListener {
            (requireActivity() as? NextButtonClickListener)?.onNextButtonClickListenerAtoB()

        }
    }

    interface NextButtonClickListener {
        fun onNextButtonClickListenerAtoB()
    }

    companion object {
        const val FragmentA_TAG = "FragmentA_TAG"
        fun newInstance() = FragmentA()
    }
}