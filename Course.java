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
public class Course {
    private float creditHours;
	private Schedule schedule; 
	
	private Student[] students = new Student[50];
	private int studentCount = 0;
	
	private Teacher teacher;
	
	public Course(String name, float creditHours) {
		this.name = name;
		this.creditHours = creditHours;
	}

	public Course(String name, float creditHours, Schedule schedule) {
		this(name, creditHours);
		this.schedule = schedule;
	}
	
	public static Course createACourse(Scanner scanner) {
		Course course = null;
		
		System.out.println("\nEnter course name: "); 
		String name = scanner.nextLine();
		System.out.println("\nEnter course credit hours: "); 
		float ch = scanner.nextFloat();
		System.out.println("\nIs schedule decided? (y/n): ");
		String sch = scanner.next();
		
		if (sch.equals("y")) {
			Schedule schedule = Schedule.createASchedule(scanner);
			course = new Course(name, ch, schedule);
		} else {
			course = new Course(name, ch);	
		}
		
		return course;
	}
	
	public String getCourseInfo() {
		StringBuffer cInfo = new StringBuffer("Course Info:");
		cInfo.append("\nName: ");
		cInfo.append(this.name);
		cInfo.append("\tCredit hours: ");
		cInfo.append(this.creditHours);
		cInfo.append("\n");
		if (this.schedule != null) {
			cInfo.append(this.schedule.getScheduleInfo());
		}
		cInfo.append("-----------------");
		return cInfo.toString();
	}

	public void saveTheData(FileWriter writer) throws IOException {
		
		writer.write(this.name);
		writer.write("\n");
		
		writer.write(new Float(this.creditHours).toString());
		writer.write("\n");

		if (this.schedule != null) {
			writer.write("y\n");
			this.schedule.saveTheData(writer);
		} else {
			writer.write("n\n");			
		}

	}

	@Override
	public String toString() {
		return this.getCourseInfo();
	}

	/**
	 * Add student to this course
	 * @param student
	 */
	public void addStudent(Student student) {
		this.students[this.studentCount++] = student;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(float creditHours) {
		this.creditHours = creditHours;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


}
