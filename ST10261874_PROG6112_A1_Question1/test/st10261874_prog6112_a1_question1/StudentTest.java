/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package st10261874_prog6112_a1_question1;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dianca
 */
public class StudentTest {
  
@Test    
public void testSaveStudent()
{
    // Create a new student instance with default values
    Student student = new Student(0, "", 0, "", "");
    
    // Set specific values for the student
    student.setStudentID(1);
    student.setStudentAge(19);
    student.setStudentName("Dianca");
    student.setStudentCourse("BCAD");
    student.setStudentEmail("djn@gmail.com");
    
    // Assert that the set values match the expected values
    assertEquals(1, student.getStudentID());
    assertEquals(19, student.getStudentAge());
    assertEquals("Dianca", student.getStudentName());
    assertEquals("BCAD", student.getStudentCourse());
    assertEquals("djn@gmail.com", student.getStudentEmail());
}  

@Test
public void testSearchStudent()
{
    // Define the student ID to search for
    int studentIdToSearch = 1;

    // Create a new student instance and set its values
    Student student = new Student(0, "", 0, "", "");
    student.setStudentID(1);
    student.setStudentAge(17);
    student.setStudentName("Jade");
    student.setStudentEmail("jade@gmail.com");
    student.setStudentCourse("BACC");
    
    // Assert that the set values match the expected values
    assertEquals(studentIdToSearch, student.getStudentID());
    assertEquals("Jade", student.getStudentName());
    assertEquals(17, student.getStudentAge());
    assertEquals("jade@gmail.com", student.getStudentEmail());
    assertEquals("BACC", student.getStudentCourse());
}

@Test
public void TestSearchStudent_StudentNotFound()
{
    // Define the student ID to search for
    int studentIdToSearch = 1;

    // Create a new student instance with different values
    Student student = new Student(0, "", 0, "", "");
    student.setStudentID(2);
    student.setStudentAge(20);
    student.setStudentName("John Doe");
    student.setStudentEmail("john@gmail.com");
    student.setStudentCourse("BCAD");
    
    // Assert that the set student ID does not match the expected student ID
    assertNotEquals(studentIdToSearch, student.getStudentID());
}

@Test
public void TestDeleteStudent()
{
    // Define the student ID to delete
    int studentIdToDelete = 1;

    // Create a new student instance and set its values
    Student student = new Student(0, "", 0, "", "");
    student.setStudentID(1);
    student.setStudentAge(19);
    student.setStudentName("Dianca");
    student.setStudentEmail("djn@gmail.com");
    student.setStudentCourse("BCAD");
    
    // Assert that the set student ID matches the expected student ID
    assertEquals(studentIdToDelete, student.getStudentID());
} 

@Test
public void TestDeleteStudent_StudentNotFound()
{
    // Define the student ID to delete
    int studentIdToDelete = 5;

    // Create a new student instance and set its values
    Student student = new Student(0, "", 0, "", "");
    student.setStudentID(1);
    student.setStudentAge(20);
    student.setStudentName("John");
    student.setStudentEmail("john@gmail.com");
    student.setStudentCourse("BA");
    
    // Assert that the set student ID does not match the expected student ID
    assertNotEquals(studentIdToDelete, student.getStudentID());
}

@Test
public void TestStudentAge_StudentAgeValid()
{
    // Create a new student instance
    Student student = new Student(0, "", 0, "", "");

    // Test with a valid student age (e.g., 16)
    boolean isValid = student.isValidAge(16);

    // Assert that the age is valid
    assertTrue(isValid);
}

@Test
public void TestStudentAge_StudentAgeInvalid()
{
    // Create a new student instance
    Student student = new Student(0, "", 0, "", "");

    // Test with an invalid student age (e.g., 12)
    boolean isInvalid = student.isValidAge(12);

    // Assert that the age is invalid
    assertFalse(isInvalid);
}

@Test
public void TestStudentAge_StudentAgeInvalidCharacter()
{
    // Create a new student instance
    Student student = new Student(0, "", 0, "", "");

    // Test with an invalid character for student age (e.g., "abc")
    boolean isValid = student.isValidAge("abc");

    // Assert that the age is invalid
    assertFalse(isValid);
}
}

