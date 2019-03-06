package com.zywork.vo;

/**
 * 时间轴详情对象
 * 创建于2019-03-05
 *
 * @author 危锦辉
 * @version 1.0
 */
public class TimeaxisDetailVO extends BaseVO {

    private static final long serialVersionUID = 3190662580972960075L;
    private String monthColumn;
    private String title;
    private String summary;
    private Integer recommend;

    public TimeaxisDetailVO() {
    }

    public TimeaxisDetailVO(String monthColumn, String title, String summary) {
        this.monthColumn = monthColumn;
        this.title = title;
        this.summary = summary;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMonthColumn() {
        return monthColumn;
    }

    public void setMonthColumn(String monthColumn) {
        this.monthColumn = monthColumn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return "TimeaxisDetailVO{" +
                "monthColumn='" + monthColumn + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", recommend=" + recommend +
                '}';
    }
}
