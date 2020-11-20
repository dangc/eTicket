package com.nuri.etk.entity.aimir;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 지역 관리 Zone 정보 
 * BEMS에서 빌딩 내 층이나 지역 구분을 위한 지역 정보
 */

public class Zone {
	private Integer id;
	
	private String name;
	
	private Integer orderNo;
	
	private Location location;
	
	private Integer locationId;

	private Zone parent;
	
	private Integer parentId;
	
	private Set<Zone> children = new HashSet<Zone>(0);
	
	public Zone() {
	}
	public Zone(Integer id) {
		this.id = id;
	}
	public Zone(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Zone getParent() {
		return parent;
	}
	
	public void setParent(Zone parent) {
		this.parent = parent;
	}
	public Set<Zone> getChildren() {
		return children;
	}
	public void setChildren(Set<Zone> children) {
		this.children = children;
	}
	public void addChildLocation(Zone child) {
		if (child == null)
			throw new IllegalArgumentException("Null child Zone");
		
		if (child.getParent() != null)
			child.getParent().getChildren().remove(child);
		
		child.setParent(this);
		children.add(child);
	}
	
	public Integer getLocationId() {
        return locationId;
    }
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }
    public Integer getParentId() {
        return parentId;
    }
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
