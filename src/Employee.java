// Shankar Lohar 20BAI10040 CSE3002 Programming in JAVA
// Exercise 9 and Tutorial - :)

import java.sql.*;
import java.util.Scanner;

public class Employee {
    public static void main(String[] args) throws SQLException {
        Statement statement = connectToDatabase();
        if (statement != null) {
            //1. First show the available table inside the database
            showTables(statement);
            //2. check database name is exist or not
            checkDatabase(statement);
            //3. if exist drop the table  else print is not available
            dropTableIfExists(statement);
            //4. Now create an Employee table  with 10 properties(attributes)
            createEmployeeTable(statement);
            //5. insert a minimum of 10 rows and print it after insertion.
            // With pdf and image property using BLOB
            insert10Employees(statement);
            showEmployeeRecords(statement);
            //6. now modify the employee salary and designation with emp id
            modifySalaryDesignation(statement);
            //7. increase the salary (rs:10000) for all the employees who are all working in the bhopal branch.
            increaseSalaryForBhopal(statement);
        }
    }

    private static void increaseSalaryForBhopal(Statement statement) throws SQLException {
        statement.executeUpdate("UPDATE Employee SET Salary = Salary + 10000 WHERE Branch = 'Bhopal'");
        System.out.println("\n Bhopal Employee Salary Updated!\n");
    }

    private static void modifySalaryDesignation(Statement statement) throws SQLException {
        System.out.println("\n\n Enter employee id to update salary and designation -> ");
        Scanner empIdScanner = new Scanner(System.in);
        int id = empIdScanner.nextInt();
        empIdScanner.close();
        statement.executeUpdate("UPDATE Employee SET Designation = 'Student', Salary = Salary + 8000 WHERE EmployeeID ="+id);
        System.out.println("\n Employee "+id+"'s Salary and Designation Updated!\n");
    }

    private static void showEmployeeRecords(Statement statement) throws SQLException {
        int noOfRecords = 0;
        ResultSet tableRecords = statement.executeQuery("SELECT * FROM employee");
        System.out.println("\n\n ##### Showing Records in the Current Table ##### ");
        System.out.println("\nid      firstname       lastname        email       address     city        salary      designation     branch      phoneNo       image       resume\n");
        while (tableRecords.next()) {
            int id = tableRecords.getInt("EmployeeID");
            String firstname = tableRecords.getString("FirstName");
            String lastname = tableRecords.getString("LastName");
            String email = tableRecords.getString("Email");
            String address = tableRecords.getString("AddressLine");
            String city = tableRecords.getString("City");
            int salary = tableRecords.getInt("Salary");
            String designation = tableRecords.getString("Designation");
            String branch = tableRecords.getString("Branch");
            String phone = tableRecords.getString("Phone");
            String image = tableRecords.getString("Image");
            String resume = tableRecords.getString("Resume");
            System.out.println(id+"     "+firstname+"     "+lastname+"     "+email+"     "+address+"     "+city+"     "+salary+"     "+designation+"     "+branch+"     "+phone+"     "+image+"     "+resume);
            noOfRecords++;
            System.out.println();
        }
        System.out.println("\nTHERE ARE " + noOfRecords + " TABLES CURRENTLY IN THE DATABASE!\n");
    }

    private static void insert10Employees(Statement statement) throws SQLException {
        System.out.println("Enter number of Employee records to insert");
        Scanner scanner = new Scanner(System.in);
        int numberOfRecords = scanner.nextInt();
        ShankarsEmployee shankarsEmployee = new ShankarsEmployee(1,"Shankar","Lohar","shankarloharmail@gmail.com","Cossipore, Kolkata 700002", "Kolkata", 10000000, "Developer","Bhopal", "9681698597", "src/ShankarBLOB.jpg", "src/ShankarResumeBLOBcHECK.pdf");
//        statement.executeUpdate("INSERT INTO Employee VALUES ("+ shankarsEmployee.id +", '"+ shankarsEmployee.firstname +"', '"+ shankarsEmployee.lastname +"', '"+ shankarsEmployee.email +"', '"+ shankarsEmployee.address +"', '"+ shankarsEmployee.city +"', "+ shankarsEmployee.salary +", '"+ shankarsEmployee.designation +"', '"+ shankarsEmployee.branch +"', '"+ shankarsEmployee.phone +"', '"+ shankarsEmployee.image +"','"+ shankarsEmployee.resumePDF +"')");
//        statement.executeUpdate("INSERT INTO Employee VALUES (1, 'Zara', 'Ali', 'something.email', '22H Punjab', 'Bangaloru', 10000, 'Professor', 'Bhopal', 9879897865, 'src/ShankarBLOB.jpg', 'src/ShankarResumeBLOBcHECK.pdf')");
//        statement.executeUpdate("INSERT INTO Employee VALUES (2, 'Tara', 'Mungfali', 'nothing.email', '22H Haryana', 'xuz', 10000, 'Professor', 'Bhopal', 3323232323, 'src/ShankarBLOB.jpg', 'src/ShankarResumeBLOBcHECK.pdf')");
//        statement.executeUpdate("INSERT INTO Employee VALUES (3, 'Mara', 'Boxer', 'vit.email', '22H UP', 'ppp', 10000, 'Professor', 'Bhopal', 55656565656, 'src/ShankarBLOB.jpg', 'src/ShankarResumeBLOBcHECK.pdf')");
//        statement.executeUpdate("INSERT INTO Employee VALUES (4, 'Gara', 'Singer', 'bopal.email', '22H Bihar', 'Amritsar', 10000, 'Professor', 'Bhopal', 3232365652, 'src/ShankarBLOB.jpg', 'src/ShankarResumeBLOBcHECK.pdf')");
//        statement.executeUpdate("INSERT INTO Employee VALUES (5, 'Chara', 'Bakri', 'chaipeeloo.email', '22H Jharkhand', 'patna', 10000, 'Professor', 'Bhopal', 987545345467, 'src/ShankarBLOB.jpg', 'src/ShankarResumeBLOBcHECK.pdf')");
//        statement.executeUpdate("INSERT INTO Employee VALUES (6, 'Para', 'Fever', 'mrbeast.email', '22H Tamil', 'dubai', 10000, 'Professor', 'Bhopal', 7897654654, 'src/ShankarBLOB.jpg', 'src/ShankarResumeBLOBcHECK.pdf')");
//        statement.executeUpdate("INSERT INTO Employee VALUES (7, 'Lara', 'Dutta', 'dundundundun.email', '22H Maharashtra', 'poadifp', 10000, 'Professor', 'Bhopal', 789765451332, 'src/ShankarBLOB.jpg', 'src/ShankarResumeBLOBcHECK.pdf')");
//        statement.executeUpdate("INSERT INTO Employee VALUES (8, 'Dulara', 'Beta', 'hacker.email', '22H WestBengal', 'Amrzczzitsar', 10000, 'Professor', 'Bhopal', 879865453, 'src/ShankarBLOB.jpg', 'src/ShankarResumeBLOBcHECK.pdf')");
//        statement.executeUpdate("INSERT INTO Employee VALUES (9, 'Bheins', 'Gaay', 'shankar.email', '22H China', 'kuchbhi', 10000, 'Professor', 'Bhopal', 79874656654, 'src/ShankarBLOB.jpg', 'src/ShankarResumeBLOBcHECK.pdf')");
//        statement.executeUpdate("INSERT INTO Employee VALUES (10, 'Boring', 'Assignment', 'easy.email', '22H USA', 'alone', 10000, 'Professor', 'Bhopal', 897654546851, 'src/ShankarBLOB.jpg', 'src/ShankarResumeBLOBcHECK.pdf')");
        for (int i = 0; i < numberOfRecords; i++) {
            System.out.println("Enter the employee id ->");
            shankarsEmployee.id = scanner.nextInt();
            System.out.println("Enter the employee first name ->");
            shankarsEmployee.firstname = scanner.nextLine();
            System.out.println("Enter the employee last name ->");
            shankarsEmployee.lastname = scanner.nextLine();
            System.out.println("Enter the employee email ->");
            shankarsEmployee.email = scanner.nextLine();
            System.out.println("Enter the employee address ->");
            shankarsEmployee.address = scanner.nextLine();
            System.out.println("Enter the employee city ->");
            shankarsEmployee.city = scanner.nextLine();
            System.out.println("Enter the employee salary ->");
            shankarsEmployee.salary = scanner.nextInt();
            System.out.println("Enter the employee designation ->");
            shankarsEmployee.designation = scanner.nextLine();
            System.out.println("Enter the employee branch ->");
            shankarsEmployee.branch = scanner.nextLine();
            System.out.println("Enter the employee phone ->");
            shankarsEmployee.phone = scanner.nextLine();
            System.out.println("Enter the employee image path ->");
            shankarsEmployee.image = scanner.nextLine();
            System.out.println("Enter the employee resume PDF path ->");
            shankarsEmployee.resumePDF = scanner.nextLine();

            System.out.println("Inserting records into the table...");
            statement.executeUpdate("INSERT INTO Employee VALUES ("+ shankarsEmployee.id +", '"+ shankarsEmployee.firstname +"', '"+ shankarsEmployee.lastname +"', '"+ shankarsEmployee.email +"', '"+ shankarsEmployee.address +"', '"+ shankarsEmployee.city +"', "+ shankarsEmployee.salary +", '"+ shankarsEmployee.designation +"', '"+ shankarsEmployee.branch +"', '"+ shankarsEmployee.phone +"', '"+ shankarsEmployee.image +"','"+ shankarsEmployee.resumePDF +"')");
            System.out.println("Inserted record "+(i+1)+" into the table... "+(numberOfRecords - (1 + i))+" left.");
        }
        System.out.println("Inserted ALL records into the table...");
    }

    private static void createEmployeeTable(Statement statement) throws SQLException {
        statement.executeUpdate("CREATE TABLE Employee" + "(" + "EmployeeID int," + "FirstName varchar(255)," + "LastName varchar(255)," + "Email varchar(255)," + "AddressLine varchar(255)," + "City varchar(255)," + "Salary int," + "Designation varchar(255)," + "Branch varchar(255)," + "Phone varchar(255)," +"Image blob," +"Resume blob" +")");
        System.out.println("\nTable Employee Created!\n");
    }

    private static void dropTableIfExists(Statement statement) throws SQLException {
        System.out.println("\n\n Enter name of the table to delete from database -> ");
        Scanner input = new Scanner(System.in);
        String deleteTable = input.nextLine();
        input.close();
        ResultSet tableList = statement.executeQuery("Show tables");
        System.out.println("\n\n ##### Checking the table exists or not... ##### ");
        while (tableList.next()) {
            if (tableList.getString(1).equalsIgnoreCase(deleteTable)) {
                statement.executeUpdate("Drop table " + deleteTable);
                System.out.println("THE DATABASE '" + deleteTable + "' DELETED!");
                return;
            }
        }
        System.out.println("THE TABLE  '" + deleteTable + "'  DOES NOT EXISTS!");
    }

    private static void checkDatabase(Statement statement) throws SQLException {
        System.out.println("\n\n Enter name of the database to check -> ");
        Scanner input = new Scanner(System.in);
        String databaseCheck = input.nextLine();
        input.close();
        ResultSet databaseList = statement.executeQuery("Show databases");
        System.out.println("\n\n ##### Checking the database exists or not... ##### ");
        while (databaseList.next()) {
            if (databaseList.getString(1).equalsIgnoreCase(databaseCheck)) {
                System.out.println("THE DATABASE '" + databaseCheck + "' EXISTS!");
                return;
            }
        }
        System.out.println("THE DATABASE  '" + databaseCheck + "'  DOES NOT EXISTS!");
    }

    private static void showTables(Statement statement) throws SQLException {
        ResultSet tableList = statement.executeQuery("Show tables");
        System.out.println("\n\n ##### Showing Tables in the Current Database ##### ");
        int dataRecords = 0;
        while (tableList.next()) {
            System.out.print(tableList.getString(1));
            dataRecords++;
            System.out.println();
        }
        System.out.println("\nTHERE ARE " + dataRecords + " TABLES CURRENTLY IN THE DATABASE!\n");
    }

    public static Statement connectToDatabase() {
        String url = "jdbc:mysql://127.0.0.1:3306/shankarsemployees";  // Shankar Lohar's Location
        String username = "root"; // Shankar Lohar's sql username
        String password = "1234"; // Shankar Lohar's sql password
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Using JDBC latest 8.something I don't remember.
            System.out.println("Class Reached...");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Done!");
            Statement statement = connection.createStatement(); // Created Statement variable
            System.out.println("Statement Ready -> #");
            return statement;
        } catch (Exception e) {
            System.out.println("Connection Cancelled : ");
            System.out.println(e);
        }
        return null;
    }
}
// Making a data class to Store the data temporarily before insertion
class ShankarsEmployee{
    int id ;
    String firstname;
    String lastname;
    String email;
    String address;
    String city;
    int salary;
    String designation;
    String branch;
    String phone;
    String image;
    String resumePDF;

    public ShankarsEmployee(int id, String firstname, String lastname, String email, String address, String city, int salary, String designation, String branch, String phone, String image, String resumePDF) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.city = city;
        this.salary = salary;
        this.designation = designation;
        this.branch = branch;
        this.phone = phone;
        this.image = image;
        this.resumePDF = resumePDF;
    }
}
