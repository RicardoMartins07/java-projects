import Model.Student;
import Service.StudentService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        

        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService();

        List<Student> students = studentService.doImport("Students.txt");

        showMenu(scanner,students);

        scanner.close();


    }

    public static void showMenu(Scanner scanner, List<Student> students) {

        int option = 0;
        boolean isValid = false;

        StudentService studentService = new StudentService();


        while (!isValid) {
            System.out.println("============== Student Grade Tracker ================");
            System.out.println("1 - Enter a new Student");
            System.out.println("2 - List all Students");
            System.out.println("3 - Assign Grade");
            System.out.println("4 - Average grade of a student");
            System.out.println("5 - Average grade of all students");
            System.out.println("6 - Delete Student");
            System.out.println("7 - Order Students by average grade");
            System.out.println("8 - Top 3 Students by average grade");
            System.out.println("9 - Export");
            System.out.println("0 - Quit");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option == 0) {
                    studentService.doExport(students);
                    System.out.println("Exiting... 👋");
                    return;
                } else if (option >= 1 && option <= 9) {
                    isValid = true;
                } else {
                    System.out.println("Choose a valid option between 0 and 6");
                }
            } else {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
        }

        switch(option){
            case 1:
                studentService.registerStudent(scanner,students);
                showMenu(scanner,students);
                break;
            case 2:
                studentService.listAllStudents(students);
                showMenu(scanner,students);
                break;
            case 3:
                studentService.assignGrade(scanner,students);
                showMenu(scanner,students);
                break;
            case 4:
                studentService.averageGradeOfStudent(scanner,students);
                showMenu(scanner,students);
                break;
            case 5:
                studentService.averageGradeOfAllStudents(students);
                showMenu(scanner,students);
                break;
            case 6:
                studentService. deleteStudent(scanner,students);
                showMenu(scanner,students);
                break;
            case 7:
                studentService.sortStudentsByAverageGrade(students);
                showMenu(scanner,students);
                break;
            case 8:
                studentService.topStudentsByAverage(students);
                showMenu(scanner,students);
                break;
            case 9:
                studentService.doExport(students);
                showMenu(scanner,students);
                break;
        }
    }


}