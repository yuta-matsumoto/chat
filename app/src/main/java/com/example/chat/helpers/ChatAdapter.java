package com.example.chat.helpers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.chat.R;
import com.example.chat.models.ChatRowData;

/**
 * チャット表示に使用するAdapterクラス
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatViewHolder> {

    private List<ChatRowData> list;

    public ChatAdapter(List<ChatRowData> list) {
        this.list = list;
    }

    /**
     * チャットのViewHolderを作成する
     */
    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_row, parent, false);
        final ChatViewHolder vh = new ChatViewHolder(inflate);
        return vh;
    }

    /**
     * ViewHolder内のViewにチャットListのデータをbindする
     */
    @Override
    public void onBindViewHolder(final ChatViewHolder holder, int position) {
        if (!list.get(position).getChangeDateFlg()) {
            // 日付変更フラグがfalse
            // 日付変更線周りを隠す
            holder.dateLineView.setVisibility(View.GONE);
            holder.dateLineLeft.setVisibility(View.GONE);
            holder.dateLineTextView.setVisibility(View.GONE);
            holder.dateLineRight.setVisibility(View.GONE);
        } else {
            // 日付変更フラグがtrue
            // 日付変更線周りを描画する
            holder.dateLineView.setVisibility(View.VISIBLE);
            holder.dateLineLeft.setVisibility(View.VISIBLE);
            holder.dateLineTextView.setVisibility(View.VISIBLE);
            holder.dateLineRight.setVisibility(View.VISIBLE);
            holder.dateLineTextView.setText(list.get(position).getDateLineDate());
        }

        holder.nameView.setText(list.get(position).getName());
        holder.textView.setText(list.get(position).getText());
        holder.timeView.setText(list.get(position).getMessageDateTime());
        holder.profileView.setImageResource(list.get(position).getProfileImageId());
    }

    /**
     * チャット一覧Listの要素数を設定する
     */
    @Override
    public int getItemCount() {
        return list.size();
    }
}
