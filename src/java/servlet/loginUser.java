package servlet;

import Controller.Akun;
import classModel.Member;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import koneksi.DbConnection;

@WebServlet(name = "loginUser", urlPatterns = {"/loginUser"})
public class loginUser extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String email = request.getParameter("email");
            String pass = request.getParameter("password");
            try {
                Akun akun = new Akun();
                Member x = new Member();
                x = akun.loginMember(email, pass);
                if (x == null) {
                    session.setAttribute("warning", 1 );
                    response.sendRedirect("./masukjsp");
                } else if (x.getIdUser() > 0) {
                    session.setAttribute("akun", x);
                    session.setAttribute("sukses", 1);
                    RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp");
                    rd.forward(request, response);

                }
            } catch (Exception e) {
                out.println("erros : " + e);
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
