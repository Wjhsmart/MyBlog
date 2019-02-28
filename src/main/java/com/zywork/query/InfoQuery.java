package com.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * InfoQuery查询对象类<br/>
 *
 * 创建于2019-02-27<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
public class InfoQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036462039029L;

    // 系统信息主键
	private Integer id;
	// 系统信息主键（最小值）
	private Integer idMin;
	// 系统信息主键（最大值）
	private Integer idMax;
	// 系统名称
	private String title;
	// 说明
	private String desc;
	// 备案号
	private String recordNum;
	// 域名
	private String domainName;
	// 姓名
	private String name;
	// 真实姓名
	private String rename;
	// 网名
	private String netName;
	// 职业
	private String vocation;
	// QQ
	private String qq;
	// 微信
	private String wechat;
	// 邮箱
	private String email;
	// 头像
	private String headImg;
	// 微信二维码
	private String wechatCode;
	// 格言
	private String motto;
	
    public InfoQuery () {}

    public InfoQuery (Integer id, Integer idMin, Integer idMax, String title, String desc, String recordNum, String domainName, String name, String rename, String netName, String vocation, String qq, String wechat, String email, String headImg, String wechatCode, String motto) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.title = title;
		this.desc = desc;
		this.recordNum = recordNum;
		this.domainName = domainName;
		this.name = name;
		this.rename = rename;
		this.netName = netName;
		this.vocation = vocation;
		this.qq = qq;
		this.wechat = wechat;
		this.email = email;
		this.headImg = headImg;
		this.wechatCode = wechatCode;
		this.motto = motto;
		
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdMin() {
		return idMin;
	}

	public void setIdMin(Integer idMin) {
		this.idMin = idMin;
	}

	public Integer getIdMax() {
		return idMax;
	}

	public void setIdMax(Integer idMax) {
		this.idMax = idMax;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRename() {
		return rename;
	}

	public void setRename(String rename) {
		this.rename = rename;
	}

	public String getNetName() {
		return netName;
	}

	public void setNetName(String netName) {
		this.netName = netName;
	}

	public String getVocation() {
		return vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getWechatCode() {
		return wechatCode;
	}

	public void setWechatCode(String wechatCode) {
		this.wechatCode = wechatCode;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	
    @Override
    public String toString() {
        return "InfoQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", title = " + title + 
				", desc = " + desc + 
				", recordNum = " + recordNum + 
				", domainName = " + domainName + 
				", name = " + name + 
				", rename = " + rename + 
				", netName = " + netName + 
				", vocation = " + vocation + 
				", qq = " + qq + 
				", wechat = " + wechat + 
				", email = " + email + 
				", headImg = " + headImg + 
				", wechatCode = " + wechatCode + 
				", motto = " + motto + 
				" }";
    }

}
