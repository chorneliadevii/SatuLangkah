<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Homepage</title>
        <link rel="stylesheet" href="css/newcss.css">
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
        <div>
            <div class="imgMenu">
                <div class="zoomImg"> 
                    <img src="asset/destinasi.png" class="imgMenu"> <br> 
                    <a class="style1" href="./tampilWisata">Destinasi</a>
                </div>
                <div class="zoomImg">
                    <img src="asset/produk.png" class="imgMenu">  
                    <p><a class="style1" href="./tampilLokalProduk">Lokal Produk</a></p>
                </div>
            </div>
        </div>
        <script>
            <%if (session.getAttribute("sukses") == null) {
                } else if ((int) session.getAttribute("sukses") == 1) {
            %>alert("Anda Telah Berhasil Login");
            <% }
                session.removeAttribute("sukses");
            %>
        </script>
    </body>
</html>
