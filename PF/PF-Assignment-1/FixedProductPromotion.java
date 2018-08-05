package shopping;

import java.util.HashMap;

public class FixedProductPromotion {
	Store store=new Store();
	public HashMap<Integer,Integer> productPromotionList;
	public FixedProductPromotion() {
		productPromotionList=new HashMap<Integer,Integer>();
	}
	public void setMinimumPriceOfProductForPromotion(int productId,int productPrice) {
		Integer productPricePrimitive=new Integer(productPrice);
		Integer productIdInteger=new Integer(productId);
		productPromotionList.put(productIdInteger,productPricePrimitive);
	}
	public int getMinimumPriceOfProductPromotion(int productId) {
		int minProductPrice;
		Integer productIdInteger=new Integer(productId);
		if(productPromotionList.containsKey(productIdInteger)) {
			Integer productPriceInteger=new Integer(productPromotionList.get(productIdInteger));
			minProductPrice=productPriceInteger.intValue();
			return minProductPrice;
		}
		return -1;
	}
	public void setMinimumDiscount(int productId,int discount) {
		Integer productIdInteger=new Integer(productId);
		if(productPromotionList.containsKey(productIdInteger)) {
			Store.storeproductlist.get(Store.getIndexStore(productId)).setProductDiscount(discount);
		}
	}
	public int getMinimumDiscount(int productId) {
		Integer productIdInteger=new Integer(productId);
		if(productPromotionList.containsKey(productIdInteger)) {
			return Store.storeproductlist.get(Store.getIndexStore(productIdInteger)).getProductDiscount();
			
		}
		return -1;
	}
}
