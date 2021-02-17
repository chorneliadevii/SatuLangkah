package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homeAwal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <title>Homepage</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/newcss.css\">\n");
      out.write("        <script src=\"https://kit.fontawesome.com/a076d05399.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav>\n");
      out.write("            <div class=\"wrapper\">\n");
      out.write("                <div class=\"logo\"><a href=\"#\">Satu Langkah</a></div>\n");
      out.write("                <input type=\"radio\" name=\"slider\" id=\"menu-btn\">\n");
      out.write("                <input type=\"radio\" name=\"slider\" id=\"close-btn\">\n");
      out.write("                <ul class=\"nav-links\">\n");
      out.write("                    <label for=\"close-btn\" class=\"btn close-btn\"><i class=\"fas fa-times\"></i></label>\n");
      out.write("                    <li><a href=\"./homepageAwal\">Home</a></li>\n");
      out.write("                    <li><a href=\"./tentang1\">Tentang</a></li>\n");
      out.write("                    <li><a href=\"./kontak1\">Kontak</a></li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\" class=\"desktop-item\"><img src=\"asset/profile.png\" class=\"imgCart\"></a>\n");
      out.write("                        <input type=\"checkbox\" id=\"showDrop\">\n");
      out.write("                        <label for=\"showDrop\" class=\"mobile-item\">Profil</label>\n");
      out.write("                        <ul class=\"drop-menu\">\n");
      out.write("                            <li><a href=\"./masukAdmin\">Login Admin</a></li>\n");
      out.write("                            <li><a href=\"./masukjsp\">Login Member</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <label for=\"menu-btn\" class=\"btn menu-btn\"><i class=\"fas fa-bars\"></i></label>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div>\n");
      out.write("            <div class=\"imgMenu\">\n");
      out.write("                <div class=\"zoomImg\"> \n");
      out.write("                    <img src=\"asset/destinasi.png\" class=\"imgMenu\"> <br> \n");
      out.write("                    <a class=\"style1\" href=\"./tampilWisata\">Destinasi</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"zoomImg\">\n");
      out.write("                    <img src=\"asset/produk.png\" class=\"imgMenu\">  \n");
      out.write("                    <p><a class=\"style1\" href=\"./tampilLokalProduk\">Lokal Produk</a></p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
