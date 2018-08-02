package shopping;

import java.util.Date;

public class FixedOrderPromotion implements Promotion{
	int minprice,fixdiscount;
	public int getMinimumPrice(){
		return minprice;
	}
	
	public void setMinimumPrice(int minprice) {
		this.minprice=minprice;
	}
	
	public int getFixedDiscount() {
		return fixdiscount;
	}
	
	public void setFixedDiscount(int discount) {
		fixdiscount=discount;
	}
	
	/**
	 * this method checks if the promotion can be applied based on the promo code provided by the user
	 * @param code contains the promo code as provided by the user
	 * @return returns true if promotion can be applied, false otherwise
	 */
		public boolean isPromotionApplicable(String code) {
		Date currentDate = new Date();
		boolean result = false;
		
		for(PromotionEnum promotion: PromotionEnum.values())
		{
			if(code.equals(promotion.getCode()))
			{					
				if(currentDate.after(promotion.getStartDate()) && currentDate.before(promotion.getEndDate()))
					result = true;
				else
					result = false;
			}
		}
		return result;
	}
}
