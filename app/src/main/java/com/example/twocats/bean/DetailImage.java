package com.example.twocats.bean;

/**
 * @ClassName DetailImage
 * @Author name
 * @Date 2023/1/30
 * @Description
 */
public class DetailImage {

        private int id;
        private String image;
        public void setId(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }

        public void setImage(String image) {
            this.image = image;
        }
        public String getImage() {
            return image;
        }

    @Override
    public String toString() {
        return "DetailImage{" +
                "id=" + id +
                ", image='" + image + '\'' +
                '}';
    }
}
