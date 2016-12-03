package br.com.mack.recipes;

import br.com.mack.data.component.NetComponent;
import br.com.mack.utils.CustomScope;
import dagger.Component;

/**
 * Created by Amor on 03/12/2016.
 */
@CustomScope
@Component(dependencies = NetComponent.class, modules = RecipeModule.class)
interface RecipeComponent {
    void inject(RecipeFragment fragment);
}
