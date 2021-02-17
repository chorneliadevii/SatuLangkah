/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Controller.MenuAdminSatuLangkah;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "verifikasiData", urlPatterns = {"/verifikasiData"})
public class verifikasiData extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            int idPariwisata = Integer.parseInt(request.getParameter("idPariwisata"));
            int count = 0;
            MenuAdminSatuLangkah admin = new MenuAdminSatuLangkah();

            if (request.getParameter("submit").equals("Hapus")) {
                count = admin.hapusDestinasi(idPariwisata);
                if (count > 0) {
                    session.setAttribute("warning5", 2);
                    RequestDispatcher rd = request.getRequestDispatcher("/AdminSatuDestinasi");
                    rd.forward(request, response);
                } else {
                    session.setAttribute("warning5", 3);
                    RequestDispatcher rd = request.getRequestDispatcher("/AdminSatuDestinasi");
                    rd.forward(request, response);

                }
            } else {
                count = admin.verifikasiWisata(idPariwisata);
                if (count > 0) {
                    session.setAttribute("warning5", 1);
                    RequestDispatcher rd = request.getRequestDispatcher("/AdminSatuDestinasi");
                    rd.forward(request, response);
                } else {
                    session.setAttribute("warning5", 0);
                    RequestDispatcher rd = request.getRequestDispatcher("/AdminSatuDestinasi");
                    rd.forward(request, response);

                }
            }

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
