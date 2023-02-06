package com.example.twocats.bean;

/**
 * @ClassName Content
 * @Author name
 * @Date 2023/1/30
 * @Description
 */
public class Content {
        private String user_id;
        private String user_head;
        private String user_name;
        private String content;
        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
        public String getUser_id() {
            return user_id;
        }

        public void setUser_head(String user_head) {
            this.user_head = user_head;
        }
        public String getUser_head() {
            return user_head;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }
        public String getUser_name() {
            return user_name;
        }

        public void setContent(String content) {
            this.content = content;
        }
        public String getContent() {
            return content;
        }

}
