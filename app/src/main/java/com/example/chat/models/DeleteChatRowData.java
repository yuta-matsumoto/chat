package com.example.chat.models;

import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

/**
 * 削除ダイアログ用モデルクラス
 * 削除したい行のデータを詰める
 */
public class DeleteChatRowData implements Serializable {
    private List<ChatListRowData> list;
    private RecyclerView.Adapter adapter;
    private int position;
    private int itemCount;

    public List<ChatListRowData> getList() {
        return list;
    }

    public void setList(List<ChatListRowData> list) {
        this.list = list;
    }

    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
}
