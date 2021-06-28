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
import java.util.*;
import java.util.Scanner;
public class Test {
 public static void main(String[] args) {
    /**
		 * Course
		 * 			Maths, 3, [{Monday, 0900, 2hr}, {Wednesday, 1300, 2hr}]
		 * 			Physics, 2, [{Monday, 1600, 2hr}, {Wednesday, 1600, 2hr}]*
		 * 			Urdu, 1, [{Tuesday, 0900, 2hr}, {Thursday, 1300, 2hr}]
		 * Teacher
		 * 			T1, Maths, [{Monday, 1000, 2hr}, {Friday, 2000, 1hr}]
		 * 			T2, Physics, [{Tuesday 1200, 1hr}, {Friday 1400, 1hr}]
		 * Student
		 * 			S1, [Maths, Physics], 101
		 * 			S2, [Maths, Physics, Urdu], 102
		 * 			S3, [Physics, Urdu], 103*
		 */
		
		Course maths = new Course("Maths", 3);
		Schedule schedule = new Schedule(new String[]{"Monday", "Wednesday"}, new int[]{9, 13}, new int[] {2, 2}); 
		maths.setSchedule(schedule);

		Course physics = new Course("Physics", 2);
		schedule = new Schedule(new String[]{"Monday", "Wednesday"}, new int[]{16, 16}, new int[] {2, 2}); 
		physics.setSchedule(schedule);

		Course urdu = new Course("Urdu", 1);
		schedule = new Schedule(new String[]{"Tuesday", "Thursday"}, new int[]{9, 13}, new int[] {2, 2}); 
		urdu.setSchedule(schedule);
		
		schedule = new Schedule(new String[]{"Monday", "Friday"}, new int[]{10, 20}, new int[] {2, 1}); 
		Teacher t1 = new Teacher("T1", maths, schedule);

		schedule = new Schedule(new String[]{"Tuesday", "Friday"}, new int[]{12, 14}, new int[] {1, 1}); 
		Teacher t2 = new Teacher("T2", physics, schedule);
		
		Student s1 = new Student("S1", 101, new Course[] {maths, physics});
		Student s2 = new Student("S2", 102, new Course[] {maths, physics, urdu});
		Student s3 = new Student("S3", 103, new Course[] {physics, urdu});
		

		School.addCourse(maths);
		School.addCourse(physics);
		School.addCourse(urdu);
		
		School.addTeacher(t1);
		School.addTeacher(t2);
		
		School.admitStudent(s1);
		School.admitStudent(s2);
		School.admitStudent(s3);
		
                Scanner input= new Scanner (System.in);
		// print student information
		System.out.println(s1.getStudentInfo());
		System.out.println(s2.getStudentInfo());
		System.out.println(s3.getStudentInfo());
		
		System.out.println(t1.getTeacherInfo());
		System.out.println(t2.getTeacherInfo());

		System.out.println(physics.getCourseInfo());
		System.out.println(physics);
		System.out.println(maths.getCourseInfo());
		System.out.println(urdu.getCourseInfo());
}
	

}




    
   

