package servlet;

import Controller.Akun;
import classModel.AdminDesa;
import classModel.adminSatuLangkah;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "loginAdmin", urlPatterns = {"/loginAdmin"})
public class loginAdmin extends HttpServlet {

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
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        HttpSession session = request.getSession();
        Akun akun = new Akun();
        adminSatuLangkah admin1 = new adminSatuLangkah();
        AdminDesa admin2 = new AdminDesa();

        admin1 = akun.loginAdminSatu(email, pass);

        if (admin1 != null) {
            session.setAttribute("akun", admin1);
            session.setAttribute("sukses", 1);
            RequestDispatcher rd = request.getRequestDispatcher("/homeAdminSatuLang.jsp");
            rd.forward(request, response);
        } else {
            admin2 = akun.loginAdmin(email, pass);
            if (admin2 != null) {
                session.setAttribute("sukses", 1);
                session.setAttribute("akun", admin2);
                RequestDispatcher rd = request.getRequestDispatcher("./homeAdminDesa.jsp");
                rd.forward(request, response);
            } else {
                session.setAttribute("warning", 2);
                response.sendRedirect("./masukAdmin.jsp");
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
