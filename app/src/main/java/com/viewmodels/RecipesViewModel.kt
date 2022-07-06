package com.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.util.Constants
import com.util.Constants.API_KEY
import com.util.Constants.QUERY_ADD_RECIPE_INFORMATION
import com.util.Constants.QUERY_API_KEY
import com.util.Constants.QUERY_DIET
import com.util.Constants.QUERY_FILL_INGREDIENTS
import com.util.Constants.QUERY_NUMBER
import com.util.Constants.QUERY_TYPE

class RecipesViewModel(
    application: Application
) : AndroidViewModel(application) {
    fun applyQuesries(): HashMap<String, String> {
        val queries: HashMap<String, String> = HashMap()
        queries[QUERY_NUMBER] = "50"
        queries[QUERY_API_KEY] = API_KEY
        queries[QUERY_TYPE] = "snack"
        queries[QUERY_DIET] = "vegan"
        queries[QUERY_ADD_RECIPE_INFORMATION] = "true"
        queries[QUERY_FILL_INGREDIENTS] = "true"

        return queries

    }
}