package com.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ArticleCategoryDTO数据传输对象类<br/>
 *
 * 创建于2019-03-04<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
public class ArticleCategoryDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372034789865245L;

    // 类别编号
	private Long id;
	// 类别名称
	private String title;
	// 类别描述
	private String description;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public ArticleCategoryDTO () {}

    public ArticleCategoryDTO (Long id, String title, String description, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.title = title;
		this.description = description;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isActive = isActive;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	
    @Override
    public String toString() {
        return "ArticleCategoryDTO {" +
                "id = " + id + 
				", title = " + title + 
				", description = " + description + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
