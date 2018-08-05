import java.util.*;
class palindrome{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter A String");
		String inputString=sc.nextLine();
		Stack stack=new Stack();
		for(int i=0;i<inputString.length();i++){
			stack.push(inputString.charAt(i));
		} 
		String reversedString="";
		while(!stack.isEmpty()){
			reversedString=reversedString+stack.pop();
		}
		if(inputString.equals(reversedString)){
			System.out.println("palindrome");
		}
		else
			System.out.println("Not Palindrome");
	}
}