import java.io.IOException;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.Scanner;

class Employee{
    int id;
    String name;
    float salary;
    int age;
    int contact_no;

    public Employee(int id,String name,float salary,int age,int contact_no){
        this.id=id;
        this.name=name;
        this.salary=salary;
        this.age=age;
        this.contact_no=contact_no;
    }

    public String toString(){
        return "EMPLOYEE DETAILS" + "\nID:" + this.id + "\nName" + this.name + "\nSalary" + this.salary
                + "\nAge" + this.age +"\nContact No."+this.contact_no;
    }
}

public class EmpManagement {
    static void display(ArrayList<Employee> al){
        System.out.println("EMPLOYEE LIST");
        System.out.println(String.format("%-10s%-15s%-10s%-20s%-10s","ID","Name","salary","age","contact-no"));

        for(Employee emp : al)
        {
            System.out.println(String.format("%-10s%-15s%-10s%-20s%-10s",emp.id,emp.name,emp.salary,emp.age,emp.contact_no));
        }
    }

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        int id;
        String name;
        float salary;
        int age;
        int contact_no;

        Scanner sc=new Scanner(System.in);
        ArrayList<Employee> al = new ArrayList<Employee>();

        do {
            System.out.println("WELCOME TO EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("\n1. Insert Employee" + "\n2. Display Employee of this company" +
                    "\n3. Search Employee" + "\n4. Edit Employee" + "\n5. Delete Employee" + "\n6.Exit");
            System.out.println("Enter your choice from 1 to 6");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Employee Details to insert in the list");
                    System.out.println("\nEnter ID");
                    id = sc.nextInt();
                    System.out.println("\nEnter name");
                    name = sc.next();
                    System.out.println("Enter Salary");
                    salary = sc.nextFloat();
                    System.out.println("Enter Age");
                    age = sc.nextInt();
                    System.out.println("Enter Contact No.");
                    contact_no = sc.nextInt();

                    System.out.println("DETAILS ENTERED SUCCESSFULLY");
                    al.add(new Employee(id, name, salary, age, contact_no));
                    display(al);
                    break;

                case 2:
                    ObjectInput ois = null;
                    al = (ArrayList<Employee>) ois.readObject();
                    break;

                case 3:
                    System.out.println("Enter Employee ID to Search");
                    id = sc.nextInt();
                    int i = 0;
                    for (Employee emp : al) {
                        if (id == emp.id) {
                            System.out.println("\n" + emp);
                            i++;
                        } else if (i == 0) {
                            System.out.print("Please enter valid details!!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("\nEnter the Employee ID to EDIT the details");
                    id = sc.nextInt();
                    int j = 0;
                    for (Employee emp : al) {
                        if (id == emp.id) {
                            j++;
                            do {
                                int choice1 = 0;
                                System.out.println("\nEDIT Employee Details :\n" + "1. Employee ID\n" + "2. Name\n" +
                                        "3. Salary\n" + "4. Age\n" + "5. Contact No\n" + "6. GO BACK\n");
                                System.out.println("Enter your choice : ");
                                choice1 = sc.nextInt();
                                switch (choice1) {
                                    case 1:
                                        System.out.println("\nEnter new Employee ID:");
                                        emp.id = sc.nextInt();
                                        System.out.println(emp + "\n");
                                        break;

                                    case 2:
                                        System.out.println("Enter new Employee Name:");
                                        emp.name = sc.nextLine();
                                        System.out.println(emp + "\n");
                                        break;

                                    case 3:
                                        System.out.println("Enter new Employee Salary:");
                                        emp.salary = sc.nextFloat();
                                        System.out.println(emp + "\n");
                                        break;

                                    case 4:
                                        System.out.println("Enter new Employee Contact No. :");
                                        emp.age = sc.nextInt();
                                        System.out.println(emp + "\n");
                                        break;

                                    case 5:
                                        System.out.println("Enter new Employee Email-ID :");
                                        emp.contact_no = sc.nextInt();
                                        System.out.println(emp + "\n");
                                        break;

                                    case 6:
                                        j++;
                                        break;

                                    default:
                                        System.out.println("\nEnter a correct choice from the List :");
                                        break;

                                }
                            }
                            while (j == 1);
                        }
                    }
                    if (j == 0) {
                        System.out.println("\nPlease enter a valid ID!!");
                    }

                    break;

                case 5:
                    System.out.println("Enter Emp ID to Delete");
                    id = sc.nextInt();
                    int k = 0;
                    for (Employee emp : al) {
                        if (id == emp.id) {
                            al.remove(emp);
                            display(al);
                            k++;
                        }
                    }
                    if (k == 0) {
                        System.out.println("\nPlease enter a valid ID!!");
                    }
                    break;

                case 6:
                    System.out.println("\nYou have chosen EXIT!! Saving Files and closing the tool.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nEnter a correct choice from the List :");
                    break;
            }
        }
        while(true);
    }
}
