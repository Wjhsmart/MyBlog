package com.zywork.vo;

import java.util.List;

/**
 * 时间轴对象
 * 创建于2019-03-05
 *
 * @author 危锦辉
 * @version 1.0
 */
public class TimeaxisVO extends BaseVO {
    private static final long serialVersionUID = -8455449813604751673L;
    private String yearColumn;
    private List<Object> rows;

    public TimeaxisVO() {
    }

    public TimeaxisVO(String yearColumn, List<Object> rows) {
        this.yearColumn = yearColumn;
        this.rows = rows;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getYearColumn() {
        return yearColumn;
    }

    public void setYearColumn(String yearColumn) {
        this.yearColumn = yearColumn;
    }

    public List<Object> getRows() {
        return rows;
    }

    public void setRows(List<Object> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "TimeaxisVO{" +
                "yearColumn='" + yearColumn + '\'' +
                ", rows=" + rows +
                '}';
    }
}
