package com.example.twocats.bean;

import java.util.List;

/**
 * @ClassName HomeData
 * @Author name
 * @Date 2023/1/13
 * @Description
 */
public class HomeData {
    @Override
    public String toString() {
        return "HomeData{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_head='" + user_head + '\'' +
                ", text='" + text + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }

    private int id;
        private int user_id;
        private String user_name;
        private String user_head;
        private String text;
        private String cover;
        public void setId(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }
        public int getUser_id() {
            return user_id;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }
        public String getUser_name() {
            return user_name;
        }

        public void setUser_head(String user_head) {
            this.user_head = user_head;
        }
        public String getUser_head() {
            return user_head;
        }

        public void setText(String text) {
            this.text = text;
        }
        public String getText() {
            return text;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }
        public String getCover() {
            return cover;
        }


}
