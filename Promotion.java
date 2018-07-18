package shopping;

public interface Promotion {
	public int getMinimumPrice();
	
	public void setMinimumPrice(int minimumPrice);
	
	public int getFixedDiscount();
	
	public void setFixedDiscount(int discount);
	
	public boolean isPromotionApplicable(String code);
}

