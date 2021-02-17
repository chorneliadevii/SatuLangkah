<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pembayaran</title>
        <link rel="stylesheet" href="css/pembayaran.css">
        <link rel="stylesheet" href="css/newcss.css">
    </head>

    <body>
        <!----- navbar ----->
        <nav>
            <div class="wrapper">
                <div class="logo"><a href="#">Satu Langkah</a></div>
                <input type="radio" name="slider" id="menu-btn">
                <input type="radio" name="slider" id="close-btn">
                <ul class="nav-links">
                    <label for="close-btn" class="btn close-btn"><i class="fas fa-times"></i></label>
                    <li><a href="homepage.jsp">Home</a></li>
                    <li><a href="#">Tentang</a></li>
                    <li><a href="#">Kontak</a></li>
                    <li><a href="./TampilCart"><img src="asset/cart.png" class="imgCart"></a></li>
                    <li>
                        <a href="#" class="desktop-item"><img src="asset/profile.png" class="imgCart"></a>
                        <input type="checkbox" id="showDrop">
                        <label for="showDrop" class="mobile-item">Profil</label>
                        <ul class="drop-menu">
                            <li><a href="profile.jsp">Edit Profil</a></li>
                            <li><a href="riwayatPembelian.jsp">Riwayat Pesanan</a></li>
                            <li><a href="./logoutMember">Logout</a></li>
                        </ul>
                    </li>
                </ul>
                <label for="menu-btn" class="btn menu-btn"><i class="fas fa-bars"></i></label>
            </div>
        </nav>
        <!-------- pembayaran -------->
        <jsp:useBean id="detail" class="classModel.pembayaranModel" scope="session" />
        <div class="small-container cart-page">
            <table class="line1">
                <tr>
                    <th>Alamat: ${detail.detail.alamat}</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                <tr>
                    <td><p></p>
                    </td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
            <br>
            <table class="line1">
                <tr>
                    <th>Produk Dipesan</th>
                    <th>Harga Satuan</th>
                    <th>Kuantitas</th>
                    <th>Total Harga</th>
                </tr>
                <!--1-->
                <tr>
                    <td>
                        <h4>${detail.detail.namaBarang}</h4>
                        <div class="cart-info">
                            <img src="data:image/jpg;base64,${detail.detail.base64Image}">
                        </div>
                    </td>
                    <td>Rp.${detail.detail.hargaBarang}0
                        <input type="hidden" id="harga" value="${detail.detail.hargaBarang}">
                    </td>
                    <td><input type="text" id="rubah" value="1" onchange="updateInput(value)"</td>
                    <td><input type="text" id="rubah" value="Rp.${detail.detail.hargaBarang}0" readonly="readonly"></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
            <br>
            <table class="line1">
                <tr>
                    <th>Metode Pembayaran</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                <tr>
                    <td>Transfer Bank - BCA </td>
                    <td>Total pembayaran  :</td>
                    <td></td>
                    <td><input type="text" id="htotal" value="Rp.${detail.detail.hargaBarang}0" readonly="readonly"></td>
                </tr>
                <tr>
                    <td>Nomor Rekening: 4560942465 </td>
                    <td></td>
                    <td></td>
                    <td>
                        <form method="POST" action="./uploadBukti">
                            <input type="hidden" name="idCart" value="${detail.detail.idCart}">
                            <input type="hidden" name="idBarang" value="${detail.detail.idBarang}">
                            <input type="submit" id="upload" value="Upload Bukti Transfer" class="btn">
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>Atas Nama: Chornelia Chrisentya Devi</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
        </div>
    </body>
    <script type="text/javascript">
        function updateInput(x) {
            var harga = parseFloat(document.getElementById('harga').value);
            var total = x * harga;
            document.getElementById("rubah").value = "Rp." + total + ".00";
            document.getElementById("htotal").value = "Rp." + total + ".00";
        }
    </script>

</html>