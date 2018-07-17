package shopping;
import java.util.*;
public class Cart {
	public static List<Product> cartproductlist = new ArrayList<Product>();
	public void addProductCart(int id,int quantity) {
		cartproductlist.add(new Product(id,Store.storeproductlist.get(Store.getIndexStore(id)).getProductName(),Store.storeproductlist.get(Store.getIndexStore(id)).getProductPrice(),quantity));
		Store.LeftQuantity(id, quantity);
	}
	public void removeFromCart(int id,int quantity) {
		int newQuantity= Store.storeproductlist.get(Store.getIndexStore(id)).getProductQuantity() + quantity;
		Store.storeproductlist.get(Store.getIndexStore(id)).setProductQuantity(newQuantity);
		cartproductlist.get(cartIndex(id)).setProductQuantity(cartproductlist.get(cartIndex(id)).getProductQuantity() - quantity);
		if(cartproductlist.get(cartIndex(id)).getProductQuantity() == 0){
			cartproductlist.remove(cartIndex(id));
		}
	}
	public static int cartIndex(int id) {
		for (int i = 0; i < cartproductlist.size(); i++) {
	        Product index = (Product) cartproductlist.get(i);
	        if (id == index.getProductId()) {
	            return i;
	        }
	    }
	    System.out.println("\n" + "Item " + id + " wasn't found in the store	.");
	    return -1;
	}
	public int generateBill() {
		int totalamount = 0;
		for(Product s:cartproductlist) {
			
		totalamount+=(s.Product_Price)*(s.product_quantity);
		}
		return totalamount;
	}
	public void view() {
		for(Product s:cartproductlist) {
			   System.out.println(s.Product_Id + "\t" + s.Product_Name + "\t" + s.Product_Price + "\t" + s.product_quantity);
		   }
	}
	
}
