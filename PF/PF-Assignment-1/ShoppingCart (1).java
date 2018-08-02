package shopping;
import java.util.*;
public class ShoppingCart {
	public static void main(String[] args){
		
		Store.addElementsToStore();
		Cart cart = new Cart();
		Scanner sc = new Scanner(System.in);
		char ch;
		do{
			System.out.println("1.Store.");
			System.out.println("2.Cart");
			System.out.println("3.Add into Cart.");
			System.out.println("4.Remove item from the cart.");
			System.out.println("5.Genrate bill.");
			System.out.println("Enter your choice");
			
			
			int choice = sc.nextInt();
			
			switch(choice){
			
				case 1:
					Store.display();
					break;
				case 2:
					cart.view();
					break;
				case 3:
					System.out.println("Enter id and quantity of ihe item you want to add.");
					int addId = sc.nextInt();
					int addQuantity = sc.nextInt();
					cart.addProductCart(addId, addQuantity);
					break;
				case 4:
					System.out.println("Enter id and quantity you want to remove.");
					int removeId = sc.nextInt();
					int removeQuantity = sc.nextInt();
					cart.removeFromCart(removeId, removeQuantity);
					break;
				case 5:
					String code;
					System.out.println("Do You have any promocde.if yes please enter else press N");
					code=sc.next();
					System.out.println("Your current bill is " + cart.generateBill(code));
					break;
				
					
					
				default: 
					System.out.println("Wrong choice");
					break;
			}
					System.out.println("Enter y if you want to continue");
					ch = sc.next().charAt(0);
			
		}while (ch =='Y' || ch =='y');
		sc.close();
}
}