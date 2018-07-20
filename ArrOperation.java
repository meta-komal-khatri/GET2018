package SCFSession3;

import java.util.Scanner;

public class ArrOperation {
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter");
		int size=sc.nextInt();
		int clump=0;
		int[] arr=new int[size];
		for(int i=0;i<size;i++){
			System.out.println("enetr "+(i+1));
			arr[i]=sc.nextInt();
		}
		/*for(int i=0;i<(size-1);i++){
			if(arr[i]==arr[i+1]){
				if((i-1)==-1){
					clump++;
				}
				else{
					if(arr[i-1]!=arr[i]){
					clump++;
					
					}
				}
				
			}
		}
		int sum=0;
		for(int i=0;i<size;i++){
			sum=sum+arr[i];
		}
		for(int i=0;i<size;i++){
			int sum1=0,sum2=0;
			sum1=sum1+arr[i];
			sum2=sum-sum1;
			if(sum1==sum2){
				System.out.println(i+1);
			}
		}*/
		int count,tempcount=0,maxcount=0; 
		outer: for(int i=0;i<size;i++){
			count=i;
			boolean flag=false;
			for(int j=size-1;j>=0&&count<size;j--){
				if(arr[count]==arr[j]&&count<=j){
				System.out.println(count);
					//count++;
					tempcount++;
					flag=true;
					if((count-j)==1||(count==j)){
						//tempcount=tempcount+j+1;
						maxcount=((tempcount+j+1)>maxcount)?tempcount:maxcount;
		
					}
					/*else if(count==j){
						//tempcount=tempcount+j;
						maxcount=((tempcount+j+1)>maxcount)?tempcount:maxcount;
					}*/
					else{
					//tempcount++;
					maxcount=(tempcount>maxcount)?tempcount:maxcount;
					}
					System.out.println("--");
					System.out.println(maxcount);
					if(maxcount==size){
						break outer;
					}
					count++;
					
					//maxcount=(tempcount>maxcount)?tempcount:maxcount;
					continue;
				}
				if(!(arr[count]==arr[j])&& flag==true){
					count=i;
					tempcount=0;
					flag=false;
					continue;
				}
				if(count==j||(count-j)==1){
					break;
				}
			}
		}
		System.out.println("maxCount"+maxcount);
		
	}
	  
}
