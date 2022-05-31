package com.example.laboratornayaandroyd.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratornayaandroyd.databinding.FragmentPersonalAccountBinding
import com.example.laboratornayaandroyd.viewmodels.PersonalAccountViewModel

class PersonalAccountFragment : Fragment() {

    private lateinit var binding: FragmentPersonalAccountBinding

    private lateinit var tariffAdapter: TariffAdapter

    private val viewModel: PersonalAccountViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonalAccountBinding.inflate(inflater, container, false)

        tariffAdapter = TariffAdapter()
        val layoutManager = LinearLayoutManager(activity)
        binding.tariffRecyclerView.layoutManager = layoutManager
        binding.tariffRecyclerView.adapter = tariffAdapter

        viewModel.updateData()
        viewModel.tariffs.observe(viewLifecycleOwner) {
            tariffAdapter.tariffs = it
        }
        viewModel.balance.observe(viewLifecycleOwner) {
            binding.balance.text = it.balance.toString()
            binding.personalAccountId.text = it.accNum.toString()
            binding.nextPay.text = it.nextPay.toString()
        }
        viewModel.user.observe(viewLifecycleOwner) {
            val name: String = it.firstName + " " + it.lastName
            binding.userName.text = name
            binding.userAddress.text = it.address
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.updateData()
    }
}