package com.example.checkid.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.example.checkid.R
import com.example.checkid.databinding.ActivityMainBinding
import com.example.checkid.model.NotificationChannelManager.createNotificationChannel
import com.example.checkid.view.fragment.ReportFragment
import com.example.checkid.view.fragment.StatisticsFragment
import com.example.checkid.view.fragment.NotificationFragment
import com.example.checkid.view.dialogFragment.PermissionRequestDialogFragment
import com.example.checkid.view.fragment.EmptyFragment
import com.example.checkid.view.fragment.LoginFragment
import com.example.checkid.view.fragment.SettingsFragment
import com.example.checkid.viewmodel.LoginViewModel
import com.example.checkid.viewmodel.LoginViewModelFactory
import com.google.firebase.Firebase
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class ChildActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val database : FirebaseFirestore = Firebase.firestore
        val view = binding.root

        setContentView(view)

        if (false) {

        }

        else {
            replaceFragment(ReportFragment()) // 나중에 바꾸기
        }

        binding.bottomNavigationMenu.setOnItemSelectedListener {
            item -> when (item.itemId) {
                R.id.page_home -> replaceFragment(ReportFragment())
                R.id.page_statistics -> replaceFragment(StatisticsFragment())
                R.id.page_notification -> replaceFragment(NotificationFragment())
                R.id.page_setting -> replaceFragment(SettingsFragment())
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) : Boolean {
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.activity_main_FragmentContainerView, fragment)
            .commit()

        return true
    }
}