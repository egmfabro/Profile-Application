package com.example.profileapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment(R.layout.profile_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val followButton = view.findViewById<Button>(R.id.buttonAction)
        val logoutButton = view.findViewById<Button>(R.id.buttonLogout)

        followButton.setOnClickListener {
            followButton.text = "Following"
            (activity as? MainActivity)?.praise()
        }

        logoutButton.setOnClickListener {
            Toast.makeText(requireContext(), "Logging out...", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<TextView>(R.id.personalInformation).setOnClickListener {
            val personalInfo = getString(R.string.personal_info_detail)
            (activity as? MainActivity)?.navigateToDetail(personalInfo)
        }

        view.findViewById<TextView>(R.id.notifications).setOnClickListener {
            (activity as? MainActivity)?.navigateToDetail("Notifications")
        }
    }
}