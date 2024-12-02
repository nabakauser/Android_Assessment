package com.example.android_assessment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.android_assessment.R
import com.example.android_assessment.adapter.CardHeaderAdapter
import com.example.android_assessment.data.local.CardDetails
import com.example.android_assessment.databinding.FragmentHomeBinding
import com.google.android.material.button.MaterialButton

class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAccountCards()
    }

    private fun setUpAccountCards() {
        val cards = arrayListOf(
            CardDetails(
                index = 0,
                bankLogo = R.drawable.ic_qpay_wallet,
                bankCode = "QPay Balance",
                accBalance = "₹2,36,000.47",
                accNumber = "XXXXXXXXXXXX4536"
            ),
            CardDetails(
                index = 1,
                bankLogo = R.drawable.ic_sbi,
                bankCode = "SBI",
                bankName = "State Bank of India",
                accBalance = "₹2,36,000.47",
                accNumber = "XXXXXXXXXXXX4536"
            ),
            CardDetails(
                index = 2,
                bankLogo = R.drawable.ic_bob,
                bankCode = "BOB",
                bankName = "Bank of Baroda",
                accBalance = "₹2,13,000.47",
                accNumber = "XXXXXXXXXXXX4536"
            ),
            CardDetails(
                index = 3,
                bankLogo = R.drawable.ic_bank,
                bankCode = "Bank Name",
                accBalance = "₹0.00",
                accNumber = "XXXXXXXXXXXX4536"
            )
        )
        binding?.uiRvBank?.adapter = CardHeaderAdapter(
            cardDetails = cards,
            onCardHeaderClicked = { onCardHeaderClicked(selectedCard = it, cardDetails = cards) }
        )
    }

    private fun onCardHeaderClicked(
        selectedCard: CardDetails,
        cardDetails: List<CardDetails>
    ) {
        when(selectedCard.index) {
            cardDetails.first().index -> {
                binding?.uiGrpNewAccount?.visibility = View.GONE
                binding?.uiGrpBankDetails?.visibility = View.GONE
                binding?.uiGrpWallet?.visibility = View.VISIBLE
                binding?.uiBtnStatement?.visibility = View.VISIBLE
                binding?.uiBtnStatement?.text = "Add Money"
                binding?.uiBtnStatement?.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_add_money)
                binding?.uiBtnStatement?.iconGravity = MaterialButton.ICON_GRAVITY_TEXT_START
                binding?.uiBtnTransfer?.visibility = View.VISIBLE
            }
            cardDetails.last().index -> {
                binding?.uiGrpNewAccount?.visibility = View.VISIBLE
                binding?.uiGrpBankDetails?.visibility = View.GONE
                binding?.uiGrpWallet?.visibility = View.GONE
                binding?.uiBtnStatement?.visibility = View.GONE
                binding?.uiBtnTransfer?.visibility = View.GONE
            }
            else -> {
                binding?.uiGrpNewAccount?.visibility = View.GONE
                binding?.uiGrpBankDetails?.visibility = View.VISIBLE
                binding?.uiGrpWallet?.visibility = View.GONE
                binding?.uiTvBankText?.text = selectedCard.bankName
                binding?.uiBtnStatement?.visibility = View.VISIBLE
                binding?.uiBtnStatement?.text = "Statement"
                binding?.uiBtnStatement?.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_statement)
                binding?.uiBtnTransfer?.visibility = View.VISIBLE
            }
        }
    }
}