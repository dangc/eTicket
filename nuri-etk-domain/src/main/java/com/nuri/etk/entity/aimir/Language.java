package com.nuri.etk.entity.aimir;

/**
 * @fileName Language.java
 * Locale 적용을 위한 언어코드
 */

public class Language {
    private Integer id;
    
    private String name;                // 언어 풀네임
    private String code_2letter;        // 2글자 코드
    private String code_3letter;        // 3글자 코드
    
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
}