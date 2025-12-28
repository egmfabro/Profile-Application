package com.example.profileapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment(R.layout.profile_fragment) {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val followButton = view.findViewById<Button>(R.id.buttonAction)
        val logoutButton = view.findViewById<Button>(R.id.buttonLogout)

        followButton.setOnClickListener {
            followButton.text = "Followed"
            (activity as? MainActivity)?.praise()
        }

        logoutButton.setOnClickListener {
            Toast.makeText(requireContext(), "Logging out...", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<TextView>(R.id.personalInformation).setOnClickListener {
            val personalInfo = getString(R.string.personalInfoDetail)
            (activity as? MainActivity)?.navigateToDetail(personalInfo)
        }

        view.findViewById<TextView>(R.id.notifications).setOnClickListener {
            (activity as? MainActivity)?.navigateToDetail("Notifications")
        }

        view.findViewById<TextView>(R.id.saved).setOnClickListener {
            (activity as? MainActivity)?.navigateToDetail("Saved Items")
        }

        view.findViewById<TextView>(R.id.following).setOnClickListener {
            (activity as? MainActivity)?.navigateToDetail("Following")
        }

        view.findViewById<TextView>(R.id.privacyPolicy).setOnClickListener {
            (activity as? MainActivity)?.navigateToDetail("Privacy Policy")
        }

        view.findViewById<TextView>(R.id.terms).setOnClickListener {
            (activity as? MainActivity)?.navigateToDetail("Terms and Conditions")
        }

        view.findViewById<TextView>(R.id.faq).setOnClickListener {
            (activity as? MainActivity)?.navigateToDetail("FAQ and Help")
        }
    }
}