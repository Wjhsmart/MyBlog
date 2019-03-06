package com.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ArticleQuery查询对象类<br/>
 *
 * 创建于2019-03-05<br/>
 *
 * @author http://wjhsmart.vip 危锦辉
 * @version 1.0
 */
public class ArticleQuery extends PageQuery {

    private static final long serialVersionUID = -9223372034934121516L;

    // 文章编号
	private Long id;
	// 文章编号（最小值）
	private Long idMin;
	// 文章编号（最大值）
	private Long idMax;
	// 类别编号
	private Long categoryId;
	// 类别编号（最小值）
	private Long categoryIdMin;
	// 类别编号（最大值）
	private Long categoryIdMax;
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
	// 阅读数（最小值）
	private Long viewCountMin;
	// 阅读数（最大值）
	private Long viewCountMax;
	// 评论数
	private Long commentCount;
	// 评论数（最小值）
	private Long commentCountMin;
	// 评论数（最大值）
	private Long commentCountMax;
	// 是否推荐
	private Integer recommend;
	// 是否推荐（最小值）
	private Integer recommendMin;
	// 是否推荐（最大值）
	private Integer recommendMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMax;
	// 是否激活
	private Byte isActive;
	// 是否激活（最小值）
	private Byte isActiveMin;
	// 是否激活（最大值）
	private Byte isActiveMax;
	
    public ArticleQuery () {}

    public ArticleQuery (Long id, Long idMin, Long idMax, Long categoryId, Long categoryIdMin, Long categoryIdMax, String title, String coverImg, String summary, String content, Long viewCount, Long viewCountMin, Long viewCountMax, Long commentCount, Long commentCountMin, Long commentCountMax, Integer recommend, Integer recommendMin, Integer recommendMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.categoryId = categoryId;
		this.categoryIdMin = categoryIdMin;
		this.categoryIdMax = categoryIdMax;
		this.title = title;
		this.coverImg = coverImg;
		this.summary = summary;
		this.content = content;
		this.viewCount = viewCount;
		this.viewCountMin = viewCountMin;
		this.viewCountMax = viewCountMax;
		this.commentCount = commentCount;
		this.commentCountMin = commentCountMin;
		this.commentCountMax = commentCountMax;
		this.recommend = recommend;
		this.recommendMin = recommendMin;
		this.recommendMax = recommendMax;
		this.createTime = createTime;
		this.createTimeMin = createTimeMin;
		this.createTimeMax = createTimeMax;
		this.updateTime = updateTime;
		this.updateTimeMin = updateTimeMin;
		this.updateTimeMax = updateTimeMax;
		this.isActive = isActive;
		this.isActiveMin = isActiveMin;
		this.isActiveMax = isActiveMax;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMin() {
		return idMin;
	}

	public void setIdMin(Long idMin) {
		this.idMin = idMin;
	}

	public Long getIdMax() {
		return idMax;
	}

	public void setIdMax(Long idMax) {
		this.idMax = idMax;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getCategoryIdMin() {
		return categoryIdMin;
	}

	public void setCategoryIdMin(Long categoryIdMin) {
		this.categoryIdMin = categoryIdMin;
	}

	public Long getCategoryIdMax() {
		return categoryIdMax;
	}

	public void setCategoryIdMax(Long categoryIdMax) {
		this.categoryIdMax = categoryIdMax;
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

	public Long getViewCountMin() {
		return viewCountMin;
	}

	public void setViewCountMin(Long viewCountMin) {
		this.viewCountMin = viewCountMin;
	}

	public Long getViewCountMax() {
		return viewCountMax;
	}

	public void setViewCountMax(Long viewCountMax) {
		this.viewCountMax = viewCountMax;
	}

	public Long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public Long getCommentCountMin() {
		return commentCountMin;
	}

	public void setCommentCountMin(Long commentCountMin) {
		this.commentCountMin = commentCountMin;
	}

	public Long getCommentCountMax() {
		return commentCountMax;
	}

	public void setCommentCountMax(Long commentCountMax) {
		this.commentCountMax = commentCountMax;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public Integer getRecommendMin() {
		return recommendMin;
	}

	public void setRecommendMin(Integer recommendMin) {
		this.recommendMin = recommendMin;
	}

	public Integer getRecommendMax() {
		return recommendMax;
	}

	public void setRecommendMax(Integer recommendMax) {
		this.recommendMax = recommendMax;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTimeMin() {
		return createTimeMin;
	}

	public void setCreateTimeMin(Date createTimeMin) {
		this.createTimeMin = createTimeMin;
	}

	public Date getCreateTimeMax() {
		return createTimeMax;
	}

	public void setCreateTimeMax(Date createTimeMax) {
		this.createTimeMax = createTimeMax;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTimeMin() {
		return updateTimeMin;
	}

	public void setUpdateTimeMin(Date updateTimeMin) {
		this.updateTimeMin = updateTimeMin;
	}

	public Date getUpdateTimeMax() {
		return updateTimeMax;
	}

	public void setUpdateTimeMax(Date updateTimeMax) {
		this.updateTimeMax = updateTimeMax;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	public Byte getIsActiveMin() {
		return isActiveMin;
	}

	public void setIsActiveMin(Byte isActiveMin) {
		this.isActiveMin = isActiveMin;
	}

	public Byte getIsActiveMax() {
		return isActiveMax;
	}

	public void setIsActiveMax(Byte isActiveMax) {
		this.isActiveMax = isActiveMax;
	}

	
    @Override
    public String toString() {
        return "ArticleQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", categoryId = " + categoryId + 
				", categoryIdMin = " + categoryIdMin + 
				", categoryIdMax = " + categoryIdMax + 
				", title = " + title + 
				", coverImg = " + coverImg + 
				", summary = " + summary + 
				", content = " + content + 
				", viewCount = " + viewCount + 
				", viewCountMin = " + viewCountMin + 
				", viewCountMax = " + viewCountMax + 
				", commentCount = " + commentCount + 
				", commentCountMin = " + commentCountMin + 
				", commentCountMax = " + commentCountMax + 
				", recommend = " + recommend + 
				", recommendMin = " + recommendMin + 
				", recommendMax = " + recommendMax + 
				", createTime = " + createTime + 
				", createTimeMin = " + createTimeMin + 
				", createTimeMax = " + createTimeMax + 
				", updateTime = " + updateTime + 
				", updateTimeMin = " + updateTimeMin + 
				", updateTimeMax = " + updateTimeMax + 
				", isActive = " + isActive + 
				", isActiveMin = " + isActiveMin + 
				", isActiveMax = " + isActiveMax + 
				" }";
    }

}
