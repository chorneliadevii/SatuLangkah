package servlet;

import Controller.MenuAdminDesa;
import classModel.lokalProduk;
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

@WebServlet(name = "editProdukDesa", urlPatterns = {"/editProdukDesa"})
@MultipartConfig(maxFileSize = 16177215)

public class editProdukDesa extends HttpServlet {

    private static final int BUFFER_SIZE = 4096;

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
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            lokalProduk produk = new lokalProduk();

            produk.setGambarProduk(request.getPart("fotoProduk"));
            produk.setIdProdukLokal(Integer.parseInt(request.getParameter("idProduk")));
            produk.setNamaBarang(request.getParameter("namaBarang"));
            produk.setKuantitas(Integer.parseInt(request.getParameter("kuantitas")));
            produk.setHarga(Double.parseDouble(request.getParameter("hargaJual")));
            produk.setKeterangan(request.getParameter("ket"));
            produk.setStatus(false);

            MenuAdminDesa menu = new MenuAdminDesa();

            int count = 0;
            try {
                count = menu.updateProduk(produk);
            } catch (SQLException ex) {
                Logger.getLogger(editProdukDesa.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (count > 0) {
                session.setAttribute("warning1", 3);
                response.sendRedirect("./tampilProdukAdmin");
            } else if (count == 0) {
                if (produk.getGambarProduk().getSize() > 1000000) {
                    session.setAttribute("warning1", 2);
                    response.sendRedirect("./tampilProdukAdmin");
                } else {
                    session.setAttribute("warning1", 0);
                    response.sendRedirect("./tampilProdukAdmin");
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
