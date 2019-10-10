<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: iminghuang
  Date: 2019/9/19
  Time: 下午 03:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select</title>
</head>
<body>


<fieldset>
    <form action="SelectServlet" method="post">
        關鍵字: &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="enterKeyword" id="enterKeyword" value="Test123456">&nbsp;(作者、內文)<br><br>
        選擇日期: <input type="text" name="enterLowDate" id="enterLowDate" value="1990/1/1">
        ~ <input type="text" name="enterHighDate" id="enterHighDate" value="2019/10/10"><br><br>
        價格區間: <input type="text" name="enterLowPrice" id="enterLowPrice" value="0">
        ~ <input type="text" name="enterHighPrice" id="enterHighPrice" value="500"><br><br>
        語言:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="enterLanguage"id="enterLanguage" value="English"><br><br>
        <button name="search" id="search">search</button>
    </form>
</fieldset>
<br>

<script>

    var xhr = new XMLHttpRequest();
    xhr.open('post', 'http://localhost:8888/TSP_war_exploded/MainPage.jsp', 'true');
    xhr.send(null);
    xhr.onload = function () {
        console.log(xhr.responseText);
        if (xhr.status == 200){
            var str = JSON.parse(xhr.responseText);
            var information =  document.querySelector('.information').textContent = str[0].name;  /*???document.querySelector('要插入資料的 DOM .class 名稱').textContent = str[陣列編號].陣列屬性;*/
        }else {
            console.log("資料錯誤");
        }



    }


    // var xhr = new XMLHttpRequest();
    // xhr.open('get', 'https://ruienyuski.github.io/git_test/data.json', true);
    // xhr.send(null);
    // xhr.onload = function () {
    //     var datastr = JSON.parse(xhr.responseText);
    //     var info = document.querySelector('.info');
    //     var len = datastr.length;
    //     var str = "";
    //     var btn = document.querySelector('.btn');
    //     btn.onclick = function (e) {
    //         for (var i = 0; i < len; i++) {
    //             var content = '<p>' + '<li>名稱：' + datastr[i].place + '</li>' + '</p>' + '<p>' + '<li>地址：' + datastr[i].address + '</li>' + '</p>';
    //             console.log(content);
    //             str += content;
    //         };
    //         info.innerHTML += str;
    //     };
    // };
</script>
<fieldset>
    <%--    <button class="btn">顯示Query</button>--%>
    <%--    <ul class="info"></ul>--%>
</fieldset>

</body>
</html>
