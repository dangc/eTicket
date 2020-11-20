package com.nuri.etk.entity.aimir;

/**
 * 공급사 지역공급서비스
 * 동일한 지역에 여러 공급사가 있을 수 있음. 
 * SSE의 경우 전기/가스를 서비스하고 있는데 실제로는 다른 회사를 묶어서 처리하는 것으로 이러한 경우는 SSE_Energy, SSE_Gas 식으로 공급사를 분리해야 함.  
 *  
 * 빌딩/공장에서 각 건물의 계약전력 정보로 사용할 수 있다
 * 
 */

public class SupplyTypeLocation {

    private Integer id;
    
    private SupplyType supplyType;
    
    private Integer supplyTypeId;
    
    private Location location;
    
    private Integer locationId;
    
    private ContractCapacity contractCapacity;
    
    private Integer contractCapacityId;
    
    public SupplyTypeLocation() {
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public SupplyType getSupplyType() {
        return supplyType;
    }
    public void setSupplyType(SupplyType supplyType) {
        this.supplyType = supplyType;
    }
    
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public ContractCapacity getContractCapacity() {
        return contractCapacity;
    }

    public void setContractCapacity(ContractCapacity contractCapacity) {
        this.contractCapacity = contractCapacity;
    }

    public Integer getSupplyTypeId() {
        return supplyTypeId;
    }

    public void setSupplyTypeId(Integer supplyTypeId) {
        this.supplyTypeId = supplyTypeId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getContractCapacityId() {
        return contractCapacityId;
    }

    public void setContractCapacityId(Integer contractCapacityId) {
        this.contractCapacityId = contractCapacityId;
    }
}
