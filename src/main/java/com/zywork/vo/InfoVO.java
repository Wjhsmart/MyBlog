package com.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * InfoVO值对象类<br/>
 *
 * 创建于2019-02-27<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
public class InfoVO extends BaseVO {

    private static final long serialVersionUID = -9223372036686851846L;

    // 系统信息主键
	private Integer id;
	// 系统名称
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String title;
	// 说明
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String desc;
	// 备案号
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String recordNum;
	// 域名
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String domainName;
	// 姓名
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String name;
	// 真实姓名
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String rename;
	// 网名
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String netName;
	// 职业
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String vocation;
	// QQ
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String qq;
	// 微信
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String wechat;
	// 邮箱
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String email;
	// 头像
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String headImg;
	// 微信二维码
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String wechatCode;
	// 格言
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String motto;
	
    public InfoVO () {}

    public InfoVO (Integer id, String title, String desc, String recordNum, String domainName, String name, String rename, String netName, String vocation, String qq, String wechat, String email, String headImg, String wechatCode, String motto) {
        this.id = id;
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
        return "InfoVO {" +
                "id = " + id + 
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
