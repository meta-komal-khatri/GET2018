package fcfs;

import java.util.Scanner;

public class JobScheduling {
	public static void main(String[] args){
		JobScheduler jobscheduler=new JobScheduler();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number of Process");
		int size=sc.nextInt();
		jobscheduler.enterProcess(size);
		/*printing processes with their process number,
		 * arrival time,burst time,completion time ,turn around time,waiting time
		*/
		for(int i=0;i<size;i++){
			System.out.println("Process"+(i+1)+"\t\t\t"+jobscheduler.process[i][0]+"\t\t\t"+jobscheduler.process[i][1]+"\t\t\t"+jobscheduler.completionTime(i+1)+"\t\t\t"+jobscheduler.turnAroundTime(i+1)+"\t\t\t"+jobscheduler.WaitingTime(i+1));
		}
			System.out.println("Average Waiting Time"+jobscheduler.averageWaitingTime());
			System.out.println("Max Waiting Time"+jobscheduler.maxWaitingTimeProcess());
		
	}
}
