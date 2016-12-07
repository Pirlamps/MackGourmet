package br.com.mack.bindingadapter;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import br.com.mack.R;

/**
 * Created by Amor on 03/12/2016.
 */

public class BindingAdapters {

    @BindingAdapter({"bind:imageRecipe"})
    public static void loadRecipeImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.recipe_loading_img)
                .fit()
                .into(view);
    }

    @BindingAdapter({"bind:imageChef"})
    public static void loadChefImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.chef_loading_img)
                .fit()
                .into(view);
    }

    @BindingAdapter({"bind:imageRestaurant"})
    public static void loadRestaurantImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.placeholder_restaurant_img)
                .fit()
                .into(view);
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .fit()
                .into(view);
    }
}
