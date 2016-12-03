package br.com.mack.concepts;

import br.com.mack.utils.CustomScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Amor on 03/12/2016.
 */
@Module
public class ConceptModule {
    private final ConceptContract.View mView;

    public ConceptModule(ConceptContract.View mView){
        this.mView = mView;
    }

    @Provides
    @CustomScope
    ConceptContract.View provideConceptContractView(){
        return this.mView;
    }
}
