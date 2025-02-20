<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>사원 등록 페이지</title>
            <style>
                body {
                    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                    background-color: #f4f4f4;
                    margin: 0;
                    padding: 0;
                }

                .container {
                    max-width: 600px;
                    margin: 50px auto;
                    background: #fff;
                    border-radius: 8px;
                    padding: 20px 30px;
                    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                }

                h1 {
                    text-align: center;
                    color: #333;
                    margin-bottom: 30px;
                }

                table {
                    width: 100%;
                    border-collapse: collapse;
                }

                table td {
                    padding: 12px;
                }

                label {
                    display: block;
                    font-weight: bold;
                    color: #555;
                    margin-bottom: 5px;
                }

                input[type="text"] {
                    width: 100%;
                    padding: 10px;
                    margin: 5px 0 10px;
                    border: 1px solid #ccc;
                    border-radius: 4px;
                    box-sizing: border-box;
                }

                input[type="submit"] {
                    width: 100%;
                    padding: 10px;
                    background-color: #0c8785;
                    color: #fff;
                    border: none;
                    border-radius: 4px;
                    font-size: 16px;
                    cursor: pointer;
                    margin-top: 20px;
                }

                input[type="submit"]:hover {
                    background-color: #274e00;
                }
            </style>
        </head>

        <body>
            <div class="container">
                <h1>사원 등록 페이지</h1>
                <jsp:include page="../top_menu.jsp" />
                <form action="e_insertOK.do" method="post">
                    <table>
                        <tr>
                            <td>
                                <label for="employee_id">사원아이디:</label>
                                <input type="text" id="employee_id" name="employee_id" value="207">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="first_name">성:</label>
                                <input type="text" id="first_name" name="first_name" value="James">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="last_name">이름:</label>
                                <input type="text" id="last_name" name="last_name" value="bond">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="email">이메일:</label>
                                <input type="text" id="email" name="email" value="dummy01@gmail.com">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="phone_number">전화번호:</label>
                                <input type="text" id="phone_number" name="phone_number" value="010-1234-5678">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="hire_date">입사일:</label>
                                <input type="text" id="hire_date" name="hire_date" value="20200202">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="job_id">직책 아이디:</label>
                                <input type="text" id="job_id" name="job_id" value="IT_PROG">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="salary">연봉:</label>
                                <input type="text" id="salary" name="salary" value="9500.00">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="commission_pct">커미션퍼센트:</label>
                                <input type="text" id="commission_pct" name="commission_pct" value="0.50">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="manager_id">메니저아이디:</label>
                                <input type="text" id="manager_id" name="manager_id" value="108">
                            </td>
                        <tr>
                            <td>
                                <label for="department_id">부서아이디:</label>
                                <input type="text" id="department_id" name="department_id" value="20">
                            </td>
                        </tr>
                    </table>
                    <input type="submit" value="전송">
                </form>
            </div>
        </body>

        </html>