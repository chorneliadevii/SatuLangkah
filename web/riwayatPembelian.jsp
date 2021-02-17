<%-- 
    Document   : riwayatPembelian
    Created on : Dec 9, 2020, 3:34:16 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Riwayat Pemesanan</title>
        <link rel="stylesheet" href="css/newcss.css">
        <link rel="stylesheet" href="css/riwayatPem.css">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    </head>
    <body>
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
                    <li><a href="./keranjangjsp"><img src="asset/cart.png" class="imgCart"></a></li>
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
        <div class="barang"> 
            <br><br><br>
            <div class="background">
                <br><br>
                <div class="kanan">Selesai</div>
                <h4>Desa Kemandeng</h4>
                <div>
                    <img class="gambar" src="asset/produk1.jpg">
                    <p><b>Kain Batik</b></p>
                    <div class="kanan2">
                        <b>x1 <br>
                            Rp85.000</b>
                    </div>
                </div>
                <hr style="margin-top: 75px">
                <div class="isi">
                    <div class="padd">1 produk</div>
                    <div class="kanan3"> Total Pemesanan : Rp85.000</div>
                </div>
                <br>
                <hr>
                <div class="gambar1">
                    <img src="asset/truck.png">
                    <div class="paket"> 
                        [SLEMAN] Paket telah diterima [Devi]
                    </div>
                </div>    
            </div>
        </div>
    </body>
</html>
