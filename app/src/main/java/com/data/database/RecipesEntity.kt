package com.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.elchinasgarov.models.FoodRecipe

@Entity(tableName = "recipes_table")
class RecipesEntity(
    var foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}