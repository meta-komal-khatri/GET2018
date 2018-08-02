package marksheet;

import java.util.Scanner;

public class StudentMarks {
	float[] student;
	Scanner sc=new Scanner(System.in);
	public StudentMarks(int size){
		student=new float[size];
	}
	/**
	 * function to take input from user for students marks
	 * @return it returns nothing
	 */
	public void enterMarks(){
		for(int i=0;i<student.length;i++){
			System.out.println("Marks for Student"+(i+1)+":");
			student[i]=sc.nextInt();
			if(student[i]<0 || student[i]>100){
				System.out.println("not valid marks");
				i--;
			}
		}
	}
	/**
	 * calculate average marks for a list of students marks
	 * 
	 * @return average 
	 */
	public float averageMarks(){
		float sum=0,average=0;
		for(int i=0;i<student.length;i++){
			sum+=student[i];
		}
		average=(float) sum/(student.length);
		return average;
	}
	/**
	 * finds max grade value 
	 * @return max grade value 
	 */
	public float maxGrade(){
		float max=0;
		for(int i=0;i<student.length;i++){
			if(max<student[i]){
				max=student[i];
			}
		}
		return max;
	}
	/**
	 * finds min grade value 
	 * @return min grade value 
	 */
	public float minGrade(){
		float min=101;
		for(int i=0;i<student.length;i++){
			if(min>student[i]){
				min=student[i];
			}
		}
		return min;
	}
	/**
	 * finds percentage of number passed
	 * @return percentage of passed students  
	 */
	public float studentPassed(){
		int passed=0;
		for(int i=0;i<student.length;i++){
			if(student[i]>=40){
				
				passed++;
				System.out.println(passed);
			}
		}
		
		float percentage=(float) ((passed*100)/(student.length));
		System.out.println(percentage);
		return percentage;
	}
}
