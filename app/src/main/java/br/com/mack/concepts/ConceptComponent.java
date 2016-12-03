package br.com.mack.concepts;

import br.com.mack.data.component.NetComponent;
import br.com.mack.utils.CustomScope;
import dagger.Component;

/**
 * Created by Amor on 03/12/2016.
 */
@CustomScope
@Component(dependencies = NetComponent.class, modules = ConceptModule.class)
public interface ConceptComponent {
    void inject(FragmentConcepts fragment);
}
