package com.example.chat.helpers;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.chat.R;
import com.example.chat.models.ChatListRowData;

import java.util.List;

/**
 * チャット一覧表示に使用するAdapterクラス
 */
public class ChatListAdapter extends RecyclerView.Adapter<ChatListViewHolder> {
    private List<ChatListRowData> list;

    public ChatListAdapter(List<ChatListRowData> list) {
        this.list = list;
    }

    /**
     * チャット一覧のViewHolderを作成する
     */
    @Override
    public ChatListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 一行分のlayoutをViewに読み込む
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_list_row, parent, false);
        final ChatListViewHolder vh = new ChatListViewHolder(inflate);

        // クリックリスナーを登録
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // クリックされた行のpositionを取得
                int position = vh.getAdapterPosition();
                // Viewの操作はActivityかFragmentでハンドリングしなくてはいけないので実処理は書かない
                onItemClick(v, position, list);
            }
        });

        // タッチリスナーを登録
        inflate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Viewの操作はActivityかFragmentでハンドリングしなくてはいけないので実処理は書かない
                return onItemTouch(v);
            }
        });
        return vh;
    }

    /**
     * ViewHolder内のViewにチャット一覧Listのデータをbindする
     */
    @Override
    public void onBindViewHolder(ChatListViewHolder holder, int position) {
        String messageDateTime = list.get(position).getMessageDateTime();
        holder.nameView.setText(list.get(position).getName());
        holder.textView.setText(list.get(position).getText());
        holder.timeView.setText(messageDateTime);
        holder.profileView.setImageResource(list.get(position).getProfileImageId());
    }

    /**
     * チャット一覧Listの要素数を設定する
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * ChatListFragmentでoverrideして処理させる
     */
    public void onItemClick(View view, int pos, List<ChatListRowData> list) {
        ;
    }

    /**
     * ChatListFragmentでoverrideして処理させる
     */
    public boolean onItemTouch(View view) {
        return false;
    }
}
