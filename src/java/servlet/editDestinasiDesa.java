package servlet;

import Controller.MenuAdminDesa;
import classModel.AdminDesa;
import classModel.Wisata;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@MultipartConfig(maxFileSize = 16177215)
@WebServlet(name = "editDestinasiDesa", urlPatterns = {"/editDestinasiDesa"})
public class editDestinasiDesa extends HttpServlet {

    private static final int BUFFER_SIZE = 4096;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession session = request.getSession();
        Wisata wisata = new Wisata();

        wisata.setIdWisata(Integer.parseInt(request.getParameter("id")));
        wisata.setNamaTempat(request.getParameter("namaDestinasi"));
        wisata.setAlamat(request.getParameter("alamat"));
        wisata.setKeterangan(request.getParameter("ket"));
        wisata.setGambar(request.getPart("foto"));
        

        MenuAdminDesa menu = new MenuAdminDesa();

        int count = 0;
        try {
            count = menu.updateDestinasi1(wisata);
        } catch (SQLException ex) {
            Logger.getLogger(editDestinasiDesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (count > 0) {
            session.setAttribute("warning1", 3);
            response.sendRedirect("./tampilDestinasiAdmin");
        } else if (count == 0) {
            if (wisata.getGambar().getSize() > 1000000) {
                session.setAttribute("warning1", 2);
                response.sendRedirect("./tampilDestinasiAdmin");
            } else {
                session.setAttribute("warning1", 0);
                response.sendRedirect("./tampilDestinasiAdmin");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
