package scfsession7;

import java.util.Arrays;

public final class SparseMatrice {
	private final static int MAX_ELEMENT=20;
	private final static int ARRAY_COLUMNS=3;
	private final int[][] sparseMatriceArray;
	private int row;
	private int column;
	public SparseMatrice(int[][] sparseMatriceArray,int row,int column) {
		if(sparseMatriceArray.length==0) {
			throw new AssertionError();
		}
		this.sparseMatriceArray=sparseMatriceArray;
		this.row=row;
		this.column=column;
	}
	/**
	 * add two sparse matrices in row-column-value model
	 * @param sparseMatrice
	 * @return addition of two sparse matrices
	 */
	public SparseMatrice addMatrice(SparseMatrice sparseMatrice) {
		//Complexity: O(n) and using merge concept of merge sort
		int[][] sparseMatriceArray=new int[MAX_ELEMENT][ARRAY_COLUMNS];
		int i=0,j=0,k=0;
		if(sparseMatrice.row==row && sparseMatrice.column==column) {
			while(i<this.sparseMatriceArray.length 
					&& j<sparseMatrice.sparseMatriceArray.length) {
				//matrice1.row<matrice2.row or matrice1.column<matrice2.column
				if((this.sparseMatriceArray[i][0]<sparseMatrice.sparseMatriceArray[j][0])
						||( this.sparseMatriceArray[i][0]==sparseMatrice.sparseMatriceArray[j][0] 
								&& this.sparseMatriceArray[i][1]<sparseMatrice.sparseMatriceArray[j][1])){
					sparseMatriceArray[k][0]=this.sparseMatriceArray[i][0];
					sparseMatriceArray[k][1]=this.sparseMatriceArray[i][1];                                                                 
					sparseMatriceArray[k][2]=this.sparseMatriceArray[i][2];
					i++;
					k++;
					
				}
				//matrice1.row>matrice2.row or matrice1.column>matrice2.column
				else if((this.sparseMatriceArray[i][0]>sparseMatrice.sparseMatriceArray[j][0])
						|| (this.sparseMatriceArray[i][0]==sparseMatrice.sparseMatriceArray[j][0] 
								&& this.sparseMatriceArray[i][1]>sparseMatrice.sparseMatriceArray[j][1])) {
					sparseMatriceArray[k][0]=sparseMatrice.sparseMatriceArray[j][0];
					sparseMatriceArray[k][1]=sparseMatrice.sparseMatriceArray[j][1];
					sparseMatriceArray[k][2]=sparseMatrice.sparseMatriceArray[j][2];
					j++;
					k++;
				}
				//row and column both are equal
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
	/**
	 * obtain transpose of given sparse matrix.
	 * @return sparse matrix
	 */
	public SparseMatrice transpose() {
		// complexity: O(n) and counting sort
		int[] count=new int[column+1];
		int[][] sparseMatriceTransposeArray=new int[sparseMatriceArray.length][3];
		for(int i=1;i<=column;i++) {
			count[i]=0;
		}
		for(int i=0;i<sparseMatriceArray.length;i++) {
			count[this.sparseMatriceArray[i][1]]++;
		}
		//counter for position 
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
		return new SparseMatrice(sparseMatriceTransposeArray,this.row,this.column);
	}
	/**
	 * checks whether that sparse matrix is symmetric or not
	 * @return true if matrix is symmetric otherwise false
	 */
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
	/**
	 * converts matrix from normal form to row-column-value
	 * @param inputMatrice
	 * @return converted matrix
	 * @throws AssertionError
	 */
	 int[][] convertMatrice(int[][] inputMatrice) throws AssertionError
	    {
	        //Complexity: O(n^2)
	        if(inputMatrice.length == 0)
	        {
	            throw new AssertionError("Empty Matrix");
	        }
	        int[][] nonZeroMatrice;
	        int nonZeroValuesCounter = 0;
	        for(int i=0; i<inputMatrice.length; i++)
	        {
	            for(int j=0; j<inputMatrice[i].length; j++)
	            {
	                if(inputMatrice[i][j] != 0)
	                {
	                    nonZeroValuesCounter++;
	                }
	            }
	        }
	        nonZeroMatrice = new int[nonZeroValuesCounter][3];
	        nonZeroValuesCounter = 0;
	        for(int i=0; i<inputMatrice.length; i++)
	        {
	            for(int j=0; j<inputMatrice[i].length; j++)
	            {
	                if(inputMatrice[i][j] != 0)
	                {
	                    nonZeroMatrice[nonZeroValuesCounter][0] = i+1;
	                    nonZeroMatrice[nonZeroValuesCounter][1] = j+1;
	                    nonZeroMatrice[nonZeroValuesCounter][2] = inputMatrice[i][j];
	                    nonZeroValuesCounter++;
	                }
	            }
	        }
	        return nonZeroMatrice;
	}
	 /**
	  * multiplies two matrices 
	  * @param sparseMatrice second matrix 
	  * @return sparse matrix
	  */
	public SparseMatrice multiply(SparseMatrice sparseMatrice) {
		if(this.column!=sparseMatrice.row) {
			throw new AssertionError();
		}
		int[][] productMatrix = new int[this.row][sparseMatrice.column];
		System.out.println(this.sparseMatriceArray.length);
		   for(int i=0; i<this.sparseMatriceArray.length; i++)
	        {    System.out.println(i);
	            for(int j=0; j<sparseMatrice.sparseMatriceArray.length; j++)
	            {
	                //for column number of matrix 1 equal to row number of matrix 2
	                if(this.sparseMatriceArray[i][1] == sparseMatrice.sparseMatriceArray[j][0])
	                {
	                    //productMatrix[matrix1.rowNumber][matrix2.columnNumber] += matrix1.value * matrix2.value
	                    productMatrix[this.sparseMatriceArray[i][0]-1][sparseMatrice.sparseMatriceArray[j][1]-1] +=  
	                            this.sparseMatriceArray[i][2] * sparseMatrice.sparseMatriceArray[j][2];
	                }
	                //System.out.println(productMatrix[i][j]+"  "+i+"  "+j);
	            }
	            
	            
	        }
		   System.out.println(Arrays.deepToString(productMatrix));
		   
		   return new SparseMatrice(convertMatrice(productMatrix),this.row,sparseMatrice.column);
	
	}
	/**
	 * @return sparse matrix in array format
	 */
	public int[][] getarray(){
		return sparseMatriceArray;
	}
}