package com.nuri.etk.entity.aimir;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

/**
 * 공급사 정보
 * 하나의 사이트에서 여러 공급사 관리를 할 수 있으므로 예전처럼 지역으로 구분하는 것은 한계가 있음.  
 * 
 * 시스템을 구축하는 대상이 무엇인가에 따라서 빌딩/공장이 될 수 있다. 
 * 지금까지는 공급사 중심으로 시스템을 구축했지만 빌딩/공장을 중심으로 구축할 수 있다. 
 * 용어의 혼동이 있을 수 있지만 개념을 잘 파악한다면 상관없다. 
 * 신재생 에너지 개념이 포함되면 좀 더 포괄적인 의미로 사용할 수 있다. 
 *  
 * 에너지 공급자 
 * - 전기 
 * - 수도 
 * - 가스 
 * - 기타 
 *  
 * 처음엔 공급자로써 설계가 됐으나 소비 주체가 될 수 있음. 가령 BEMS 구축을 위해서 공급자는 없는데 빌딩 자체를 공급자로 보고 메시지를 빌딩에 맞도록 수정해야 한다. 
 */

@Getter
@Setter
@NoArgsConstructor
public class Supplier {

    private String name;

    private Country country;

    private Integer countryId;

    private String sysDatePattern;

    private Language lang;

    private Integer langId;

    private TimeZone timezone;

    private Integer timezoneId;

    private String address;

    private String descr;

    private String telno;

    private String administrator;

    private Double area;

    private String attribute;

    private Set<Location> locations = new HashSet<Location>(0); // 공급사가 관리하는 지역

    private String image;

    private Float taxRate;

    private Float commissionRate;
    
	private Integer licenceUse;
	
	private Integer licenceMeterCount;

    public String getSysDatePattern() {
        return sysDatePattern;
    }

    public void setSysDatePattern(String sysDatePattern) {
        this.sysDatePattern = sysDatePattern;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    public TimeZone getTimezone() {
        return timezone;
    }

    public void setTimezone(TimeZone timezone) {
        this.timezone = timezone;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    public void addLocation(Location location) {
        if (location == null)
            throw new IllegalArgumentException("Null Location");

        // location.setSupplier(this);
        locations.add(location);
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getLangId() {
        return langId;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    public Integer getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(Integer timezoneId) {
        this.timezoneId = timezoneId;
    }

    public Float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Float taxRate) {
        this.taxRate = taxRate;
    }

    public Float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Float commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Integer getLicenceUse() {
		return licenceUse;
	}
	public void setLicenceUse(Integer licenceUse) {
		this.licenceUse = licenceUse;
	}
	
	public Integer getLicenceMeterCount() {
		return licenceMeterCount;
	}
	public void setLicenceMeterCount(Integer licenceMeterCount) {
		this.licenceMeterCount = licenceMeterCount;
	}
}
