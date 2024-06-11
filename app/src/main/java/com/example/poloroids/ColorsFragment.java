package com.example.poloroids;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ColorsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ColorsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private ArrayList<colors> colorsArrayList;
    private ArrayList<patterns> patternsArrayList;
    private ArrayList<gradients> gradientsArrayList;

    private String mParam1;
    private String mParam2;
    private String[] colorName;
    private int[] imageResourceID;
    private RecyclerView recyclerView;
    private String[] patternName;
    private int[] patternimageResourceID;
    private String[] gradientName;
    private int[] gradientimageResourceID;

    public ColorsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ColorsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ColorsFragment newInstance(String param1, String param2) {
        ColorsFragment fragment = new ColorsFragment();
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

    private RecyclerView colorsRecyclerView;
    private RecyclerView patternsRecyclerView;
    private RecyclerView gradientsRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_colors, container, false);

        colorsRecyclerView = view.findViewById(R.id.colorsRecycleview);
        patternsRecyclerView = view.findViewById(R.id.patternsRecycleview);
        gradientsRecyclerView = view.findViewById(R.id.gradientRecycleview);

        LinearLayoutManager colorsLayoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager patternsLayoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager gradientsLayoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        colorsRecyclerView.setLayoutManager(colorsLayoutManager);
        patternsRecyclerView.setLayoutManager(patternsLayoutManager);
        gradientsRecyclerView.setLayoutManager(gradientsLayoutManager);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataInitialize();

        ColorRecyclerAdapter colorRecyclerAdapter = new ColorRecyclerAdapter(getContext(), colorsArrayList);
        colorsRecyclerView.setAdapter(colorRecyclerAdapter);
        colorRecyclerAdapter.notifyDataSetChanged();

        PatternsRecyclerAdapter patternsRecyclerAdapter = new PatternsRecyclerAdapter(getContext(), patternsArrayList);
        patternsRecyclerView.setAdapter(patternsRecyclerAdapter);
        patternsRecyclerAdapter.notifyDataSetChanged();

        GradientRecyclerAdapter gradientRecyclerAdapter = new GradientRecyclerAdapter(getContext(), gradientsArrayList);
        gradientsRecyclerView.setAdapter(gradientRecyclerAdapter);
        gradientRecyclerAdapter.notifyDataSetChanged();
    }

    private void dataInitialize() {
        colorsArrayList = new ArrayList<>();

        colorName = new String[]{
                getString(R.string.black),
                getString(R.string.ash),
                getString(R.string.brown),
                getString(R.string.cream),
                getString(R.string.light_pink),
                getString(R.string.white),
        };

        imageResourceID = new int[]{
                R.drawable.black,
                R.drawable.ash,
                R.drawable.wooden2,
                R.drawable.wooden1,
                R.drawable.black,
                R.drawable.white,
        };

        for (int i=0;i<colorName.length;i++){
           colors colors= new colors(colorName[i],imageResourceID[i]);
           colorsArrayList.add(colors);
        }

        patternsArrayList = new ArrayList<>();

        patternName = new String[]{
                getString(R.string.black),
                getString(R.string.ash),
                getString(R.string.brown),
                getString(R.string.cream),
                getString(R.string.light_pink),
                getString(R.string.white),
        };

        patternimageResourceID = new int[]{
                R.drawable.black,
                R.drawable.ash,
                R.drawable.wooden2,
                R.drawable.wooden1,
                R.drawable.black,
                R.drawable.white,
        };

        for (int i=0;i<patternName.length;i++){
            patterns patterns= new patterns(patternName[i],patternimageResourceID[i]);
            patternsArrayList.add(patterns);
        }

        gradientsArrayList = new ArrayList<>();

        gradientName = new String[]{
                getString(R.string.black),
                getString(R.string.ash),
                getString(R.string.brown),
                getString(R.string.cream),
                getString(R.string.light_pink),
                getString(R.string.white),
        };

        gradientimageResourceID = new int[]{
                R.drawable.black,
                R.drawable.ash,
                R.drawable.wooden2,
                R.drawable.wooden1,
                R.drawable.black,
                R.drawable.white,
        };

        for (int i=0;i<gradientName.length;i++) {
            gradients gradients = new gradients(gradientName[i], gradientimageResourceID[i]);
            gradientsArrayList.add(gradients);

        }
    }
}