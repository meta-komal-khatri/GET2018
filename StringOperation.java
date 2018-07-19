package stringoperation;

public class StringOperation {
		/**
		 * compare strings whether equal or not 
		 * @param String s1 and s2 that are used to compare string
		 * @param size is used to store the length of string
		 * @returns 1 if strings are equal else returns 0
		 * @throws exception if passed string is null
		 */
		public int compareEquality(String S1,String S2) {
			if(S1==null||S2==null) {
				throw new NullPointerException("Null Strings are not allowed");
			}
			char[] s1=S1.toCharArray();
			char[] s2=S2.toCharArray();
			if((s1.length>s2.length)||s1.length<s2.length) {
				return 0;
			}
			else {
				
			
			for(int i=0;i<s1.length;i++) {
				if(s1[i]==s2[i]) {
					
				}
				else {
					return 0;
				}
			}
			}
			return 1;
			
		}
		/**
		 * reverse the string entered by user 
		 * @param reverse should not be null
		 * @return reversed string
		 * @throws nullponterexception if passed string is empty 
		 */
		public String reverseString(String reverse) {
			if(reverse==null) {
				throw new NullPointerException("Null Strings are not allowed");
			}
			char[] input=reverse.toCharArray();
			char[] reversed=new char[reverse.length()];
			int size=input.length;
			for(int i=0;i<size;i++) {
				reversed[i]=input[(size-1)-i];
			}
			String rev=new String(reversed);
			
			return rev;
		}
		/**
		 * Receive a string as parameter and replace lowercase characters with
		 *  uppercase and vice-versa.
		 * @param convert should not be null
		 * @return converted array
		 * @throws NullPointerException if convert is empty 
		 */
		public String convertString(String convert) {
			if(convert==null) {
				throw new NullPointerException("Null Strings are not allowed");
			}
			char[] convertArray=convert.toCharArray();
			
			int Size=convertArray.length;
			
			for(int i=0;i<Size;i++) {
				if(convertArray[i]>='A' && convertArray[i]<='Z') {
					convertArray[i]=(char) (convertArray[i]+32); //covert uppercase to lowercase
				}
				else if(convertArray[i]>='a' && convertArray[i]<='z') {
					convertArray[i]=(char) (convertArray[i]-32); //covert lowercase to uppercase
				}
				else {
					System.out.println("String contains other values rather than alphabets");
					return null;
				}
			}
			String rev=new String(convertArray);
			return rev;
		}
		/**
		 * Find largest word among all words of a sentence
		 * @param input should not be null
		 * @return largestString 
		 */
		public String largestWord(String input) {
			if(input==null) {
				throw new NullPointerException("Null Strings are not allowed");
			}
			//char[] largest=input.toCharArray();
			int maxLength=0,length=0,SIndex=0,MaxSIndex=0;
			for(int i=0;i<input.length();i++) {
				if(input.charAt(i)!=' ' && i<input.length()) {
					length++;
				}
				else{
					int currentlength=length+1-SIndex;
					if(maxLength<currentlength) {
						maxLength=currentlength;
						MaxSIndex=SIndex;
						
					}
					length++;
					SIndex=length;
					
					
			   }
			}
			String Result=input.substring(MaxSIndex, (maxLength+MaxSIndex));
			return Result;
			
		}
	}

