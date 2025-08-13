/*
Title: Employee Stack Implementation using Array in Java

Problem Statement:
Write a Java program to implement a stack of employees using an array. The program should allow the user to:

Push (add) an employee to the stack.

Pop (remove) an employee from the stack.

Peek (view the top employee).

Display all employees in the stack.

The stack should hold Employee objects with:

id (int)

name (String)

salary (double)
*/
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void displayEmployee() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }
}

class EmployeeStack {
    private Employee[] stack;
    private int top;
    private int capacity;

    public EmployeeStack(int size) {
        stack = new Employee[size];
        capacity = size;
        top = -1;
    }

    public void push(Employee emp) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow! Cannot add more employees.");
        } else {
            stack[++top] = emp;
            System.out.println("Employee pushed to stack.");
        }
    }

    public Employee pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! No employees to remove.");
            return null;
        } else {
            return stack[top--];
        }
    }

    public Employee peek() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return null;
        }
        return stack[top];
    }

    public void displayStack() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Employees in Stack:");
            for (int i = top; i >= 0; i--) {
                stack[i].displayEmployee();
            }
        }
    }
}

class EmployeeStackMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter stack capacity: ");
        int size = sc.nextInt();

        EmployeeStack stack = new EmployeeStack(size);

        while (true) {
            System.out.println("\n--- Employee Stack Operations ---");
            System.out.println("1. Push Employee");
            System.out.println("2. Pop Employee");
            System.out.println("3. Peek Employee");
            System.out.println("4. Display Stack");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = sc.nextDouble();
                    stack.push(new Employee(id, name, salary));
                    break;

                case 2:
                    Employee removed = stack.pop();
                    if (removed != null) {
                        System.out.println("Popped Employee:");
                        removed.displayEmployee();
                    }
                    break;

                case 3:
                    Employee topEmp = stack.peek();
                    if (topEmp != null) {
                        System.out.println("Top Employee:");
                        topEmp.displayEmployee();
                    }
                    break;

                case 4:
                    stack.displayStack();
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
/*
Explanation
Employee Class

Stores employee ID, name, and salary.

Has displayEmployee() to print employee details.

EmployeeStack Class

Implements stack using an Employee[] array.

Supports:

push() → Add employee to stack.

pop() → Remove top employee from stack.

peek() → View top employee without removing.

displayStack() → Show all employees from top to bottom.

Main Program

Menu-driven interface for stack operations.

-------------------------------------------------------
*/