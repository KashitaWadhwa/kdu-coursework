package kdu.backend3;


import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws InvalidDataException {

        Logging logger = new Logging();
        int[] studentIdList = {1001, 1002};
        char[][] studentsGrades = {{' ', 'A', 'A', 'B'}, {'A', 'B', 'B'}};
        double[] studentGPA = new double[0];
        try {
            studentGPA = StudentUtil.calculateGPA(studentIdList, studentsGrades);
        } catch (MissingGradeException e) {
            logger.logInfo(e.getMessage());
        }

        int[] studentWithinRangeOfGPA = StudentUtil.getStudentsByGPA(3.2,3.5,studentIdList,studentsGrades);
        logger.logInfo("Printing student's id whose CPA is in given range");
        for (int id : studentWithinRangeOfGPA) {
            logger.logInfo("" + id);
        }
        logger.logInfo("Student gpa: " + Arrays.toString(studentGPA));
    }
}