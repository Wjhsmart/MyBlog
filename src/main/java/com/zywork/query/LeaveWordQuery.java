package com.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * LeaveWordQuery查询对象类<br/>
 *
 * 创建于2019-03-06<br/>
 *
 * @author http://wjhsmart.vip 危锦辉
 * @version 1.0
 */
public class LeaveWordQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035418478797L;

    // 留言表主键
	private Long id;
	// 留言表主键（最小值）
	private Long idMin;
	// 留言表主键（最大值）
	private Long idMax;
	// 称呼
	private String nickname;
	// 邮箱
	private String email;
	// 回复标识
	private Integer replyFlag;
	// 回复标识（最小值）
	private Integer replyFlagMin;
	// 回复标识（最大值）
	private Integer replyFlagMax;
	// 回复内容
	private String replyContent;
	// 回复时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date replyTime;
	// 回复时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date replyTimeMin;
	// 回复时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date replyTimeMax;
	// 是否已读
	private Integer readFlag;
	// 是否已读（最小值）
	private Integer readFlagMin;
	// 是否已读（最大值）
	private Integer readFlagMax;
	// 提交时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 提交时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMin;
	// 提交时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMax;
	
    public LeaveWordQuery () {}

    public LeaveWordQuery (Long id, Long idMin, Long idMax, String nickname, String email, Integer replyFlag, Integer replyFlagMin, Integer replyFlagMax, String replyContent, Date replyTime, Date replyTimeMin, Date replyTimeMax, Integer readFlag, Integer readFlagMin, Integer readFlagMax, Date createTime, Date createTimeMin, Date createTimeMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.nickname = nickname;
		this.email = email;
		this.replyFlag = replyFlag;
		this.replyFlagMin = replyFlagMin;
		this.replyFlagMax = replyFlagMax;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.replyTimeMin = replyTimeMin;
		this.replyTimeMax = replyTimeMax;
		this.readFlag = readFlag;
		this.readFlagMin = readFlagMin;
		this.readFlagMax = readFlagMax;
		this.createTime = createTime;
		this.createTimeMin = createTimeMin;
		this.createTimeMax = createTimeMax;
		
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

	public Integer getReplyFlagMin() {
		return replyFlagMin;
	}

	public void setReplyFlagMin(Integer replyFlagMin) {
		this.replyFlagMin = replyFlagMin;
	}

	public Integer getReplyFlagMax() {
		return replyFlagMax;
	}

	public void setReplyFlagMax(Integer replyFlagMax) {
		this.replyFlagMax = replyFlagMax;
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

	public Date getReplyTimeMin() {
		return replyTimeMin;
	}

	public void setReplyTimeMin(Date replyTimeMin) {
		this.replyTimeMin = replyTimeMin;
	}

	public Date getReplyTimeMax() {
		return replyTimeMax;
	}

	public void setReplyTimeMax(Date replyTimeMax) {
		this.replyTimeMax = replyTimeMax;
	}

	public Integer getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(Integer readFlag) {
		this.readFlag = readFlag;
	}

	public Integer getReadFlagMin() {
		return readFlagMin;
	}

	public void setReadFlagMin(Integer readFlagMin) {
		this.readFlagMin = readFlagMin;
	}

	public Integer getReadFlagMax() {
		return readFlagMax;
	}

	public void setReadFlagMax(Integer readFlagMax) {
		this.readFlagMax = readFlagMax;
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

	
    @Override
    public String toString() {
        return "LeaveWordQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", nickname = " + nickname + 
				", email = " + email + 
				", replyFlag = " + replyFlag + 
				", replyFlagMin = " + replyFlagMin + 
				", replyFlagMax = " + replyFlagMax + 
				", replyContent = " + replyContent + 
				", replyTime = " + replyTime + 
				", replyTimeMin = " + replyTimeMin + 
				", replyTimeMax = " + replyTimeMax + 
				", readFlag = " + readFlag + 
				", readFlagMin = " + readFlagMin + 
				", readFlagMax = " + readFlagMax + 
				", createTime = " + createTime + 
				", createTimeMin = " + createTimeMin + 
				", createTimeMax = " + createTimeMax + 
				" }";
    }

}
