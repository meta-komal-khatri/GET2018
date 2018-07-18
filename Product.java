package shopping;

public class Product {
	protected int Product_Id;
	protected String Product_Name;
	protected int Product_Price;
	protected int product_quantity;
	
	public Product(int product_Id,String Product_Name,int Product_Price,int product_quantity){
		this.Product_Id=product_Id;
		this.Product_Name=Product_Name;
		this.Product_Price=Product_Price;
		this.product_quantity=product_quantity;
	}
	public void setProductName(String name){
		Product_Name=name;
	}
	public void setProductId(int id){
		Product_Id=id;
	}
	public void setProductPrice(int price){
		Product_Price=price;
	}
	public void setProductQuantity(int quantity){
		product_quantity=quantity;
	}
	public int getProductId(){
		return Product_Id;
	}
	public String getProductName(){
		return Product_Name; 
	}
	public int getProductPrice(){
		return Product_Price;
	}
	public int getProductQuantity(){
		return product_quantity;
	}
}
