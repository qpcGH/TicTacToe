package com.example.tictactoe

import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [PlayerWinPopUp.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlayerWinPopUp : DialogFragment() {

    private lateinit var tv: TextView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var data = arguments?.getString("data")
        var rootView: View =
            inflater.inflate(R.layout.fragment_player_win_pop_up, container, false)
        tv = rootView.findViewById(R.id.show)
        tv.text = data + " Won "
        return rootView
    }
}
