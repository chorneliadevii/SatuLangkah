<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lihat Produk</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/homeAdmin.css">
        <link rel="stylesheet" href="css/adminSatuLangkah.css">      
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    </head>
    <body>
        <%@include file="navbaradmin.jsp"%>
        <jsp:useBean id="daftarProdukAdmin" class="classModel.DaftarProduk" scope="session"/>   
        <div class="edit1"> 
            <div class="destinasi">
                <h1>Produk Lokal</h1>  
                <c:forEach items="${daftarProdukAdmin.daftar}" var="dp">
                    <div class="shadow">
                        <form method="post" action="./editProduk" >
                            <table>
                                <tr>
                                    <td>  
                                        <img src="data:image/jpg;base64,${dp.base64Image}">
                                    </td>
                                    <td>
                                        <div>
                                            <h4>Nama Barang</h4>
                                            <input type="text" name="namaBarang"  value="${dp.namaBarang}">
                                        </div>
                                        <div>
                                            <h4>Harga Jual</h4>
                                            <input type="text" name="harga"  value="${dp.harga}">
                                        </div>
                                        <div>
                                            <h4>Keterangan</h4>
                                            <textarea name="ket" cols="50" rows="2" >${dp.keterangan}</textarea>  
                                        </div>
                                        <div>
                                            <h4>Kuantitas</h4>
                                            <input type="text" name="stok"  value="${dp.kuantitas}">
                                        </div>
                                        <div> <h4>Status </h4>
                                            <c:if test="${dp.status}">
                                                <input type="text" name="status" id="sta" value="Terverifikasi">
                                            </c:if>
                                            <c:if test="${!dp.status}">
                                                <input type="text" name="status" id="sta" value="Belum di verifikasi">
                                            </c:if>
                                        </div>
                                        <div>
                                            <input type="hidden" name="idProduk" value="${dp.idProdukLokal}">
                                        </div>
                                    </td>
                                    <td>
                                        <div class="kanan">
                                            <input type="submit" name="submit" value="Edit" class="input1"/>
                                            <input type="submit" name="submit" value="Hapus" class="input1"/>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </div>
        <script src="javascript/menuAdmin.js"></script>
        <script>
            <%if (session.getAttribute("warning1") == null) {
                } else if ((int) session.getAttribute("warning1") == 3) {
            %>alert("Data Berhasil Diupdate");
            <% } else if ((int) session.getAttribute("warning1") == 2) { %>
                alert("Gagal Update. File Image Lebih dari 1 MB");
            <% } else if ((int) session.getAttribute("warning1") == 0) { %>
                alert("Gagal mengupdate");
            <% }
                session.removeAttribute("warning1");
            %>
        </script>
    </body>
</html>
