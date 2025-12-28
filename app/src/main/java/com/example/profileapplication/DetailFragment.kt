package com.example.profileapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment(R.layout.detail_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailView = view.findViewById<TextView>(R.id.detailTextView)
        val message = arguments?.getString("EXTRA_TEXT")
        if (message == getString(R.string.personalInfoDetail)) {
            detailView.text = getText(R.string.personalInfoDetail)
        } else {
            detailView.text = message
        }
    }
}