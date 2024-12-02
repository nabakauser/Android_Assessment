package com.example.android_assessment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_assessment.R
import com.example.android_assessment.data.local.CardDetails

class CardHeaderAdapter(
    private val cardDetails: List<CardDetails>,
    private val onCardHeaderClicked:(CardDetails) -> Unit,
): RecyclerView.Adapter<CardHeaderAdapter.CardHeaderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHeaderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_header_layout, parent, false)
        return CardHeaderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cardDetails.size
    }

    override fun onBindViewHolder(holder: CardHeaderViewHolder, position: Int) {
        val header = cardDetails[position]
        holder.uiIvBankLogo.setImageResource(header.bankLogo ?: 0)
        holder.uiTvBankName.text = header.bankCode
        holder.uiTvAccBalance.text = header.accBalance
    }

    inner class CardHeaderViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var uiIvBankLogo: ImageView = view.findViewById(R.id.uiIvWallet)
        var uiTvBankName: AppCompatTextView = view.findViewById(R.id.uiTvQpayWallet)
        var uiTvAccBalance: AppCompatTextView = view.findViewById(R.id.uiTvWalletBalance)
        private var uiCvAccount: CardView = view.findViewById(R.id.uiCvAccount)
        init {
            uiCvAccount.setOnClickListener {
                onCardHeaderClicked(cardDetails[adapterPosition])
            }
        }
    }
}