package com.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * LeaveWordDO数据对象实体类<br/>
 *
 * 创建于2019-03-06<br/>
 *
 * @author http://wjhsmart.vip 危锦辉
 * @version 1.0
 */
public class LeaveWordDO extends BaseDO {

    private static final long serialVersionUID = -9223372034736813988L;

    // 留言表主键
	private Long id;
	// 称呼
	private String nickname;
	// 邮箱
	private String email;
	// 回复标识
	private Integer replyFlag;
	// 回复内容
	private String replyContent;
	// 回复时间
	private Date replyTime;
	// 是否已读
	private Integer readFlag;
	// 提交时间
	private Date createTime;
	
    public LeaveWordDO () {}

    public LeaveWordDO (Long id, String nickname, String email, Integer replyFlag, String replyContent, Date replyTime, Integer readFlag, Date createTime) {
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
        return "LeaveWordDO {" +
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
