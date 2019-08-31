package com.zywork.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * SearchVO值对象类<br/>
 *
 * 创建于2019-03-05<br/>
 *
 * @author http://wjhsmart.vip 危锦辉
 * @version 1.0
 */
public class SearchVO extends BaseVO {

    private static final long serialVersionUID = -9223372035597488855L;

    private Long id;
    private String name;

	public SearchVO() {
	}

	public SearchVO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SearchVO{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
