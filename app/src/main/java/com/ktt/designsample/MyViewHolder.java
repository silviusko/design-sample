package com.ktt.designsample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * @author luke.kao
 */
public class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView textView;
    public MyViewHolder(View itemView) {
        super(itemView);

        textView = (TextView) itemView.findViewById(R.id.text);
    }
}
