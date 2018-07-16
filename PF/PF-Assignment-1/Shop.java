import java.util.*;
class Product{
	protected int Product_Id;
	protected String Product_Name;
	protected int Product_Price;
	protected Product nextProduct;
	public Product(int product_Id,String Product_Name,int Product_Price){
		this.Product_Id=product_Id;
		this.Product_Name=Product_Name;
		this.Product_Price=Product_Price;
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
	public int getProductId(){
		return Product_Id;
	}
	public String getProductName(){
		return Product_Name; 
	}
	public int getProductPrice(){
		return Product_Price;
	}
	public void setNextProduct(Product nextProduct){
		this.nextProduct=nextProduct;
	}
	public Product getNextProduct(){
		return nextProduct;
	}


}
class Cart{
	protected Product product;
	int size=0;
	public Cart(){
		product=null;
	}
	public void addProduct(int Product_Id,String Product_Name,int Product_price){
		Product newProduct=new Product(Product_Id,Product_Name,Product_price);
		if(product==null){
			product=newProduct;
		}
		else{
			newProduct.setNextProduct(product);
			product=newProduct;
		}
		size++;
		
	}
	public void update(String Product_name){
		Product ptr,nptr=null;
		ptr=product;
		if(product==null){
			throw new NoSuchElementException("Underflow Exception");
		}
		else{
			for(int i=0;i<size;i++){
				if(Product_name.equals(ptr.getProductName())){
					nptr=ptr;
				}
				else{
                                	ptr=ptr.getNextProduct();
				}
			}
		}
		if(nptr!=null){
			System.out.println("Enter New Price");
			Scanner sc=new Scanner(System.in);
			int newprice=sc.nextInt();
			nptr.setProductPrice(newprice);
			
		}
	}
	public void view(){
	       	Product ptr;
		ptr=product;
		for(int i=0;i<size;i++){
			System.out.println(ptr.getProductId()+" "+ptr.getProductName()+" "+ptr.getProductPrice());
			ptr=ptr.getNextProduct();
		}
	} 
	public void removeFromCart(String Product_Name){
		
	}
}
public class Shop{
	public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	Cart cart=new Cart();
	char ch;
	do{
		System.out.println("1. Add");
		System.out.println("2. Update");
		System.out.println("3. View");
		System.out.println("Enter Your Choice");
		int choice=sc.nextInt();
		switch(choice){
			case 1:
				System.out.println("enter Product Name");
				String name=sc.next();
				System.out.println("Enter Product Id"); 
				int id=sc.nextInt();
				System.out.println("Enter Price");
				int price=sc.nextInt();
				cart.addProduct(id,name,price);
				
				break;
			case 2:
				try{
					System.out.println("Enetr Product Name");
					String name1=sc.next();
					cart.update(name1);
					
					
					
				}
				catch(Exception e){
					System.out.println("error"+e.getMessage());
				}
				break;
			case 3:
				cart.view();
				break;
			default:
				System.out.println("wrong choice");
		
		}
		System.out.println("Do you want to continue? if yes press Y or y");
		ch=sc.next().charAt(0);
	}while(ch=='Y'||ch=='y');
	}
}