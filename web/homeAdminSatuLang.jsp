<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Admin Satu Langkah</title> <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">       
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
        <div>
            <div class="menu">
                <div class="zoomImg"> 
                    <img src="asset/destinasi.png" class="imgMenu"> <br> 
                    <p><a class="style1" href="./AdminSatuDestinasi">Destinasi</a></p>
                </div>
                <div class="zoomImg">
                    <img src="asset/produk.png" class="imgMenu">  
                    <p><a class="style1" href="./AdminSatuProduk">Lokal Produk</a></p>
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
