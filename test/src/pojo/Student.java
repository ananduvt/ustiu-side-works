/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author u55369
 */
public class Student {
    
    private String name;
    private int rollNo;
    
    private static String schoolName;
    
    public void Student()
    {
        
    }
    public Student(String name , int no){
        this.name = name;
        this.rollNo = no;
    
    }
    
    public Student(Student s)
    {
        this.name = s.getName();
    }
    
    // data /attributes 
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        Student.schoolName = schoolName;
    }
 
    
}
