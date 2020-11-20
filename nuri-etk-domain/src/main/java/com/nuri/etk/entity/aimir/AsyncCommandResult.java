package com.nuri.etk.entity.aimir;

import com.nuri.etk.util.StringUtil;
/**
 * <p>Copyright NuriTelecom Co.Ltd. since 2009</p>
 * 
 * 비동기 명령어 결과
 */
public class AsyncCommandResult {

	public AsyncCommandResultPk id;
    
    private String oid;
    
    private Long length;
    
    private byte[] data;
    
    private String resultType;
    
    private String resultValue;
    
    private String trType;
    
    public AsyncCommandResult() {
        id = new AsyncCommandResultPk();
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
    
    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getResultValue() {
        return resultValue;
    }

    public void setResultValue(String resultValue) {
        this.resultValue = resultValue;
    }
    
    public String getTrType() {
		return trType;
	}

	public void setTrType(String trType) {
		this.trType = trType;
	}
}
