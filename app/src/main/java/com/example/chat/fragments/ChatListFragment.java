package com.example.chat.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chat.models.DeleteChatRowData;
import com.example.chat.helpers.ChatListAdapter;
import com.example.chat.models.ChatRowData;
import com.example.chat.R;
import com.example.chat.helpers.SwipeHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * チャット一覧画面用Fragment
 */
public class ChatListFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rv = view.findViewById(R.id.recyclerView);

        // チャット一覧のデータList
        final List list = getChatList();
        // チャット一覧のデータListの要素数
        final int itemCount = list.size();

        // チャット一覧のアダプター
        final ChatListAdapter adapter = new ChatListAdapter(list) {
            @Override
            public void onItemClick(View view, int pos, List<ChatRowData> list) {
                // 行をクリックした時の処理を追記
            }
        };

        LinearLayoutManager llm = new LinearLayoutManager(getContext());

        rv.setHasFixedSize(true);

        rv.setLayoutManager(llm);

        rv.setAdapter(adapter);

        // スワイプを実装
        SwipeHelper swipeHelper = new SwipeHelper(getContext(), rv) {
            @Override
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<UnderlayButton> underlayButtons) {
                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        getResources().getString(R.string.chat_list_delete_button_label),
                        0,
                        Color.parseColor(getResources().getString(R.string.chat_list_delete_button_color)),
                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                FragmentManager fragmentManager = getFragmentManager();
                                DeleteChatRowFragment fragment = new DeleteChatRowFragment();
                                // 削除ダイアログfragmentに削除する行データをセット
                                DeleteChatRowData deleteChatRowData = new DeleteChatRowData();
                                deleteChatRowData.setList(list);
                                deleteChatRowData.setAdapter(adapter);
                                deleteChatRowData.setPosition(pos);
                                deleteChatRowData.setItemCount(itemCount);

                                // bundleを利用してデータを渡す
                                Bundle bundle = new Bundle();
                                bundle.putSerializable(getResources().getString(R.string.delete_dialog_list_tag), deleteChatRowData);
                                fragment.setArguments(bundle);

                                // ダイアログ表示
                                fragment.show(fragmentManager, "delete chat list");
                            }
                        }
                ));
            }
        };
    }

    /**
     * チャット一覧のテストデータ生成
     */
    private List<ChatRowData> getChatList() {
        List<ChatRowData> list = new ArrayList<>();

        ChatRowData data1 = new ChatRowData();
        data1.setName("田中太郎");
        data1.setText("こんにちは");
        data1.setMessageDateTime("2020/6/09 13:00");
        data1.setProfileImageId(R.drawable.sample1);
        list.add(data1);

        ChatRowData data2 = new ChatRowData();
        data2.setName("佐藤茂");
        data2.setText("おはようございます！");
        data2.setMessageDateTime("2020/6/08 8:10");
        data2.setProfileImageId(R.drawable.sample2);
        list.add(data2);

        ChatRowData data3 = new ChatRowData();
        data3.setName("taro");
        data3.setText("何時だっけ？");
        data3.setMessageDateTime("2020/6/07 20:09");
        data3.setProfileImageId(R.drawable.sample3);
        list.add(data3);

        ChatRowData data4 = new ChatRowData();
        data4.setName("hanako");
        data4.setText("教科書を貸してください");
        data4.setMessageDateTime("2020/6/06 07:00");
        data4.setProfileImageId(R.drawable.sample4);
        list.add(data4);

        ChatRowData data5 = new ChatRowData();
        data5.setName("たなか");
        data5.setText("無理");
        data5.setMessageDateTime("2020/6/06 01:05");
        data5.setProfileImageId(R.drawable.sample5);
        list.add(data5);

        ChatRowData data6 = new ChatRowData();
        data6.setName("小林");
        data6.setText("いいよ");
        data6.setMessageDateTime("2020/6/05 14:22");
        data6.setProfileImageId(R.drawable.sample6);
        list.add(data6);

        ChatRowData data7 = new ChatRowData();
        data7.setName("ペタジーニ");
        data7.setText("帰りたい");
        data7.setMessageDateTime("2020/6/05 13:00");
        data7.setProfileImageId(R.drawable.sample7);
        list.add(data7);

        ChatRowData data8 = new ChatRowData();
        data8.setName("Hayato");
        data8.setText("映画を見に行きましょう先輩！");
        data8.setMessageDateTime("2020/6/04 21:50");
        data8.setProfileImageId(R.drawable.sample8);
        list.add(data8);

        ChatRowData data9 = new ChatRowData();
        data9.setName("Tom");
        data9.setText("lol");
        data9.setMessageDateTime("2020/5/30 2:30");
        data9.setProfileImageId(R.drawable.sample9);
        list.add(data9);

        ChatRowData data10 = new ChatRowData();
        data10.setName("y.matsumoto");
        data10.setText("やったぜ");
        data10.setMessageDateTime("2020/5/29 4:00");
        data10.setProfileImageId(R.drawable.sample10);
        list.add(data10);

        return list;
    }
}