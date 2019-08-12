package com.example.dailycast.UI;
/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class OnSwipeTouchListener implements View.OnTouchListener {

    private final GestureDetector gesDec;

    //Constructor that takes a context


    public OnSwipeTouchListener(Context c) {
        gesDec = new GestureDetector(c, new SwipeListener());
    }

    public void onLeftSWipe(){}
    public void onRightSWipe(){}

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gesDec.onTouchEvent(event);
    }

    private final class SwipeListener extends GestureDetector.SimpleOnGestureListener{

        private static final int SWIPE_VELOCITY_THRESHOLD = 100;
        private static final int SWIPE_DISTANCE_THRESHOLD = 100;

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velY, float velX){
            float distanceY = event2.getY() - event1.getY();
            float distanceX = event2.getX() - event1.getX();

            if(Math.abs(distanceX) > Math.abs(distanceY) && Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOLD && Math.abs(velX) > SWIPE_VELOCITY_THRESHOLD){
                if (distanceX > 0)
                    onRightSWipe();
                else
                    onLeftSWipe();
                return true;
            }

            return false;

        }
    }
}
