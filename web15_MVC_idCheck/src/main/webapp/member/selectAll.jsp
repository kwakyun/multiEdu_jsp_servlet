<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
 <html>
 <head>
    <title>selectAll.jsp</title>
    <style>
    #customers {
      font-family: Arial, Helvetica, sans-serif;
      border-collapse: collapse;
      width: 100%;
    }

    #customers td, #customers th {
      border: 1px solid #ddd;
      padding: 8px;
      text-align: center; /* 이미지 정렬 */
    }

    #customers tr:nth-child(even) { background-color: #f2f2f2; }

    #customers tr:hover { background-color: #ddd; }

    #customers th {
      padding-top: 12px;
      padding-bottom: 12px;
      text-align: left;
      background-color: #04AA6D;
      color: white;
    }

    /* 이미지 크기 조정 및 셀 확장 */
    #customers img {
      max-width: 100px; /* 최대 이미지 폭 제한 */
      height: auto;     /* 비율을 유지한 채로 높이 조정 */
    }

    </style>
 </head>
 <body>
    <h1>회원 목록 페이지</h1>
    <jsp:include page="../top_menu.jsp"/>

    <form action="m_searchList.do" method="get">
        <select name="searchKey">
            <option value="name">name</option>
            <option value="tel">tel</option>
        </select>
        <input type="text" name="searchWord" value="ki"/>
        <input type="submit" value="search"/>
    </form>

    <table id="customers">
        <tr>
            <th>num</th>
            <th>id</th>
            <th>pw</th>
            <th>name</th>
            <th>tel</th>
            <th>imgName</th>
        </tr>
        <c:choose>
           <c:when test="${spage == null}">
               <c:forEach var="vo" items="${vos}">
                   <tr>
                       <td><a href="m_selectOne.do?num=${vo.num}">${vo.num}</a></td>
                       <td>${vo.id}</td>
                       <td>${vo.pw}</td>
                       <td>${vo.name}</td>
                       <td>${vo.tel}</td>
                       <td><img src="upload/${vo.imgName}" width="50" alt="default.png"></td>



                   </tr>
               </c:forEach>
           </c:when>
           <c:otherwise>
               <c:forEach var="vo" items="${spageVos}">
                   <tr>
                       <td><a href="m_selectOne.do?num=${vo.num}">${vo.num}</a></td>
                       <td>${vo.id}</td>
                       <td>${vo.pw}</td>
                       <td>${vo.name}</td>
                       <td>${vo.tel}</td>
                       <td><img src="upload/${vo.imgName}" width="50" alt="default.png"></td>
                   </tr>
               </c:forEach>
           </c:otherwise>
        </c:choose>

        <tr>
            <td colspan="${cpage}">
                <c:forEach var="i" begin="1" end="${cpage}">
                    <a href="m_selectAll.do?spage=${i}&limit=10">${i}</a>
                </c:forEach>
            </td>
        </tr>
    </table>
 </body>
 </html>