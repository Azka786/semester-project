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
import java.util.Scanner;

/*
 * A teacher can teach one course and manages a default schedule
 * Teacher name: Muzammil
 * Course: OOP
 * Office hours: Monday 10 2h, Friday 20 1h
 */
public class Teacher {
    
private String name;
	private Course course;
	private Schedule officeHours;
	
	/**
	 * Constructor
	 * @param name
	 * @param course
	 * @param officeHours
	 */
	public Teacher(String name, Course course, Schedule officeHours) {
		this.name = name;
		this.course = course;
		this.officeHours = officeHours;
	}
	
	public static Teacher createATeacher(Scanner scanner) {
		System.out.println("\nEnter name of the teacher: ");
		String name = scanner.next();
		System.out.println("\nEnter course: ");
		String courseName = scanner.next();
		Course cour = School.findCourse(courseName);
		
		Schedule sched = Schedule.createASchedule(scanner);
		
		Teacher t = new Teacher(name, cour, sched);
		
		return t;
	}
	
	public String getTeacherInfo() {
		StringBuffer tInfo = new StringBuffer("Teacher Info:");
		tInfo.append("\nName: ");
		tInfo.append(this.name);
		tInfo.append("\tCourse: ");
		tInfo.append(this.course.getName());
		tInfo.append("\n");
		tInfo.append(this.officeHours.getScheduleInfo());
		tInfo.append("-----------------");
		return tInfo.toString();
	}

	public void saveTheData(FileWriter writer) {
		//TODO: save the data 
	}


	/**
	 * Get list of students who are taought by this teacher
	 * @return
	 */
	public Student[] getStudents() {
		Student[] students = null;
		if (course != null) {
			students = course.getStudents();
		}
		return students;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Schedule getOfficeHours() {
		return officeHours;
	}
	public void setOfficeHours(Schedule officeHours) {
		this.officeHours = officeHours;
	}
}
