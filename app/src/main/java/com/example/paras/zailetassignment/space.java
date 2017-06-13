package com.example.paras.zailetassignment;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by paras on 08-06-2017.
 */

public class space extends RecyclerView.ItemDecoration {
int space;


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //outRect.right=space;
        outRect.left=space;
        outRect.bottom=space;
       // outRect.top=space;
    }

    public space(int space) {
        this.space = space;
    }
}
