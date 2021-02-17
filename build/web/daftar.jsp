<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar</title>
        <link rel="stylesheet" href="css/masuk.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                        <ul class="drop-menu">
                            <li><a href="./masukAdminjsp">Login Admin</a></li>
                            <li><a href="./masukjsp">Login Member</a></li>
                        </ul>
                    </li>
                </ul>
                <label for="menu-btn" class="btn menu-btn"><i class="fas fa-bars"></i></label>
            </div>
        </nav>
        <div class="daftar">
            <br>
            <br>
            <br>
            <h1><b>Daftar</b></h1>
            <div>Sudah punya akun ? <a href="./masukjsp">Masuk</a></div>
            <form action="./newUser">
                <input type="text" name="username" placeholder="Nama Lengkap" >
                <input type="text" name="email" placeholder="Email" >
                <input type="text" name="alamat" placeholder="Alamat">
                <input type="text" name="noHP" placeholder="No Telepon">
                <input type="password" name="password" placeholder="password" >
                <input type="submit" name="submit" value="daftar">
            </form>

        </div>
    </body>
</html>