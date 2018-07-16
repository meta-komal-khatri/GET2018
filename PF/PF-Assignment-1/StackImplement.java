import java.util.*;
class arrStack{
	private int[] data;
	private int top,size;
	public arrStack(int n){
		size=n;
		data=new int[size];
		top=-1;
	}
	public void push(int x){
		if(top+1>=size){
			throw new IndexOutOfBoundsException("Overflow Exception");
		}
		else{
			data[++top]=x;
		}
		
	}
	public int pop(){
		int p; 
		if(top==-1){
			throw new NoSuchElementException("Underflow Exception");	
		}
		else{
			p=data[top--];
		}
		return p;
				
	}
	public boolean isEmpty(){
		return top==-1;
	}
}
public class StackImplement{
	public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter size of stack");
	int n=sc.nextInt();
	arrStack arrstack=new arrStack(n);
	char ch;
	do{
		System.out.println("1. Push");
		System.out.println("2. Pop");
		System.out.println("3. isEmpty");
		System.out.println("Enter Your Choice");
		int choice=sc.nextInt();
		switch(choice){
			case 1:
				try{
					System.out.println("enter element ");
					int x=sc.nextInt();
					arrstack.push(x);
				}
				catch(Exception e){
					System.out.println("error"+e.getMessage());
				}
				break;
			case 2:
				try{
					int y=arrstack.pop();
					System.out.println("element removed"+y);
					
					
				}
				catch(Exception e){
					System.out.println("error"+e.getMessage());
				}
				break;
			case 3:
				System.out.println("Empty Status"+arrstack.isEmpty());
				break;
			default:
				System.out.println("wrong choice");
		
		}
		System.out.println("Do you want to continue? if yes press Y or y");
		ch=sc.next().charAt(0);
	}while(ch=='Y'||ch=='y');
	}
}