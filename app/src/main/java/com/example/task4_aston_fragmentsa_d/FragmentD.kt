package com.example.task4_aston_fragmentsa_d

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager


class FragmentD : Fragment(R.layout.fragment_d) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonToB = view.findViewById<Button>(R.id.buttonToB)

      buttonToB.setOnClickListener {
          (requireActivity() as? BackButtonClickListener)?.OnBackButtonClickListenerDtoB()
      }

    }

    companion object {
        const val FragmentD_TAG = "FragmentD_TAG"
        fun newInstance() = FragmentD()
    }


    interface BackButtonClickListener {
        fun OnBackButtonClickListenerDtoB()
    }
}