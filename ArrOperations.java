package arroperation;

public class ArrOperations {
	int[] fixedArray;
	int size;
	public ArrOperations(){
		
	}
	/**
	 * find maximum length of mirror present in given array
	 * @param array should not be null
	 * @return length of largest mirror
	 */
	public int maxMirror(int[] array){
		int count;
		int maxcount=0;
		if(array.length==0) {
			throw new AssertionError("Array Is Null");
		}
		 for(int i=0;i<array.length;i++){
			count=i;
			int tempcount=0;
			boolean flag=false;
			for(int j=array.length-1;j>=0&&count<array.length;j--){
				if(array[count]==array[j]){
					tempcount++;
					count++;
					flag=true;
					maxcount=(tempcount>maxcount)?tempcount:maxcount;
					continue;
				}
				if(!(array[count]==array[j])&& flag==true){
					count=i;
					tempcount=0;
					flag=false;
					j=j+1;
					continue;
				}
				if(count==j||(count-j)==1){
					break;
				}
			}
		}
		 System.out.println(maxcount);
		 return maxcount;  
	}
	/**
	 *find number of clumps available in given array	
	 * @param array should not be null
	 * @return number of clumps available in given array 
	 */
	public int countClumps(int[] array){
		int clump=0;
		if(array.length==0){
			throw new AssertionError("Empty Array");
		}
		for(int i=0;i<(array.length-1);i++){
			if(array[i]==array[i+1]){
				if((i-1)==-1){
					clump++;
				}
				else{
					if(array[i-1]!=array[i]){
					clump++;
					
					}
				}
				
			}
		}
		return clump;
	}
	/**
	 * Return the index if there is a place to split the input array 
	 * so that the sum of the numbers on one side is equal to the sum
	 *  of the numbers on the other side else return -1
	 * @param array should not be null
	 * @return index at which array can be split
	 */
	public int splitSum(int[] array){
		if(array.length==0){
			throw new AssertionError("Empty Array");
		}
		int sum=0;
		int sum1=0,sum2=0;
		System.out.println("kjskdj");
		for(int i=0;i<array.length;i++){
			sum=sum+array[i];
		}
		
		for(int i=0;i<array.length;i++){
			
			System.out.println(",slkl");
			sum1=sum1+array[i];
			sum2=sum-sum1;
			System.out.println(sum1);
			System.out.println(sum);
			if(sum1==sum2){
				System.out.println(i);
				return i+1;
				
			}
		}
		return -1;
		
	}
	/**
	 * Return an array that contains exactly the same numbers as the input array,
	 * but rearranged so that every X is immediately followed by a Y
	 * @param array should not be null
	 * @param x 
	 * @param y
	 * @return arranged array
	 */
	
	public int[] fixXY(int[] array,int x,int y){
		fixedArray=array;
		int k=0;
		if(fixedArray.length==0) {
			throw new AssertionError();
		}
		if(fixedArray[array.length-1]==x) {
			
			throw new IllegalStateException("Enter valid Array");
		}
		int count1=0,count2=0;
		for(int i=0;i<array.length;i++) {
			if(fixedArray[i]==x) {
				count1++;
			}
			if(fixedArray[i]==y) {
				count2++;
			}
		}
		if(count1!=count2) {
			throw new IllegalStateException("number of x and y should be equal");
		}
		int Y=-1;
		for(int i=0;i<array.length;i++) {
			if(fixedArray[i]==x) {
				if(fixedArray[i+1]!=x) {
					for(int j=k;j<array.length;) {
						System.out.println(j);
						if(fixedArray[j]==y && j!=Y) {
							int temp=fixedArray[i+1];
							fixedArray[i+1]=fixedArray[j];
							fixedArray[j]=temp;
							k=j+1;
							Y=i+1;
							//i=i+2;
							break;
						}
						else {
							j++;
						}
					}	
				}
				else {
					throw new IllegalStateException("Enter valid Array");
				}
			}
		}
		return fixedArray;
		}
	}
