<%@ page contentType="text/html;charset=UTF-8"  %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="css/xing.css" />
</head>
<body>
<div id="content" style="margin:0 auto; background-color:#0F6; width:1000px; height:500px; position:relative;">

<form action="/user/login.do" method="post">
    <div class="login" style="position:absolute; top:50%;left:50%;margin-top:-100px;margin-left:-200px;background:#69F; width:400px; height: 200px; border-radius:10px;">
        <div style=" margin-left:100px;margin-top:50px">
            <p style="display:inline">用户名:</p>
            <input type="text" placeholder="请输入帐号!" name="uname" />
        </div>
        <div style="margin-left:100px;margin-top:20px">
            <p style="display:inline">密&nbsp;码:</p>
            <input type="password" placeholder="请输入密码!" name="upwd" />
        </div>
        <div style=" text-align:center;margin-top:20px">
            <input class="button" type="submit" value="登录" style="margin-right:10px; padding:5px 15px; background:#F9C; border-radius:3px; border:#F0C 1px solid;"/>
            <input class="button" type="button" value="重置" style="padding:5px 15px; background:#F9C; border-radius:3px; border:#F0C 1px solid;"/>
        </div>
    </div>
</form>
</div>
</body>
</html>