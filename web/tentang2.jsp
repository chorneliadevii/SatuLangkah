<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Tentang</title>
        <link rel="stylesheet" href="css/newcss.css">
        <link rel="stylesheet" href="css/tentang.css">
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
        <br>
        <h1>Tentang Satu Langkah</h1>
        <h2>Hello Millennials,</h2>
        <div class="paragrf">
            Di era saat ini, mudah bagi kebanyakan orang untuk mencari destinasi-destinasi yang menarik dan indah di Indonesia, terlebih di daerah Yogyakarta. 
            Tetapi disamping itu, masih banyak keindahan alam di desa-desa kecil yang masih belum tereksplor yang dimana juga mempunyai daya tarik dan keindahan yang tidak kalah 
            bersaing dengan destinasi-destinasi yang umum lainnya. Kelompok kami mencoba membuat sebuah Platform bernama SATU LANGKAH, dimana platform ini berbasis web. 
            Satu Langkah merupakan bentuk kepedulian kami terhadap desa-desa kecil yang memiliki potensi dibidang pariwisata dan sumber daya alam.
        </div>
        <div class="paragrf2">
            Terjadinya Pandemi Covid19 saat ini, mengakibatkan perekonomian anjlok di segala sisi nya, hal tersebut membuat kami semakin yakin untuk mengembangkan sistem ini, 
            guna membantu membumikan desa-desa kecil tersebut agar setidaknya, perekonomian warga lokal juga dapat terbantu. Sehingga sistem ini diharapkan tidak hanya mampu mengatasi 
            masalah perekonomian dengan menjual hasil bumi atau kerajinan warga lokal tetapi juga bisa mengeksplorasi lebih jauh mengenai desa-desa kecil yang memiliki potensi di bidang pariwisata tetapi belum terjamah oleh orang awam. 
        </div>
        <img class="kanan" src="asset/font.jpeg"><br>
        <div class="kanan1">
            Salam Developer
        </div>
    </body>
</html>