package interfaces;

import java.util.*;

/**
 * Ten program demonstruje sposób użycia interfejsu Comparable.
 * @author Tomek
 *
 */

public class EmployeeSortTest {

    public static void main(String[] args) {

        //Employee[] staff = new Employee[3];
        var staff = new Employee[3];

        staff[0] = new Employee("Henryk Kwiatek", 35000);
        staff[1] = new Employee("Karol Kowalski", 75000);
        staff[2] = new Employee("Tadeusz Nowak", 38000);

        Arrays.sort(staff);

        //Drukowanie informacji o wszystkich obiektach klasy Employee.
        for(Employee e : staff)
            System.out.println("name: " + e.getName() + ", Salary: " + e.getSalary());
    }

}