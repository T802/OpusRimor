package com.example.user.OpusRimor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Extension of recyclerview
 * Handles what happens clicked
 */
public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

    private GestureDetector gestureDetector;
    private ClickListener clickListener;

    /**
     *
     * @param context
     * @param recyclerView
     * @param clickListener
     *
     * Argumentative constructor
     */
    public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
        this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

            /**
             *
             * @param e Handles short click
             * @return true
             */
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            /**
             *
             * @param e Handles long click
             */
            @Override
            public void onLongPress(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && clickListener != null) {
                    clickListener.onLongClick(child, recyclerView.getChildLayoutPosition(child));
                }
            }
        });
    }

    /**
     *
     * @param rv
     * @param e Handles click
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
            clickListener.onClick(child, rv.getChildLayoutPosition(child));
        }
        return false;
    }

    /**
     *
     * @param rv
     * @param e
     *
     * Blank function
     */
    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    /**
     *
     * @param disallowIntercept
     *
     * Blank function
     */
    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    /**
     * Outlines user events
     */
    public interface ClickListener {
        /**
         *
         * @param view
         * @param position
         *
         * Listens for regular clicks
         */
        void onClick(View view, int position);

        /**
         *
         * @param view
         * @param position
         *
         * Listens for longer clicks
         */
        void onLongClick(View view, int position);
    }

}

