package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
    
    // Attributes
    private String name;
    private WorkerLevel level;
    private Double baseSalary; 

    // object composition
    private Department department;
    private List<HourContract> contracts = new ArrayList<>(); 
    
    // constructor
    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    // getters and Setters
    
    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return WorkerLevel return the level
     */
    public WorkerLevel getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    /**
     * @return Double return the baseSalary
     */
    public Double getBaseSalary() {
        return baseSalary;
    }

    /**
     * @param baseSalary the baseSalary to set
     */
    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    /**
     * @return Department return the department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * @return List<HourContract> return the contracts
     */
    public List<HourContract> getContracts() {
        return contracts;
    }

    // methods
    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public Double income(int year, int month) {
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();  // Instanciando cal
        for (HourContract c : contracts) {
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);
            if(year == c_year && month == c_month) {
                sum += c.totalValue();
            }
        }
        return sum;
    }

}
