package shopping;
import java.util.*;
public class Store {
   public static List<Product> storeproductlist=new ArrayList<Product>();
   
   public static void addElementsToStore() {
	   storeproductlist=new ArrayList<Product>();
	   storeproductlist.add(new Product(1,"bat" , 10, 10));
	   storeproductlist.add(new Product(2,"ball" , 20, 5));
	   storeproductlist.add(new Product(3,"racket" , 10, 10));
   }
   public static void display() {
	   for(Product s:storeproductlist) {
		   System.out.println(s.Product_Id + "\t" + s.Product_Name + "\t" + s.Product_Price + "\t" + s.product_quantity);
	   }
   }
	public static void LeftQuantity(int id,int quantity){
		int availableQuantity= storeproductlist.get(getIndexStore(id)).getProductQuantity() - quantity;
		storeproductlist.get(getIndexStore(id)).setProductQuantity(availableQuantity);
		if(availableQuantity==0){
			storeproductlist.remove(getIndexStore(id));//Deletes item from store if quantity becomes 0.		
	
		}
	}
	public static int getIndexStore(int id){
		for (int i = 0; i < Store.storeproductlist.size(); i++) {
        Product index = (Product) Store.storeproductlist.get(i);
        if (id == index.getProductId()) {
            return i;
        }
    }
    System.out.println("\n" + "Item " + id + " wasn't found in the store.");
    return -1;
}
}
