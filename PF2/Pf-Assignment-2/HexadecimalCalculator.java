package hexcal;

public class HexadecimalCalculator implements Arithmetic{
  int firsthexnumber,secondhexnumber;
  public HexadecimalCalculator(){
	  firsthexnumber=0;
	  secondhexnumber=0;
  }
  /**
   * Converting Hexadecimal Number into Decimal
   * @param number1 hexadecimal number that to changed
   * @return decimal value
   */
  public int toConvertHexToDecimal(String number){
	  int decimal;
	  decimal=Integer.parseInt(number, 16);
	  return decimal;
  }
  /**
   * Converting decimal Number into hexaDecimal
   * @param number1 decimal number that to changed
   * @return Hexadecimal value
   */
  public String toConvertDecimalToHex(int number){
	  String hexadecimal;
	  hexadecimal=Integer.toHexString(number);
	  return hexadecimal;
  }
  /**
   * Add two Hexadecimal Numbers and takes only positive hexadecimal
   * @param hexnumber1 first number 
   * @param hexnumber2 second number
   * @return returns addition of hexadecimal numbers (String type)
   */
  public String addHexNumber(String hexnumber1,String hexnumber2){
	  String sum;
	  int hexvalue1=toConvertHexToDecimal(hexnumber1);
	  int hexvalue2=toConvertHexToDecimal(hexnumber2);
	  int total=hexvalue1+hexvalue2;
	  sum=toConvertDecimalToHex(total);
	  return sum;
  }
  /**
   * Subtract two Hexadecimal Numbers and takes only positive hexadecimal
   * @param hexnumber1 first number 
   * @param hexnumber2 second number
   * @return returns subtraction of hexadecimal numbers (String type) also returns negative number
   */
  public String subtractHexNumber(String hexnumber1,String hexnumber2){
	  String sum;
	  int hexvalue1=toConvertHexToDecimal(hexnumber1);
	  int hexvalue2=toConvertHexToDecimal(hexnumber2);
	  int total=hexvalue1-hexvalue2;
	  sum=toConvertDecimalToHex(total);
	  return sum;
  }
  /**
   * Multiply two Hexadecimal Numbers and takes only positive hexadecimal
   * @param hexnumber1 first number 
   * @param hexnumber2 second number
   * @return returns multiplication of hexadecimal numbers (String type)
   */
  public String multiplyHexNumber(String hexnumber1,String hexnumber2){
	  String sum;
	  int hexvalue1=toConvertHexToDecimal(hexnumber1);
	  int hexvalue2=toConvertHexToDecimal(hexnumber2);
	  int total=hexvalue1*hexvalue2;
	  sum=toConvertDecimalToHex(total);
	  return sum;
  }
  /**
   * Divide two Hexadecimal Numbers and takes only positive hexadecimal
   * @param hexnumber1 first number 
   * @param hexnumber2 second number
   * @return returns division of hexadecimal numbers (String type) and throws ArithmeticException
   */
  public String divideHexNumber(String hexnumber1,String hexnumber2){
	  String sum;
	  HexadecimalCompare hexadecimalcompare=new HexadecimalCompare();
	  if(hexadecimalcompare.lesserHexNumbers(hexnumber1,hexnumber2)){
		  sum=null;
		  return sum;
	  }
	  else{
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
}
