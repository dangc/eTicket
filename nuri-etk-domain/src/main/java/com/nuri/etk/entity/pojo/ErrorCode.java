package com.nuri.etk.entity.pojo;


import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;

@Getter
@Setter
public class ErrorCode {
    static public final int Nuri_API_Http_Response_OK                   = 200;
    static public final int Nuri_API_Http_Response_Accepted             = 202;
    static public final int Nuri_API_Http_Response_NoContent            = 204;
    static public final int Nuri_API_Http_Response_BadRequest           = 400;
    static public final int Nuri_API_Http_Response_UnAuthorized         = 401;
    static public final int Nuri_API_Http_Response_Forbidden            = 403;
    static public final int Nuri_API_Http_Response_NotFound             = 404;
    static public final int Nuri_API_Http_Response_InternalServerError  = 501;

    static public final int Nuri_API_Response_OK        = 200;
    static public final int Nuri_API_Response_303       = 303;
    static public final int Nuri_API_Response_330       = 330;
    static public final int Nuri_API_Response_340       = 340;
    static public final int Nuri_API_Response_341       = 341;
    static public final int Nuri_API_Response_342       = 342;
    static public final int Nuri_API_Response_343       = 343;
    static public final int Nuri_API_Response_344       = 344;
    static public final int Nuri_API_Response_345       = 345;
    static public final int Nuri_API_Response_350       = 350;
    static public final int Nuri_API_Response_560       = 560;
    static public final int Nuri_API_Response_561       = 561;
    static public final int Nuri_API_Response_370       = 370;
    static public final int Nuri_API_Response_371       = 371;
    static public final int Nuri_API_Response_390       = 390;
    static public final int Nuri_API_Response_500       = 500;

    public ErrorCode() {
    }

    public static String getCodeString(int code) throws Exception
    {
        Class<ErrorCode> clazz = ErrorCode.class;
        Field[] fs = clazz.getFields();
        //log.debug("Field length ["+fs.length+"]");
        for (int i = 0; i < fs.length; i++)
        {
            String name = fs[i].getName();
            int value = fs[i].getInt(name);
            //log.debug("CodeName="+name+", CodeValue="+value);
            if (code == value)
            {
                return name;
            }
        }
        return "UKNOWN ERROR CODE";
    }

    public static String getHttpMessage(int code) throws Exception
    {
        switch(code)
        {
            case Nuri_API_Http_Response_OK                      : return "Succese";
            case Nuri_API_Http_Response_Accepted                : return "Accepted";                //비동기 요청에 대한 응답
            case Nuri_API_Http_Response_NoContent               : return "Not Support";             //지원하지 않는 기능
            case Nuri_API_Http_Response_BadRequest              : return "Bad Request";
            case Nuri_API_Http_Response_UnAuthorized            : return "UnAuthenticated";         //해당 리소스에 접근 권한을 가지고 있지 않는 경우(비인증)
            case Nuri_API_Http_Response_Forbidden               : return "Invalid Credentials";     //인증 여부와 상관 없이 감춰진 리소스에 접근(비승인)
            case Nuri_API_Http_Response_NotFound                : return "Not Found";               //해당 URI에 매칭되는 리소스가 없는 경우
            case Nuri_API_Http_Response_InternalServerError     : return "Internal Server Error";
            default : return "Unknown Error";
        }
    }

    public static String getMessage(int code) throws Exception
    {
        switch(code)
        {
            case Nuri_API_Response_OK               : return "Message is not displayed to user";     //성공
            case Nuri_API_Response_303              : return "Invalid Credentials";                 //인증 에러
            case Nuri_API_Response_330              : return "Missing Required Data";               //Request Parameter가 Method 요구사항을 충족시키지 않음
            case Nuri_API_Response_340              : return "Meter Does Not Exist";                //등록되지않은 미터 (in HES)
            case Nuri_API_Response_341              : return "Contract Does Not Exist";             //등록되지않은 계약 (in HES)
            case Nuri_API_Response_342              : return "Customer Does Not Exist";             //등록되지않은 고객 (in HES)
            case Nuri_API_Response_343              : return "Operator Does Not Exist";             //등록되지않은 계정 (in HES)
            case Nuri_API_Response_344              : return "STS Number Does Not Exist";           //해당 미터에 STS 번호가 등록되어있지않음 (in HES)
            case Nuri_API_Response_345              : return "Unknown Meter Model";                 //해당 미터의 모델이 정의되지 않았을 때
            case Nuri_API_Response_350              : return "Insufficient Charge Amount";          //충전금액 부족
            case Nuri_API_Response_560              : return "Fail To Generate STS Token";          //STS Token 발행 실패
            case Nuri_API_Response_561              : return "Fail To Send STS Token";              //미터에게 STS Token 전송 실패
            case Nuri_API_Response_370              : return "Tariff CRC Error";                    //CRC Error
            case Nuri_API_Response_371              : return "No Tariff Information";               //Tariff 정보 없음 (in HES)
            case Nuri_API_Response_390              : return "Other Meter Communication Error";     //미터 응답 에러
            case Nuri_API_Response_500              : return "Internal Server Error";               //서버 내부 Transaction Error
            default : return "Unknown Error";
        }
    }

}
