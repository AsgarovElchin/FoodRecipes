package com.elchinasgarov.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.elchinasgarov.foodrecipes.R
import com.elchinasgarov.models.Result
import com.util.Constants
import kotlinx.android.synthetic.main.fragment_instructions.view.*


class InstructionsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_instructions, container, false)

        val args = arguments
        val myBundle : Result? = args?.getParcelable(Constants.RECIPE_RESULT_KEY)
        view.instructions_vebView.webViewClient = object : WebViewClient(){}
        val websiteUrl : String = myBundle!!.sourceUrl
        view.instructions_vebView.loadUrl(websiteUrl)
        return view
    }


}