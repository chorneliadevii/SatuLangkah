<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Destinasi Edit Data</title>
        <link rel="stylesheet" href="css/homeAdmin.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            td{
                padding-top: 30px;
            }
        </style>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    </head>
    <body>
        <nav>
            <div class="wrapper"> 
                <div class="menu-toggle">
                    <input id="ckinput" type="checkbox" onclick="cek(this)">
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
                <div class="logo"><a href="#">Satu Langkah</a></div>
                <input type="radio" name="slider" id="menu-btn">
                <input type="radio" name="slider" id="close-btn">
                <ul class="nav-links">
                    <label for="close-btn" class="btn close-btn"><i class="fas fa-times"></i></label>
                    <li><a href="./homeAdminDesajsp">Home</a></li>
                    <li><a href="./tentang3">Tentang</a></li>
                    <li><a href="./kontak3">Kontak</a></li>
                    <li>
                        <a href="#" class="desktop-item"><img src="asset/profile.png" class="imgCart"></a>

                        <ul class="drop-menu">
                            <li><a href="./profileAdminDesa">Edit Profil</a></li>
                            <li><a href="./logoutAdmin">Logout</a></li>
                        </ul>
                    </li>
                </ul>
                <label for="menu-btn" class="btn menu-btn"><i class="fas fa-bars"></i></label>
            </div>
        </nav>

        <div id="menuAdmin">
            <br>
            <br>
            <br>
            <h1 style="color: #798A33;">Menu</h1>
            <div>
                <ul>
                    <li class="listMenu"><a class="color" href="./inputDataDesajsp">Input Data</a></li>
                    <li class="listMenu"><a class="color" href="./editDataDesa"> Lihat Data</a></li>
                    <li class="listMenu"><a class="color" href="Pesanan.html">Pesanan </a></li>
                </ul>
            </div>
        </div>

        <div class="content">
            <h2 class="content1">Destinasi</h2>
            <hr color= #798A33>
            <jsp:useBean id="wisata" class="classModel.WisataTampil" scope="session"/>
            <form method="post" enctype="multipart/form-data" action="./editDestinasiDesa">
                <div>
                    <table>
                        <tr>
                            <td>Nama Destinasi</td>
                            <td><input type="text" name="namaDestinasi" value="${wisata.namaTempat}"></td>
                        </tr>
                        <tr>
                            <td>Alamat</td>
                            <td><textarea name="alamat" cols="50" rows="4">${wisata.alamat}</textarea></td>
                        </tr>
                        <tr>
                            <td style="font-size: 18px;">Tambah Foto</td>
                            <td><input type="file" name="foto"></td>
                        </tr>
                        <tr>
                            <td style="font-size: 18px;">Keterangan</td>
                            <td><textarea name="ket" cols="50" rows="5" >${wisata.keterangan}</textarea></td>
                        </tr>
                        <tr>
                            <td><input type="hidden" name="id" value="${wisata.idPariwisata}"></td>
                        </tr>
                        <tr>
                            <td style="padding-top: 40px">
                                <a href="./editDataDesa" class="btn1">Kembali</a>
                                <input class="btn2" type="submit" name="submit" value="Simpan">
                            </td>
                        </tr>
                    </table>
                </div> 
            </form>
        </div>

        <script src="javascript/menuAdmin.js"></script> 

    </body>
</html>
