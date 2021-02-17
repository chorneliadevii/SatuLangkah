<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pendaftaran Admin</title>
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
        <div class="daftar">
            <br><br><br>
            <h2><b>Daftar Admin</b> </h2>
            <div>Sudah punya akun ? <a href="./masukAdmin">Masuk</a></div>
            <form action="./newAdminDesa">
            <input type="text" name="namaDesa" placeholder="Nama Desa">
            <input type="text" name="username" placeholder="Username">
            <input type="password" name="pass" placeholder="Password">
            <input type="text" name="alamat" placeholder="Alamat">
            <input type="text" name="email" placeholder="Email">
            <input type="text" name="noHp" placeholder="No Telepon">
            <input type="submit" name=submit value="Daftar">
        </form>
    </div>
</body>

</html>
