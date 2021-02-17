<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Destinasi</title>
        <link rel="stylesheet" href="css/destinasiHomePage.css">
        <link rel="stylesheet" href="css/newcss.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
              rel="stylesheet">
    </head>
    <body>
         <nav>
            <div class="wrapper">
                <div class="logo"><a href="#">Satu Langkah</a></div>
                <input type="radio" name="slider" id="menu-btn">
                <input type="radio" name="slider" id="close-btn">
                <ul class="nav-links">
                    <label for="close-btn" class="btn close-btn"><i class="fas fa-times"></i></label>
                    <li><a href="./homepageAwal">Home</a></li>
                    <li><a href="./tentang1">Tentang</a></li>
                    <li><a href="./kontak1">Kontak</a></li>
                    <li>
                        <a href="#" class="desktop-item"><img src="asset/profile.png" class="imgCart"></a>
                        <input type="checkbox" id="showDrop">
                        <label for="showDrop" class="mobile-item">Profil</label>
                        <ul class="drop-menu">
                            <li><a href="./masukAdmin">Login Admin</a></li>
                            <li><a href="./masukjsp">Login Member</a></li>
                        </ul>
                    </li>
                </ul>
                <label for="menu-btn" class="btn menu-btn"><i class="fas fa-bars"></i></label>
            </div>
        </nav>

        <div class="header">
            <div class="container">
                <div class="row">
                    <div class="col-2">
                        <h1>Temukan Tempat yang Sempurna <br>Untuk Tripmu Selanjutnya!</h1>
                    </div>
                    <div class="col-2">                
                    </div>
                </div>
            </div>
        </div>
        <!-------- destinasi -------->
        <jsp:useBean id="daftarWisata" class="classModel.DaftarWisata" scope="session"/>
        <div class="destinasi">
            <h2 class="title">Destinasi</h2>
            <c:forEach items="${daftarWisata.daftar}" var="dp">
                <div class="small-container">
                    <div class="row">
                        <div class="col-3">
                            <img src="data:image/jpg;base64,${dp.base64Image}">
                            <h2> ${dp.namaTempat}</h2>
                            <p><i class="fa fa-quote-left"></i> Alamat : ${dp.alamat}</p>
                            <p><i class="fa fa-quote-left"></i> Keterangan : ${dp.keterangan}</p> 
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>