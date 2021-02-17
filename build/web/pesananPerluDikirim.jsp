<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesanan Perlu Dikirim</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/homeAdmin.css">
        <link rel="stylesheet" href="css/pesanan.css">
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
                <input type="radio" name="slider" id="menu-btn">
                <input type="radio" name="slider" id="close-btn">
                <ul class="nav-links">
                    <label for="close-btn" class="btn close-btn"><i class="fas fa-times"></i></label>
                    <li><a href="./homeAdminDesajsp">Home</a></li>
                    <li><a href="#">Tentang</a></li>
                    <li><a href="#">Kontak</a></li>
                    <li>
                        <a href="#" class="desktop-item"><img src="asset/profile.png" class="imgCart"></a>
                       
                        <ul class="drop-menu">
                            <li><a href="./profilejsp">Edit Profil</a></li>
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
                    <li class="listMenu"><a class="color" href="LaporanPenjualan">Laporan penjualan </a></li>
                </ul>
            </div>
        </div>
        <h2>PESANAN</h2>
        <hr>
        <ul class="catBlock">
            <li><a href="">Belum Bayar</a></li>
            <li><a href="">Perlu Dikirim</a></li>
            <li><a href="">Selesai</a></li>
        </ul>
        <div class="line"></div><br>
        <div class="pesanan"><b>PESANAN</b></div>
        <table>
            <th class="tiga">Produk</th>
            <th class="satu">Jumlah Harus Bayar</th>
            <th class="dua">Kuantitas</th>
            <th class="dua">Jasa Kirim</th>
            <th class="dua">Aksi</th>
            <tr class="line1">
                <td>Nama Pemesan</td>
                <td></td>
                <td></td>
                <td></td>
                <td>No.Pesanan : 1234567</td>
            </tr>
            <tr class="line1">
                <td>
                    <div class="cart-info">
                        <img class="img4" src="asset/cat1.png">
                        <div>
                            <p>Nama Produsen</p>
                            <p><b>Tas Anyaman</b></p>
                        </div>
                    </div>
                </td>
                <td>
                    <div class="isi">Rp50.000</div>
                </td>
                <td>
                    <div class="isi">1</div>
                </td>
                <td>
                    <div class="isi">JNE Reguler</div>
                </td>
                <td>
                    <div class="isi"><button class="btn2">Kirim</button></div>
                </td>
            </tr>
        </table>
        <br>


    </table>

    <script src="javascript/menuAdmin.js"></script>   
    </body>
</html>
