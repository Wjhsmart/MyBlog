package com.zywork.dos;

import java.util.List;

/**
 * 时间轴对象
 * 创建于2019-03-05
 *
 * @author 危锦辉
 * @version 1.0
 */
public class TimeaxisDO extends BaseDO {
    private static final long serialVersionUID = 6023437495678958674L;
    private String yearColumn;
    private List<Object> rows;

    public TimeaxisDO() {
    }

    public TimeaxisDO(String yearColumn, List<Object> rows) {
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
        return "TimeaxisDO{" +
                "yearColumn='" + yearColumn + '\'' +
                ", rows=" + rows +
                '}';
    }
}
