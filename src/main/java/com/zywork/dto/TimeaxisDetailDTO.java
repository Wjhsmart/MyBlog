package com.zywork.dto;

/**
 * 时间轴详情对象
 * 创建于2019-03-05
 *
 * @author 危锦辉
 * @version 1.0
 */
public class TimeaxisDetailDTO extends BaseDTO {

    private static final long serialVersionUID = 5025620148703661731L;
    private String monthColumn;
    private String title;
    private String summary;
    private Integer recommend;

    public TimeaxisDetailDTO() {
    }

    public TimeaxisDetailDTO(String monthColumn, String title, String summary) {
        this.monthColumn = monthColumn;
        this.title = title;
        this.summary = summary;
    }

    public String getmonthColumn() {
        return monthColumn;
    }

    public void setmonthColumn(String monthColumn) {
        this.monthColumn = monthColumn;
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
        return "TimeaxisDetailDTO{" +
                "monthColumn='" + monthColumn + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", recommend=" + recommend +
                '}';
    }
}
