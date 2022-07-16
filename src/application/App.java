package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class App {
    public static void main(String[] args) throws Exception {
       
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter department´s name: ");
        String department = scan.nextLine();
        
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String nameOfWorker = scan.nextLine();
        System.out.print("Level: ");
        String levelOfWorker = scan.nextLine();
        System.out.print("Base Salary: ");
        Double salaryOfWorker = scan.nextDouble();

        Worker worker = new Worker(nameOfWorker, WorkerLevel.valueOf(levelOfWorker), salaryOfWorker, new Department(department));

        System.out.print("How many contracts to this worker? ");
        int numberOfContracts = scan.nextInt();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for(int i = 1; i <= numberOfContracts; i++) {
            System.out.printf("Enter contract #%d data:\n", i);
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(scan.next());
            System.out.print("Value per hour: ");
            Double valuePerHour = scan.nextDouble();
            System.out.print("Duration (hours): ");
            int durationInHours = scan.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHour, durationInHours);
            worker.addContract(contract);
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = scan.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + worker.income(year, month));
        scan.close();

    }
}
