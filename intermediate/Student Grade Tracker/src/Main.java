import Model.Student;
import Service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        /*
        * Funcionalidades
        *
        *
        * //Extras
        *
        * Editar nome
        * Remover nota especifica
        * Ordenar alunos
        * Importar
        * Exportar
        * Top 3 alunos
        *
        *
        * */

        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        showMenu(scanner,students);

        scanner.close();


    }

    public static void showMenu(Scanner scanner, List<Student> students) {

        int option = 0;
        boolean isValid = false;

        StudentService studentService = new StudentService();


        while (!isValid) {
            System.out.println("============== Model.Student Grade Tracker ================");
            System.out.println("1 - Enter a new Model.Student");
            System.out.println("2 - List all Students");
            System.out.println("3 - Assign Grade");
            System.out.println("4 - Average grade of a student");
            System.out.println("5 - Average grade of all students");
            System.out.println("6 - Delete Model.Student");
            System.out.println("0 - Quit");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option == 0) {
                    System.out.println("Exiting... 👋");
                    return;
                } else if (option >= 1 && option <= 6) {
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
        }
    }


}