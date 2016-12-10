package br.com.mack.recipes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.Toast;

import br.com.mack.BR;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.mack.App;
import br.com.mack.R;
import br.com.mack.concepts.ConceptFragment;
import br.com.mack.databinding.FragmentRecipesBinding;
import br.com.mack.joat.JoatAdapter;
import br.com.mack.joat.JoatObject;
import br.com.mack.recipes.recipedetail.RecipeDetailFragment;
import br.com.mack.valueobjects.Recipe;

/**
 * Created by Amor on 03/12/2016.
 */

public class RecipeFragment extends Fragment implements RecipeContract.View, SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {

    JoatAdapter adapter;
    FragmentRecipesBinding binding;

    @Inject
    RecipePresenter recipePresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerRecipeComponent.builder()
                .netComponent(((App)getActivity().getApplicationContext()).getmNetComponent())
                .recipeModule(new RecipeModule(this))
                .build().inject(this);
        adapter = new JoatAdapter(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRecipesBinding.inflate(inflater,container,false);
        binding.listRefresh.setOnRefreshListener(this);
        binding.recipesList.setOnItemClickListener(this);
        recipePresenter.loadRecipes();
        return binding.getRoot();

    }

    @Override
    public void showRecipes(List<Recipe> recipes) {
        List<JoatObject>joatList = new ArrayList<>();
        for(Recipe item:recipes){
            joatList.add(new JoatObject(R.layout.row_recipe,BR.recipe,item,null));
        }
        adapter.setData(joatList);
        binding.recipesList.setAdapter(adapter);
        binding.recipesList.setDividerHeight(10);

    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        binding.listRefresh.setRefreshing(false);
    }

    @Override
    public void showComplete() {
        Toast.makeText(getActivity(), "Complete", Toast.LENGTH_SHORT).show();
        binding.listRefresh.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        recipePresenter.refreshRecipes();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Recipe item = (Recipe) ((JoatObject)adapter.getItem(position)).getBindingObject();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.mainFragment, RecipeDetailFragment.newInstance(item), "RecipeDetail");
        ft.addToBackStack("RecipeDetail");
        ft.commit();
    }
}
