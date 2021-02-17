/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Controller.Akun;
import classModel.AdminDesa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author acer
 */
@WebServlet(name = "updatePrifileAdminDesa", urlPatterns = {"/updateProfileAdminDesa"})
public class updateProfileAdminDesa extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        AdminDesa adminDesa = new AdminDesa();
        adminDesa.setNamaDesa(request.getParameter("namaDesa"));
        adminDesa.setUsername(request.getParameter("username"));
        adminDesa.setPass(request.getParameter("password"));
        adminDesa.setEmail(request.getParameter("email"));
        adminDesa.setNoHp(request.getParameter("noHp"));
        adminDesa.setAlamat(request.getParameter("alamat"));
        adminDesa.setIdDesa(Integer.parseInt(request.getParameter("IdDesa")));

        Akun akun = new Akun();
        int count = akun.updateProfile(adminDesa);
        if (count > 0) {
            session.setAttribute("warning404", 1);
            response.sendRedirect("./profileAdminDesa");
        } else {
            session.setAttribute("warning404", 1);
            response.sendRedirect("./profileAdminDesa");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
