/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.util.*;

/**
 * Post model
 *
 * @author tft
 * @since 0.0.1
 */
public class RecordModel {

    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }
    private String studentName;
    private String department;
    private Double mark;

    public RecordModel(String studentId, String studentName, String department, Double mark) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.mark = mark;
    }

}
