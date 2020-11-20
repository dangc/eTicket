package com.nuri.etk.store.jpo.aimir;

import com.nuri.etk.entity.aimir.DeviceModel;
import com.nuri.etk.entity.aimir.DeviceVendor;
import com.nuri.etk.entity.aimir.Supplier;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Copyright NuriTelecom Co.Ltd. since 2009</p>
 * AIMIR System 에서 사용하는 Device들의 제조사 정보를 나타낸다.
 * Device의 제조사의 고유코드, 제조사명, 제조사 정보와 연관되는 제조사의 모델정보들을 가지고 있다.
 * 집중기, 모뎀, 미터, ACD, IHD 등 모든 장비에 대한 제조사 정보   
 * 집중기,  
 * 모뎀,  
 * 미터,  
 * ACD,  
 * IHD 등 모든 장비에 대한 제조사 정보 
 * supplierId는 해당 제조사를 사용하는 전력회사 가스 회사가 된다. 
 * Supplier 클래스의 주키가 된다. 
 */

@Getter
@Setter
@NoArgsConstructor
public class DeviceVendorJpo {

	private Integer id;

	private Supplier supplier;

	private Integer supplierId;

	private Integer code;

	private String name;

	private String address;

	private String descr;

	public DeviceVendorJpo(Integer id) {
		this.id = id;
	}

	public DeviceVendor toDomain(){
		DeviceVendor deviceVendor = new DeviceVendor();
		deviceVendor.setId(this.id);
		deviceVendor.setSupplier(this.supplier);
		deviceVendor.setSupplierId(this.supplierId);
		deviceVendor.setCode(this.code);
		deviceVendor.setName(this.name);
		deviceVendor.setAddress(this.address);
		deviceVendor.setDescr(this.descr);
		return deviceVendor;
	}
	
}
