package br.com.mack.concepts;

import java.util.List;

import br.com.mack.valueobjects.Concept;

/**
 * Created by Amor on 03/12/2016.
 */

interface ConceptContract {

    interface View{
        void showConcepts(List<Concept> concepts);

        void showError(String message);

        void showComplete();
    }

    interface Presenter{
        void loadConcepts();
        void refreshConcepts();
    }
}
