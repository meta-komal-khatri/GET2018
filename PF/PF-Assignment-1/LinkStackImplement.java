import java.util.*;
class Node{
	protected int data;
	protected Node link;
	public Node(){
		link=null;
		data=0;
	}
	public Node(int data,Node n){
		this.data=data;
		link=n;
	}
	public void setData(int d){
		data=d;
	}
	public void setLink(Node n){
		link=n;
	}
	public int getData(){
		return data;
	}
	public Node getLink(){
		return link;
	}
}
class linkedStack{
	protected Node top;
	public linkedStack(){
		top=null;
	}
	public void push(int x){
		Node newNode=new Node(x,null);
		if(top==null){
			top=newNode;
		}
		else{
			newNode.setLink(top);
			top=newNode;
		}
	}
	public int pop(){
		Node ptr;
		int x;
		if(top==null){
			throw new NoSuchElementException("Underflow Exception");
		}
		else{
			ptr=top;
			top=ptr.getLink();
			x=ptr.getData();
		}
		return x;
	}
	public boolean isEmpty(){
		return top==null;
	}
}
public class LinkStackImplement{
	public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	linkedStack linkedstack=new linkedStack();
	char ch;
	do{
		System.out.println("1. Push");
		System.out.println("2. Pop");
		System.out.println("3. isEmpty");
		System.out.println("Enter Your Choice");
		int choice=sc.nextInt();
		switch(choice){
			case 1:
				System.out.println("enter element ");
				int x=sc.nextInt();
				linkedstack.push(x);
				
				break;
			case 2:
				try{
					int y=linkedstack.pop();
					System.out.println("element removed"+y);
					
					
				}
				catch(Exception e){
					System.out.println("error"+e.getMessage());
				}
				break;
			case 3:
				System.out.println("Empty Status"+linkedstack.isEmpty());
				break;
			default:
				System.out.println("wrong choice");
		
		}
		System.out.println("Do you want to continue? if yes press Y or y");
		ch=sc.next().charAt(0);
	}while(ch=='Y'||ch=='y');
	}
}