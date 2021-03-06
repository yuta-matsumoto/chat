package com.example.chat.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chat.models.DeleteChatRowData;
import com.example.chat.helpers.ChatListAdapter;
import com.example.chat.models.ChatListRowData;
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
            public void onItemClick(View view, int pos, List<ChatListRowData> list) {
                // 選択したユーザーの情報を渡す
                ChatFragment fragment = new ChatFragment();
                // fragment間のデータ受け渡しにはBundleが便利
                Bundle args = new Bundle();
                if (args != null) {
                    args.putString("userName", list.get(pos).getName());
                    fragment.setArguments(args);
                }
                // 画面遷移の準備
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                // 左から右へfragmentを重ねるアニメーション
                transaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
                // ChatListFragmentの上にChatFragmentを重ねる
                transaction.add(R.id.mainContainer, fragment, "fragment");
                // バックスタックに加える
                transaction.addToBackStack(null);
                transaction.commit();
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
    private List<ChatListRowData> getChatList() {
        List<ChatListRowData> list = new ArrayList<>();

        ChatListRowData data1 = new ChatListRowData();
        data1.setName("田中太郎");
        data1.setText("こんにちは");
        data1.setMessageDateTime("2020/6/09 13:00");
        data1.setProfileImageId(R.drawable.sample1);
        list.add(data1);

        ChatListRowData data2 = new ChatListRowData();
        data2.setName("佐藤茂");
        data2.setText("おはようございます！");
        data2.setMessageDateTime("2020/6/08 8:10");
        data2.setProfileImageId(R.drawable.sample2);
        list.add(data2);

        ChatListRowData data3 = new ChatListRowData();
        data3.setName("taro");
        data3.setText("何時だっけ？");
        data3.setMessageDateTime("2020/6/07 20:09");
        data3.setProfileImageId(R.drawable.sample3);
        list.add(data3);

        ChatListRowData data4 = new ChatListRowData();
        data4.setName("hanako");
        data4.setText("教科書を貸してください");
        data4.setMessageDateTime("2020/6/06 07:00");
        data4.setProfileImageId(R.drawable.sample4);
        list.add(data4);

        ChatListRowData data5 = new ChatListRowData();
        data5.setName("たなか");
        data5.setText("無理");
        data5.setMessageDateTime("2020/6/06 01:05");
        data5.setProfileImageId(R.drawable.sample5);
        list.add(data5);

        ChatListRowData data6 = new ChatListRowData();
        data6.setName("小林");
        data6.setText("いいよ");
        data6.setMessageDateTime("2020/6/05 14:22");
        data6.setProfileImageId(R.drawable.sample6);
        list.add(data6);

        ChatListRowData data7 = new ChatListRowData();
        data7.setName("ペタジーニ");
        data7.setText("帰りたい");
        data7.setMessageDateTime("2020/6/05 13:00");
        data7.setProfileImageId(R.drawable.sample7);
        list.add(data7);

        ChatListRowData data8 = new ChatListRowData();
        data8.setName("Hayato");
        data8.setText("映画を見に行きましょう先輩！");
        data8.setMessageDateTime("2020/6/04 21:50");
        data8.setProfileImageId(R.drawable.sample8);
        list.add(data8);

        ChatListRowData data9 = new ChatListRowData();
        data9.setName("Tom");
        data9.setText("lol");
        data9.setMessageDateTime("2020/5/30 2:30");
        data9.setProfileImageId(R.drawable.sample9);
        list.add(data9);

        ChatListRowData data10 = new ChatListRowData();
        data10.setName("y.matsumoto");
        data10.setText("やったぜ");
        data10.setMessageDateTime("2020/5/29 4:00");
        data10.setProfileImageId(R.drawable.sample10);
        list.add(data10);

        return list;
    }
}