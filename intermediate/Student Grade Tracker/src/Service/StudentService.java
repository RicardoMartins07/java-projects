package Service;

import Model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService {

    public void registerStudent(Scanner scanner, List<Student> students) {

        scanner.nextLine();

        System.out.println("Please enter the first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Please enter the last name: ");
        String lastName = scanner.nextLine();


        students.add(new Student(firstName, lastName));

        System.out.println("Student Registered Successfully");
    }

    public void assignGrade(Scanner scanner, List<Student> students) {

        scanner.nextLine();

        System.out.println("Please enter the first name of the student: ");
        String firstName = scanner.nextLine();
        List<Student> studentList = searchStudentsByName(students, firstName);


        if (studentList.isEmpty()) {
            System.out.println("There are no matching students with that name");
        } else {
            System.out.println("================== Students ==================");
            int i = 1;
            for (Student s : studentList) {
                System.out.println(i + " - " + s.toString());
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

    public List<Student> searchStudentsByName(List<Student> students, String name) {

        List<Student> filteredStudents = new ArrayList<>();
        for (Student s : students) {
            if (s.getFirstName().equals(name)) {
                filteredStudents.add(s);
            }
        }
        return filteredStudents;
    }

    public void listAllStudents(List<Student> students) {

        if (students.isEmpty()) {
            System.out.println("There are no Students registered!");
            return;
        }

        for (Student s : students) {
            System.out.println(s.toString());
        }
    }

    public void deleteStudent(Scanner scanner, List<Student> students) {

        if (students.isEmpty()) {
            System.out.println("There are no Students registered!");
            return;
        }

        scanner.nextLine();

        System.out.println("Please enter the first name of the student: ");
        String firstName = scanner.nextLine();
        List<Student> studentList = searchStudentsByName(students, firstName);


        if (studentList.isEmpty()) {
            System.out.println("There are no matching students with that name");
        } else {
            System.out.println("================== Students ==================");
            int i = 1;
            for (Student s : studentList) {
                System.out.println(i + " - " + s.toString());
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
                        System.out.println("Student Deleted Successfully!");
                        isValid = true;
                    }
                } else {
                    System.out.println("Please enter a valid number: ");
                    scanner.next();
                }
            }

        }

    }

    public void averageGradeOfStudent(Scanner scanner, List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("There are no Students registered!");
            return;
        }

        scanner.nextLine();

        System.out.println("Please enter the first name of the student: ");
        String firstName = scanner.nextLine();
        List<Student> studentList = searchStudentsByName(students, firstName);

        if (studentList.isEmpty()) {
            System.out.println("There are no matching students with that name");
        } else {
            System.out.println("================== Students ==================");
            int i = 1;
            for (Student s : studentList) {
                System.out.println(i + " - " + s.toString());
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
                        double sumGrades = 0;

                        for (double g : grades) {
                            sumGrades += g;
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

    public void averageGradeOfAllStudents(List<Student> students) {

        if (students.isEmpty()) {
            System.out.println("There are no Students registered!");
            return;
        }

        double sumGrades = 0;
        double numOfGrades = 0;
        for (Student s : students) {
            List<Double> grades = s.getGrades();
            for (double g : grades) {
                sumGrades += g;
                numOfGrades++;
            }
        }

        System.out.println("The average grade of all students is: " + sumGrades / numOfGrades);
    }



    public void doExport(List<Student> students) {
        try {
            FileWriter myWriter = new FileWriter("Students.txt");

            for (Student s : students) {
                StringBuilder line = new StringBuilder();

                line.append(s.getId()).append(" ");
                line.append(s.getFirstName()).append(" ");
                line.append(s.getLastName()).append(" ");

                List<Double> grades = s.getGrades();
                if (!grades.isEmpty()) {
                    line.append("| Grades: ");
                    for (int i = 0; i < grades.size(); i++) {
                        line.append(grades.get(i));
                        if (i < grades.size() - 1) {
                            line.append(", ");
                        }
                    }
                } else {
                    line.append("| Grades: none");
                }

                line.append("\n");
                myWriter.write(line.toString());
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public List<Student> doImport(String filePath) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\| Grades:");

                if (parts.length < 1) continue;


                String[] studentInfo = parts[0].trim().split(" ");
                int id = Integer.parseInt(studentInfo[0]);
                String firstName = studentInfo[1];
                String lastName = studentInfo[2];

                Student student = new Student(firstName, lastName);
                student.setId(id);

                if (parts.length > 1 && !parts[1].trim().equalsIgnoreCase("none")) {
                    String[] gradesStr = parts[1].trim().split(",");
                    for (String gradeStr : gradesStr) {
                        try {
                            double grade = Double.parseDouble(gradeStr.trim());
                            student.getGrades().add(grade);
                        } catch (NumberFormatException e) {
                            System.out.println("Nota inválida ignorada: " + gradeStr);
                        }
                    }
                }

                students.add(student);
            }

            System.out.println("Successfully imported students from file.");

        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }

        return students;
    }
}

