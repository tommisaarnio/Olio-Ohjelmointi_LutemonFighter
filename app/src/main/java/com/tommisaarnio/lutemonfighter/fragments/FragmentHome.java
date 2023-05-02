package com.tommisaarnio.lutemonfighter.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.google.android.material.button.MaterialButton;
import com.tommisaarnio.lutemonfighter.FightingListAdapter;
import com.tommisaarnio.lutemonfighter.HomeListAdapter;
import com.tommisaarnio.lutemonfighter.Lutemon;
import com.tommisaarnio.lutemonfighter.R;
import com.tommisaarnio.lutemonfighter.Storage;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHome extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private ArrayList<Lutemon> lutemonsInHome = new ArrayList<>();

    private ArrayList<Lutemon> lutemonList = new ArrayList<>();


    private RecyclerView recyclerView;

    private RadioGroup radioGroup;

    public FragmentHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHome.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHome newInstance(String param1, String param2) {
        FragmentHome fragment = new FragmentHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private HomeListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        lutemonsInHome = Storage.getInstance().getLutemonsHome();
        radioGroup = view.findViewById(R.id.rgHome);
        recyclerView = view.findViewById(R.id.recycler_lutemons);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new HomeListAdapter(getContext(), lutemonsInHome));
        adapter = (HomeListAdapter) recyclerView.getAdapter();
        MaterialButton button = view.findViewById(R.id.homeMoveLutemon);
        button.setOnClickListener(view1 -> {
            moveLutemon(view1);
            Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
        });
        return view;
    }


    public void moveLutemon(View view) {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radioBtnHome:
                break;
            case R.id.radioBtnFightning:
                lutemonList = Storage.getInstance().getMovingLutemon();
                for (Lutemon l : lutemonList){
                    Storage.getInstance().addLutemonToFighting(l);
                    Storage.getInstance().getLutemonsHome().remove(l);
                }
                Storage.getInstance().getMovingLutemon().clear();
                break;
            case R.id.radioBtnTraining:
                lutemonList = Storage.getInstance().getMovingLutemon();
                for (Lutemon l : lutemonList){
                    Storage.getInstance().addLutemonToTraining(l);
                    Storage.getInstance().removeHomeLutemon(l);
                }
                Storage.getInstance().getMovingLutemon().clear();
                break;
            default:
                break;
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        adapter.notifyDataSetChanged();
    }

}