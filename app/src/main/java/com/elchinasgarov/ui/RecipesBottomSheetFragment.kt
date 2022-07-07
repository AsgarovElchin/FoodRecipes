package com.elchinasgarov.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elchinasgarov.foodrecipes.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class RecipesBottomSheetFragment : BottomSheetDialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes_bottom_sheet, container, false)
    }

}