package kdu.backend;

public class StudentUtil {

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        int numStudents = studentIdList.length;
        double[] result = new double[numStudents];

        for (int i = 0; i < numStudents; i++) {
            int totalPoints = 0;
            int numCourses = studentsGrades[i].length;

            for (int j = 0; j < numCourses; j++) {
                char grade = studentsGrades[i][j];
                int points = switch (grade) {
                    case 'A' -> 4;
                    case 'B' -> 3;
                    case 'C' -> 2;
                    default -> 0; // Consider other grades as 0 points
                };

                totalPoints += points;
            }

            result[i] = (double) totalPoints / numCourses;
        }

        return result;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        // Perform parameter validation
        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }

        // Invoke calculateGPA
        double[] gpas= calculateGPA(studentIdList, studentsGrades);

        // Compute the size of the resulting array
        int count = 0;
        for (double gpa : gpas) {
            if (gpa >= lower && gpa <= higher) {
                count++;
            }
        }

        // Construct the result array
        int[] result = new int[count];
        int index = 0;

        for (int i = 0; i < gpas.length; i++) {
            if (gpas[i] >= lower && gpas[i] <= higher) {
                result[index++] = studentIdList[i];
            }
        }

        return result;
    }
}
