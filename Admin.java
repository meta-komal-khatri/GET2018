package marksheet;

import java.util.Scanner;

public class Admin {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enetr Number Of Students");
		int size=sc.nextInt();
		StudentMarks studentmarks=new StudentMarks(size);
		char ch;
		do{
			System.out.println("1. Enter marks");
			System.out.println("2. Average");
			System.out.println("3. Max Grade");
			System.out.println("4. Min Grade");
			System.out.println("5. Students Passed");
			System.out.println("Enter Your Choice");
			int choice=sc.nextInt();
			float ans;
			switch(choice){
				case 1:
					
					studentmarks.enterMarks();
					break;
				case 2:
					ans=studentmarks.averageMarks();
					System.out.println("Average Of Marks"+ans);
				
					break;
				case 3:
					ans=studentmarks.maxGrade();
					System.out.println("Max grade"+ans);
					break;
				case 4:
					ans=studentmarks.minGrade();
					System.out.println("Min Grade"+ans);
					break;	
				case 5:
					ans=studentmarks.studentPassed();
					System.out.println("Percentage Of Passed Students"+ans);
					break;
				default:
					System.out.println("wrong choice");
					break;
			
			}
			System.out.println("Do you want to continue? if yes press Y or y");
			ch=sc.next().charAt(0);
		}while(ch=='Y'||ch=='y');
		}
	 
 
	}
	
	

