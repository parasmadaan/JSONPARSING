package com.example.paras.zailetassignment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by paras on 09-06-2017.
 */

public class AnimationUtil {
    public  static void animate(RecyclerView.ViewHolder holder,Boolean goesdown) {
        AnimatorSet animatorSet = new AnimatorSet();

        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView, "translationY", goesdown == true ? 200 : -200, 0);
        animatorTranslateY.setDuration(1000);


        ObjectAnimator animatorTranslateX = ObjectAnimator.ofFloat(holder.itemView, "translationX", -50, 50, -30, 30, -20, 20, -5, 5, 0);
        animatorTranslateX.setDuration(1000);

        animatorSet.playTogether(animatorTranslateX, animatorTranslateY);

        animatorSet.start();

    }
}






