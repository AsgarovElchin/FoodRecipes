package asgarov.elchin.foodrecipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import asgarov.elchin.foodrecipes.databinding.FragmentFoodJokeBinding


class FoodJokeFragment : Fragment() {
    private lateinit var binidng:FragmentFoodJokeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binidng = FragmentFoodJokeBinding.inflate(layoutInflater,container,false)
        return binidng.root
    }


}