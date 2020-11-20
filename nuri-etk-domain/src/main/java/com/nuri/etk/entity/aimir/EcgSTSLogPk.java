package com.nuri.etk.entity.aimir;

/**
 *  <p>Copyright NuriTelecom Co.Ltd. since 2009</p>
 * 에너지 절감 목표를 위한 평균 사용량 AverageUsageBase Entity Class에 대한 Primary Key 정보
 * 복합키를 사용하기 때문에 XXXXPk 클래스로 별도 선언함.
 */
public class EcgSTSLogPk {

    private String cmd;

	private String meterNumber;

	private String createDate;

    private long asyncTrId;
	
	private int seq;
    
	
    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public long getAsyncTrId() {
        return asyncTrId;
    }

    public void setAsyncTrId(long asyncTrId) {
        this.asyncTrId = asyncTrId;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

}