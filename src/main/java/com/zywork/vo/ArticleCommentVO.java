package com.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ArticleCommentVO值对象类<br/>
 *
 * 创建于2019-03-04<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
public class ArticleCommentVO extends BaseVO {

    private static final long serialVersionUID = -9223372036567004489L;

    // 评论编号
	private Long id;
	// 文章编号
	@NotNull(message = "此项是必须项")
	private Long articleId;
	// 用户昵称
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String username;
	// 评论标题
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 50, message = "必须是1-50个字符")
	private String title;
	// 评论详情
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 500, message = "必须是1-500个字符")
	private String content;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public ArticleCommentVO () {}

    public ArticleCommentVO (Long id, Long articleId, String username, String title, String content, Date createTime, Date updateTime, Byte isActive) {
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
        return "ArticleCommentVO {" +
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
