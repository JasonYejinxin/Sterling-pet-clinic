<%--
  Created by IntelliJ IDEA.
  User: jinxinye
  Date: 2022-11-28
  Time: 8:51 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .owners{
            float:left;
            width:850px;
            background:url(../../static/images/owners.webp)no-repeat;
            height:830px;

        }
        .vets{
            margin-left:800px;
            background: url(../../static/images/vet.png)no-repeat;
            height:830px;
        }
        .botton1{
            position: absolute;
            top: 500px;
            left:400px;
        }
        .botton2{
            position: absolute;
            top: 500px;
            left:1250px;
        }
        .title1{
            position: absolute;
            top: 260px;
            left:260px;
            font-size: 50px;
            color: black;
        }
        .title2{
            position: absolute;
            top: 260px;
            left:1200px;
            font-size: 50px;
            color: black;

        }
    </style>
</head>
<div class="owners" >
    <div class="title1">
        <h1>Owner</h1>
    </div>
    <a class = "botton1" href="/ownerRegister"><button type="button">Go Now</button></a>
</div>
<div class="vets">
    <div class="title2">
        <h1>Vet</h1>
    </div>
    <a class = "botton2" href="/vetRegister"><button type="button">Go Now</button></a>
</div>
</body>
</html>
