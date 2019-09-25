package com.gigamole.sample.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gigamole.sample.R;
import com.gigamole.sample.utils.Utils;

import static com.gigamole.sample.utils.Utils.setupItem;

/**
 * Created by GIGAMOLE on 7/27/16.
 */
public class HorizontalPagerAdapter extends PagerAdapter {

    private final Utils.LibraryObject[] LIBRARIES = new Utils.LibraryObject[]{
            new Utils.LibraryObject(
                    R.drawable.ic_strategy,
                    "Strategy"
            ),
            new Utils.LibraryObject(
                    R.drawable.ic_design,
                    "Design"
            ),
            new Utils.LibraryObject(
                    R.drawable.ic_development,
                    "Development"
            ),
            new Utils.LibraryObject(
                    R.drawable.ic_qa,
                    "Quality Assurance"
            )
    };

    private LayoutInflater mLayoutInflater;


    public HorizontalPagerAdapter(final Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return LIBRARIES.length;
    }

    @Override
    public int getItemPosition(@NonNull final Object object) {
        return POSITION_NONE;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        final View view = mLayoutInflater.inflate(R.layout.item, container, false);
        setupItem(view, LIBRARIES[position]);
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(final View view, @NonNull final Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        container.removeView((View) object);
    }
}
