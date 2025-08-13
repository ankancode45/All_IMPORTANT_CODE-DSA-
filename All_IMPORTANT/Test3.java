/*
Title: Student Admission System using Arrays in Core Java

Problem Statement:
Write a Java program to manage student admissions in a college using arrays. The program should allow the user to:

Add new student details.

View all student records.

Search for a student by roll number.

Update student details.

Delete a student record.

The system should store a maximum of 100 students using arrays (no collections or database).

Requirements:

Create a Student class with:

rollNumber (int)

name (String)

course (String)

year (int)

Use an array of Student objects in the main program.

Implement a menu-driven interface.
*/
import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    String course;
    int year;

    public Student(int rollNumber, String name, String course, int year) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.course = course;
        this.year = year;
    }

    public void displayStudent() {
        System.out.println("Roll No: " + rollNumber + ", Name: " + name + 
                           ", Course: " + course + ", Year: " + year);
    }
}

class StudentAdmission {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[100];
        int count = 0;

        while (true) {
            System.out.println("\n--- Student Admission System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Update Student Details");
            System.out.println("5. Delete Student Record");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    if (count < students.length) {
                        System.out.print("Enter Roll Number: ");
                        int roll = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();
                        System.out.print("Enter Year: ");
                        int year = sc.nextInt();
                        students[count] = new Student(roll, name, course, year);
                        count++;
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Admission limit reached!");
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No student records available.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            students[i].displayStudent();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll Number to Search: ");
                    int searchRoll = sc.nextInt();
                    Student foundStudent = findStudent(students, count, searchRoll);
                    if (foundStudent != null) {
                        foundStudent.displayStudent();
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll Number to Update: ");
                    int updateRoll = sc.nextInt();
                    sc.nextLine();
                    Student updateStudent = findStudent(students, count, updateRoll);
                    if (updateStudent != null) {
                        System.out.print("Enter New Name: ");
                        updateStudent.name = sc.nextLine();
                        System.out.print("Enter New Course: ");
                        updateStudent.course = sc.nextLine();
                        System.out.print("Enter New Year: ");
                        updateStudent.year = sc.nextInt();
                        System.out.println("Student details updated successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Roll Number to Delete: ");
                    int deleteRoll = sc.nextInt();
                    int index = findStudentIndex(students, count, deleteRoll);
                    if (index != -1) {
                        for (int i = index; i < count - 1; i++) {
                            students[i] = students[i + 1];
                        }
                        students[count - 1] = null;
                        count--;
                        System.out.println("Student record deleted successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static Student findStudent(Student[] students, int count, int roll) {
        for (int i = 0; i < count; i++) {
            if (students[i].rollNumber == roll) {
                return students[i];
            }
        }
        return null;
    }

    public static int findStudentIndex(Student[] students, int count, int roll) {
        for (int i = 0; i < count; i++) {
            if (students[i].rollNumber == roll) {
                return i;
            }
        }
        return -1;
    }
}
/*
Explanation
Student Class → Holds student details like roll number, name, course, and year.

Array of Students → Stores up to 100 student records.

Menu-Driven Program → Lets the user add, view, search, update, and delete records.

findStudent Method → Returns a student object by roll number.

findStudentIndex Method → Returns the index of a student for deletion.

Shifting Array → When deleting a record, elements are shifted to keep data contiguous.

----------------------------------------------------------------------------
*/