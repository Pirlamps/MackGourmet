package br.com.mack.chefs;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

public class ChefFragment extends Fragment implements ChefContract.View, SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {

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
        binding.chefsList.setOnItemClickListener(this);
        binding.listRefresh.setOnRefreshListener(this);
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
        binding.listRefresh.setRefreshing(false);
    }

    @Override
    public void showComplete() {
        Toast.makeText(getActivity(), "Complete", Toast.LENGTH_SHORT).show();
        binding.listRefresh.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        chefPresenter.refreshChefs();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Chef chef = (Chef)((JoatObject)adapter.getItem(position)).getBindingObject();
        new AlertDialog.Builder(getContext())
                .setTitle(chef.getName())
                .setMessage(chef.getAbout())
                .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }
}
