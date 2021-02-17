<!DOCTYPE html>

<html>
    <head>
        <title>Profil</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/newcss.css">
        <style>
            td{
                padding-top: 40px;
            }
        </style>
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
        <br>
        <br>
        <br>
        <div class="konten-profil">
            <h1 style="margin-left: 46%">Profil Saya </h1>
            <hr>
            <jsp:useBean id="akun1" class="classModel.Member" scope="session"/>
            <form method="POST" action="./updateProfileMember">
                <div style="padding-left:40%">
                    <table style="padding:15px;">
                        <tr>
                            <td>Username</td>
                            <td><input type="text" name="username" value="${akun1.username}"></td>
                        </tr>                      
                        <tr>
                            <td>Email</td>
                            <td><input type="text" name="email" value="${akun1.email}"></td>
                        </tr>
                        <tr>
                            <td>No. Telepon</td>
                            <td><input type="text" name="noHp" value="${akun1.noHp}"></td>
                        </tr>
                        <tr>
                            <td>Alamat</td>
                            <td><textarea name="alamat" rows="2" cols="25">${akun1.alamat}</textarea></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="text" name="pass" value="${akun1.pass}"></td>
                        </tr>
                        <tr>
                            <td><input type="hidden" name="id" value="${akun1.idUser}"></td>
                        </tr>

                        <tr>
                            <td style="padding-left: 20%"><input class="btn2" type="submit" name="submit" value="Update"></td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>

        <script>
            <%if (session.getAttribute("warning") == null) {
                } else if ((int) session.getAttribute("warning") == 1) {
            %>alert("Data Berhasil Disimpan");<% } else if ((int) session.getAttribute("warning") == 0) { %>
                alert("Gagal menyimpan");
            <% }
                session.removeAttribute("warning");
            %>
        </script>
    </body>
</html>
