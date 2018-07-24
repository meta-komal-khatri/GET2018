package scfsession6;

public final class IntSet {
  private final int[] setArray;
  private int[] universalArray;
	public IntSet(int[] setArray){
		if(setArray.length==0){
			throw new AssertionError("Set Empty");
		}
		for(int i=0;i<setArray.length;i++){
			if(setArray[i]>=setArray[i+1]){
				throw new AssertionError("Set must be sorted in increasing order or no duplicate elements allowed");
			}
		}
		if(!checkRangeOfSetArray()){
			throw new AssertionError("elements are not in range");
		}
		this.setArray=setArray;
	}
	public boolean isMember(int x){
		for(int i=0;i<size();i++){
			if(setArray[i]==x){
				return true;
			}
		}
		return false;
	}
	public int size(){
		return setArray.length;
	}
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
	private boolean checkRangeOfSetArray(){
		for(int i=0;i<size();i++){
			if(setArray[i]<1 || setArray[i]>1000){
				return false;
			}
		}
		return true;
	}
	public IntSet unionSet(IntSet set1){
		int[] setArray1=new int[set1.size()+size()];
		int i=0,j=0,k=0;
		 while (i < set1.size() && j < size())
		    {
		        if (set1.setArray[i] < setArray[j])
		        {
		            setArray1[k] = set1.setArray[i];
		            i++;
		        }
		        else if(set1.setArray[i]>setArray[j])
		        {
		           setArray1[k] = setArray[j];
		            j++;
		        }
		        else{
		        	setArray1[k]=set1.setArray[j];
		        	i++;
		        	j++;
		        }
		        k++;
		    }
		 IntSet intset=new IntSet(setArray1);
		 return intset;
	}
	private void initializeUniversalArray(){
		universalArray=new int[1000];
		for(int i=0;i<1000;i++){
			universalArray[i]=i+1;
		}
	}
	public IntSet compliment(){
		initializeUniversalArray();
		int[] complimentedArray=new int[universalArray.length];
		for(int i=0;i<1000;i++){
			if(!isMember(i+1)){
			complimentedArray[i]=universalArray[i];
			}
		}
		IntSet intset=new IntSet(complimentedArray);
		return intset;
	}
	
	
}
