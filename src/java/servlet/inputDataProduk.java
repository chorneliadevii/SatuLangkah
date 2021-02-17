/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Controller.MenuAdminDesa;
import classModel.AdminDesa;
import classModel.Wisata;
import classModel.lokalProduk;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author acer
 */
@WebServlet(name = "inputDataProduk", urlPatterns = {"/inputDataProduk"})
@MultipartConfig(maxFileSize = 16177215)
public class inputDataProduk extends HttpServlet {

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
        lokalProduk produk = new lokalProduk();
        produk.setAdmin(admin);
        produk.setNamaBarang(request.getParameter("namaBarang"));
        produk.setHarga(Double.parseDouble(request.getParameter("hargaJual")));
        produk.setKuantitas(Integer.parseInt(request.getParameter("kuantitas")));
        produk.setKeterangan(request.getParameter("ket"));
        produk.setGambarProduk(request.getPart("lokalproduk"));

        if (produk.getGambarProduk().getSize() > 1000000) {
            session.setAttribute("warning1", 1);
            RequestDispatcher rd = request.getRequestDispatcher("./inputLokalProduk.jsp");
            rd.forward(request, response);
        } else {
            MenuAdminDesa menu = new MenuAdminDesa();

            int count = menu.inputLokalProduk(produk);

            if (count > 0) {
                session.setAttribute("warning1", 3);

                RequestDispatcher rd = request.getRequestDispatcher("./inputLokalProduk.jsp");
                rd.forward(request, response);
            } else {
                session.setAttribute("warning1", 0);

                RequestDispatcher rd = request.getRequestDispatcher("./inputLokalProduk.jsp");
                rd.forward(request, response);
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
