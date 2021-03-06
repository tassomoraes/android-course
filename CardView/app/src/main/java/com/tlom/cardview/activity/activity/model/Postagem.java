package com.tlom.cardview.activity.activity.model;

public class Postagem {

    String user;
    String data;
    String post;
    int imagemPost;

    public Postagem() {
    }

    public Postagem(String user, String data, String post, int imagemPost) {
        this.user = user;
        this.data = data;
        this.post = post;
        this.imagemPost = imagemPost;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getImagemPost() {
        return imagemPost;
    }

    public void setImagemPost(int imagemPost) {
        this.imagemPost = imagemPost;
    }
}
