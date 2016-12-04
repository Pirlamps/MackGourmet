package br.com.mack.chefs;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.mack.App;
import br.com.mack.BR;
import br.com.mack.R;
import br.com.mack.databinding.FragmentChefsBinding;
import br.com.mack.joat.JoatAdapter;
import br.com.mack.joat.JoatObject;
import br.com.mack.valueobjects.Chef;

/**
 * Created by Amor on 02/12/2016.
 */

public class ChefFragment extends Fragment implements ChefContract.View{

    JoatAdapter adapter;
    FragmentChefsBinding binding;

    @Inject
    ChefPresenter chefPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerChefComponent.builder()
                .netComponent(((App)getActivity().getApplicationContext()).getmNetComponent())
                .chefModule(new ChefModule(this))
                .build().inject(this);
        adapter = new JoatAdapter(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentChefsBinding.inflate(inflater,container,false);
        chefPresenter.loadChefs();
        return binding.getRoot();

    }

    @Override
    public void showChefs(List<Chef> chefs) {
        List<JoatObject> joatList = new ArrayList<>();
        for (Chef item: chefs) {
            joatList.add(new JoatObject(R.layout.row_chef, BR.chef,item,null));
        }
        adapter.setData(joatList);
        binding.chefsList.setAdapter(adapter);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {
        Toast.makeText(getActivity(), "Complete", Toast.LENGTH_SHORT).show();
    }
}
