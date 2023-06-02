package com.example.mvp.home.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mvp.R;

public class HomeFragment extends Fragment {
    Button allProductsBtn;
    Button favBtn;
    Button exitBtn;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initUI(view);
        allProductsBtn.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_allProductsFragment);
        });
        favBtn.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_favoritesFragment2);
        });
        exitBtn.setOnClickListener(v -> {
            getActivity().finish();
        });
        return view;
    }

    private void initUI(View view) {
        allProductsBtn = view.findViewById(R.id.allProductsBtn);
        favBtn = view.findViewById(R.id.favsBtn);
        exitBtn = view.findViewById(R.id.exitBtn);
    }
}