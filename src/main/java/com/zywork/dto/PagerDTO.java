package com.zywork.dto;

import java.util.List;

/**
 * 分页对象，包括分页需要的参数pageSize和pageNo及分页结果total和rows
 * 创建于2019-02-28
 *
 * @author 危锦辉
 * @version 1.0
 */
public class PagerDTO {
    private Long total;
    private List<Object> rows;

    public PagerDTO() {
    }

    public PagerDTO(Long total, List<Object> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<Object> getRows() {
        return this.rows;
    }

    public void setRows(List<Object> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PagerDTO{total=" + this.total + ", rows=" + this.rows + '}';
    }
}
