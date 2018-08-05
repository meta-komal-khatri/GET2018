package shopping;
import java.util.*;
public class Cart {
	FixedProductPromotion fixedProductPromotion;
	public Cart() {
		fixedProductPromotion=new FixedProductPromotion();
		fixedProductPromotion.setMinimumPriceOfProductForPromotion(1,100);
		fixedProductPromotion.setMinimumPriceOfProductForPromotion(2,40);
		fixedProductPromotion.setMinimumPriceOfProductForPromotion(3,700);
		fixedProductPromotion.setMinimumPriceOfProductForPromotion(6,150);
		fixedProductPromotion.setMinimumDiscount(1,10);
		fixedProductPromotion.setMinimumDiscount(2,5);
		fixedProductPromotion.setMinimumDiscount(3,20);
		fixedProductPromotion.setMinimumDiscount(6,10);
	}
	Promotion promotion;
	public static List<Product> cartproductlist = new ArrayList<Product>();
	public void addProductCart(int id,int quantity) {
		int discount=0;
		System.out.println(fixedProductPromotion.getMinimumPriceOfProductPromotion(id));
		int price=(Store.storeproductlist.get(Store.getIndexStore(id)).getProductPrice())*quantity;
		if(fixedProductPromotion.getMinimumPriceOfProductPromotion(id)<=price) {
			discount=fixedProductPromotion.getMinimumDiscount(id);
		}
		cartproductlist.add(new Product(id,Store.storeproductlist.get(Store.getIndexStore(id)).getProductName(),Store.storeproductlist.get(Store.getIndexStore(id)).getProductPrice(),quantity,discount));
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
	/**
	 * this method generates the bill of the cart items and also applies the discount if applicable
	 * @param promoCode is the promocode as provided by user
	 */
	public int generateBill(String promoCode) {
		int totalamount = 0;
		promotion=new FixedOrderPromotion();
		for(Product s:cartproductlist) {
			
			int productTotalPrice=s.Product_Price*s.product_quantity;
			if(s.product_discount>0) {
				totalamount+=productTotalPrice-(((productTotalPrice*s.product_discount)/100));
			}
			else {
				totalamount+=productTotalPrice;
			}
		}
		if(!"N".equals(promoCode)) {
			promotion.setMinimumPrice(20);
			promotion.setFixedDiscount(10);
			int discount = applyPromotion(promotion, promoCode, totalamount);
			System.out.println("\nTotal:" + totalamount);
			System.out.println("discount applied:"+discount+" %");
			totalamount = totalamount - ((discount/100)*totalamount);
			System.out.println("Grand Total:  " + totalamount);
			}
		return totalamount;
	}
	public void view() {
		for(Product s:cartproductlist) {
			   System.out.println(s.Product_Id + "\t" + s.Product_Name + "\t" + s.Product_Price + "\t" + s.product_quantity);
		   }
	}
	/**
	 * this method generates the discount based on the promotion applied 
	 * @param promotion is an object of Promotion class
	 * @param code is a string having the promocode
	 * @param amount is the total amount of the items in the cart 
	 * @return it returns the % discount that can be applied on the order
	 */
	public int applyPromotion(Promotion promotion, String code, int amount)
	{
		int discount = 0;
		if(promotion.isPromotionApplicable(code) && amount >= promotion.getMinimumPrice())
		{
			discount = promotion.getFixedDiscount();
		}
		return discount;
	}
	
}
