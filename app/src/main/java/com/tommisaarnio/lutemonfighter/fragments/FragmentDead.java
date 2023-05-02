package com.tommisaarnio.lutemonfighter.fragments;

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
import com.tommisaarnio.lutemonfighter.DeadListAdapter;
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
 * Use the {@link FragmentDead#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDead extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Storage storageDead;

    private ArrayList<Lutemon> lutemonsDead = new ArrayList<>();
    private ArrayList<Lutemon> lutemonList = new ArrayList<>();

    private RecyclerView recyclerView;

    private RadioGroup radioGroup;

    public FragmentDead() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentDead.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDead newInstance(String param1, String param2) {
        FragmentDead fragment = new FragmentDead();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dead, container, false);
        recyclerView = view.findViewById(R.id.recycler_lutemons);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new HomeListAdapter(getContext(), lutemonsDead));
        return view;
    }


    private DeadListAdapter adapter;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        radioGroup = view.findViewById(R.id.rgHome);
        recyclerView = view.findViewById(R.id.recycler_lutemons);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new DeadListAdapter(getContext(), Storage.getInstance().getLutemonsDead());
        recyclerView.setAdapter(new TrainingListAdapter(getContext(), Storage.getInstance().getLutemonsDead()));
        recyclerView.setAdapter(adapter);
        MaterialButton button = view.findViewById(R.id.homeMoveLutemon);
        adapter = (DeadListAdapter) recyclerView.getAdapter();
        button.setOnClickListener(view1 -> {
            moveDeadLutemon(view1);
            Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
        });
    }

    public void moveDeadLutemon(View view) {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radioBtnHome:
                lutemonList = Storage.getInstance().getMovingLutemon();
                for (Lutemon l : lutemonList) {
                    l.restoreHealth();
                    Storage.getInstance().addLutemon(l);
                    Storage.getInstance().removeLutemon(Storage.getInstance().getLutemons().size()-2);
                    l.setHealth(l.getMaxHealth());
                    Storage.getInstance().addLutemonToHome(l);
                    Storage.getInstance().saveLutemon(getContext());
                }
                Storage.getInstance().getMovingLutemon().clear();
                Storage.getInstance().saveLutemon(getContext());
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