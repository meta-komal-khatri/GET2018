package scfsession7;

import java.util.Arrays;

public final class SparseMatrice {
	private final static int MAX_ELEMENT=20;
	private final static int ARRAY_COLUMNS=3;
	private final int[][] sparseMatriceArray;
	private int row;
	private int column;
	public SparseMatrice(int[][] sparseMatriceArray,int row,int column) {
		this.sparseMatriceArray=sparseMatriceArray;
		this.row=row;
		this.column=column;
	}
	public SparseMatrice addMatrice(SparseMatrice sparseMatrice) {
		int[][] sparseMatriceArray=new int[MAX_ELEMENT][ARRAY_COLUMNS];
		int i=0,j=0,k=0;
		if(sparseMatrice.row==row && sparseMatrice.column==column) {
			while(i<this.sparseMatriceArray.length 
					&& j<sparseMatrice.sparseMatriceArray.length) {
				if((this.sparseMatriceArray[i][0]<sparseMatrice.sparseMatriceArray[j][0])
						||( this.sparseMatriceArray[i][0]==sparseMatrice.sparseMatriceArray[j][0] 
								&& this.sparseMatriceArray[i][1]<sparseMatrice.sparseMatriceArray[j][1])){
					sparseMatriceArray[k][0]=this.sparseMatriceArray[i][0];
					sparseMatriceArray[k][1]=this.sparseMatriceArray[i][1];                                                                 
					sparseMatriceArray[k][2]=this.sparseMatriceArray[i][2];
					i++;
					k++;
					
				}
				else if((this.sparseMatriceArray[i][0]>sparseMatrice.sparseMatriceArray[j][0])
						|| (this.sparseMatriceArray[i][0]==sparseMatrice.sparseMatriceArray[j][0] 
								&& this.sparseMatriceArray[i][1]>sparseMatrice.sparseMatriceArray[j][1])) {
					sparseMatriceArray[k][0]=sparseMatrice.sparseMatriceArray[j][0];
					sparseMatriceArray[k][1]=sparseMatrice.sparseMatriceArray[j][1];
					sparseMatriceArray[k][2]=sparseMatrice.sparseMatriceArray[j][2];
					j++;
					k++;
				}
				else {
					sparseMatriceArray[k][2]=this.sparseMatriceArray[i][2]+sparseMatrice.sparseMatriceArray[j][2];
					if(sparseMatriceArray[k][2]!=0) {
						sparseMatriceArray[k][0]=sparseMatrice.sparseMatriceArray[j][0];
						sparseMatriceArray[k][1]=sparseMatrice.sparseMatriceArray[j][1];
						i++;
						j++;
						k++;
					}
				}
				
			}
			if(i<this.sparseMatriceArray.length) {
				while(i<this.sparseMatriceArray.length) {
					sparseMatriceArray[k][0]=this.sparseMatriceArray[i][0];
					sparseMatriceArray[k][1]=this.sparseMatriceArray[i][1];
					sparseMatriceArray[k][2]=this.sparseMatriceArray[i][2];
					i++;
					k++;
				}
			}
			else {
				while(j<sparseMatrice.sparseMatriceArray.length) {
					System.out.println(k);
					sparseMatriceArray[k][0]=sparseMatrice.sparseMatriceArray[j][0];
					sparseMatriceArray[k][1]=sparseMatrice.sparseMatriceArray[j][1];
					sparseMatriceArray[k][2]=sparseMatrice.sparseMatriceArray[j][2];
					j++;
					k++;
					
				}
			}
		}
		else {
			throw new AssertionError("Both matrice should be of same size");
		}
		int[][] sparseMatriceArray1=new int[k][3];
		for(int x=0;x<k;x++) {
			sparseMatriceArray1[x][0]=sparseMatriceArray[x][0];
			sparseMatriceArray1[x][1]=sparseMatriceArray[x][1];
			sparseMatriceArray1[x][2]=sparseMatriceArray[x][2];
		}
		return new SparseMatrice(sparseMatriceArray1,row,column);
	}
	public SparseMatrice transpose() {
		int[] count=new int[column+1];
		int[][] sparseMatriceTransposeArray=new int[sparseMatriceArray.length][3];
		for(int i=1;i<=column;i++) {
			count[i]=0;
		}
		for(int i=0;i<sparseMatriceArray.length;i++) {
			count[this.sparseMatriceArray[i][1]]++;
		}
		for(int i=2;i<=column;i++){
			count[i]=count[i-1]+count[i];
		}
		System.out.println(Arrays.toString(count));
		for(int i=sparseMatriceArray.length-1;i>=0;i--){
			sparseMatriceTransposeArray[count[sparseMatriceArray[i][1]]-1][0]=sparseMatriceArray[i][1];
			sparseMatriceTransposeArray[count[sparseMatriceArray[i][1]]-1][1]=sparseMatriceArray[i][0];
			sparseMatriceTransposeArray[count[sparseMatriceArray[i][1]]-1][2]=sparseMatriceArray[i][2];
			count[sparseMatriceArray[i][1]]--;
		}
		System.out.println(Arrays.deepToString(sparseMatriceTransposeArray));
		/*for(int i=0;i<column;i++) {
			for(int j=0;j<this.sparseMatriceArray.length;j++) {
				if(count[i+1]!=0) {
					if(this.sparseMatriceArray[j][1]==count[i+1]) {
						sparseMatriceArray[k][1]=this.sparseMatriceArray[j][0];
						sparseMatriceArray[k][0]=this.sparseMatriceArray[j][1];
						sparseMatriceArray[k][2]=this.sparseMatriceArray[j][2];
						k++;
						count[i+1]--;
					}
				}
				else {
					break;
				}
			}
		}*/
		return new SparseMatrice(sparseMatriceTransposeArray,this.row,this.column);
	}
	public boolean isSymmetric(){
		int[][] transposeMatrice=transpose().getarray();
		System.out.println(Arrays.deepToString(sparseMatriceArray));
		System.out.println(Arrays.deepToString(transposeMatrice));
		for(int i=0;i<sparseMatriceArray.length;i++){
			if(sparseMatriceArray[i][0]!=transposeMatrice[i][0] 
					|| sparseMatriceArray[i][1]!=transposeMatrice[i][1] ||  sparseMatriceArray[i][2]!=transposeMatrice[i][2] ){
				return false;
			}
		}
		return true;
	}
	public int[][] getarray(){
		return sparseMatriceArray;
	}
}