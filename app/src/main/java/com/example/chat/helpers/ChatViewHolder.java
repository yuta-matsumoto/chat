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
public class ChatViewHolder extends RecyclerView.ViewHolder {
    public TextView nameView;
    public TextView textView;
    public TextView timeView;
    public ImageView profileView;
    public View dateLineView;
    public View dateLineLeft;
    public View dateLineRight;
    public TextView dateLineTextView;

    public ChatViewHolder(View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.name);
        textView = itemView.findViewById(R.id.text);
        timeView = itemView.findViewById(R.id.time);
        profileView = itemView.findViewById(R.id.profileImage);
        dateLineView = itemView.findViewById(R.id.dateLineView);
        dateLineLeft = itemView.findViewById(R.id.dateLineLeft);
        dateLineRight = itemView.findViewById(R.id.dateLineRight);
        dateLineTextView = itemView.findViewById(R.id.dateLineTextView);
    }
}
