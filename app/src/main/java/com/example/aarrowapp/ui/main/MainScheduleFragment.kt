package com.example.aarrowapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aarrowapp.R

class MainScheduleFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_main_schedule, container, false)

    }

    companion object {

        private const val ARG_SECTION_NUMBER = "main_schedule_section_number"

        fun newInstance(sectionNumber: Int): MainScheduleFragment {
            //we are returning a fragment
            return MainScheduleFragment().apply {
                //applying our arguments as a bundle object to the fragment
                arguments = Bundle().apply {
                    //applying our key/value pair by invoking the putInt method and passing in the constant String value and section number
                    //this way the arguments from the bundle can ge passed when a new fragment is instantiated
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }

    }

}