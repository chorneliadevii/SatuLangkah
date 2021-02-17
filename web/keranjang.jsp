<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Keranjang</title>
        <link rel="stylesheet" href="css/detailProduk.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
              rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
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
        <!-------- cart -------->
        <div class="small-container cart-page">
            <table>
                <tr>
                    <th>Produk</th>
                    <th>Pembayaran</th>
                    <th>Harga Satuan</th>
                </tr>
                <%
                    int i = 0;
                    double total = 0;
                %>
                <jsp:useBean id="daftar" class="classModel.DaftarCart" scope="session" />
                <c:forEach items="${daftar.daftar}" var="dc">
                    <%
                        total = total + (daftar.getDaftar().get(i).getHargaBarang());
                        i++;
                    %>
                    <!--1-->
                    <tr>
                        <td>
                            <div class="cart-info">
                                <img src="data:image/jpg;base64,${dc.base64Image}">
                                <div>
                                    <p>${dc.namaBarang}</p>
                                    <%--
                                    <small>Harga : Rp.${dc.hargaBarang}0</small>
                                    --%>
                                    <br>
                                    <form method="POST" action="./hapusCart">
                                        <input type="hidden" name="idCart" value="${dc.idcart}">
                                        <button type="submit">Hapus dari Keranjang</button> 
                                    </form>
                                </div>
                            </div>
                        </td>                        
                        <td>
                            <form method="POST" action="./bayarCart">
                                <input type="hidden" name="idCart" value="${dc.idcart}">
                                <button type="submit">Bayar</button> 
                            </form>
                        </td>
                        <td><input type="text" id="rubah" value="Rp.${dc.hargaBarang}0" readonly="readonly"></td>
                    </tr>
                    <!--1-->
                </c:forEach>
            </table>
            <div class="total-price">
                <table>
                    <%--
                    <tr>
                        <td>Total</td>
                        <td>Rp.<%=total%>0</td>
                    </tr>
                    --%>
                </table>
            </div>
            <%--
            <a class="btn" href="./pembayaranjsp">Pembayaran</a>
            --%>
        </div>       
    </body>

</html>