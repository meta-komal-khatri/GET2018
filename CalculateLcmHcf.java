package recursion;

public class CalculateLcmHcf {
	/**
	 * calculates HCF of given two numbers
	 * @param firstNumber should always be greater than secondNumber
	 * @param secondNumber
	 * @return HCF of given numbers
	 */
	public int calculateHCFOfGivenNumber(int firstNumber,int secondNumber) {
		if(firstNumber<0||secondNumber<0) {
			throw new AssertionError("Negative Values Are Not Allowed");
		}
		if(firstNumber>=secondNumber) {
			if(secondNumber==0) {
				return firstNumber;
			}
			else {
				return calculateHCFOfGivenNumber(secondNumber,firstNumber%secondNumber);
			}
		}
		return -1;
	}
	/**
	 * calculates LCM of given two numbers
	 * @param firstNumber should always be greater than secondNumber
	 * @param secondNumber
	 * @return LCM of given numbers
	 */
	public int calculateLCMOfGivenNumbers(int firstNumber,int secondNumber) {
		if(firstNumber<0||secondNumber<0) {
			throw new AssertionError("Negative Values Are Not Allowed");
		}
		if(firstNumber>=secondNumber) {
			int lcmOfNumbers=(firstNumber*secondNumber)/(calculateHCFOfGivenNumber(firstNumber,secondNumber));
			return lcmOfNumbers;
		}
		return -1;
	}
}