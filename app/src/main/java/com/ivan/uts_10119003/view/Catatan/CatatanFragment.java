package com.ivan.uts_10119003.view.Catatan;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ivan.uts_10119003.MainActivity;
import com.ivan.uts_10119003.R;
import com.ivan.uts_10119003.model.CatatanModel;
import com.ivan.uts_10119003.service.DBService;

import java.util.ArrayList;
import java.util.List;
//import com.ivan.uts_10119003.databinding.FragmentHomeBinding;

//nim : 10119003
//nama : ivan faathirza
//kelas : IF1
public class CatatanFragment extends Fragment {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ImageView empyt_imageView;
    TextView data_kosong;
    CatatanAdapter catatanAdapter;

    DBService db;
    List<CatatanModel> catatan_list = new ArrayList<CatatanModel>();


//    private FragmentHomeBinding binding;
//    FragmentActivity listener;

//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        HomeViewModel homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//
//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
//    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catatan, container, false);
        db = new DBService(getActivity());
        recyclerView = view.findViewById(R.id.recyclerView);
        add_button = view.findViewById(R.id.add_button);
        empyt_imageView = view.findViewById(R.id.empty_imageview);
        data_kosong = view.findViewById(R.id.data_kosong);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddCatatanActivity.class);
                startActivity(intent);
            }
        });

        catatan_list.clear();

        storeDataInListModel();

        catatanAdapter = new CatatanAdapter(getActivity(), catatan_list);
        recyclerView.setAdapter(catatanAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((getActivity())));

        return view;
    }

    void storeDataInListModel(){
        Cursor cursor = db.readAllData();
        if(cursor.getCount() == 0){

        }else{
            while(cursor.moveToNext()){

                CatatanModel catatanModel = new CatatanModel(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );
                catatan_list.add(catatanModel);
            }
            empyt_imageView.setVisibility(View.GONE);
            data_kosong.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }
}