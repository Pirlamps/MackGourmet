package br.com.mack.recipes;

import br.com.mack.utils.CustomScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Amor on 03/12/2016.
 */
@Module
public class RecipeModule {
    private final RecipeContract.View mView;

    public RecipeModule(RecipeContract.View mView){
        this.mView = mView;
    }

    @Provides
    @CustomScope
    RecipeContract.View provideRecipeContractView(){
        return this.mView;
    }

}
