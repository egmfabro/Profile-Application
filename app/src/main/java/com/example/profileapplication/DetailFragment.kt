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
        if (message == getString(R.string.personal_info_detail)) {
            detailView.text = getText(R.string.personal_info_detail)
        } else {
            detailView.text = message
        }
    }
}