package com.nuri.etk.entity.aimir;

/**
 * <p>Copyright NuriTelecom Co.Ltd. since 2009</p>
 * 
 * AIMIR System에서 Locale 적용을 위한 국가 코드 정보를 나타내는 모델 클래스
 */

public class Country {

    private Integer id;
    
    private String name;                // 국가이름
    private String code_2letter;        // 2글자 코드
    private String code_3letter;        // 3글자 코드
    private String code_number;         // 국가 숫자 코드
    
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
    public String getCode_2letter() {
        return code_2letter;
    }
    public void setCode_2letter(String code_2letter) {
        this.code_2letter = code_2letter;
    }
    public String getCode_3letter() {
        return code_3letter;
    }
    public void setCode_3letter(String code_3letter) {
        this.code_3letter = code_3letter;
    }
    public String getCode_number() {
        return code_number;
    }
    public void setCode_number(String code_number) {
        this.code_number = code_number;
    }
}
