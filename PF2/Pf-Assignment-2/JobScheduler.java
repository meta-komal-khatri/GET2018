package fcfs;

import java.util.Scanner;

public class JobScheduler {
	int[][] process;
	Scanner sc=new Scanner(System.in);
	int size;
	public void enterProcess(int size){
		this.size=size;
		process=new int[size][2];
		for(int i=0;i<size;i++){
			System.out.println("enter Arrival Time And Busrt Time For Process"+(i+1));
			for(int j=0;j<2;j++){
				process[i][j]=sc.nextInt();
			}
		}
	}
	/*
	 * calculate completion time for process whose number is given 
	 * @param processnumber number of process
	 * @returns totalTime taken by every process to complete their execution
	 */
	public int completionTime(int processnumber){
		int totalTime=0;
		if(processnumber<=size){
			for(int i=0;i<processnumber;i++){
				if(totalTime - process[i][0] >= 0){
					totalTime+=process[i][1];
				}
				else{
					int TimeDifference=process[i][0]-totalTime;
					totalTime+=process[i][1]+TimeDifference;
				}
			}
		}
		
		else{
			System.out.println("No Such Process");
			return -1;
		}
		return totalTime;
	}
	/*
	 * calculate turn around time for process whose number is given 
	 * @param processnumber number of process
	 * @returns totalAroundtime taken by every process to complete their execution after its arrival
	 */
	public int turnAroundTime(int processnumber){
		int totalTime=completionTime(processnumber);
		int turnAroundtime=totalTime-process[processnumber-1][0];
		
		return turnAroundtime;
	}
	/*public int[] waitingTime(){
		int []waitingArray=new int[size];
		for(int i=0;i<size;i++){
			waitingArray[i]=completionTime(i)-turnAroundTime(i);
		}
		return waitingArray;
	}*/
	/*
	 * calculate waiting time for process whose number is given 
	 * @param processnumber number of process
	 * @returns total waiting time taken by every process  after its arrival
	 */
	
	public int WaitingTime(int i){
		int waitingTime=turnAroundTime(i)-process[i-1][1];
		
		/*if(waitingTime>=process[i-1][0]){
			return 0;
		}*/
		return waitingTime;
	}/*
	 * calculate maximum waiting time among all processes
	 * @returns maxWaittimeProcess
	 */
	public int maxWaitingTimeProcess(){
		int maxWaitTimeProcess=WaitingTime(1);
		for(int i=2;i<=size;i++){
		if(maxWaitTimeProcess<WaitingTime(i)){
			maxWaitTimeProcess=WaitingTime(i);
		}
		}
		return maxWaitTimeProcess;
	}
	/*
	 * calculate average waiting time for all processes
	 * @returns averageWaitingTime
	 */
	public int averageWaitingTime(){
		int averageTime=0;
		for(int i=0;i<size;i++){
			averageTime+=WaitingTime(i+1);
			
		}
		averageTime=(int) (averageTime/size);
		return averageTime;
	}
}
