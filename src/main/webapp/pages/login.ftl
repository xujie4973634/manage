<#assign ctx=request.contextPath/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Purple_loginform Website Template | Home :: w3layouts</title>
    <link rel="stylesheet" href="${ctx!}/web-static/css/style.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script>
        var pageContext = {
            ctx: '${ctx!}'
        }
    </script>
    <!-- -->
</head>
<body>
<!-- contact-form -->
<div class="message warning">
    <div class="inset">
        <div class="login-head">
            <h1>Login</h1>
            <div class="alert-close"> </div>
        </div>
        <form id="loginForm">
            <li>
                <input type="text" id="loginName" name="loginName"><a href="#" class=" icon user"></a>
            </li>
            <div class="clear"> </div>
            <li>
                <input type="password" id="loginPass" name="loginPass"> <a href="#" class="icon lock"></a>
            </li>
            <div class="clear">
                <label class="error" id="msg"></label>
            </div>
            <div class="submit">
                <input type="submit" id="submit" onclick="myFunction()" value="Sign in" >
                <div class="clear">  </div>
            </div>
        </form>
    </div>
</div>
</div>
<div class="clear"> </div>
<!--- footer --->
<div class="footer">
    <p>禾麦集团 &copy; 2018.</p>
</div>
<script src="${ctx!}/web-static/js/plugins/jquery.js"></script>
<script src="${ctx!}/web-static/js/plugins/layui/layui.js" charset="utf-8"></script>
<script src="${ctx!}/web-static/js/urls.js"></script>
<script src="${ctx!}/web-static/js/util.js"></script>
    <script>
        $(function () {
            $('.submit').on('click', function () {
                $('.error').html('');
                var userName = $('input[name="loginName"]').val(),
                        password = $('input[name="loginPass"]').val();
                if (!userName || !password) {
                    $('.error').html("用户名或者密码为空");
                    return false;
                }
                util.ajaxRequest({
                    url: urls.login.ajaxLogin,
                    data: $('#loginForm').serialize(),
                    success: function (data) {
                        if (data.success) {
                            location.href = urls.login.index;
                            return false;
                        }
                        $('.error').html(data.message);
                    }
                });
                return false ;
            });
            document.onkeydown = function (e) {
                var ev = document.all ? window.event : e;
                if (ev.keyCode === 13) {
                    $('.submit').trigger('click');
                }
            };
        });
    </script>
</body>
</html>