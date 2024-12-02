package com.example.android_assessment.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_assessment.ui.adapter.BankDetailsAdapter
import com.example.android_assessment.data.local.TabText
import com.example.android_assessment.databinding.FragmentBankBinding
import com.google.android.material.tabs.TabLayoutMediator

class BankFragment : Fragment() {
    private var binding: FragmentBankBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBankBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tobBarItems = listOf(
            TabText(index = 0, title = "Accounts"),
            TabText(index = 1, title = "Cards"),
        )

        binding?.uiViewPage?.adapter = BankDetailsAdapter(this)
        TabLayoutMediator(binding?.uiTabs!!, binding?.uiViewPage!!) { tab, position ->
            tab.text = tobBarItems[position].title
        }.attach()
    }
}
