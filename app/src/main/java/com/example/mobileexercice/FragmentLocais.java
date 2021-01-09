package com.example.mobileexercice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentLocais#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLocais extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView lvLocais;
    private View view;
    private ArrayList<String> locais;

    public FragmentLocais() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LocaisFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentLocais newInstance(String param1, String param2) {
        FragmentLocais fragment = new FragmentLocais();
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
        view = inflater.inflate(R.layout.fragment_locais, container, false);
        createListViewLocais();
        return view;
    }

    private void createListViewLocais() {
        locais = new ArrayList<String>();
        locais.add("Fortaleza");
        locais.add("Quixadá");
        locais.add("Quixeramobim");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1 , locais);
        lvLocais = (ListView) view.findViewById(R.id.lvLocais);
        lvLocais.setAdapter(adapter);
    }

}