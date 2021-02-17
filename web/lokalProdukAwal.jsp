<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lokal Produk</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/newcss.css">
        <link rel="stylesheet" href="css/menuUtama.css">
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
        <div>
            <div class="container">
                <div class="small-container">
                    <div class="row row-2">
                        <h2>Produk Lokal</h2>
                    </div>
                    <div class="product-items">
                        <!--Single product-->
                        <jsp:useBean id="daftarProduk" class="classModel.DaftarProduk" scope="session"/>
                        <c:forEach items="${daftarProduk.daftar}" var="dp">
                            <!--Single product-->
                            <div class="product">
                                <div class="product-content">
                                    <div class="product-img">
                                        <img src="data:image/jpg;base64,${dp.base64Image}"/>
                                    </div>
                                    <div class="product-btns">
                                        <form action="#" onsubmit=" return validate()">
                                            <button type="submit" class="btn-cart">keranjang
                                                <span><i class="fas fa-plus"></i></span>
                                            </button> 
                                        </form>
                                    </div>
                                </div>
                                <div class="product-info">
                                    <a href="#" class="product-name">${dp.namaBarang}</a><br>
                                    <p>Rp. ${dp.harga}0</p><br>
                                    <p>${dp.keterangan}</p>
                                </div>
                                <div class="off-info">
                                    <h2 class="sm-title">Stok : ${dp.kuantitas}</h2>
                                </div>
                            </div>
                            <!--end single product-->
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function validate() {
                alert("Silahkan Login Terlebih Dahulu");
                return false;
            }
        </script>
    </body>
</html>
