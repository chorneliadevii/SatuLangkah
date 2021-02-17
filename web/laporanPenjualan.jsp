<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Laporan Penjualan</title>
        <link rel="stylesheet" href="css/laporanPenjualan.css">
    </head>
    <body>
        <%@include file="navbaradmin.jsp" %>
        <div class="laporan">
            <h1>Laporan Penjualan</h1>
            <hr>
            <div class="container">
                <label for="laporanPenjualan">Tanggal: </label>
                <input type="date" id="laporanPenjualan" name="laporanPenjualan" class="input1"/>
                <input  class="btn" type="submit" value="lihat">
            </div>
            <div class="container">
                <table class="table1" >
                    <tr>
                        <th>No. Oder</th>
                        <th>Id User</th>
                        <th>Tanggal Pemesanan</th>
                        <th>Total Jual</th>
                        <th>Total Bayar</th>
                        <th>Keuntungan</th>
                        <th>Aksi</th>
                    </tr>
                    <tr>
                        <td>a</td>
                        <td>b</td>
                        <td>c</td>
                        <td>d</td>
                        <td>e</td>
                        <td>f</td>
                        <td>g</td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
