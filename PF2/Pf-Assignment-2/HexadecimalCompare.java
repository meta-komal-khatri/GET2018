package hexcal;

public class HexadecimalCompare {
	String FHex;
	String SHex;
	/*
	 * compare string for equality
	 * 
	 */
	public boolean areEqualHexNumbers(String number1,String number2){
		if(number1.compareTo(number2)==0)
		{
			return true;
		}
		return false;
		
	}
	/*
	 * compare string greater
	 */
	public boolean greaterHexNumbers(String number1,String number2){
		if(number1.compareTo(number2)>0)
		{
			return true;
		}
		return false;
	}
	/*
	 * compare string lesser
	 */
	public boolean lesserHexNumbers(String number1,String number2){
		if(number1.compareTo(number2)<0)
		{
			return true;
		}
		return false;
	}
}
