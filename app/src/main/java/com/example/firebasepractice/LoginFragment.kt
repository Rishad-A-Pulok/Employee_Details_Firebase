package com.example.firebasepractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.firebasepractice.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: EmployeeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel.authLD.observe(viewLifecycleOwner){
            if(it == EmployeeViewModel.Auth.AUTHENTICATED){
                findNavController().popBackStack()
            }
        }

        viewModel.errMsgLD.observe(viewLifecycleOwner){
            binding.errMsgTV.text = it
        }

        binding.logInBtn.setOnClickListener {
            val email = binding.emailET.text.toString()
            val password = binding.passET.text.toString()
            //TODO: Validate login credential
            viewModel.login(email, password)
        }
        return binding.root
    }
}