package br.com.mack.chefs;

import br.com.mack.utils.CustomScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Amor on 03/12/2016.
 */
@Module
public class ChefModule {
    private final ChefContract.View mView;

    public ChefModule(ChefContract.View mView){
        this.mView = mView;
    }

    @Provides
    @CustomScope
    ChefContract.View provideConceptContractView(){
        return this.mView;
    }
}
