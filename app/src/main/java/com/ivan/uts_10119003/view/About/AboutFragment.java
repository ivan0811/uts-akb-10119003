package com.ivan.uts_10119003.view.About;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.ivan.uts_10119003.R;
import com.ivan.uts_10119003.databinding.ViewpagerItemBinding;
import com.ivan.uts_10119003.model.AboutModel;

import java.util.ArrayList;

//import com.ivan.uts_10119003.databinding.FragmentSlideshowBinding;

//nim : 10119003
//nama : ivan faathirza
//kelas : IF1

public class AboutFragment extends Fragment {

    ViewPager2 viewPager2;
    ArrayList<AboutModel> viewPagerItemArraylist;


//    private FragmentSlideshowBinding binding;

//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        SlideshowViewModel slideshowViewModel =
//                new ViewModelProvider(this).get(SlideshowViewModel.class);
//
//        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textSlideshow;
//        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
//    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        viewPager2 = view.findViewById(R.id.viewpager);
        int[] image ={
                R.drawable.a,R.drawable.b
        };
        String[] heading = {"Tentang Aplikasi", "Versi"};
        String[] desc = {getString(R.string.a_desc),
                getString(R.string.b_desc)};
        viewPagerItemArraylist = new ArrayList<>();

        for (int i = 0; i < image.length; i++) {
            AboutModel aboutModel = new AboutModel(image[i], heading[i], desc[i]);
            viewPagerItemArraylist.add(aboutModel);
        }

        AboutAdapter aboutAdapter = new AboutAdapter(viewPagerItemArraylist);
        viewPager2.setAdapter(aboutAdapter);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }
}