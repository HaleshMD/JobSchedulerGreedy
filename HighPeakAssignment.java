import java.util.Arrays;
import java.util.Scanner;

public class JobSchedulerGreedy

{
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter the number of Jobs");
	        int n = scanner.nextInt();

	        // create an array to store the jobs
	        Job[] jobs = new Job[n];

	        // input the jobs
	        for (int i = 0; i < n; i++) {
	            System.out.println("Enter job start time, end time, and earnings");
	            int startTime = scanner.nextInt();
	            int endTime = scanner.nextInt();
	            int profit = scanner.nextInt();
	            jobs[i] = new Job(startTime, endTime, profit);
	        }

	        // sort the jobs by their profit in non-increasing order
	        Arrays.sort(jobs, (j1, j2) -> Integer.compare(j2.profit, j1.profit));

	        // select the non-conflicting jobs
	        int maxEarnings = 0;
	        int lastEndTime = 0;
	        int numJobsLeft = n;
	        int totalEarningsLeft = 0;
	        for (int i = 0; i < n; i++) {
	            if (jobs[i].startTime >= lastEndTime) {
	                maxEarnings += jobs[i].profit;
	                lastEndTime = jobs[i].endTime;
	                numJobsLeft--;
	            } else {
	                totalEarningsLeft += jobs[i].profit;
	            }
	        }

	        // output the result
	        System.out.println("The number of tasks and earnings available for others");
	        System.out.println("Task: " + numJobsLeft);
	        System.out.println("Earnings: " + totalEarningsLeft);
	    }
	}

	class Job {
	    int startTime;
	    int endTime;
	    int profit;

	    public Job(int startTime, int endTime, int profit) {
	        this.startTime = startTime;
	        this.endTime = endTime;
	        this.profit = profit;
	    }
	}


