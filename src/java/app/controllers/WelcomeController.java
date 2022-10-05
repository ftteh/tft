/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import tft.core.controller.Controller;
import javax.servlet.http.HttpServletResponse;

/**
 * Welcome controller
 *
 * Default controller registered with '/' path in Router.
 *
 * @author tft
 * @since 0.0.1
 */
public class WelcomeController extends Controller {

    /**
     * Load view from directory 'WEB-INF/views/'
     *
     * @param req user request
     * @param res user response
     */
    public void welcome(HttpServletRequest req, HttpServletResponse res) {
        view("welcome", req, res);
    }

    public void login(HttpServletRequest req, HttpServletResponse res) {

        try {
            String userId = req.getParameter("userId");
            String password = req.getParameter("password");
            if (userId != null && !userId.trim().isEmpty() && password != null && !password.trim().isEmpty()) {
                res.sendRedirect("http://localhost:8080/app/records?userId=" + userId);
            } else {
                res.sendRedirect("http://localhost:8080/app/");
            }

        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
