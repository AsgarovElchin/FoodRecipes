package com.data.network

import com.data.database.RecipesDao
import com.data.database.RecipesEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    val recipesDao: RecipesDao
) {
    suspend fun insertRecipes(recipesEntity: RecipesEntity) {
        recipesDao.insertRecipes(recipesEntity)
    }

    fun readDatabase(): Flow<List<RecipesEntity>> {
        return recipesDao.readRecipes()
    }
}