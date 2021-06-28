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

import java.util.Scanner;
public class SchoolmanagementSystem {
      
          public static int menu(){
		int command = 0;
            Scanner input=new Scanner(System.in);
                    
		System.out.println("Enter your command,\n");
		System.out.println("To add a student: enter 1\n");
		System.out.println("To add a course: enter 2\n");
		System.out.println("To add a teacher: enter 3\n");
		System.out.println("To print list of students: enter 4\n");
		System.out.println("To exit: enter 0\n");
		Scanner scanner = new Scanner(System.in);
		command = scanner.nextInt();
		return command;
	}

	public static void addAStudent() {
		Scanner scanner = new Scanner(System.in);
		Student student = Student.createNewStudent(scanner);
		School.admitStudent(student);
	}
	
	public static void addACourse() {
		Scanner scanner = new Scanner(System.in);
		Course course = Course.createACourse(scanner);
		School.addCourse(course);
	}
	
	public static void addATeacher() {
		Scanner scanner = new Scanner(System.in);
		Teacher teacher = Teacher.createATeacher(scanner);
		School.addTeacher(teacher);
	}
    public static void main(String[] args) {
        
        
        // TODO: Load the data
		
		int command = menu();
		while (command != 0) {
			if (command == 1) {
				addAStudent();
			} else if (command == 2) {
				addACourse();
			} else if (command == 3) {
				addATeacher();
			} else if (command == 4) {
				School.printStudentList();
			} else if (command == 5) {
				School.printCourseList();
			} else if (command == 6) {
				School.printTeacherList();
			}
			command = menu();
		}

		School.saveTheData();
	}

        
}
    

  