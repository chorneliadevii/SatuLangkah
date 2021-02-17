<%-- 
    Document   : profileAdminDesa
    Created on : Dec 11, 2020, 8:36:45 PM
    Author     : Hp
--%>
<!DOCTYPE html>

<html>
    <head>
        <title>Profil Admin Desa</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/homeAdmin.css">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <style>
            td{
                padding-top: 40px;
            }
        </style>
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
                    <li class="listMenu"><a class="color" href="./inputDataDesajsp">Input Data</a></li>
                    <li class="listMenu"><a class="color" href="./editDataDesa"> Lihat Data</a></li>
                    <li class="listMenu"><a class="color" href="Pesanan.html">Pesanan </a></li>
                </ul>
            </div>
        </div>
            <br>
            <h1 style="margin-left: 46%">Profil Saya </h1>
            <br>
            <hr>
            <jsp:useBean id="akun1" class="classModel.AdminDesa" scope="session"/>
            <form method="POST" action="./updateProfileAdminDesa">
                <div style="padding-left:40%">
                    <table style="padding:15px;">
                        <tr>
                            <td>Nama Desa</td>
                            <td><input type="text" name="namaDesa" value="${akun1.namaDesa}"></td>
                        </tr>
                        <tr>
                            <td>Username</td>
                            <td><input type="text" name="username" value="${akun1.username}"></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="text" name="password" value="${akun1.pass}"></td>
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
                            <td><input type="hidden" name="IdDesa" value="${akun1.idDesa}"></td>
                        </tr>
                        <tr>
                            <td style="padding-left: 20%"><input class="btn2" type="submit" value="Update"></td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>
        </div>
        <script src="javascript/menuAdmin.js"></script>       
        <script>
            <%if (session.getAttribute("warning404") == null) {
                } else if ((int) session.getAttribute("warning404") == 1) {
            %>alert("Data Berhasil Disimpan");<% } else if ((int) session.getAttribute("warning404") == 0) { %>
                alert("Gagal menyimpan");
            <% }
                session.removeAttribute("warning404");
            %>
        </script>
    </body>
</html>
