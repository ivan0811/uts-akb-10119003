package com.ivan.uts_10119003.view.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.ivan.uts_10119003.R;
//import com.ivan.uts_10119003.databinding.FragmentHomeBinding;

public class ProfileFragment extends Fragment {
//    private FragmentHomeBinding binding;
//    FragmentActivity listener;
//    private FragmentGalleryBinding binding;

//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        GalleryViewModel galleryViewModel =
//                new ViewModelProvider(this).get(GalleryViewModel.class);
//
//        binding = FragmentGalleryBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textGallery;
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }
}