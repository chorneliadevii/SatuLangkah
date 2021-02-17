<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Upload Bukti Pembayaran</title>
        <link rel="stylesheet" href="css/uploadBukti.css">
        <link rel="stylesheet" href="css/newcss.css">
    </head>

    <body>

        <!----- navbar ----->
        <nav>
            <div class="wrapper">
                <div class="logo"><a href="#">Satu Langkah</a></div>
                <input type="radio" name="slider" id="menu-btn">
                <input type="radio" name="slider" id="close-btn">
                <ul class="nav-links">
                    <label for="close-btn" class="btn close-btn"><i class="fas fa-times"></i></label>
                    <li><a href="./homepagejsp">Home</a></li>
                    <li><a href="./tentang2">Tentang</a></li>
                    <li><a href="./kontak2">Kontak</a></li>
                    <li><a href="./TampilCart"><img src="asset/cart.png" class="imgCart"></a></li>
                    <li>
                        <a href="#" class="desktop-item"><img src="asset/profile.png" class="imgCart"></a>
                        <input type="checkbox" id="showDrop">
                        <label for="showDrop" class="mobile-item">Profil</label>
                        <ul class="drop-menu">
                            <li><a href="./profileUser">Edit Profil</a></li>
                            <li><a href="./riwayatjsp">Riwayat Pesanan</a></li>
                            <li><a href="./logoutMember">Logout</a></li>
                        </ul>
                    </li>
                </ul>
                <label for="menu-btn" class="btn menu-btn"><i class="fas fa-bars"></i></label>
            </div>
        </nav>
        <br>
        <br>
        <jsp:useBean id="bayar" class="classModel.cart" scope="session" />
        <div class="posisi1">
            <form name="pembayaran" method="POST" enctype="multipart/form-data" action="./inputPesanan">
                <div class="card">
                    <div class="container">
                        <h4><b>Upload Bukti Pembayaran</b></h4><br><br>
                        <input type="hidden" name="idCart" value="${bayar.idCart}">
                        <input class="tengah2" type="file" name="buktiTrf" value="Masukkan foto disini"><br>
                        <div class="tengah"><input class="btn2" type="submit" name="submit" value="Submit"></div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
