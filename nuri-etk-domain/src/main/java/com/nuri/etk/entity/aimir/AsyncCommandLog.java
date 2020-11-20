package com.nuri.etk.entity.aimir;

import java.util.List;

/**
 * <p>Copyright NuriTelecom Co.Ltd. since 2009</p>
 * 
 * 비동기 명령어 처리 로그
 */
public class AsyncCommandLog {

	public AsyncCommandLogPk id;
    
    private String deviceType;
    
    private String deviceId;
    
    private String command;
    
    private Integer trOption;
    
    private Integer day;
    
    private Integer initNice;
    
    private Integer curNice;
    
    private Integer initTry;
    
    private Integer curTry;
    
    private Integer queue;
    
    private Integer state;
    
    private Integer errorCode;
    
    private Integer eventType;
    
    private Integer resultCnt;
    
    private String operator;
    
    private String createTime;
    
    private String lastTime;
    
    private String requestTime;
    
    private List<AsyncCommandParam> params;
    
    private List<AsyncCommandResult> results;
    
    public AsyncCommandLog() {
        id = new AsyncCommandLogPk();
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
    
    public AsyncCommandLogPk getId() {
        return id;
    }

    public void setId(AsyncCommandLogPk id) {
        this.id = id;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Integer getTrOption() {
        return trOption;
    }

    public void setTrOption(Integer trOption) {
        this.trOption = trOption;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getInitNice() {
        return initNice;
    }

    public void setInitNice(Integer initNice) {
        this.initNice = initNice;
    }

    public Integer getCurNice() {
        return curNice;
    }

    public void setCurNice(Integer curNice) {
        this.curNice = curNice;
    }

    public Integer getInitTry() {
        return initTry;
    }

    public void setInitTry(Integer initTry) {
        this.initTry = initTry;
    }

    public Integer getCurTry() {
        return curTry;
    }

    public void setCurTry(Integer curTry) {
        this.curTry = curTry;
    }

    public Integer getQueue() {
        return queue;
    }

    public void setQueue(Integer queue) {
        this.queue = queue;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public Integer getResultCnt() {
        return resultCnt;
    }

    public void setResultCnt(Integer resultCnt) {
        this.resultCnt = resultCnt;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public List<AsyncCommandParam> getParams() {
        return params;
    }

    public void setParams(List<AsyncCommandParam> params) {
        this.params = params;
    }

    public List<AsyncCommandResult> getResults() {
        return results;
    }

    public void setResults(List<AsyncCommandResult> results) {
        this.results = results;
    }
}
