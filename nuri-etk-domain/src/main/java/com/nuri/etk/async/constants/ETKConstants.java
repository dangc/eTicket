/**
 * 
 */
package com.nuri.etk.async.constants;


/**
 * @author	: sejin 
 * @date	: 2018. 6. 27.
 */
public class ETKConstants {

	public enum ErrorType {
		Ok(200),
		
		invaildCredentials(303),
		
		internalServerError(300),

		missingRequiredData(330),

		meterDoesNotExist(340), contractDoesNotExist(341), customerDoesNotExist(342), operatorDoesNotExist(343), stsNumberDoesNotExist(344), UnknowMeterModel(345),

		insufficientChargeAmount(350), // 충전금액부족

		failToGenerateSTSToken(360), failToSendSTSToken(361),

		tariffCrcError(370), noTariffInformation(371),
		
		noReturnData(380),
		
		etcError(390);
		
		private Integer value;

		ErrorType(int value) {
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}

		public int getIntValue() {
			return this.value.intValue();
		}

		public static ErrorType getErrorType(int code) {
			for (ErrorType type : ErrorType.values()) {
				if (type.getIntValue() == code)
					return type;
			}

			return ErrorType.Ok;
		}
	}

    public enum ChargeType {
        Charge(0),
        Cancel(1),
        NoType(-1);

        private Integer value;

        ChargeType(int value){
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public int getIntValue() {
            return this.value.intValue();
        }

        public static ChargeType getChargeType(int code) {
            for (ChargeType type : ChargeType.values()) {
                if (type.getIntValue() == code)
                    return type;
            }
            return ChargeType.NoType;
        }
    }
}
