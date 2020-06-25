package com.example.chat.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chat.R;
import com.example.chat.models.DeleteChatRowData;

import java.util.List;

/**
 * 削除ダイアログ用Fragment
 */
public class DeleteChatRowFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // setCancelable(false)でダイアログ外を押しても閉じない
        this.setCancelable(false);
        TextView title = new TextView(getContext());
        title.setText(getResources().getString(R.string.delete_dialog_message));
        title.setPadding(10, 50, 10, 10);
        title.setGravity(Gravity.CENTER);

        return new AlertDialog.Builder(getActivity())
                .setCustomTitle(title)
                // OKが押された場合
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 削除処理
                        Bundle bundle = getArguments();
                        DeleteChatRowData deleteChatRowData =
                                (DeleteChatRowData) bundle.getSerializable(getResources().getString(R.string.delete_dialog_list_tag));
                        List list = deleteChatRowData.getList();
                        RecyclerView.Adapter adapter = deleteChatRowData.getAdapter();
                        int pos = deleteChatRowData.getPosition();
                        int itemCount = deleteChatRowData.getItemCount();
                        // チャット一覧Listから押された行のpositionの順番の要素を削除
                        list.remove(pos);
                        // アダプターに要素を削除したことを通知
                        deleteChatRowData.getAdapter().notifyItemRemoved(pos);
                        // チャット一覧に変更があったことを通知しバインドし直す
                        adapter.notifyItemRangeChanged(pos, itemCount);
                    }
                })
                // Cancelが押された場合
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // スワイプを戻す
                        Bundle bundle = getArguments();
                        DeleteChatRowData deleteChatRowData =
                                (DeleteChatRowData) bundle.getSerializable(getResources().getString(R.string.delete_dialog_list_tag));
                        RecyclerView.Adapter adapter = deleteChatRowData.getAdapter();
                        int pos = deleteChatRowData.getPosition();

                        // スワイプが元に戻る
                        adapter.notifyItemChanged(pos);
                    }
                })
                .create();
    }

    // アプリがバックグラウンドに回った時終了させない
    @Override
    public void onPause() {
        super.onPause();
        dismiss();
    }
}
