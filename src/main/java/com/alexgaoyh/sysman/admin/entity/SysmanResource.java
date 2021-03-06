package com.alexgaoyh.sysman.admin.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Where;

import com.alexgaoyh.common.entity.BaseEntity;

/**
 * 
 * @desc 用户后台资源资源权限表--RBAC权限管理实体
 *
 * @author alexgaoyh
 * @Fri Aug 08 13:29:41 CST 2014
 */
@Entity
@Table(name="SYSMAN_RESOURCE")
@JsonIgnoreProperties("parent")
public class SysmanResource extends BaseEntity{
	
	/** 资源类型-菜单级别 */
	public static int TYPE_MENU = 1;
	/** 资源类型-按钮级别*/
	public static int TYPE_BTN = 2;
	
	/**
	 * 资源类型
	 */
	private Integer resourceType;
	
	/**
	 * 权限名称
	 */
	@Column(length = 200)
	private String name;
	
	/**
	 * 权限描述
	 */
	@Column(length = 200)
	private String description;
	
	/**
	 * 排序
	 */
	@Column(length =  3 , name ="order_no")
	private Integer orderNo;
	
	/**
	 * 父节点
	 */
	@ManyToOne
	@JoinColumn(name = "p_menu_id")
	private SysmanResource parent;
	
	/**
	 * 子节点
	 */
	@OneToMany(mappedBy="parent",fetch=FetchType.EAGER)
	@OrderBy("orderNo")
	@Where(clause="delete_flag=0")
	private List<SysmanResource> subResource;
	
	/**
	 * 链接
	 */
	@Column(length = 200)
	private String href;

	public Integer getResourceType() {
		return resourceType;
	}

	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public SysmanResource getParent() {
		return parent;
	}

	public void setParent(SysmanResource parent) {
		this.parent = parent;
	}

	public List<SysmanResource> getSubResource() {
		return subResource;
	}

	public void setSubResource(List<SysmanResource> subResource) {
		this.subResource = subResource;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	
}

