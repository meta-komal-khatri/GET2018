package hexcal;


	public interface Arithmetic{
		public int toConvertHexToDecimal(String number);
		public String toConvertDecimalToHex(int number);
		public String addHexNumber(String hexnumber1,String hexnumber2);
		public String subtractHexNumber(String hexnumber1,String hexnumber2);
		public String multiplyHexNumber(String hexnumber1,String hexnumber2);
		public String divideHexNumber(String hexnumber1,String hexnumber2);
	}

