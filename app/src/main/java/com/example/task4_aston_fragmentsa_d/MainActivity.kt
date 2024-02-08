package com.example.task4_aston_fragmentsa_d

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit


class MainActivity : AppCompatActivity(),
    FragmentA.NextButtonClickListener,
    FragmentB.NextButtonClickListener,
    FragmentB.BackButtonClickListener,
    FragmentC.NextButtonClickListener,
    FragmentC.BackButtonClickListener,
    FragmentD.BackButtonClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentByTag(FragmentA.FragmentA_TAG) == null) {
            supportFragmentManager.commit {
                val fragmentA = FragmentA.newInstance()
                replace(R.id.fragment_container, fragmentA, FragmentA.FragmentA_TAG)
                addToBackStack(FragmentA.FragmentA_TAG)
            }
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onNextButtonClickListenerAtoB() {
        supportFragmentManager.commit {
            val fragmentB = FragmentB.newInstance()
            replace(R.id.fragment_container, fragmentB, FragmentB.Fragment_B_TAG)
            addToBackStack(FragmentB.Fragment_B_TAG)
        }
    }

    override fun onNextButtonClickListenerBtoC(message: String) {
        supportFragmentManager.commit {
            val fragmentC = FragmentC.newInstance(message)
            replace(R.id.fragment_container, fragmentC, FragmentC.FragmentC_TAG)
                .addToBackStack(FragmentC.FragmentC_TAG)
        }
    }

    override fun OnBackButtonClickListenerBtoA() {
        supportFragmentManager.popBackStack()
    }

    override fun onBackButtonClickListenerCtoD() {
        supportFragmentManager.commit {
            val fragmentD = FragmentD.newInstance()
            replace(R.id.fragment_container, fragmentD, FragmentD.FragmentD_TAG)
                .addToBackStack(FragmentD.FragmentD_TAG)
        }
    }

    override fun onBackButtonClickListenerCtoA() {
        supportFragmentManager.popBackStack(FragmentA.FragmentA_TAG, 0)
    }

    override fun OnBackButtonClickListenerDtoB() {
        supportFragmentManager.popBackStack(FragmentB.Fragment_B_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        supportFragmentManager.commit {
            val fragmentB = FragmentB.newInstance()
            replace(R.id.fragment_container, fragmentB, FragmentB.Fragment_B_TAG)
            addToBackStack(FragmentB.Fragment_B_TAG)
        }
    }
}


