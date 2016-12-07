package br.com.mack.chefs;

import java.util.List;

import br.com.mack.valueobjects.Chef;

/**
 * Created by Amor on 03/12/2016.
 */

interface ChefContract {

    interface View{
        void showChefs(List<Chef> chefs);

        void showError(String message);

        void showComplete();
    }

    interface Presenter{
        void loadChefs();
        void refreshChefs();
    }
}
