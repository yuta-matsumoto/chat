package com.example.chat.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chat.R;
import com.example.chat.helpers.ChatAdapter;
import com.example.chat.models.ChatRowData;

import java.util.ArrayList;
import java.util.List;

/**
 * チャット画面用Fragment
 */
public class ChatFragment extends BaseFragment {
    private ChatFragment chatFragment = this;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 画面トップのユーザー名表示
        TextView chatSubject = view.findViewById(R.id.chatSubject);
        // Bundleから取得する
        Bundle args = getArguments();
        chatSubject.setText(args.getString("userName"));

        RecyclerView rv = view.findViewById(R.id.recyclerView);

        // チャットのデータList
        final List list = getChatList();

        // チャットのアダプター
        final ChatAdapter adapter = new ChatAdapter(list);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());

        rv.setHasFixedSize(true);

        rv.setLayoutManager(llm);

        rv.setAdapter(adapter);

        // <ボタンのリスナー
        ImageButton backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 画面遷移の準備
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                // 右から左へfragmentが消えるアニメーション
                transaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
                // ChatFragmentを削除
                transaction.remove(chatFragment);
                transaction.commit();
            }
        });

        // 送信ボタンのリスナー
        ImageButton sendButton = view.findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 送信処理を記述
            }
        });
    }

    /**
     * チャットのテストデータ生成
     */
    private List<ChatRowData> getChatList() {
        List<ChatRowData> list = new ArrayList<>();

        ChatRowData data1 = new ChatRowData();
        data1.setName("田中太郎");
        data1.setText("こんにちは");
        data1.setMessageDateTime("13:00");
        data1.setProfileImageId(R.drawable.sample1);
        data1.setDateLineDate("2020/6/09");
        data1.setChangeDateFlg(true);
        list.add(data1);

        ChatRowData data2 = new ChatRowData();
        data2.setName("佐藤茂");
        data2.setText("こんにちわ");
        data2.setMessageDateTime("14:00");
        data2.setProfileImageId(R.drawable.sample2);
        list.add(data2);

        ChatRowData data3 = new ChatRowData();
        data3.setName("佐藤茂");
        data3.setText("明日暇？");
        data3.setMessageDateTime("15:00");
        data3.setProfileImageId(R.drawable.sample2);
        list.add(data3);

        ChatRowData data4 = new ChatRowData();
        data4.setName("佐藤茂");
        data4.setText("既読無視ですか？？");
        data4.setMessageDateTime("09:00");
        data4.setProfileImageId(R.drawable.sample1);
        data4.setDateLineDate("2020/6/10");
        data4.setChangeDateFlg(true);
        list.add(data4);

        return list;
    }
}