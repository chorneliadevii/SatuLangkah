<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Masuk Admin</title>
        <link rel="stylesheet" href="css/masuk.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    </head>
    <body>
        <nav>
            <div class="wrapper">
                <div class="logo"><a href="#">Satu Langkah</a></div>
                <ul class="nav-links">
                    <label for="close-btn" class="btn close-btn"><i class="fas fa-times"></i></label>
                    <li><a href="./homepageAwal">Home</a></li>
                    <li><a href="./tentang1">Tentang</a></li>
                    <li><a href="./kontak1">Kontak</a></li>
                    <li>
                        <a href="#" class="desktop-item"><img src="asset/profile.png" class="imgCart"></a>
                        <ul class="drop-menu">
                            <li><a href="./masukAdmin">Login Admin</a></li>
                            <li><a href="./masukjsp">Login Member</a></li>
                        </ul>
                    </li>
                </ul>
                <label for="menu-btn" class="btn menu-btn"><i class="fas fa-bars"></i></label>
            </div>
        </nav>

        <div class="masuk">
            <br> <br><br>
            <h1>LOGIN ADMIN</h1><br>
            <div>Pengguna baru? <a href="daftarAdminjsp">Daftar</a></div>

            <form method="POST" action="./loginAdmin" >
                <input type="text" name="email" placeholder="Email" > 
                <input type="password" name="pass" placeholder="Password"  > 
                <input type="submit" name="submit" value="LOGIN" > 
            </form>

            <div>
                <br>
                Dengan masuk, Anda menyetujui Persyaratan <br>
                Layanan kami dan menerima email serta <br>
                pembaruan dariSatu Langkah dan Anda setuju <br>
                untuk membaca Kebijakan Privasi kami <br>
            </div>
        </div>
        <script>
            <% if (session.getAttribute("warning") == null) {
                } else if ((int) session.getAttribute("warning") == 2) {
            %>
            alert("username / password anda salah");

            <% session.removeAttribute("warning");
                    session.invalidate();
                }
            %>
        </script> 
    </body>
</html>