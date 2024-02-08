package com.example.task4_aston_fragmentsa_d

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment


class FragmentC : Fragment(R.layout.fragment_c) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonToD = view.findViewById<Button>(R.id.buttonToD)
        val buttonToA = view.findViewById<Button>(R.id.buttonToA)

        arguments?.let {
            view.findViewById<TextView>(R.id.textViewMessage).text =
                it.getString(KEY_EXTRA_MESSAGE).toString()

           buttonToD.setOnClickListener {
        (requireActivity() as? NextButtonClickListener)?.onBackButtonClickListenerCtoD()
           }

            buttonToA.setOnClickListener {
                (requireActivity() as? BackButtonClickListener)?.onBackButtonClickListenerCtoA()

            }
        }
    }

    companion object {
        private const val KEY_EXTRA_MESSAGE = "KEY_EXTRA_MESSAGE"
        const val FragmentC_TAG = "FRAGMENTC_TAG"
        fun newInstance(message: String) = FragmentC().apply {
            arguments = Bundle().apply {
                putString(KEY_EXTRA_MESSAGE, message)
            }
        }
    }

    interface NextButtonClickListener {
        fun onBackButtonClickListenerCtoD()
    }

    interface BackButtonClickListener{
    fun onBackButtonClickListenerCtoA()
}

}