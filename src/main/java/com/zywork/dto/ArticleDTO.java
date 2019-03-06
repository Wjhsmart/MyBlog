package com.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ArticleDTO数据传输对象类<br/>
 *
 * 创建于2019-03-05<br/>
 *
 * @author http://wjhsmart.vip 危锦辉
 * @version 1.0
 */
public class ArticleDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036780964745L;

    // 文章编号
	private Long id;
	// 类别编号
	private Long categoryId;
	// 类别名称
	private String categoryName;
	// 文章标题
	private String title;
	// 封面图片
	private String coverImg;
	// 文章摘要
	private String summary;
	// 文章内容
	private String content;
	// 阅读数
	private Long viewCount;
	// 评论数
	private Long commentCount;
	// 是否推荐
	private Integer recommend;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public ArticleDTO () {}

    public ArticleDTO (Long id, Long categoryId, String title, String coverImg, String summary, String content, Long viewCount, Long commentCount, Integer recommend, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.categoryId = categoryId;
		this.title = title;
		this.coverImg = coverImg;
		this.summary = summary;
		this.content = content;
		this.viewCount = viewCount;
		this.commentCount = commentCount;
		this.recommend = recommend;
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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCoverImg() {
		return coverImg;
	}

	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getViewCount() {
		return viewCount;
	}

	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}

	public Long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
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
        return "ArticleDTO {" +
                "id = " + id + 
				", categoryId = " + categoryId +
				", categoryName = " + categoryName +
				", title = " + title + 
				", coverImg = " + coverImg + 
				", summary = " + summary + 
				", content = " + content + 
				", viewCount = " + viewCount + 
				", commentCount = " + commentCount + 
				", recommend = " + recommend + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
