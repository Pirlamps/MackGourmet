package br.com.mack.recipes;

import java.util.List;

import br.com.mack.valueobjects.Recipe;

/**
 * Created by Amor on 03/12/2016.
 */

interface RecipeContract {

    interface View{
        void showRecipes(List<Recipe> recipes);

        void showError(String message);

        void showComplete();
    }

    interface Presenter{
        void loadRecipes();
        void refreshRecipes();
    }
}
