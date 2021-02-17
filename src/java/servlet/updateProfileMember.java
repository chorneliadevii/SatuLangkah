/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Controller.Akun;
import classModel.Member;
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
@WebServlet(name = "updateProfileMember", urlPatterns = {"/updateProfileMember"})
public class updateProfileMember extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
        Member member = new Member();
        member.setUsername(request.getParameter("username"));
        member.setEmail(request.getParameter("email"));
        member.setNoHp(request.getParameter("noHp"));
        member.setAlamat(request.getParameter("alamat"));
        member.setPass(request.getParameter("pass"));
        member.setIdUser(Integer.parseInt(request.getParameter("id")));

        Akun akun = new Akun();
        int count = akun.updateProfile(member);
        if (count > 0) {
            session.setAttribute("warning", 1);
            RequestDispatcher rd = request.getRequestDispatcher("./profileUser");
            rd.forward(request, response);
        } else {
            session.setAttribute("warning", 0);
            RequestDispatcher rd = request.getRequestDispatcher("./profileUser");
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
