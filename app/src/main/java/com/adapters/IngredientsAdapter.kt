package com.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.elchinasgarov.foodrecipes.R
import com.elchinasgarov.models.ExtendedIngredient
import com.util.Constants
import com.util.RecipesDiffUtil
import kotlinx.android.synthetic.main.ingredients_item_list.view.*

class IngredientsAdapter:RecyclerView.Adapter<IngredientsAdapter.MyViewHolder>(){
    private var ingredientList = emptyList<ExtendedIngredient>()
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.ingredients_item_list,parent,false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.ingredient_imageView.load(Constants.BASE_IMAGE_URL+ingredientList[position].image){
            crossfade(600)
            error(R.drawable.error_placeholder)
        }
        holder.itemView.ingredient_name.text = ingredientList[position].name.capitalize()
        holder.itemView.ingredient_amount.text = ingredientList[position].amount.toString()
        holder.itemView.ingredient_unit.text = ingredientList[position].unit
        holder.itemView.ingredient_consistency.text = ingredientList[position].consistency
        holder.itemView.ingredient_original.text = ingredientList[position].original
    }

    override fun getItemCount(): Int {
        return ingredientList.size
    }

    fun setData(newIngredients:List<ExtendedIngredient>){
        val recipesDiffUtil = RecipesDiffUtil(ingredientList,newIngredients)
        val diffUtilResult = DiffUtil.calculateDiff(recipesDiffUtil)
        ingredientList = newIngredients
        diffUtilResult.dispatchUpdatesTo(this)
    }

}