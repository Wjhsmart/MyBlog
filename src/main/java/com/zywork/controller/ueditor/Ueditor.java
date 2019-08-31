package com.zywork.controller.ueditor;

/**
 * @program: MyBlog
 * @description: UEditor实体类
 * @author: 危锦辉 http://wjhsmart.vip
 * @create: 2019-04-19 13:28
 */
public class Ueditor {

    private  String state;
    private  String url;
    private  String title;
    private  String original;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }
}
