<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Input Data Lokal Produk</title>
        <link rel="stylesheet" href="css/homeAdmin.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            td{
                padding-top: 30px;
            }
        </style>
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
                    <li class="listMenu"><a class="color" href="./inputDataDesajsp">Input Data</a></li>
                    <li class="listMenu"><a class="color" href="./editDataDesa"> Lihat Data</a></li>
                    <li class="listMenu"><a class="color" href="Pesanan.html">Pesanan </a></li>
                </ul>
            </div>
        </div>
        <div class="content">
            <h2 class="content1">Produk Lokal</h2>
            <hr color=#798A33>
            <form  name="produk" onsubmit="return validateForm()" method="post" enctype="multipart/form-data" action="./inputDataProduk">
                <div>
                    <table>
                        <tr>
                            <td>Nama Barang</td>
                            <td><input type="text" name="namaBarang" ></td>
                        </tr>
                        <tr>
                            <td>Tambah Foto</td>
                            <td><input type="file" name="lokalproduk" accept='image/*'> Max Image Size 1 MB</td>
                        </tr>
                        <tr>
                            <td>Harga Jual</td>
                            <td><input type="number" name="hargaJual" placeholder="75000"></td>

                        </tr>
                        <tr>
                            <td>Stok</td>
                            <td><input type="number" name="kuantitas"></td>

                        </tr>
                        <tr>
                            <td>Keterangan</td>
                            <td><textarea name="ket" cols="50" rows="5"
                                          placeholder="Kain batik tulis asli motif wayang kombinasi tumpal bawah sekarjagad .Batik ini menggunakan pewarna alam biru indigo jadi sangat aman bagi kulit sensitif dipadu bahan kain yg digunakan katun primisima yg halus dan adem dengan ukuran panjang 1,50 x 1,10 m"></textarea>
                            </td>
                        </tr>
                    </table>
                    <div style="padding-top: 40px">
                        <a href="./inputDataDesajsp" class="btn1">Kembali</a>
                        <input class="btn2" type="submit" name="submit" value="Simpan">
                        <a href="./inputLokalProduk" class="btn1">Batal</a>
                    </div>                  
                </div>
            </form>
        </div>

        <script src="javascript/menuAdmin.js"></script>
        <script>
                function validateForm() {
                    var x = document.forms["produk"]["namaBarang"].value;
                    if (x == "") {
                        alert("Nama tidak boleh kosong");
                        return false;
                    }
                    var a = document.forms["produk"]["hargaJual"].value;
                    if (a == "") {
                        alert("Harga tidak boleh kosong");
                        return false;

                    }
                    var b = document.forms["produk"]["kuantitas"].value;
                    if (b == "") {
                        alert("Stok tidak boleh kosong");
                        return false;

                    }
        </script>
        <script>
            <%if (session.getAttribute("warning1") == null) {
                } else if ((int) session.getAttribute("warning1") == 3) {
            %>alert("Data Berhasil Disimpan");<% } else if ((int) session.getAttribute("warning1") == 1) { %>
                    alert("File Gambar lebih dari 1 MB");
            <% } else if ((int) session.getAttribute("warning1") == 0) { %>
                    alert("Data Gagal Disimpan");
            <% }
                session.removeAttribute("warning1");
            %>
        </script>
    </body>

</html>