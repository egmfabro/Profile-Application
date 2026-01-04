package com.example.profileapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProfileFragment : Fragment(R.layout.profile_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profileItems = listOf(
            ProfileItem(1, getString(R.string.personalInfo), R.drawable.icon_person),
            ProfileItem(2, getString(R.string.notifications), R.drawable.icon_notifications),
            ProfileItem(3, getString(R.string.saved), R.drawable.icon_saved),
            ProfileItem(4, getString(R.string.memories), R.drawable.icon_memories)
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.profileRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = ProfileAdapter(profileItems) { item ->
            when (item.id) {
                1 -> (activity as? MainActivity)?.navigateToDetail(getString(R.string.personalInfoDetail))
                2 -> (activity as? MainActivity)?.navigateToDetail(getString(R.string.notifications))
                3 -> (activity as? MainActivity)?.navigateToDetail(getString(R.string.saved))
                4 -> (activity as? MainActivity)?.navigateToDetail(getString(R.string.memories))
            }
        }

        val helpItems = listOf(
            ProfileItem(1, getString(R.string.privacyPolicy), R.drawable.icon_privacy),
            ProfileItem( 2, getString(R.string.terms), R.drawable.icon_terms),
            ProfileItem(3, getString(R.string.faqAndHelp), R.drawable.icon_faq)
        )

        val helpRecyclerView = view.findViewById<RecyclerView>(R.id.helpRecyclerView)
        helpRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        helpRecyclerView.adapter = ProfileAdapter(helpItems) { item ->
            when (item.id) {
                1 -> (activity as? MainActivity)?.navigateToDetail(getString(R.string.privacyPolicy))
                2 -> (activity as? MainActivity)?.navigateToDetail(getString(R.string.terms))
                3 -> (activity as? MainActivity)?.navigateToDetail(getString(R.string.faqAndHelp))
            }
        }

        val followButton = view.findViewById<Button>(R.id.buttonAction)
        val logoutButton = view.findViewById<Button>(R.id.buttonLogout)

        followButton.setOnClickListener {
            followButton.text = "Followed"
            (activity as? MainActivity)?.praise()
        }

        logoutButton.setOnClickListener {
            Toast.makeText(requireContext(), "Logging out...", Toast.LENGTH_SHORT).show()
        }

    }
}