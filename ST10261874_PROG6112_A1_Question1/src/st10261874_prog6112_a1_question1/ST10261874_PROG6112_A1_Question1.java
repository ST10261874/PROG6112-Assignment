/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package st10261874_prog6112_a1_question1;

//ST10261874
//Dianca Jade Naidu

/*
REFERENCES:
https://www.javaguides.net/2022/11/unit-test-spring-boot-delete-rest-api.html
https://youtu.be/vZm0lHciFsQ?si=b3wfHdbaQ2UcRNq8
https://www.w3schools.com/java/java_arraylist.asp
*/

import java.util.Scanner;

public class ST10261874_PROG6112_A1_Question1 {

     public static void main(String[] args) {
  // Create a new Student object to manage student data
        Student student = new Student(0, "", 0, "", "");

        // Create a Scanner object to read user input
        Scanner kb = new Scanner(System.in);

        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("**************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");

        // Read user input to decide whether to launch the menu or exit
        String userInput = kb.nextLine();

        switch (userInput) {
            case "1":
                // Display the main menu options
                System.out.println("Please select one of the following menu items:");
                System.out.println("(1) Capture a new student.");
                System.out.println("(2) Search for a student.");
                System.out.println("(3) Delete a student.");
                System.out.println("(4) Print student report.");
                System.out.println("(5) Exit application.");
                break;

            default:
                // Exit the application if the user enters anything other than "1"
                System.out.println("Exiting");
                System.exit(0);
        }

        // Read user input to determine which menu option to execute
        String input = kb.nextLine();
        switch (input) {
            case "1":
                // Capture and save a new student's information
                student.saveStudent(kb);
                break;
            case "2":
                // Search for a student
                student.searchStudent(kb);
                break;
            case "3":
                // Delete a student
                student.deleteStudent(kb);
                break;
            case "4":
                // Print the student report
                student.studentReport();
                break;
            case "5":
                // Exit the application
                student.exitStudentApplication();
                break;
            default:
                // Display an error message for invalid input
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
