package area;

import java.util.Scanner;



public class CalculateArea {
	public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	AreaFunctions areafunction=new AreaFunctions();
	char ch ;
	do{
		System.out.println("1. Area Triangle");
		System.out.println("2. Area Rectangle");
		System.out.println("3. Area Square");
		System.out.println("4. Area Circle");
		System.out.println("Enter Your Choice");
		int choice=sc.nextInt();
		double ans,input1,input2;
		switch(choice){
			case 1:
				System.out.println("Enter Height");
				input1=sc.nextDouble();
				System.out.println("Enter Base");
				input2=sc.nextDouble();
				ans=areafunction.triangleArea(input1, input2);
				System.out.println("area:"+ans);
				break;
			case 2:
				System.out.println("Enter Height");
				input1=sc.nextDouble();
				System.out.println("Enter Width");
				input2=sc.nextDouble();
				ans=areafunction.rectangleArea(input1, input2);
				System.out.println("area:"+ans);
				break;
			case 3:
				System.out.println("Enter Side");
				input1=sc.nextDouble();
				ans=areafunction.squareArea(input1);
				System.out.println("area:"+ans);
				break;
			case 4:
				System.out.println("Enter Radius");
				input1=sc.nextDouble();
				ans=areafunction.squareArea(input1);
				System.out.println("area:"+ans);
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

