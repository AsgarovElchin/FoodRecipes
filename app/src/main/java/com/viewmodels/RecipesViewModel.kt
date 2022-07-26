package com.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.data.DataStoreRepository
import com.util.Constants
import com.util.Constants.API_KEY
import com.util.Constants.DEFAULT_DIET_TYPE
import com.util.Constants.DEFAULT_MEAL_TYPE
import com.util.Constants.QUERY_ADD_RECIPE_INFORMATION
import com.util.Constants.QUERY_API_KEY
import com.util.Constants.QUERY_DIET
import com.util.Constants.QUERY_FILL_INGREDIENTS
import com.util.Constants.QUERY_NUMBER
import com.util.Constants.QUERY_TYPE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    application: Application,
    private val dataStoreRepository: DataStoreRepository
) : AndroidViewModel(application) {

    private var mealType = DEFAULT_MEAL_TYPE
    private var dietType = DEFAULT_DIET_TYPE

    val readMealAndDietType = dataStoreRepository.readMealAndDietType

    fun saveMealAndDietType(mealType:String,mealTypeId:Int,dietType:String,dietTypeId:Int)=
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("slohs","$mealType")
            Log.d("slohs","$dietType")

            dataStoreRepository.saveMealAndDietType(mealType, mealTypeId, dietType, dietTypeId)
        }

    fun applyQuesries(): HashMap<String, String> {
        val queries: HashMap<String, String> = HashMap()

        viewModelScope.launch {
            readMealAndDietType.collect{value->
                Log.d("aloha","lololo+$value")
                mealType = value.selectedMealType
                dietType = value.selectedDietType
            }

        }
        queries[QUERY_NUMBER] = Constants.DEFAULT_RECIPES_NUMBER
        queries[QUERY_API_KEY] = API_KEY
        queries[QUERY_TYPE] = mealType
        queries[QUERY_DIET] = dietType
        queries[QUERY_ADD_RECIPE_INFORMATION] = "true"
        queries[QUERY_FILL_INGREDIENTS] = "true"

        return queries

    }
}