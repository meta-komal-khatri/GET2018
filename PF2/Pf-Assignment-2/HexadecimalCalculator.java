package hexcal;

public class HexadecimalCalculator implements Arithmetic{
  int firsthexnumber,secondhexnumber;
  public HexadecimalCalculator(){
	  firsthexnumber=0;
	  secondhexnumber=0;
  }
  public int toConvertHexToDecimal(String number){
	  int decimal;
	  decimal=Integer.parseInt(number, 16);
	  return decimal;
  }
  public String toConvertDecimalToHex(int number){
	  String hexadecimal;
	  hexadecimal=Integer.toHexString(number);
	  return hexadecimal;
  }
  public String addHexNumber(String hexnumber1,String hexnumber2){
	  String sum;
	  int hexvalue1=toConvertHexToDecimal(hexnumber1);
	  int hexvalue2=toConvertHexToDecimal(hexnumber2);
	  int total=hexvalue1+hexvalue2;
	  sum=toConvertDecimalToHex(total);
	  return sum;
  }
  public String subtractHexNumber(String hexnumber1,String hexnumber2){
	  String sum;
	  int hexvalue1=toConvertHexToDecimal(hexnumber1);
	  int hexvalue2=toConvertHexToDecimal(hexnumber2);
	  int total=hexvalue1-hexvalue2;
	  sum=toConvertDecimalToHex(total);
	  return sum;
  }
  public String multiplyHexNumber(String hexnumber1,String hexnumber2){
	  String sum;
	  int hexvalue1=toConvertHexToDecimal(hexnumber1);
	  int hexvalue2=toConvertHexToDecimal(hexnumber2);
	  int total=hexvalue1*hexvalue2;
	  sum=toConvertDecimalToHex(total);
	  return sum;
  }
  public String divideHexNumber(String hexnumber1,String hexnumber2){
	  String sum;
	  int hexvalue1=toConvertHexToDecimal(hexnumber1);
	  int hexvalue2=toConvertHexToDecimal(hexnumber2);
	  if(hexvalue2==0){
		  throw new ArithmeticException("0 cant be second number");
	  }
	  else{
	  int total=hexvalue1/hexvalue2;
	  sum=toConvertDecimalToHex(total);
	  }
	  return sum;
  }
}
