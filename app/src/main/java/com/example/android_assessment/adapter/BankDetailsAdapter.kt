package com.example.android_assessment.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android_assessment.fragment.AccountsFragment
import com.example.android_assessment.fragment.CardFragment

class BankDetailsAdapter(
    fragment: Fragment
): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> AccountsFragment()
            else -> CardFragment()
        }
    }
}