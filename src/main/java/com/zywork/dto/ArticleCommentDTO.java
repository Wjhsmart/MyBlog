package com.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ArticleCommentDTO数据传输对象类<br/>
 *
 * 创建于2019-03-04<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
public class ArticleCommentDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035963636863L;

    // 评论编号
	private Long id;
	// 文章编号
	private Long articleId;
	// 用户昵称
	private String username;
	// 评论标题
	private String title;
	// 评论详情
	private String content;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public ArticleCommentDTO () {}

    public ArticleCommentDTO (Long id, Long articleId, String username, String title, String content, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.articleId = articleId;
		this.username = username;
		this.title = title;
		this.content = content;
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

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
        return "ArticleCommentDTO {" +
                "id = " + id + 
				", articleId = " + articleId + 
				", username = " + username + 
				", title = " + title + 
				", content = " + content + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
