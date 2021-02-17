<%@page import="classModel.DaftarWisata"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Data</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/adminSatuLangkah.css">      
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    </head>
    <body>
        <%@include file="navbaradmin.jsp"%>
        <jsp:useBean id="daftarWisataAdmin" class="classModel.DaftarWisata" scope="session"/>
        <div class="edit1">   
            <div class="destinasi">
                <h1>Destinasi</h1>
                <c:forEach items="${daftarWisataAdmin.daftar}" var="dp" >
                    <!--start content-->
                    <div class="shadow">
                        <form name="destinasi"  method="post" action="./editDestinasi">
                            <table>
                                <tr>
                                    <td>
                                        <h3>${dp.namaTempat}</h3><br>
                                        <img src="data:image/jpg;base64,${dp.base64Image}">
                                    </td>
                                    <td>
                                        <div>
                                            <h4>Id Pariwisata</h4>
                                            <input type="text" name="idPariwisata" value="${dp.idPariwisata}">
                                        </div>
                                        <div>
                                            <h4>Alamat</h4>
                                            <textarea name="alamat" cols="50" rows="2">${dp.alamat}</textarea>
                                        </div>
                                        <div>
                                            <h4>Keterangan</h4>
                                            <textarea name="ket" cols="50" rows="2" >${dp.keterangan}</textarea>  
                                        </div>
                                        <div>
                                            <h4>Status</h4>
                                            <c:if test="${dp.status}">
                                                <input type="text" name="status" id="sta" value="Terverifikasi">
                                            </c:if>
                                            <c:if test="${!dp.status}">
                                                <input type="text" name="status" id="sta" value="Belum di verifikasi">
                                            </c:if>
                                        </div>

                                    </td>
                                    <td>
                                        <div class="kanan">
                                            <input  type="submit" name="submit" value="Edit" class="input1"/>
                                            <input  type="submit" onclick="return confirm(Apakah anda yakin ingin menghapus data ini ?)"  name="submit" value="Hapus" class="input1"/>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>
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
