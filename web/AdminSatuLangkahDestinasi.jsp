<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Destinasi Admin Satu Langkah</title>
        <link rel="stylesheet" href="css/newcss.css">
        <link rel="stylesheet" href="css/adminSatuLangkah.css">
    </head>
    <body>
        <!--navbar-->
        <nav>
            <div class="wrapper">
                <div class="logo"><a href="#">Satu Langkah</a></div>
                <input type="radio" name="slider" id="menu-btn">
                <input type="radio" name="slider" id="close-btn">
                <ul class="nav-links">
                    <label for="close-btn" class="btn close-btn"><i class="fas fa-times"></i></label>
                    <li><a href="./homeAdminSatu">Home</a></li>
                    <li><a href="./tentang4.jsp">Tentang</a></li>
                    <li><a href="./kontak4">Kontak</a></li>
                    <li>
                        <a href="#" class="desktop-item"><img src="asset/profile.png" class="imgCart"></a>
                        <input type="checkbox" id="showDrop">
                        <label for="showDrop" class="mobile-item">Profil</label>
                        <ul class="drop-menu">
                            <li><a href="./AdminSatuLangkahVerifikasi.jsp">pembayaran</a></li>
                            <li><a href="./logoutAdmin">Logout</a></li>
                        </ul>
                    </li>
                </ul>
                <label for="menu-btn" class="btn menu-btn"><i class="fas fa-bars"></i></label>
            </div>
        </nav>

        <jsp:useBean id="daftarWisataAdmin" class="classModel.DaftarWisata" scope="session"/>
        
            <div class="destinasi">
                <h1>Destinasi</h1>
                <c:forEach items="${daftarWisataAdmin.daftar}" var="dp" >
                <!--start content-->
                <div class="shadow">
                    <form method="post" action="./verifikasiData">
                        <table>
                            <tr>
                                <td>
                                    <h3>${dp.namaTempat}</h3>
                                    <img src="data:image/jpg;base64,${dp.base64Image}">
                                </td>
                                <td>
                                    <div>
                                        <h4>ID pariwisata</h4>
                                        <input type="text" name="idPariwisata" value="${dp.idPariwisata}">
                                    </div>
                                    <div>
                                        <h4>Alamat</h4>
                                        <textarea name="alamat" cols="50" rows="2" readonly="alamat">${dp.alamat}</textarea>
                                    </div>
                                    <div>
                                        <h4>Keterangan</h4>
                                        <textarea name="ket" cols="50" rows="2" readonly="ket">${dp.keterangan}</textarea>  
                                    </div>

                                </td>
                                <td>
                                    <div class="kanan">
                                        <input  type="submit" name="submit" value="Verifikasi" class="input1"/>
                                        <input type="submit" name="submit" value="Hapus" class="input1"/>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </c:forEach>
        </div>


        <script>
               <%if (session.getAttribute("warning5") == null) {
                } else if ((int) session.getAttribute("warning5") == 1) {
            %>alert("Data Berhasil Diverifikasi");
            <% } else if ((int) session.getAttribute("warning5") == 0) { %>
                alert("Gagal Memverifikasi");
            <% } else if ((int) session.getAttribute("warning5") == 2) { %>
                alert("Berhasil menghapus");
            <% } else if ((int) session.getAttribute("warning5") == 3) { %>
                alert("Gagal menghapus");
            <% }
                session.removeAttribute("warning5");
            %>
        </script>


    </body>
</html>
