package com.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * LeaveWordVO值对象类<br/>
 *
 * 创建于2019-03-06<br/>
 *
 * @author http://wjhsmart.vip 危锦辉
 * @version 1.0
 */
public class LeaveWordVO extends BaseVO {

    private static final long serialVersionUID = -9223372035502841131L;

    // 留言表主键
	private Long id;
	// 称呼
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 32, message = "必须是1-32个字符")
	private String nickname;
	// 邮箱
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String email;
	// 回复标识
	@NotNull(message = "此项是必须项")
	private Integer replyFlag;
	// 回复内容
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String replyContent;
	// 回复时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date replyTime;
	// 是否已读
	private Integer readFlag;
	// 提交时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	
    public LeaveWordVO () {}

    public LeaveWordVO (Long id, String nickname, String email, Integer replyFlag, String replyContent, Date replyTime, Integer readFlag, Date createTime) {
        this.id = id;
		this.nickname = nickname;
		this.email = email;
		this.replyFlag = replyFlag;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.readFlag = readFlag;
		this.createTime = createTime;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getReplyFlag() {
		return replyFlag;
	}

	public void setReplyFlag(Integer replyFlag) {
		this.replyFlag = replyFlag;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public Integer getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(Integer readFlag) {
		this.readFlag = readFlag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
    @Override
    public String toString() {
        return "LeaveWordVO {" +
                "id = " + id + 
				", nickname = " + nickname + 
				", email = " + email + 
				", replyFlag = " + replyFlag + 
				", replyContent = " + replyContent + 
				", replyTime = " + replyTime + 
				", readFlag = " + readFlag + 
				", createTime = " + createTime + 
				" }";
    }

}
