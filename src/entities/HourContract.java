package entities;

import java.util.Date;

public class HourContract {
    
    private Date date;
    private Double valuePerHour;
    private Integer hours;


    public HourContract() {
    }
    
    public HourContract(Date date, Double valuePerHour, Integer hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    /**
     * @return Date return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return Double return the valuePerHour
     */
    public Double getValuePerHour() {
        return valuePerHour;
    }

    /**
     * @param valuePerHour the valuePerHour to set
     */
    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    /**
     * @return Integer return the hours
     */
    public Integer getHours() {
        return hours;
    }

    /**
     * @param hours the hours to set
     */
    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public double totalValue() {
        return valuePerHour * hours;
    }
}
