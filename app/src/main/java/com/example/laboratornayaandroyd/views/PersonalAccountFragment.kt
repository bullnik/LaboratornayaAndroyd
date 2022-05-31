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
import kotlinx.android.synthetic.main.fragment_personal_account.*

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
            val balance = "${it.balance} ₽"
            binding.balance.text = balance
            val ls = "ЛС ${it.accNum}"
            binding.personalAccountId.text = ls
            val toPay = "К оплате: ${it.nextPay} ₽"
            binding.nextPay.text = toPay
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