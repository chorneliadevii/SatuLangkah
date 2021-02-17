package servlet;

import Controller.MenuAdminDesa;
import Controller.MenuAdminSatuLangkah;
import classModel.Wisata;
import classModel.WisataTampil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "editDestinasi", urlPatterns = {"/editDestinasi"})
public class editDestinasi extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
        response.setContentType("text/html;charset=UTF-8");
        int idPariwisata = Integer.parseInt(request.getParameter("idPariwisata"));
        HttpSession session = request.getSession();

        MenuAdminDesa menu = new MenuAdminDesa();
        if (request.getParameter("submit").equals("Hapus")) {
            menu.hapusDestinasi(idPariwisata);
            response.sendRedirect("./tampilDestinasiAdmin");
        } else {
            WisataTampil tampil = menu.getWisata(idPariwisata);
            session.setAttribute("wisata", tampil);
            RequestDispatcher rd = request.getRequestDispatcher("/editDestinasi.jsp");
            rd.forward(request, response);
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
