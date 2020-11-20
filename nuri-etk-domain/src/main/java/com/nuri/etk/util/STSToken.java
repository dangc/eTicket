package com.nuri.etk.util;

import java.io.IOException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class STSToken {

	private static Log log = LogFactory.getLog(STSToken.class);
	
	/**
	 * 
	 * ECG STS 토근발행 IdRecord.
	 * 
	 * IIN : iec-62055에 근거한 고정값.
	 * MfrCode : 제조사 번호 (Kamstrup: 96, Wasion: 24)
	 * TCT : 01(Margnetic card), 02(Numberic), 07(Virtual Token Carrier)
	 * EA : 07(STA), 09(DEA)
	 * SGC : Supply Group Code
	 * TI : Tariff
	 * 
	 * @param DSN
	 * @param DOE
	 * @param TI
	 * @return
	 */
	public static String getIdRecord(String TCT, String EA, String SGC, String KRN, String DSN, String DOE, String MfrCode, String TI) {
		
		//iec-62055에 근거한다.
		String IIN = "600727";
		String IAIN_DRN = "";
		if(DSN.length() ==11) {
			IAIN_DRN = DSN;
		}else if(DSN.length() ==13 && DSN.startsWith("0024")) {
			//Wasion의 Split미터의 serial은 13자리이고, MfrCode가 24이므로 캄스트럽과 구분.
			DSN = DSN.substring(2);
			IAIN_DRN = DSN;
		}else {
			String DRNCheckDigit=getCheckDigit(MfrCode+DSN);
			IAIN_DRN =MfrCode+DSN+DRNCheckDigit;
		}
		
		String PANCheckDigit=getCheckDigit(IIN+IAIN_DRN);
		String meterPAN = IIN+IAIN_DRN+PANCheckDigit;
		
		String idRecord = meterPAN + DOE + TCT + EA + SGC + TI + KRN;
		
		return idRecord;
	}
	
	/**
	 * 
	 * ISO/IEC 7812-1 의 Luhn algorithm을 사용한다.
	 * 
	 * @param number
	 * @return
	 */
	public static String getCheckDigit(String number) {
    	String checkDigit = "";
		int sum=0;
		
		boolean alternate = true;
		for (int i = number.length() -1; i >=0; i--) {
			int n = Integer.parseInt(number.substring(i,i + 1));
			if (alternate) {
				n *= 2;
				if(n > 9) {
					n = (n % 10) +1;
				}
			}
			sum += n;
			alternate = !alternate;
		}
		
		String check = (sum*9) + "";
		checkDigit = check.substring(check.length()-1);
		log.info("checkDigit" + checkDigit);
		return checkDigit;
	}
	
	/**
	 * 
	 * 문서 IEC 62055-41 참고.
	 * DOE를 사용하지 않는 경우 이 값을 0000 으로 처리한다.
	 * DOE를 사용하는 경우 아래와 같이 정의한다.
	 * YY : 2000 ~ 2099년까지만 정의되어 있고 뒤에 두자리를 사용한다.
	 *      00 은 DOE를 사용하지 않는 경우에도 사용될 수 있다.
	 *      (format : 2 digit)
	 * MM : 01 ~ 12까지만 사용. 00(DOE를 사용하지 않는 경우)
	 *      (format : 2 digit)
	 * 
	 * @param tokenDate
	 * @return
	 */
	public static String getDOE(String tokenDate) {
		String doe = "0000";
		
		if (tokenDate.length() >= 6) {
			String YY = tokenDate.substring(0, 4);
			String MM = tokenDate.substring(4, 6);
			if (YY.startsWith("20") && (Integer.parseInt(MM) >= 1 && Integer.parseInt(MM) <= 12)) {
				YY = YY.substring(2, 4);

				// extension DOE(DateOfExpiry) for one year
				YY = Integer.toString(Integer.parseInt(YY) + 1);

				doe = YY + MM;
				log.info("DOE [" + doe + "]");
			}
		}
		
		return doe;
	}

	public static String makeToken(String sendURL) {
		String token = "";
		
		HttpClient client = new HttpClient();
		
		PostMethod method = null;
		try {
			log.info("sendURL["+sendURL+"]");
            
            //Timeout 설정
            HttpConnectionManagerParams managerParam = new HttpConnectionManagerParams();
			HttpConnectionManager manager = new SimpleHttpConnectionManager();
			managerParam.setConnectionTimeout(10*1000);
			client.setHttpConnectionManager(manager);
			
			method = new PostMethod(sendURL);
			method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0, false));
			int status  = client.executeMethod(method);
			
			
			//URL에서 보내온 메세지 읽는 부분 : 
			String body = method.getResponseBodyAsString();
			if(body != null && !body.isEmpty()) {
				log.info("\n"+body);
				
				if(body.contains("tokenDec")) {
					token = body.substring(body.indexOf("tokenDec"));
				}
				token = token.replace("tokenDec=", "").trim();
				
			}

			log.info("\nStatus[" + status+"]");
			if(status == 200) {
				log.debug("token : "+token);
			}
		}
		catch (IOException ie){
		    log.warn(ie,ie);
		    token = "Exception at connection: " + ie.getMessage();
        }
		catch (Exception e) {
			log.warn(e,e);
		} finally {
			method.releaseConnection();
		}
		
		return token;
	}
	
	//위와 동일하나 수신한 메시지를 처리하는 방법이 다름
	public static String makeTamperToken(String sendURL) {
		String token = "";

		HttpClient client = new HttpClient();

		PostMethod method = null;
		try {
			log.info("sendURL[" + sendURL + "]");

			// Timeout 설정
			HttpConnectionManagerParams managerParam = new HttpConnectionManagerParams();
			HttpConnectionManager manager = new SimpleHttpConnectionManager();
			managerParam.setConnectionTimeout(10 * 1000);
			client.setHttpConnectionManager(manager);

			method = new PostMethod(sendURL);
			method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
					new DefaultHttpMethodRetryHandler(0, false));
			int status = client.executeMethod(method);

			// URL에서 보내온 메세지 읽는 부분 :
			String body = method.getResponseBodyAsString();
			if (body != null && !body.isEmpty()) {
				log.info("\n" + body);
				token = body;
				if (body.contains("token=")) {
					int newLine = body.indexOf("\n");
					token = body.substring(body.indexOf("token="), newLine);
				}
				token = token.replace("token=", "").trim();

			}

			log.info("\nStatus[" + status + "]");
			if (status == 200) {
				log.debug("token : " + token);
			} else {
				token = "Status:" + status + ", " + body;
			}
		} catch (Exception e) {
			log.warn(e, e);
		} finally {
			method.releaseConnection();
		}

		return token;
	}
}
