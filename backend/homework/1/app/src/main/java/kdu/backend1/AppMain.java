package kdu.backend1;

import java.util.Scanner;

public class AppMain {
    static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        StudentRepository sr = new StudentRepository();

        System.out.println("Add details: 1");
        System.out.println("Update details: 2");
        System.out.println("Retrieve info by ID: 3");
        System.out.println("Retrieve info by name: 4");
        System.out.println("Enter Choice: ");

        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                Add(sr);
                break;
            case 2:
                Update(sr);
                break;
            case 3:
                RetrieveID(sr);
                break;
            case 4:
                RetrieveName(sr);
                break;
        }
    }
    public static void Add(StudentRepository sr){
        Student st=new Student();
        System.out.println("Enter ID");
        int id=sc.nextInt();
        st.setId(id);
        System.out.println("Enter Name");
        String name=sc.next();
        st.setName(name);
        System.out.println("Enter Age");
        int age=sc.nextInt();
        st.setAge(age);
        System.out.println("Enter Grade");
        String grade=sc.next();
        st.setGrade(grade);
        sr.add(st);
    }
    public static void Update(StudentRepository sr){
        System.out.println("Enter id and student");
        int id=sc.nextInt();
        Student st=new Student();
        st.setId(id);
        System.out.println("Enter Name");
        String name=sc.next();
        st.setName(name);
        System.out.println("Enter Age");
        int age=sc.nextInt();
        st.setAge(age);
        System.out.println("Enter Grade");
        String grade=sc.next();
        st.setGrade(grade);
        sr.update(id,st);
    }
    public static void RetrieveID(StudentRepository sr){
        System.out.println("Enter Id to be retrieved");
        int id=sc.nextInt();
        Student st=sr.retrieve(id);
        System.out.print(st.getID()+" "+ st.getName()+" "+st.getGrade()+" "+st.getAge());
    }
    public static void RetrieveName(StudentRepository sr) {
        System.out.println("Enter name to be retrieved");
        String name=sc.nextLine();
        Student st =sr.retrieve(name);
    }

}