package br.com.mack.activities;


import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import br.com.mack.R;
import br.com.mack.concepts.ConceptFragment;
import br.com.mack.databinding.ActivityMainBinding;
import br.com.mack.chefs.ChefFragment;
import br.com.mack.recipes.RecipeFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                return replaceFragment(item);
            }
        });

    }

    public boolean replaceFragment(MenuItem item){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = null;
        switch(item.getItemId()){
            case R.id.action_concepts:
                fragment = new ConceptFragment();
                break;
            case R.id.action_recipes:
                fragment = new RecipeFragment();
                break;
            case R.id.action_chefs:
                fragment = new ChefFragment();
                break;
            case R.id.action_favorites:

                break;
            case R.id.action_more:

                break;

        }
        ft.replace(R.id.mainFragment, fragment);
        ft.commit();
        return true;
    }
}
