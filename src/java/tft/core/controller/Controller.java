/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft.core.controller;

import app.controllers.WelcomeController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Helper methods to use from the user defined controller
 * 
 * @author tft
 * @since 0.0.1
 */
public class Controller {
    protected static void view(String file, HttpServletRequest req, HttpServletResponse res) {
        RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/views/"+file+".jsp");
        
        try {  
            dispatcher.forward(req, res);
        } catch (ServletException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected static void redirect(String file, HttpServletRequest req, HttpServletResponse res) {
        try {
            res.sendRedirect(file);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
