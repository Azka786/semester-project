/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagementsystem;

/**
 *
 * @author IT SYSTEMS
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Schedule {
   private String[] days;
	private int[] time;
	private int[] duration;
	
	public Schedule() {
		// Monday Wednesday 
		// 10AM, 10AM
		// 2 hrs, 1hr
		
		this.days = new String[2];
		this.days[0] = "Monday";
		this.days[1] = "Wednesday";
		
		this.time = new int[2];
		this.time[0] = 10;
		this.time[1] = 10;

		this.duration = new int[2];
		this.duration[0] = 2;
		this.duration[1] = 1;
	}
	public Schedule(String[] days, int[] time, int[] duration) {
		this.days = days;
		this.time = time;
		this.duration = duration;
	}
	
	public void saveTheData(FileWriter writer) throws IOException {
		if (days != null && days.length > 0) {			
			for (int i = 0; i < days.length; i++) {
				writer.write(days[i]);
				writer.write("\n");
				writer.write(new Integer(time[i]).toString());
				writer.write("\n");
				writer.write(new Integer(duration[i]).toString());
				writer.write("\n");
			}		
		}
	}

	/**
	 * This function assumes a schedule always have two sessions
	 * @param scanner * @return
	 */
	public static Schedule createASchedule(Scanner scanner) {
		System.out.println("\nEnter first entry for schedule: ");
		System.out.println("\nDay: ");
		String firstDay = scanner.next();
		System.out.println("\nTime: ");
		int firstTime = scanner.nextInt();
		System.out.println("\nDuration: ");
		int firstDuration = scanner.nextInt();
		
		System.out.println("\nEnter second entry for schedule: ");
		System.out.println("\nDay: ");
		String secondDay = scanner.next();
		System.out.println("\nTime: ");
		int secondTime = scanner.nextInt();
		System.out.println("\nDuration: ");
		int secondDuration = scanner.nextInt();
		
		String[] days = new String[]{firstDay, secondDay};
		int[] times = new int[] {firstTime, secondTime};
		int[] durations = new int[] {firstDuration, secondDuration};
		
		Schedule schedule = new Schedule(days, times, durations);
		return schedule;
	}
	
	// Monday at 10 for 2 hrs
	// Wednesday at 10 for 1 hrs
	public String getScheduleInfo() {
		String schedule = "";
		for (int i =0; i < this.days.length; i++) {
			schedule = schedule.concat(this.days[i] + " at " + this.time[i] + 
					" for " + this.duration[i] + " hrs\n");
		}
		return schedule;
	}
	
	public static void main(String[] args) {
		Schedule schedule = new Schedule();
		System.out.println(schedule.getScheduleInfo());
	}
    
    
    
    
    
    
}
 

