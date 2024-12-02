package com.example.android_assessment.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_assessment.R
import com.example.android_assessment.data.remote.RecentTransactionModel

class TransactionsAdapter(
    private val context: Context,
    private val userDetails: MutableList<RecentTransactionModel?>
): RecyclerView.Adapter<TransactionsAdapter.TransactionsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recent_transactions_item_layout, parent, false)
        return TransactionsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userDetails.size
    }

    override fun onBindViewHolder(holder: TransactionsViewHolder, position: Int) {
        val user = userDetails[position]
        Glide.with(context)
            .load(user?.avatar_url)
            .into(holder.uiIvImages)
        holder.uiTvName.text = user?.login
    }

    inner class TransactionsViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var uiTvName: AppCompatTextView = view.findViewById(R.id.uiTvName)
        val uiIvImages: AppCompatImageView = view.findViewById(R.id.uiIvUserProfile)
    }
}