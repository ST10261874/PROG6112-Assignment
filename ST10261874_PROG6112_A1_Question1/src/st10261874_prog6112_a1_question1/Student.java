/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10261874_prog6112_a1_question1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    
  //private variables
    private int studentID;
    private String studentName;
    private int studentAge;
    private String studentEmail;
    private String studentCourse;

    //list to store student objects
    List<Student> studentList = new ArrayList<>();

    //constructor
   public Student(int studentID, String studentName, int studentAge, String studentEmail, String studentCourse) {
    this.studentID = studentID;
    this.studentName = studentName;
    this.studentAge = studentAge;
    this.studentEmail = studentEmail;
    this.studentCourse = studentCourse;
}

    // Setter and getter methods for all fields
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    // Method to capture and save student details
    public void saveStudent(Scanner kb) {
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("*************************");

        System.out.println("Enter the student id:");
        setStudentID(kb.nextInt());
        kb.nextLine();

        System.out.println("Enter the student name:");
        setStudentName(kb.nextLine());

        while (true) {
            System.out.println("Enter the student age (must be 16 or older, and only numbers are allowed):");
            String ageInput = kb.nextLine();

            if (ageInput.matches("\\d+")) {
                setStudentAge(Integer.parseInt(ageInput));
                if (getStudentAge() >= 16) {
                    break;
                } else {
                    System.out.println("You have entered an incorrect student age!!!");
                    System.out.println("Please re-enter the student age >>");
                }
            } else {
                System.out.println("You have entered an incorrect student age!!!");
                System.out.println("Please re-enter the student age >>");
            }
        }

        System.out.println("Enter the student email:");
        setStudentEmail(kb.nextLine());

        System.out.println("Enter the student course:");
        setStudentCourse(kb.nextLine());

     Student newStudent = new Student(getStudentID(), getStudentName(), getStudentAge(), getStudentEmail(), getStudentCourse());
        studentList.add(newStudent);

        System.out.println("\n\n*********************************");
        System.out.println("Details captured");
        System.out.println("*********************************\n\n");

        System.out.println("Enter (1) to launch menu or any other key to exit");
        String userInput = kb.nextLine();

        //menu options 
        switch (userInput) {
            case "1":
                System.out.println("Please select one of the following menu items:");
                System.out.println("(1) Capture a new student.");
                System.out.println("(2) Search for a student.");
                System.out.println("(3) Delete a student.");
                System.out.println("(4) Print student report.");
                System.out.println("(5) Exit application.");
                break;

            default:
                System.out.println("Exiting");
        }
        
       /*
        another switch is used
        if else statement would be too long
        switch is much more efficient
        */
        
        String Input = kb.nextLine();
        switch (Input) {
            case "1":
                saveStudent(kb);
                break;
            case "2":
                searchStudent(kb);
                break;
            case "3":
                deleteStudent(kb);
                break;
            case "4":
                studentReport();
                break;
            case "5":
                exitStudentApplication();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

     // Method to search for a student by studentID
    public Student searchStudent(Scanner kb) {
        int searchQuery;
        boolean found = false;

        System.out.println("Enter the student id to search: ");
        searchQuery = kb.nextInt();
        kb.nextLine(); // Consume the newline character

        for (Student student : studentList) {
            if (student.getStudentID() == searchQuery) {
                System.out.println("-----------------------------------------");
                System.out.println("STUDENT ID: " + student.getStudentID());
                System.out.println("STUDENT NAME: " + student.getStudentName());
                System.out.println("STUDENT AGE: " + student.getStudentAge());
                System.out.println("STUDENT EMAIL: " + student.getStudentEmail());
                System.out.println("STUDENT COURSE: " + student.getStudentCourse());
                System.out.println("-----------------------------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("-----------------------------------------");
            System.out.println("Student with Student ID " + searchQuery + " was not found!");
            System.out.println("-----------------------------------------");
        }

        System.out.println("Enter (1) to launch menu or any other key to exit");
        String userInput = kb.nextLine();

        //menu options
        switch (userInput) {
            case "1":
                System.out.println("Please select one of the following menu items:");
                System.out.println("(1) Capture a new student.");
                System.out.println("(2) Search for a student.");
                System.out.println("(3) Delete a student.");
                System.out.println("(4) Print student report.");
                System.out.println("(5) Exit application.");
                break;

            default:
                System.out.println("Exiting");
        }
        String Input = kb.nextLine();
        switch (Input) {
            case "1":
                saveStudent(kb);
                break;
            case "2":
                searchStudent(kb);
                break;
            case "3":
                deleteStudent(kb);
                break;
            case "4":
                studentReport();
                break;
            case "5":
                exitStudentApplication();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return null;
    }

    // Method to delete a student by studentID
    public boolean deleteStudent(Scanner kb) {
        int deleteID;
        System.out.println("Enter the student id to delete: ");
        deleteID = kb.nextInt();
        kb.nextLine(); // adds new line

        boolean studentFound = false;
        for (Student student : studentList) {
            if (student.getStudentID() == deleteID) {
                studentFound = true;
                break;
            }
        }

        if (!studentFound) {
            System.out.println("No student found with ID " + deleteID);
            return false;
        }

        System.out.println("Are you sure you want to delete student " + deleteID + " from the system? Yes (y) to delete.");
        String confirmDelete = kb.nextLine().toLowerCase();

        if (confirmDelete.equals("y")) {
            for (Student student : studentList) {
                if (student.getStudentID() == deleteID) {
                    studentList.remove(student);
                    System.out.println("-----------------------------------------");
                    System.out.println("Student with Student Id " + deleteID + " WAS deleted!");
                    System.out.println("-----------------------------------------");
                    break;
                }
            }
            return true;
        } else {
            System.out.println("Deletion canceled.");
            return false;
        }
        
    }

    
    // Method to check if a given age is valid (16 or older)
    public boolean isValidAge(int age) {
        return age >= 16;
    }

    // Method to check if a string represents a valid age
    public boolean isValidAge(String ageInput) {
        try {
            int age = Integer.parseInt(ageInput);
            return isValidAge(age);
        } catch (NumberFormatException e) {
            return false; // Not a valid number
        }
    }

    
    // Method to print a report of all students
    public void studentReport() {
        if (studentList.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            int studentCount = 1;

            for (Student student : studentList) {
                System.out.println("STUDENT " + studentCount);
                System.out.println("-----------------------------------------");
                System.out.println("STUDENT ID: " + student.getStudentID());
                System.out.println("STUDENT NAME: " + student.getStudentName());
                System.out.println("STUDENT AGE: " + student.getStudentAge());
                System.out.println("STUDENT EMAIL: " + student.getStudentEmail());
                System.out.println("STUDENT COURSE: " + student.getStudentCourse());
                studentCount++;
            }
            System.out.println("-----------------------------------------");
        }

        System.out.println("Enter (1) to launch menu or any other key to exit");
        Scanner kb = new Scanner(System.in);
        String userInput = kb.nextLine();

        //switch used to either launch menu or exit application
        switch (userInput) {
            case "1":
                System.out.println("Please select one of the following menu items:");
                System.out.println("(1) Capture a new student.");
                System.out.println("(2) Search for a student.");
                System.out.println("(3) Delete a student.");
                System.out.println("(4) Print student report.");
                System.out.println("(5) Exit application.");
                break;

            default:
                System.out.println("Exiting");
                    System.exit(0);
        }
        String Input = kb.nextLine();
        //switch case used for choosing which option you wish to choose
        switch (Input) {
            case "1":
                saveStudent(kb);
                break;
            case "2":
                searchStudent(kb);
                break;
            case "3":
                deleteStudent(kb);
                break;
            case "4":
                studentReport();
                break;
            case "5":
                exitStudentApplication();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    //method to exit application
    public void exitStudentApplication() {
        System.out.println("Exiting the Student Application.");
        System.exit(0);
    }
}