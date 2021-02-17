package servlet;

import Controller.MenuAdminDesa;
import classModel.AdminDesa;
import classModel.Wisata;
import classModel.lokalProduk;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import koneksi.DbConnection;

@WebServlet(name = "inputDataDestinasi", urlPatterns = {"/inputDataDestinasi"})
@MultipartConfig(maxFileSize = 16177215)
public class inputDataDestinasi extends HttpServlet {

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
        AdminDesa admin = (AdminDesa) session.getAttribute("akun");
        Wisata wisata = new Wisata();
        wisata.setAdmin(admin);
        wisata.setNamaTempat(request.getParameter("namaDestinasi"));
        wisata.setAlamat(request.getParameter("alamat"));
        wisata.setGambar(request.getPart("foto"));
        wisata.setKeterangan(request.getParameter("ket"));
        if (wisata.getGambar().getSize() > 1000000) {
            session.setAttribute("warning1", 1);
            RequestDispatcher rd = request.getRequestDispatcher("./inputDestinasi.jsp");
            rd.forward(request, response);

        } else {
            MenuAdminDesa menu = new MenuAdminDesa();

            int count = menu.inputDataWisata(wisata);
            if (count > 0) {
                session.setAttribute("warning1", 3);
                RequestDispatcher rd = request.getRequestDispatcher("./inputDestinasi.jsp");
                rd.forward(request, response);
            } else if (count == 0) {
                session.setAttribute("warning1", 0);
                RequestDispatcher rd = request.getRequestDispatcher("./inputDestinasi.jsp");
                rd.forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
