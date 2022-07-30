package com.elchinasgarov.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.adapters.IngredientsAdapter
import com.elchinasgarov.foodrecipes.R
import com.elchinasgarov.models.Result
import com.util.Constants
import kotlinx.android.synthetic.main.fragment_ingredients.view.*


class IngredientsFragment : Fragment() {
    private val mAdapter: IngredientsAdapter by lazy { IngredientsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ingredients, container, false)

        val args = arguments
        val myBundles: Result? = args?.getParcelable(Constants.RECIPE_RESULT_KEY)

        setUpRecyclerView(view)
        myBundles?.extendedIngredients?.let { mAdapter.setData(it) }
        return view
    }

    private fun setUpRecyclerView(view: View){
        view.ingredients_recyclerview.adapter = mAdapter
        view.ingredients_recyclerview.layoutManager = LinearLayoutManager(requireContext())
    }


}