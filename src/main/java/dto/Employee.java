package dto;

import java.util.Objects;

public class Employee {
    private String name;
    private String lastName;
    private int department;
    private int salary;


    public Employee(String lastName, String name, int department, int salary) {

        this.name = name;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDepartment() {
        return this.department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Сотрудник " + lastName + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return name.equals(employee.getName()) && lastName.equals(employee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName);
    }
}

