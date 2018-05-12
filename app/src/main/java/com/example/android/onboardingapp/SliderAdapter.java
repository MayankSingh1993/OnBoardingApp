package com.example.android.onboardingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }
    public int[] slide_images={
            R.drawable.eat_icon,
    R.drawable.code_icon,
    R.drawable.sleep_icon};
    public String[] slide_headings={
            "EAT",
            "SLEEP",
            "CODE"

    };
    public String[] slide_descs={
            "always keep yourself full",
            "take a good nap",
            "Code as much as you can"
    };
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout) object;
    }



    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView sideImageView=(ImageView)view.findViewById(R.id.slide_image);
        TextView slideTexView=(TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription=(TextView) view.findViewById(R.id.slide_descs);
        sideImageView.setImageResource(slide_images[position]);
        slideTexView.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);
        container.addView(view);


        return view;

    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
