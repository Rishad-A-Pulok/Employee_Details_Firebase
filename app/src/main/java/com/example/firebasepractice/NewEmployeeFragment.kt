package com.example.firebasepractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.firebasepractice.databinding.FragmentNewEmployeeBinding

class NewEmployeeFragment : Fragment() {
    private val viewModel: EmployeeViewModel by activityViewModels()
    private lateinit var binding: FragmentNewEmployeeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewEmployeeBinding.inflate(inflater, container, false)
        viewModel.errMsgLD.observe(viewLifecycleOwner){
            Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
        }
        binding.saveBtn.setOnClickListener {
            val name = binding.nameInputET.text.toString()
            val dept = binding.deptInputET.text.toString()
            val salary = binding.salaryInputET.text.toString()
            //TODO: Validate info
            val employee = Employee(
                name = name,
                department = dept,
                salary = salary.toDouble(),
            )
            viewModel.insertEmployee(employee){
                findNavController().popBackStack()
            }
        }
        return binding.root
    }
}