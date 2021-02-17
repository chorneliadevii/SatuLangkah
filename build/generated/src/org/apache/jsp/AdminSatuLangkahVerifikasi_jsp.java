package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdminSatuLangkahVerifikasi_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Satu Langkah Verifikasi</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/newcss.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/adminSatuLangkah.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/verifikasiPesanan.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--navbar-->\n");
      out.write("        <nav>\n");
      out.write("            <div class=\"wrapper\">\n");
      out.write("                <div class=\"logo\"><a href=\"#\">Satu Langkah</a></div>\n");
      out.write("                <input type=\"radio\" name=\"slider\" id=\"menu-btn\">\n");
      out.write("                <input type=\"radio\" name=\"slider\" id=\"close-btn\">\n");
      out.write("                <ul class=\"nav-links\">\n");
      out.write("                    <label for=\"close-btn\" class=\"btn close-btn\"><i class=\"fas fa-times\"></i></label>\n");
      out.write("                    <li><a href=\"./homeAdminSatu\">Home</a></li>\n");
      out.write("                    <li><a href=\"./tentang4.jsp\">Tentang</a></li>\n");
      out.write("                    <li><a href=\"./kontak4\">Kontak</a></li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\" class=\"desktop-item\"><img src=\"asset/profile.png\" class=\"imgCart\"></a>\n");
      out.write("                        <input type=\"checkbox\" id=\"showDrop\">\n");
      out.write("                        <label for=\"showDrop\" class=\"mobile-item\">Profil</label>\n");
      out.write("                        <ul class=\"drop-menu\">\n");
      out.write("                            <li><a href=\"./AdminSatuLangkahVerifikasi.jsp\">pembayaran</a></li>\n");
      out.write("                            <li><a href=\"./logoutAdmin\">Logout</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <label for=\"menu-btn\" class=\"btn menu-btn\"><i class=\"fas fa-bars\"></i></label>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <br>\n");
      out.write("        <h2>Verifikasi Pemesanan Member Satu Langkah</h2>\n");
      out.write("        <div class=\"small-container cart-page\">\n");
      out.write("            <table>\n");
      out.write("                <tr class=\"line\">\n");
      out.write("                    <th>No.Pesanan</th>\n");
      out.write("                    <th>Produk</th>\n");
      out.write("                    <th>Total</th>\n");
      out.write("                    <th>Bukti Pembayaran</th>\n");
      out.write("                    <th> </th>\n");
      out.write("                </tr>\n");
      out.write("                <tr class=\"line\">\n");
      out.write("                    <td><div style=\"text-align: center\">1234567</div></td>\n");
      out.write("                    <td>\n");
      out.write("                        <div class=\"cart-info\">\n");
      out.write("                            <img class=\"img4\" src=\"asset/cat2.png\">\n");
      out.write("                            <div>\n");
      out.write("                            <p>Nama Produsen</p>\n");
      out.write("                            <p><b>Tas Anyaman</b></p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <div class=\"isi\">Rp50.000</div>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <div class=\"isi\" style=\"padding-left: 60px\">\n");
      out.write("                            <img class=\"img4\" src=\"asset/cat3.png\">\n");
      out.write("                        </div>\n");
      out.write("                    </td>\n");
      out.write("                    <td><input class=\"input1\" type=\"submit\" name=\"submit\" value=\"verifikasi\"></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("\n");
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
