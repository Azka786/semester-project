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
public class Student {
   private String name;
	private Course[] courses = new Course[5];
	private int courseEnrolled = 0;
	private int number;
	private int[] grades;
	
	public Student(String name, int number) {
		this.name = name;
		this.number = number;
	}
	public Student(String name, int number, Course[] courses) {
		this(name, number);
		if (courses != null && courses.length != 0 && courses.length < 5) {
			for (int i = 0; i < courses.length; i++ ) {
				this.courses[i] = courses[i];
			}
			this.courseEnrolled = courses.length;
		}
	}
	
	/**
	 * Register student to a new course
	 * @return
	 */
	public void addCourse(Course course) {
		if (courses == null || courses.length == 0) {
			System.out.println("Error: Courses array is NULL.");
		} else {
			if (this.courseEnrolled < 5) {
				this.courses[this.courseEnrolled] = course;
				this.courseEnrolled++;
			} else {
				System.out.println("Error: A student can only "
						+ "register to max 5 courses.");
			}			
		}
	}
	
	public static Student createNewStudent(Scanner scanner) {
		System.out.println("\nEnter student's name: "); 
		String name = scanner.nextLine();
		System.out.println("\nEnter student's roll number: "); 
		int number = scanner.nextInt();

		Student student = new Student(name, number);
		return student;
	}

	/*
	 * Update implementation
	 */
	public String getStudentInfo() {
		String sInfo = "Student Information\n";
		sInfo = sInfo + "Name: " + this.name + "\t"; 
		sInfo = sInfo + "Roll Number: " + this.number + "\n";
		
		for (int i =0; i < this.courseEnrolled ; i++) {
			sInfo = sInfo + "Course " + (i+1) + ": " + this.courses[i].getName() + "\n";
		}
		sInfo = sInfo + "------------------";
		return sInfo;
	}
	
	public void saveTheData(FileWriter writer) throws IOException {
		// TODO: save name, number, courses, courseEnrolled and grades

		writer.write(this.name);
		writer.write("\n");
		
		writer.write(new Integer(this.number).toString());
		writer.write("\n");

		writer.write(new Integer(this.courseEnrolled).toString());
		writer.write("\n");
		
		for (int i = 0; i < courseEnrolled; i++) {
			writer.write(courses[i].getName() + "\n");
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Course[] getCourses() {
		return courses;
	}
	public void setCourses(Course[] courses) {
		this.courses = courses;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int[] getGrades() {
		return grades;
	}
	public void setGrades(int[] grades) {
		this.grades = grades;
	}
	public int getCourseEnrolled() {
		return courseEnrolled;
	}
	public void setCourseEnrolled(int courseEnrolled) {
		this.courseEnrolled = courseEnrolled;
	}
	
} 
    
    
    
    
  

