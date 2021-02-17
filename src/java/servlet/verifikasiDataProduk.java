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
import sun.security.pkcs11.wrapper.Functions;

@WebServlet(name = "verifikasiDataProduk", urlPatterns = {"/verifikasiDataProduk"})
public class verifikasiDataProduk extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        int idProduk = Integer.parseInt(request.getParameter("idProduk"));
        MenuAdminSatuLangkah admin = new MenuAdminSatuLangkah();
        int count = 0;
        if (request.getParameter("submit").equals("Hapus")) {
            count = admin.hapusProduk(idProduk);
             if (count > 0) {
            session.setAttribute("warning5", 2);
            RequestDispatcher rd = request.getRequestDispatcher("/AdminSatuProduk");
            rd.forward(request, response);
        } else {
            session.setAttribute("warning5", 3);
            RequestDispatcher rd = request.getRequestDispatcher("AdminSatuProduk");
            rd.forward(request, response);

        }
        } else {
            count = admin.verifikasiProduk(idProduk);
            if (count > 0) {
                session.setAttribute("warning5", 1);
                RequestDispatcher rd = request.getRequestDispatcher("/AdminSatuProduk");
                rd.forward(request, response);
            } else {
                session.setAttribute("warning5", 0);
                RequestDispatcher rd = request.getRequestDispatcher("AdminSatuProduk");
                rd.forward(request, response);

            }
        }

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
        processRequest(request, response);
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
