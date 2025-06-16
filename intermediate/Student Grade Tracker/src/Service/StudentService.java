package Service;

import Model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService {

    public  void registerStudent(Scanner scanner, List<Student> students){

        scanner.nextLine();

        System.out.println("Please enter the first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Please enter the last name: ");
        String lastName = scanner.nextLine();


        students.add(new Student(firstName,lastName));

        System.out.println("Model.Student Registered Successfully");
    }

    public  void assignGrade(Scanner scanner, List<Student> students){

        scanner.nextLine();

        System.out.println("Please enter the first name of the student: ");
        String firstName = scanner.nextLine();
        List<Student> studentList = searchStudentsByName(students,firstName);


        if (studentList.isEmpty()){
            System.out.println("There are no matching students with that name");
        }else {
            System.out.println("================== Students ==================");
            int i =1;
            for (Student s : studentList){
                System.out.println(i+" - "+s.toString());
                i++;
            }

            boolean isValid = false;

            System.out.println("Choose the student you want to assign a grade: ");
            int index = 0;
            while (!isValid) {
                if (scanner.hasNextInt()) {
                    index = scanner.nextInt() - 1;
                    if (index < 0 || index >= studentList.size()) {
                        System.out.println("Please enter a valid option: ");

                    } else {
                        System.out.println("Grade between 0 and 20: ");
                        double grade = scanner.nextDouble();
                        Student studentToAssignGrade = studentList.get(index);
                        List<Double> grades = studentToAssignGrade.getGrades();
                        grades.add(grade);
                        System.out.println("Grade assigned Successfully!");
                        isValid = true;
                    }
                } else {
                    System.out.println("Please enter a valid number: ");
                    scanner.next();
                }
            }

        }


    }

    public  List<Student> searchStudentsByName(List<Student> students, String name){

        List <Student> filteredStudents = new ArrayList<>();
        for (Student s : students){
            if (s.getFirstName().equals(name)){
                filteredStudents.add(s);
            }
        }
        return filteredStudents;
    }

    public  void listAllStudents(List<Student> students){

        if (students.isEmpty()){
            System.out.println("There are no Students registered!");
            return;
        }

        for (Student s : students){
            System.out.println(s.toString());
        }
    }

    public  void deleteStudent(Scanner scanner, List<Student> students){

        if (students.isEmpty()){
            System.out.println("There are no Students registered!");
            return;
        }

        scanner.nextLine();

        System.out.println("Please enter the first name of the student: ");
        String firstName = scanner.nextLine();
        List<Student> studentList = searchStudentsByName(students,firstName);


        if (studentList.isEmpty()){
            System.out.println("There are no matching students with that name");
        }else {
            System.out.println("================== Students ==================");
            int i =1;
            for (Student s : studentList){
                System.out.println(i+" - "+s.toString());
                i++;
            }

            boolean isValid = false;

            System.out.println("Choose the student you want to delete: ");
            int index = 0;
            while (!isValid) {
                if (scanner.hasNextInt()) {
                    index = scanner.nextInt() - 1;
                    if (index < 0 || index >= studentList.size()) {
                        System.out.println("Please enter a valid option: ");

                    } else {
                        Student studentToDelete = studentList.get(index);
                        students.remove(studentToDelete);
                        System.out.println("Model.Student Deleted Successfully!");
                        isValid = true;
                    }
                } else {
                    System.out.println("Please enter a valid number: ");
                    scanner.next();
                }
            }

        }

    }

    public  void averageGradeOfStudent(Scanner scanner, List<Student> students){
        if (students.isEmpty()){
            System.out.println("There are no Students registered!");
            return;
        }

        scanner.nextLine();

        System.out.println("Please enter the first name of the student: ");
        String firstName = scanner.nextLine();
        List<Student> studentList = searchStudentsByName(students,firstName);

        if (studentList.isEmpty()){
            System.out.println("There are no matching students with that name");
        }else {
            System.out.println("================== Students ==================");
            int i =1;
            for (Student s : studentList){
                System.out.println(i+" - "+s.toString());
                i++;
            }

            boolean isValid = false;

            System.out.println("Choose the student you want to calculate the average grade: ");
            int index = 0;
            while (!isValid) {
                if (scanner.hasNextInt()) {
                    index = scanner.nextInt() - 1;
                    if (index < 0 || index >= studentList.size()) {
                        System.out.println("Please enter a valid option: ");

                    } else {
                        Student s = studentList.get(index);
                        List<Double> grades = s.getGrades();
                        double sumGrades=0;

                        for (double g : grades){
                            sumGrades+= g;
                        }

                        double avg = sumGrades / grades.size();
                        System.out.println("The average is: " + avg);

                        isValid = true;
                    }
                } else {
                    System.out.println("Please enter a valid number: ");
                    scanner.next();
                }
            }

        }
    }

    public  void averageGradeOfAllStudents(List<Student> students){

        if(students.isEmpty()){
            System.out.println("There are no Students registered!");
            return;
        }

        double sumGrades = 0;
        double numOfGrades = 0;
        for (Student s : students){
            List<Double> grades = s.getGrades();
            for (double g : grades){
                sumGrades+= g;
                numOfGrades++;
            }
        }

        System.out.println("The average grade of all students is: " + sumGrades/numOfGrades);
    }
}
