package kdu.backend3;

public class StudentUtil {

    private StudentUtil(){

    }


     //Calculate GPA of each student from the list of students
    public static double[] calculateGPA(int[] studentIdList, char[][]
            studentsGrades) throws MissingGradeException {
        if(studentIdList.length != studentsGrades.length){
            throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. studentIdList.length: " + studentIdList.length + ", studentsGrades.length: " + studentsGrades.length);
        }
        double[] studentGPA = new double[studentIdList.length];
        double sum = 0;
        int subjects = 0;
        char grade;
        for(int i = 0; i < studentIdList.length; i++){
            sum = 0;
            subjects = studentsGrades[i].length;
            for(int j = 0; j < subjects; j++){
                grade = studentsGrades[i][j];
                if(grade == 'A'){
                    sum += 4;
                }
                else if(grade == 'B'){
                    sum += 3;
                }
                else if(grade == 'C'){
                    sum += 2;
                }
                else if(grade == ' ') {
                    throw new MissingGradeException(studentIdList[i]);
                }
            }
            studentGPA[i] = sum/subjects;
        }
        return studentGPA;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[]
            studentIdList, char[][] studentsGrades) throws InvalidDataException {
        if(lower>higher || lower<0 || higher<0){
            return new int[0];
        }
        double[] studentGPA = new double[0];
        try {
            studentGPA = calculateGPA(studentIdList, studentsGrades);
        }
        catch (MissingGradeException e){
            throw new InvalidDataException(e.getMessage());
        }
        int count = 0;
        for (int i = 0; i < studentIdList.length; i++) {
            double gpa = studentGPA[i];
            if (gpa <= higher && gpa >= lower) {
                count++;
            }
        }
        int[] studentWithinRangeOfGPA = new int[count];
        int j = 0;
        for (int i = 0; i < studentIdList.length; i++) {
            double gpa = studentGPA[i];
            if (gpa <= higher && gpa >= lower) {
                studentWithinRangeOfGPA[j++] = studentIdList[i];
            }
        }
        return studentWithinRangeOfGPA;
    }
}
