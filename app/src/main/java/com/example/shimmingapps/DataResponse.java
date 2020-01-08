package com.example.shimmingapps;

public class DataResponse {
    String img;
    String judul;
    String desc;

    public DataResponse(String img, String judul, String desc) {
        this.img = img;
        this.judul = judul;
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
