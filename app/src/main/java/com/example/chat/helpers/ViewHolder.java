package com.example.chat.helpers;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.chat.R;

/**
 * ViewHolderクラス
 * 一行分を構成するViewを定義しておく
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView nameView;
    public TextView textView;
    public TextView timeView;
    public ImageView profileView;

    public ViewHolder(View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.name);
        textView = itemView.findViewById(R.id.text);
        timeView = itemView.findViewById(R.id.time);
        profileView = itemView.findViewById(R.id.profileImage);
    }
}
