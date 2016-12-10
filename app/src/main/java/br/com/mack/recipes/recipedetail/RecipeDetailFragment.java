package br.com.mack.recipes.recipedetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.mack.databinding.FragmentRecipeDetailBinding;
import br.com.mack.valueobjects.Recipe;

/**
 * Created by Amor on 10/12/2016.
 */

public class RecipeDetailFragment extends Fragment {
    private FragmentRecipeDetailBinding binding;
    private Recipe recipe;
    public static final RecipeDetailFragment newInstance(Recipe recipe){
        RecipeDetailFragment f = new RecipeDetailFragment();
        Bundle bundle = new Bundle(1);
        bundle.putSerializable(Recipe.TAG, recipe);
        f.setArguments(bundle);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.recipe=(Recipe) getArguments().getSerializable(Recipe.TAG);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRecipeDetailBinding.inflate(inflater, container, false);
        binding.setRecipe(this.recipe);
        return binding.getRoot();

    }
}
