package kdu.backend;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the lower GPA bound: ");
        double lower = scanner.nextDouble();

        System.out.print("Enter the higher GPA bound: ");
        double higher = scanner.nextDouble();

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[] studentIdList = new int[numStudents];
        char[][] studentsGrades = new char[numStudents][];

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student ID for student " + (i + 1) + ": ");
            studentIdList[i] = scanner.nextInt();

            System.out.print("Enter the number of grades for student " + (i + 1) + ": ");
            int numGrades = scanner.nextInt();
            studentsGrades[i] = new char[numGrades];

            System.out.println("Enter grades for student " + (i + 1) + " (A, B, C): ");
            for (int j = 0; j < numGrades; j++) {
                studentsGrades[i][j] = scanner.next().charAt(0);
            }
        }

        // Use the getStudentsByGPA method
        int[] selectedStudents = StudentUtil.getStudentsByGPA(lower, higher, studentIdList, studentsGrades);

        if (selectedStudents == null) {
            System.out.println("Invalid input parameters");
        } else if (selectedStudents.length == 0) {
            System.out.println("No students found within the specified GPA range");
        } else {
            System.out.println("Students with GPA between " + lower + " and " + higher + ":");
            for (int studentId : selectedStudents) {
                System.out.println(studentId);
            }
        }

        // Close the scanner
        scanner.close();
    }
}
