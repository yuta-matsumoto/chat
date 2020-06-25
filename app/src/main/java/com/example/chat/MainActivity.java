package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.chat.fragments.BaseFragment;
import com.example.chat.fragments.ChatListFragment;

public class MainActivity extends AppCompatActivity {
    // Fragmentのベース
    private BaseFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初回はチャット一覧のFragmentをセット
        if (fragment == null) {
            fragment = new ChatListFragment();
        }
        // main_activityにFragmentをセット
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainContainer, fragment)
                .commit();
    }
}