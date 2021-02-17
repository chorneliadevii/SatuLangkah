<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Admin Desa</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/homeAdmin.css">
        <link rel="stylesheet" href="css/kontak.css">
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
                    <li class="listMenu"><a class="color" href="./inputDataDesajsp">Input data</a></li>
                    <li class="listMenu"><a class="color" href="./editDataDesa"> Edit data</a></li>
                    <li class="listMenu"><a class="color" href="Pesanan.html">Pesanan </a></li>
                </ul>
            </div>
        </div>

        <h1>Dibalik Website Satu Langkah</h1>
        <br>
        <div class="posisi1">
            <div class="card">
                <img src="asset/ngurah.jpeg" alt="Avatar" class="gambar">
                <div class="container">
                    <h4><b>I Gusti Ngurah Astika Pradnyana Dalem</b></h4>
                    Nim : 185314136<br>
                    Fakultas : Sains dan Teknologi<br>
                    Prodi : Informatika<br> 
                    Hobi : Makan<br>
                    Jika mengalami masalah, hubungi ke-whatsapp : 081339308918<br>
                    atau, <a href="https://wa.me/6281339308918">klik disini</a> 
                </div>
            </div>
        </div>
        <div class="posisi1"> 
            <div class="card">
                <img src="asset/dimas.jpeg" alt="Avatar" class="gambar">
                <div class="container">
                    <h4><b>Dimas Restu Pamungkas</b></h4>
                    Nim : 185314142<br>
                    Fakultas : Sains dan Teknologi<br>
                    Prodi : Informatika<br> 
                    Hobi : Ngalong<br>
                    Jika mengalami masalah, hubungi ke-whatsapp : 085227644272<br>
                    atau, <a href="https://wa.me/6285227644272">klik disini</a>
                </div>
            </div>
        </div>
        <div class="posisi1">
            <div class="card">
                <img src="asset/lia.jpeg" alt="Avatar" class="gambar">
                <div class="container">
                    <h4><b>Chornelia Chrisentya Devi</b></h4>
                    Nim : 185314147<br>
                    Fakultas : Sains dan Teknologi<br>
                    Prodi : Informatika<br> 
                    Hobi : Membaca<br>
                    Jika mengalami masalah, hubungi ke-whatsapp : 08388861071<br>
                    atau, <a href="https://wa.me/628388861071">klik disini</a>
                </div>
            </div>
        </div>
        <div class="posisi1">
            <div class="card">
                <img src="asset/kenny.jpeg" alt="Avatar" class="gambar">
                <div class="container">
                    <h4><b>Kenny Gilbert</b></h4>
                    Nim : 185314111<br>
                    Fakultas : Sains dan Teknologi<br>
                    Prodi : Informatika<br> 
                    Hobi : Ngilang<br>
                    Jika mengalami masalah, hubungi ke-whatsapp : 081770979260<br>
                    atau, <a href="https://wa.me/6281770979260">klik disini</a>
                </div>
            </div>
        </div>
        <script src="javascript/menuAdmin.js"></script> 
    </body>
</html>