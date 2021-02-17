/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Controller.MenuMember;
import classModel.Member;
import classModel.cart;
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
@WebServlet(name = "inputCart", urlPatterns = {"/inputCart"})
public class inputCart extends HttpServlet {

    
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
               processRequest(request, response);
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("akun");
        cart keranjang = new cart();
        keranjang.setMember(member);
        keranjang.setProduk(Integer.parseInt(request.getParameter("produkId")));

        MenuMember menu = new MenuMember();

        int count = menu.inputCart(keranjang);
        if (count > 0) {
            session.setAttribute("warning1", 3);
            RequestDispatcher rd = request.getRequestDispatcher("./lokalProduk.jsp");
            rd.forward(request, response);
        } else {
            session.setAttribute("warning1", 0);
            RequestDispatcher rd = request.getRequestDispatcher("./lokalProduk.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
