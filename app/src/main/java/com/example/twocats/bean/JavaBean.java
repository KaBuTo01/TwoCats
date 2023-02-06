package com.example.twocats.bean;

import java.util.List;

/**
 * @ClassName JavaBean
 * @Author name
 * @Date 2023/1/10
 * @Description
 */
public class JavaBean<T> {


    private int code;
        private String msg;
        private T data;
        public void setCode(int code) {
            this.code = code;
        }
        public int getCode() {
            return code;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
        public String getMsg() {
            return msg;
        }

        public void setData(T data) {
            this.data = data;
        }
        public T getData() {
            return data;
        }

    @Override
    public String toString() {
        return "JavaBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
