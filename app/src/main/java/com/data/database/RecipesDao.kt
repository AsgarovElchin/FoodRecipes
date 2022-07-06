package com.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface RecipesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipesEntity: RecipesEntity)

    @androidx.room.Query("SELECT * FROM recipes_table ORDER BY id ASC")
    fun readRecipes(): kotlinx.coroutines.flow.Flow<List<RecipesEntity>>
}