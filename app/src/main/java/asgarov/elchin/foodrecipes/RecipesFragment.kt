package asgarov.elchin.foodrecipes

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import asgarov.elchin.foodrecipes.databinding.FragmentRecipesBinding


class RecipesFragment : Fragment() {
  private lateinit var binding:FragmentRecipesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipesBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


}