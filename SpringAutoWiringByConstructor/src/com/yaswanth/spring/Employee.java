package com.yaswanth.spring;

public class Employee {
	private String fullName;
    
    public Employee(Department department)
    {
        this.department = department;
    }
     
    private Department department;
 
    public Department getDepartment() {
        return department;
    }
 
    public void setDepartmentBean(Department department) {
        this.department = department;
    }
 
    public String getFullName() {
        return fullName;
    }
 
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
