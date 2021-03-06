package com.example.chat.models;

/**
 * 一行分のデータモデルクラス
 */
public class ChatRowData {
    private String name;
    private String text;
    private String messageDateTime;
    private int profileImageId;
    private String dateLineDate;
    private boolean changeDateFlg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMessageDateTime() {
        return messageDateTime;
    }

    public void setMessageDateTime(String messageDateTime) {
        this.messageDateTime = messageDateTime;
    }

    public int getProfileImageId() {
        return profileImageId;
    }

    public void setProfileImageId(int profileImageId) {
        this.profileImageId = profileImageId;
    }

    public String getDateLineDate() {
        return dateLineDate;
    }

    public void setDateLineDate(String dateLineDate) {
        this.dateLineDate = dateLineDate;
    }

    public boolean getChangeDateFlg() {
        return changeDateFlg;
    }

    public void setChangeDateFlg(boolean changeDateFlg) {
        this.changeDateFlg = changeDateFlg;
    }
}
