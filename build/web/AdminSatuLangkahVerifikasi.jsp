<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Satu Langkah Verifikasi</title>
        <link rel="stylesheet" href="css/newcss.css">
        <link rel="stylesheet" href="css/adminSatuLangkah.css">
        <link rel="stylesheet" href="css/verifikasiPesanan.css">
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
        <br>
        <h2>Verifikasi Pemesanan Member Satu Langkah</h2>
        <div class="small-container cart-page">
            <table>
                <tr class="line">
                    <th>No.Pesanan</th>
                    <th>Produk</th>
                    <th>Total</th>
                    <th>Bukti Pembayaran</th>
                    <th> </th>
                </tr>
                <jsp:useBean id="daftarPembayaran" class="classModel.DaftarPembayaranVerif" scope="session"/>
                <c:forEach items="${daftarPembayaran.daftar}" var="dp">
                    <tr class="line">
                        <td><div style="text-align: center">${dp.idPesanan}</div></td>
                        <td>
                            <div class="cart-info">
                                
                                <div>
                                    <p><b>${dp.namaBarang}</b></p>
                                </div>
                            </div>
                        </td>
                        <td>
                            <div class="isi">Rp${dp.hargaBarang}0</div>
                        </td>
                        <td>
                            <div class="isi" style="padding-left: 60px">
                                <img src="data:image/jpg;base64,${dp.base64Image}"/>
                            </div>
                        </td>
                        <td>
                            form
                            <input class="input1" type="submit" name="submit" value="verifikasi">
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </body>
</html>
