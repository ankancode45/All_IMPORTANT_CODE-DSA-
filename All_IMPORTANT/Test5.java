/*
Title: Employee Queue Implementation using Array in Java

Problem Statement:
Write a Java program to implement a queue of employees using an array. The program should allow the user to:

Enqueue (add) an employee to the queue.

Dequeue (remove) an employee from the queue.

Peek (view the front employee).

Display all employees in the queue.

The queue should hold Employee objects with:

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

class EmployeeQueue {
    private Employee[] queue;
    private int front, rear, capacity, count;

    public EmployeeQueue(int size) {
        queue = new Employee[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    public void enqueue(Employee emp) {
        if (count == capacity) {
            System.out.println("Queue Overflow! Cannot add more employees.");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = emp;
        count++;
        System.out.println("Employee added to queue.");
    }

    public Employee dequeue() {
        if (count == 0) {
            System.out.println("Queue Underflow! No employees to remove.");
            return null;
        }
        Employee emp = queue[front];
        front = (front + 1) % capacity;
        count--;
        return emp;
    }

    public Employee peek() {
        if (count == 0) {
            System.out.println("Queue is empty.");
            return null;
        }
        return queue[front];
    }

    public void displayQueue() {
        if (count == 0) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Employees in Queue:");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % capacity;
            queue[index].displayEmployee();
        }
    }
}

class EmployeeQueueMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter queue capacity: ");
        int size = sc.nextInt();

        EmployeeQueue queue = new EmployeeQueue(size);

        while (true) {
            System.out.println("\n--- Employee Queue Operations ---");
            System.out.println("1. Enqueue Employee");
            System.out.println("2. Dequeue Employee");
            System.out.println("3. Peek Employee");
            System.out.println("4. Display Queue");
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
                    queue.enqueue(new Employee(id, name, salary));
                    break;

                case 2:
                    Employee removed = queue.dequeue();
                    if (removed != null) {
                        System.out.println("Dequeued Employee:");
                        removed.displayEmployee();
                    }
                    break;

                case 3:
                    Employee frontEmp = queue.peek();
                    if (frontEmp != null) {
                        System.out.println("Front Employee:");
                        frontEmp.displayEmployee();
                    }
                    break;

                case 4:
                    queue.displayQueue();
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