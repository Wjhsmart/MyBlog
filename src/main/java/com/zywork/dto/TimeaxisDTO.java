package com.zywork.dto;

import java.util.List;

/**
 * 时间轴对象
 * 创建于2019-03-05
 *
 * @author 危锦辉
 * @version 1.0
 */
public class TimeaxisDTO  extends BaseDTO {

    private static final long serialVersionUID = -6027728250033359970L;
    private String yearColumn;
    private List<Object> rows;

    public TimeaxisDTO() {
    }

    public TimeaxisDTO(String yearColumn, List<Object> rows) {
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
        return "TimeaxisDTO{" +
                "yearColumn='" + yearColumn + '\'' +
                ", rows=" + rows +
                '}';
    }
}
