package com.example.android_assessment.ui.acitivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.android_assessment.R
import com.example.android_assessment.databinding.ActivityMainBinding
import com.example.android_assessment.ui.fragment.BankFragment
import com.example.android_assessment.ui.fragment.HomeFragment
import com.example.android_assessment.ui.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {

    private val homeFragment by lazy { HomeFragment() }
    private val bankFragment by lazy { BankFragment() }
    private val profileFragment by lazy { ProfileFragment() }

    private var binding : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }
        setUpFragment()
        setUpBottomNavigation()
    }

    private fun setUpFragment() {
        changeFragment(homeFragment, "homeFragment")
    }

    private fun setUpBottomNavigation(){
        binding?.uiBottomNavigation?.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.navigation_home -> {
                    changeFragment(homeFragment,"homeFragment")
                }
                R.id.navigation_bank -> {
                    changeFragment(bankFragment,"bankFragment")
                }
                R.id.navigation_profile -> {
                    changeFragment(profileFragment,"profileFragment")
                }
            }
            true
        }
    }

    private fun changeFragment(
        fragment: Fragment?,
        fragmentTag: String?
    ) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val currentFragment: Fragment? = supportFragmentManager.primaryNavigationFragment
        if(currentFragment != null) fragmentTransaction.hide(currentFragment)
        var tempFragment: Fragment? = supportFragmentManager.findFragmentByTag(fragmentTag)
        if(tempFragment == null) {
            tempFragment = fragment
            tempFragment?.let {
                fragmentTransaction.add(R.id.uiFragmentContainer, tempFragment, fragmentTag)

            }
        } else {
            fragmentTransaction.show(tempFragment)
        }
        fragmentTransaction.setPrimaryNavigationFragment(tempFragment)
        fragmentTransaction.setReorderingAllowed(true)
        fragmentTransaction.commitAllowingStateLoss()
    }
}