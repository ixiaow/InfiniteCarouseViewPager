package com.gigamole.infinitecycleviewpager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by GIGAMOLE on 7/27/16.
 */
public class InfiniteCycleViewPager extends ViewPager {

    private InfiniteCycleManager mInfiniteCycleManager;

    public InfiniteCycleViewPager(final Context context) {
        super(context);
        init(context, null);
    }

    public InfiniteCycleViewPager(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(final Context context, final AttributeSet attributeSet) {
        mInfiniteCycleManager = new InfiniteCycleManager(context, this, attributeSet);
    }

    public InfiniteCycleManager getInfiniteCycleManager() {
        return mInfiniteCycleManager;
    }


    @Override
    protected void setChildrenDrawingOrderEnabled(final boolean enabled) {
        super.setChildrenDrawingOrderEnabled(InfiniteCycleManager.DEFAULT_DISABLE_FLAG);
    }

    @Override
    public void setClipChildren(final boolean clipChildren) {
        super.setClipChildren(InfiniteCycleManager.DEFAULT_DISABLE_FLAG);
    }

    @Override
    public void setDrawingCacheEnabled(final boolean enabled) {
        super.setDrawingCacheEnabled(InfiniteCycleManager.DEFAULT_DISABLE_FLAG);
    }

    @Override
    protected void setChildrenDrawingCacheEnabled(final boolean enabled) {
        super.setChildrenDrawingCacheEnabled(InfiniteCycleManager.DEFAULT_DISABLE_FLAG);
    }

    @Override
    public void setWillNotCacheDrawing(final boolean willNotCacheDrawing) {
        super.setWillNotCacheDrawing(InfiniteCycleManager.DEFAULT_ENABLE_FLAG);
    }

    @Override
    public void setPageMargin(final int marginPixels) {
        super.setPageMargin(InfiniteCycleManager.DEFAULT_PAGE_MARGIN);
    }

    @Override
    public void setOffscreenPageLimit(final int limit) {
        super.setOffscreenPageLimit(InfiniteCycleManager.DEFAULT_OFFSCREEN_PAGE_LIMIT);
    }

    @Override
    public void setOverScrollMode(final int overScrollMode) {
        super.setOverScrollMode(OVER_SCROLL_NEVER);
    }

    @Override
    protected boolean addViewInLayout(final View child, final int index, final ViewGroup.LayoutParams params) {
        return super.addViewInLayout(child, 0, params);
    }

    @Override
    public void addView(final View child, final int index, final ViewGroup.LayoutParams params) {
        super.addView(child, 0, params);
    }

    @Override
    public void setAdapter(final PagerAdapter adapter) {
        super.setAdapter(mInfiniteCycleManager.setAdapter(adapter));
        mInfiniteCycleManager.resetPager();
    }

    @Override
    public PagerAdapter getAdapter() {
        return mInfiniteCycleManager.getInfiniteCyclePagerAdapter().getPagerAdapter();
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(final MotionEvent ev) {
        return mInfiniteCycleManager.onTouchEvent(ev) && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(final MotionEvent ev) {
        return mInfiniteCycleManager.onInterceptTouchEvent(ev) && super.onInterceptTouchEvent(ev);
    }

    @Override
    public void onWindowFocusChanged(final boolean hasWindowFocus) {
        mInfiniteCycleManager.onWindowFocusChanged(hasWindowFocus);
        super.onWindowFocusChanged(hasWindowFocus);
    }

    @Override
    protected void onDetachedFromWindow() {
        mInfiniteCycleManager.stopAutoScroll();
        super.onDetachedFromWindow();
    }

    @Override
    public void setCurrentItem(final int item) {
        setCurrentItem(item, true);
    }

    @Override
    public void setCurrentItem(final int item, final boolean smoothScroll) {
        super.setCurrentItem(mInfiniteCycleManager.setCurrentItem(item), true);
    }

}
