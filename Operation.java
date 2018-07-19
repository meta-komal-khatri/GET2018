package stringoperation;

import java.util.Scanner;

public class Operation {
	public static void main(String[] args){
		StringOperation stringOperation=new StringOperation();
		Scanner sc=new Scanner(System.in);
		char ch;
		do{
			System.out.println("1. Check Equality");
			System.out.println("2. Reverse String");
			System.out.println("3. Convert LowerCase To Upeercase and vice versa");
			System.out.println("4. Find Largest Word");
			System.out.println("Enter Your Choice");
			int choice=sc.nextInt();
			sc.nextLine();
			
			String inputString1,inputString2;
			switch(choice){
				case 1:
					System.out.println("Enetr First String"); 
					inputString1=sc.next();
					System.out.println("Enetr Second String"); 
					inputString2=sc.next();
					try{
						int result=stringOperation.compareEquality(inputString1, inputString2);
						if(result==1){
							System.out.println("Both Strings Are Equal");
						}
						else{
							System.out.println("Both Strings Are Not Equal");
						}
					}
					catch(Exception e){
						System.out.println("Error:"+e.getMessage());
					}
					break;
				case 2:
					
					System.out.println("Enetr First String"); 
					inputString1=sc.next();
					try{
						String result=stringOperation.reverseString(inputString1);
						
							System.out.println("Reversed String"+result);
						
					}
					catch(Exception e){
						System.out.println("Error:"+e.getMessage());
					}
						
					break;
				case 3:
					System.out.println("Enetr First String"); 
					inputString1=sc.next();
					try{
						String UpToLow=stringOperation.convertString(inputString1);
						
							System.out.println("Modified String"+UpToLow);
						
					}
					catch(Exception e){
						System.out.println("Error:"+e.getMessage());
					}
					break;
				case 4:
					System.out.println("Enetr First String"); 
					inputString1=sc.nextLine();
					try{
						String largest=stringOperation.largestWord(inputString1);
						
							System.out.println("String"+largest);
						
					}
					catch(Exception e){
						System.out.println("Error:"+e.getMessage());
					}
					break;			
				default:
					System.out.println("wrong choice");
					break;
			
			}
			System.out.println("Do you want to continue? if yes press Y or y");
			ch=sc.next().charAt(0);
		}while(ch=='Y'||ch=='y');
		sc.close();
		}
	 
 
		
	}

