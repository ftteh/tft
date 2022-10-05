/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.RecordModel;
import java.io.IOException;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tft.core.controller.Controller;

/**
 * Blog controller
 *
 * @author tft
 * @since 0.0.1
 */
public class School extends Controller {

    private static ArrayList<RecordModel> records;

    public School() {

    }

    /**
     * Show all the posts
     *
     * @param req user request
     * @param res user response
     */
    public void index(HttpServletRequest req, HttpServletResponse res) {
        String userId = req.getParameter("userId");
        ArrayList<RecordModel> records = new ArrayList<RecordModel>();

        records.add(new RecordModel("S1", "S1 NAME", "Dep 1", 35.0));
        records.add(new RecordModel("S2", "S2 NAME", "Dep 1", 70.0));
        records.add(new RecordModel("S3", "S3 NAME", "Dep 1", 60.0));
        records.add(new RecordModel("S4", "S4 NAME", "Dep 1", 90.0));
        records.add(new RecordModel("S5", "S5 NAME", "Dep 2", 30.0));
        records.add(new RecordModel("S6", "S6 NAME", "Dep 3", 32.0));
        records.add(new RecordModel("S7", "S7 NAME", "Dep 3", 70.0));
        records.add(new RecordModel("S8", "S8 NAME", "Dep 3", 20.0));

        HashMap<String, Double> departments = new HashMap<String, Double>();
        HashMap<String, Integer> depStudentCount = new HashMap<String, Integer>();
        for (RecordModel record : records) {
            if (departments.containsKey(record.getDepartment())) {
                if (record.getMark() > 40.0) {
                    Double passedNo = departments.get(record.getDepartment());
                    departments.put(record.getDepartment(), passedNo + 1);
                }

            } else {

                if (record.getMark() > 40.0) {
                    departments.put(record.getDepartment(), 1.0);

                } else {
                    departments.put(record.getDepartment(), 0.0);
                }
            }
        }

        for (Map.Entry<String, Double> entry : departments.entrySet()) {

            String key = entry.getKey();
            Integer counter = 0;

            for (RecordModel record : records) {
                if (record.getDepartment() == key) {
                    counter++;
                    depStudentCount.put(key, counter);
                }
            }

            Double value = entry.getValue() / counter * 100;
            value = (double) Math.round(value * 100) / 100;
            departments.put(key, value);

        }

        req.setAttribute("departments", departments);
        req.setAttribute("depStudentCount", depStudentCount);
        req.setAttribute("records", records);
        req.setAttribute("userId", userId);

        //req.setAttribute("message", "Post saved successfully!");
        view("records", req, res);

    }
}
