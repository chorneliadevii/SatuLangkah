/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Controller.MenuMember;
import classModel.Member;
import classModel.pembayaran;
import java.io.IOException;
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
@WebServlet(name = "inputPesanan", urlPatterns = {"/inputPesanan"})
@MultipartConfig(maxFileSize = 16177215)
public class inputPesanan extends HttpServlet {

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
        Member member = (Member) session.getAttribute("akun");
        pembayaran pay = new pembayaran();
        int id = Integer.parseInt(request.getParameter("idCart"));
        pay.setKeranjang(id);
        pay.setBuktiBayar(request.getPart("buktiTrf"));

        if (pay.getBuktiBayar().getSize() > 1000000) {
            session.setAttribute("warning1", 1);
            RequestDispatcher rd = request.getRequestDispatcher("./uploadBuktiTf.jsp");
            rd.forward(request, response);
        } else {
            MenuMember menu = new MenuMember();
            int count = menu.inputPembayaran(pay);

            int count2 = menu.editCart(Integer.parseInt(request.getParameter("idCart")));

            int count3 = menu.kirimPesanan(menu.getIdPembayaran(id));

            if (count > 0) {
                session.setAttribute("warning1", 3);
                RequestDispatcher rd = request.getRequestDispatcher("./keranjang.jsp");
                rd.forward(request, response);
            } else {
                session.setAttribute("warning1", 0);
                RequestDispatcher rd = request.getRequestDispatcher("./uploadBuktiTf.jsp");
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