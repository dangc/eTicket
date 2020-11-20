package com.nuri.etk.entity.aimir;

/**
 * <p>Copyright NuriTelecom Co.Ltd. since 2009</p>
 * 
 * 비동기 명령어 인자 를 정의한 클래스<br>
 * Parameter 정보 를 정의<br>
 */
public class AsyncCommandParam {

	public AsyncCommandParamPk id;
    
    private String paramType;
    
    private String paramValue;
    
    private String trType;
    
    public AsyncCommandParam() {
        id = new AsyncCommandParamPk();
    }
    
    public void setTrId(Long trId) {
        id.setTrId(trId);
    }
    
    public Long getTrId() {
        return id.getTrId();
    }
    
    public void setMcuId(String mcuId) {
        id.setMcuId(mcuId);
    }
    
    public String getMcuId() {
        return id.getMcuId();
    }
    
    public void setNum(Integer num) {
        id.setNum(num);
    }
    
    public Integer getNum() {
        return id.getNum();
    }
    
    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getTrType() {
		return trType;
	}

	public void setTrType(String trType) {
		this.trType = trType;
	}
}
