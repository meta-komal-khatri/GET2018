package hexcal;

import java.util.Scanner;
/**
 * 
 * class to use HexadecimalCalculator
 * perform all arithmetic operations
 *
 */

public class Calculator {
	
	private static Scanner sc;
	public static void main(String args[]){
		sc = new Scanner(System.in);
		String answer;
		HexadecimalCalculator hexadecimalcalculator = new HexadecimalCalculator();
		HexadecimalCompare hexcompare=new HexadecimalCompare();
		char ch;
		String fHex;
		String sHex;
		do{
			System.out.println("1. Add");
			System.out.println("2. Subtract");
			System.out.println("3. Multiply");
			System.out.println("4. Divide");
			System.out.println("Enter Your Choice");
			int choice=sc.nextInt();
			System.out.println("Enetr First Hexsdecimal Number"); 
			String Fhex=sc.next();
			System.out.println("Enetr Second Hexsdecimal Number"); 
			String Shex=sc.next();
			
			switch(choice){
				case 1:
					answer=hexadecimalcalculator.addHexNumber(Fhex, Shex);
					System.out.println("Addition of HexaDecimal Number is:"+answer);
					break;
				case 2:
					
					answer=hexadecimalcalculator.subtractHexNumber(Fhex, Shex);
					System.out.println("Subtraction of HexaDecimal Number is:"+answer);
						
					break;
				case 3:
					answer=hexadecimalcalculator.multiplyHexNumber(Fhex, Shex);
					System.out.println("Multiplication of HexaDecimal Number is:"+answer);
					break;
				case 4:
					try{
					answer=hexadecimalcalculator.subtractHexNumber(Fhex, Shex);
					if(answer==null){
						System.out.println("Division is not posiible");
					}
					else{
					System.out.println("Division of HexaDecimal Number is:"+answer);
					}
					}
					catch(Exception e){
						System.out.println("error:"+e.getMessage());
					}
					break;
				case 5:
					if(hexcompare.areEqualHexNumbers(Fhex,Shex)){
						System.out.println("Both Numbers Are Equal");
					}
					else if(hexcompare.greaterHexNumbers(Fhex,Shex)){
						System.out.println("First Number Is Greater");
					}
					else{
						System.out.println("Second Number Is Greater");
					}
					
				
				default:
					System.out.println("wrong choice");
			
			}
			System.out.println("Do you want to continue? if yes press Y or y");
			ch=sc.next().charAt(0);
		}while(ch=='Y'||ch=='y');
		}
	 
 }

