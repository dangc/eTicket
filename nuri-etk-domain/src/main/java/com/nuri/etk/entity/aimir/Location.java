package com.nuri.etk.entity.aimir;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 공급사 관리지역 정보 
 * 공급지역 
 * 공급사 입장에서는 어느 특정 지역이 될 수 있지만 빌딩/공장의 경우 건물을 표현할 수 있다. 
 * 예로 우리라이온스밸리가 있고 3개(A,B,C) 동으로 구분되고 각 층을 표현한다. 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="location">
 *   &lt;complexContent>
 *     &lt;extension base="{http://server.ws.command.fep.aimir.com/}baseObject">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderNo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="parentId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="supplierId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

public class Location {
    private Integer id;
	
    private String name;
    
    private Integer orderNo;

    private Supplier supplier;
	
    private Integer supplierId;
    
    private Location parent;
	
    private Integer parentId;
	
    private Set<Location> children = new HashSet<Location>(0);
	
    private Set<SupplyTypeLocation> supplyTypeLocations = new HashSet<SupplyTypeLocation>(0);
	
    private String geocode;
	
    public Location() {
    }
    public Location(Integer id) {
        this.id = id;
    }
    public Location(String name) {
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Location getParent() {
        return parent;
    }
    public void setParent(Location parent) {
        this.parent = parent;
    }
	
    public Set<Location> getChildren() {
        return children;
    }
    public void setChildren(Set<Location> children) {
        this.children = children;
    }
    public void addChildLocation(Location child) {
        if (child == null)
            throw new IllegalArgumentException("Null child Location");
    	
        if (child.getParent() != null)
            child.getParent().getChildren().remove(child);
    	
        child.setParent(this);
        children.add(child);
    }
	
    public Set<SupplyTypeLocation> getSupplyTypeLocations() {
        return supplyTypeLocations;
    }
    public void setSupplyTypeLocations(Set<SupplyTypeLocation> supplyTypeLocations) {
        this.supplyTypeLocations = supplyTypeLocations;
    }

    public Integer getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }
    public Integer getParentId() {
        return parentId;
    }
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    
    public String getGeocode() {
        return geocode;
    }
    public void setGeocode(String geocode) {
        this.geocode = geocode;
    }
}
