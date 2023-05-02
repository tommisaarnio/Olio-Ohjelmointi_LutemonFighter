package com.tommisaarnio.lutemonfighter.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.tommisaarnio.lutemonfighter.TrainingListAdapter;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentFightning#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTraining extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayList<Lutemon> lutemonsInTraining = new ArrayList<>();

    private RecyclerView recyclerView;

    private RadioGroup radioGroup;

    private ArrayList<Lutemon> lutemonList = new ArrayList<>();

    public FragmentTraining() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentFightning.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTraining newInstance(String param1, String param2) {
        FragmentTraining fragment = new FragmentTraining();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_training, container, false);
    }


    private TrainingListAdapter adapter;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        radioGroup = view.findViewById(R.id.rgHome);
        recyclerView = view.findViewById(R.id.recycler_lutemons);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TrainingListAdapter(getContext(), Storage.getInstance().getLutemonsTraining());
        recyclerView.setAdapter(new TrainingListAdapter(getContext(), Storage.getInstance().getLutemonsTraining()));
        recyclerView.setAdapter(adapter);
        MaterialButton button = view.findViewById(R.id.homeMoveLutemon);
        adapter = (TrainingListAdapter) recyclerView.getAdapter();
        button.setOnClickListener(view1 -> {
            moveTrainingLutemon(view1);
            Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
        });
        MaterialButton buttonG = view.findViewById(R.id.btnGym);
        adapter = (TrainingListAdapter) recyclerView.getAdapter();
        buttonG.setOnClickListener(view1 -> {
            goToGym(view1);
            Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
        });
        MaterialButton buttonJ = view.findViewById(R.id.btnJog);
        adapter = (TrainingListAdapter) recyclerView.getAdapter();
        buttonJ.setOnClickListener(view1 -> {
            goToJog(view1);
            Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
        });
    }

    public void moveTrainingLutemon(View view) {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radioBtnHome:
                lutemonList = Storage.getInstance().getMovingLutemon();
                for (Lutemon l : lutemonList) {
                    Storage.getInstance().addLutemonToHome(l);
                }
                Storage.getInstance().getMovingLutemon().clear();
                Storage.getInstance().saveLutemon(getContext());
                break;
            case R.id.radioBtnFightning:
                lutemonList = Storage.getInstance().getMovingLutemon();
                for (Lutemon l : lutemonList){
                    Storage.getInstance().addLutemonToFighting(l);
                }
                Storage.getInstance().getMovingLutemon().clear();
                break;
            case R.id.radioBtnTraining:
                break;
            default:
                break;
        }
    }
    public void goToGym(View view){
        lutemonList = Storage.getInstance().getMovingLutemon();
        for (Lutemon l : lutemonList){
            l.addExperience(2);
            Storage.getInstance().addLutemonToTraining(l);
        }
        lutemonList = null;
        Storage.getInstance().getMovingLutemon().clear();
        Storage.getInstance().saveLutemon(getContext());
    }
    public void goToJog(View view) {
        lutemonList = Storage.getInstance().getMovingLutemon();
        for (Lutemon l : lutemonList){
            l.addHealth(2);
            l.addMaxHealth(2);
            Storage.getInstance().addLutemonToTraining(l);
        }
        lutemonList = null;
        Storage.getInstance().saveLutemon(getContext());
        Storage.getInstance().getMovingLutemon().clear();
    }




    @Override
    public void onResume(){
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}