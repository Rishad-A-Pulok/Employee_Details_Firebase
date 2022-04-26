package com.example.firebasepractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class EmployeeDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val id = arguments?.getString("id")
        if( id != null ){
            
        }
        return inflater.inflate(R.layout.fragment_employee_details, container, false)
    }
}