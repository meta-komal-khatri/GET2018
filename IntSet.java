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
		if(!checkRangeOfSetArray()){
			throw new AssertionError("elements are not in range");
		}
		boolean[] markEnteredValues=new boolean[1001];
		for(int i=1;i<=1000;i++){
			markEnteredValues[i]=false;
		}
		//checks repeated elements exist or not
		for(int i=0;i<setArray.length;i++){
			if(markEnteredValues[setArray[i]]){
				throw new AssertionError("repeated Elements Are Not Allowed");
			}
			else{
				markEnteredValues[setArray[i]]=true;
			}
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
				j++;
			}	
		}		
		int[] compliment=new int[j];
		for(int i=0;i<compliment.length;i++){
			compliment[i]=complimentedArray[i];
		}
		
		IntSet intset=new IntSet(compliment);
		return intset;
	}
	/**
	 * union two sets such that set contains all elements of set1 and set2
	 * @param set should in range from 1-1000
	 * @return set 
	 */
	public IntSet union(IntSet set) {
		int k=0;
		int[] temporaryArray=new int[size()+set.size()];
		for(int i=0;i<size();i++) {
			temporaryArray[k]=setArray[i];
			k++;
		}
		for(int i=0;i<set.size();i++) {
			if(!isMember(set.setArray[i])) {
				temporaryArray[k]=set.setArray[i];
				k++;
			}
		}
		System.out.println(Arrays.toString(temporaryArray));
		int[] setArray=new int[k];
		for(int i=0;i<k;i++) {
			setArray[i]=temporaryArray[i];
		}
		return new IntSet(setArray);
	}
	/**
	 * @return set of array
	 */
	public int[] getSetArray(){
		int[] setArray=new int[this.setArray.length];
		for(int i=0;i<setArray.length;i++){
			setArray[i]=this.setArray[i];
		}
		return setArray;
	}
	
}