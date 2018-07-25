package scfsession6;

import java.util.Arrays;

public final class IntSet {
	private final int[] setArray;
	private int[] universalArray;
	public IntSet(int[] setArray){
		                         
		this.setArray=setArray;
		validate();
	
	}
	/**
	 * to check errors 
	 */
	private void validate(){
		if(setArray.length==0){
			throw new AssertionError("Set Empty");
		}
		boolean[] markEnteredValues=new boolean[1000];
		for(int i=1;i<=1000;i++){
			markEnteredValues[i]=false;
		}
		for(int i=0;i<setArray.length;i++){
			if(markEnteredValues[setArray[i]]){
				throw new AssertionError("repeated Elements Are Not Allowed");
			}
			else{
				markEnteredValues[setArray[i]]=true;
			}
		}
		if(!checkRangeOfSetArray()){
			throw new AssertionError("elements are not in range");
		}
	}
	
	/**
	 * checks that does given set contain x or not  
	 * @param x always integer and between 1 to 1000
	 * @return true if x is present in set otherwise false
	 */
	public boolean isMember(int x){
		for(int i=0;i<size();i++){
			if(setArray[i]==x){
				return true;
			}
		}
		return false;
	}
	/**
	 * size of set
	 * @return always return non zero value
	 */
	public int size(){
		return setArray.length;
	}
	/**
	 * checks that whether the given set is a subset of existing set or not 
	 * @param IntSet type set
	 * @return true if s is a subset o existing set otherwise false
	 */
	public boolean isSubSet(IntSet s){
		int setArrayMarker=0;
		for(int i=0;i<s.size();i++){
			for(int j=setArrayMarker;j<size()&&s.setArray[i]<setArray[j];j++){
				if(s.setArray[i]==setArray[j]){
					setArrayMarker=j;
					break;
				}
				if(j==size()-1){
					System.out.println(j);
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * checks that does all elements of set are in specified range or not 
	 * @return true if all elements are in specified range otherwise false
	 */
	private boolean checkRangeOfSetArray(){
		for(int i=0;i<size();i++){
			if(setArray[i]<1 || setArray[i]>1000){
				return false;
			}
		}
		return true;
	}
	/**
	 * union two sets such that set contains all elements of set1 and set2
	 * @param set1 should in range from 1-1000
	 * @param set2 should in range from 1-1000
	 * @return set 
	 */
	/*public IntSet unionSet1(IntSet set1,IntSet set2){
		int[] setArray2=new int[set1.size()+set2.size()];
		int[] setArraySet1=new int[set1.size()+1];
		int[] setArraySet2=new int[set2.size()+1];
		for(int i=0;i<set1.size();i++){
			setArraySet1[i]=set1.setArray[i];
		}
		for(int i=0;i<set2.size();i++){
			setArraySet2[i]=set2.setArray[i];
		}
		setArraySet1[set1.size()]=Integer.MAX_VALUE;
		setArraySet2[size()]=Integer.MAX_VALUE;
		int i=0,j=0,k=0;
		while(i<=set1.size() && j<=set2.size())
			
	    { 	System.out.print("\t"+k+"loop");
			System.out.print("\t"+setArray2[k]);
	        if (setArraySet1[i] < setArraySet2[j])
	        {
	            setArray2[k++] = setArraySet1[i];
	            
	            System.out.print("\t"+setArray2[k]);
	            i++;
	        }
	        else if(setArraySet1[i]>setArraySet2[j])
	        {
	           setArray2[k++] = setArraySet2[j];
	           System.out.print("\t"+setArray2[k]);
	            j++;
	        }
	        else{
	        	setArray2[k++]=setArraySet2[j];
	        	i++;
	        	j++;
	        }
	        //System.out.println(setArray1[k]);
	       
	        System.out.print("\t"+setArray2[k]);
	        
	    }
		 IntSet intset=new IntSet(setArray2);
		 return intset;
		
		
	}*/
	public IntSet union(IntSet set){
		int[] setArray2=new int[size()+set.size()];
		int i=0,j=0,k=0,l=0;
		int size;
		if(size()>set.size()){
			size=size();
		}
		else{
			size=set.size();
		}
		while(k<size)
			
	    { 	System.out.println(Arrays.toString(setArray2));
	        if (setArray[i] < set.setArray[j] && i<size() )
	        {
	            setArray2[k] = setArray[i];
	            i++;
	        }
	        else if(setArray[i] > set.setArray[j] && j<set.size())
	        {
	           setArray2[k] = set.setArray[j];
	            j++;
	        }
	        else{
	        	setArray2[k]=set.setArray[j];
	        	i++;
	        	j++;
	        }
	        k++;
	        
	    }
		System.out.println(Arrays.toString(setArray2));
		IntSet intset=new IntSet(setArray2);
		return intset;
	}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	/**
	 * initializes universal array
	 */
	private void initializeUniversalArray(){
		universalArray=new int[1000];
		for(int i=0;i<1000;i++){
			universalArray[i]=i+1;
		}
	}
	/**
	 * compliment of existing set
	 * @return complimented set
	 */
	public IntSet compliment(){
		int counter=0;
		int j=0;
		initializeUniversalArray();
		int[] complimentedArray=new int[universalArray.length];
		for(int i=0;i<1000;i++){
			if(!(isMember(i+1))){
				complimentedArray[j]=i+1;
				j++;}
				
				
			
		}
		System.out.println(Arrays.toString(complimentedArray));
		
		
		int[] compliment=new int[j];
		for(int i=0;i<compliment.length;i++){
			compliment[i]=complimentedArray[i];
		}
		
		IntSet intset=new IntSet(compliment);
		return intset;
	}
	public int[] getSetArray(){
		int[] setArray=new int[this.setArray.length];
		for(int i=0;i<setArray.length;i++){
			setArray[i]=this.setArray[i];
		}
		return setArray;
	}
	
	
}
