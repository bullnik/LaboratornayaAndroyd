package com.example.laboratornayaandroyd.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratornayaandroyd.databinding.ItemTariffBinding
import com.example.laboratornayaandroyd.models.Tariff

class TariffAdapter : RecyclerView.Adapter<TariffAdapter.TariffViewHolder>() {

    var tariffs: List<Tariff> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return tariffs.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TariffViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTariffBinding.inflate(inflater, parent, false)
        return TariffViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TariffViewHolder, position: Int) {
        val tariff = tariffs[position]
        with(holder.binding) {
            tariffCost.text = tariff.cost.toString()
            tariffDescription.text = tariff.desc
            tariffName.text = tariff.title
        }
    }

    class TariffViewHolder(
        val binding: ItemTariffBinding
    ): RecyclerView.ViewHolder(binding.root)
}