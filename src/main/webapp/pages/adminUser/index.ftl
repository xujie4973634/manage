<#assign ctx=request.contextPath/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <title>@ViewBag.Title</title>
    <link href="${ctx!}/web-static/css/Site.css" rel="stylesheet" type="text/css" />
    <link href="${ctx!}/web-static/css/zy.layout.css" rel="stylesheet" />
    <link href="${ctx!}/web-static/css/zy.form.css" rel="stylesheet" />
    <link href="${ctx!}/web-static/css/font-awesome.min.css" rel="stylesheet" />
    <style type="text/css">
        .headerlitooleulsubitem_gray>li,
        .headerlitooleulsubitem_red>li {
            height: 45px;
            background-color: White;
            padding: 0px 10px;
            border-bottom: 1px solid #E4ECF3;
            font-size: 14px;
            line-height: 26px;
        }

        .headerlitooleulsubitem_gray>li:hover {
            background-Color: #F4F9FC;
        }

        .headerlitooleulsubitem_red>li:hover {
            background-color: #FCF4F9;
        }

        .ulsubitemitems>li {
            float: left;
            height: 20px;
            font-size: 13px;
            font-weight: normal !important;
            color: #555 !important;
        }

        .ulsubitemitems>li:last-child {
            clear: both;
            width: 100%;
            height: 10px;
            margin-top: 8px;
            background-color: #DADADA;
        }

        .headerlitools_info {
            background-color: #0a318d;
            height: 45px;
            padding: 0px 10px;
            width: 135px;
        }

        .headeruserface {
            background-image: url('${ctx!}/images/logo.png');
            width: 40px;
            height: 40px;
            background-color: white;
            margin: 2px 10px 2px 2px;
            border-radius: 20px;
            float: left;
        }


        .headerlitools_ulinfo>li {
            height: 35px;
            background-color: White;
            padding: 0px 10px;
            font-size: 14px;
            line-height: 36px;
        }

        .headerlitools_ulinfo>li:hover {
            background-Color: #FEE188;
        }

        .dvcontent {
            padding: 0px 20px;
            margin: 45px auto 0px auto;
            overflow: auto;
        }

        .dvpagerecord:hover i {
            text-decoration: underline;
        }

        .ulpageRecord li {
            margin: 0px;
            padding: 6px 12px;
            background-color: #EAEFF2;
            color: #2283C5;
            display: inline-block;
            font-size: 14px;
            border: 1px solid #D9D9D9;
        }

        .ulpageRecord li:hover {
            text-decoration: underline;
            cursor: pointer;
        }

        #warn tr {
            width: 300px;
            height: 20px;
        }

        #warn tr td {
            width: 90px;
            height: 20px;
            text-align: center;
        }

        iframe {
            border: none;
        }
    </style>
    <link href="${ctx!}/web-static/css/zy.menu.css" rel="stylesheet" />
</head>

<body>
<div class="dvheader">
    <div class="dvheadertools">
        <span class="headerspantitle">禾麦用户管理系统</span>
        <ul class="headerultools">

            <li class="headerlitools_info headerlitools" style="background-color: #075597">
                <div class="headeruserface" style="text-align: center;"><i class="icon-user" style="color: black;font-size: 19px;"></i></div>
      <#if Session??>
          ${Session.sessionUser.loginName!}
      <#else >
                  <a href="/login/loginPage" style="color: #f9f9f9">登录</a>
      </#if>
            </li>
        </ul>
    </div>
</div>
<div class="dvcontent">

    <ul class="ulleftmenu" style="border-right: 1px solid #ddd;">

        <li class="limenuitem">
            <i class="icon-cog menuicon"></i>用户菜单<b class="arrow icon-angle-down arrow-down"></b>
            <ul class="ulleftsubitems">
                <a href="${ctx!}/client/type" target="right">
                    <li>跟进中客户</li>
                </a>
                <a href="${ctx!}/client/nStart" target="right">
                    <li>未启动客户</li>
                </a>
                <a href="${ctx!}/client/win" target="right">
                    <li>已成功客户</li>
                </a>
                <a href="${ctx!}/client/failed" target="right">
                    <li>已放弃客户</li>
                </a>
                <a href="${ctx!}/user/updatePwd" target="right"><li >修改密码</li></a>
                <a href="#" onclick="loginOut()" target="_top"><li>退出登录</li></a>
            </ul>
        </li>
    </ul>
    <div style="position: absolute; left: 191px; right: 20px; ">
        <iframe src="${ctx!}/client/type" scrolling="no"  width="100%" height="1200" name="right" border="none"></iframe>
    </div>
</div>
<script src="${ctx!}/web-static/js/jquery-1.7.2.min.js"></script>
<script src="${ctx!}/web-static/js/plugins/distpicker/Jqueryplugs.js" ></script>
<script src="${ctx!}/web-static/js/_layout.js"></script>
<script>
    function loginOut() {
        top.location.href="${ctx!}/login/logout";
    }
</script>


</body>

</html>