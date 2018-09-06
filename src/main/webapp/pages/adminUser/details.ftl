<#assign ctx=request.contextPath/>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" />
    <link rel="stylesheet" href="${ctx!}/web-static/css/Site.css" />
    <link rel="stylesheet" href="${ctx!}/web-static/css/zy.all.css" />
    <link rel="stylesheet" href="${ctx!}/web-static/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${ctx!}/web-static/css/amazeui.min.css" />
    <link rel="stylesheet" href="${ctx!}/web-static/css/admin.css" />
    <link rel="stylesheet" href="${ctx!}/web-static/css/type.css" />
    <link rel="stylesheet" href="${ctx!}/web-static/css/desc.css" />
    <link rel="stylesheet" href="${ctx!}/web-static/css/jquery.datepick.css" />
<body>

     <h2><input type="checkbox" id="box"><label for="box">编 辑</label></h2>
        <!--tab start-->
            <div id="show">
                <div class="tabs">
                    <div class="hd">
                        客户详情
                    </div>
                    <table class="tab">
                        <tr>
                            <td colspan="3">
                                客户姓名：${(clients.name)!}
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                客户电话：${(clients.phone)!}
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">客户公司：${(clients.company)!}</td>
                        </tr>
                        <tr>
                            <td colspan="3">客户来源：${(clients.source)!}</td>
                        </tr>
                        <tr>
                            <td colspan="3">客户需求：${(clients.demand)!}</td>
                        </tr>
                        <tr>
                            <td width="180" colspan="3">跟进时间：${(clients.createTime?string("yyyy-MM-dd"))!}</td>
                        </tr>
                        <tr>

                            <td width="180" colspan="3">客户状态：<#if clients.status == "NOT_START">未启动</#if>
                                                        <#if clients.status == "UNDERWAY">跟进中</#if>
                                                        <#if clients.status == "WIN">已完成</#if>
                                                        <#if clients.status == "FAILED">已放弃</#if></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td colspan="2">详情描述：${(clients.details)!}</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><a href="${ctx!}/details/history?id=${(clients.id)!}"> 查看历史信息</a></td>
                        </tr>
                    </table>
                </div>
            </div>

                            <div id='formDiv'>
                                <div class="sm">&nbsp;</div>
                                <form action="${ctx!}/client/update/client" method="post" id="form" >
                                    <div style="float:left;">
                                        <table class="tab">
                                            <tr>
                                                <td>
                                                    <input name="id" type="hidden" value="${(clients.id)!}">
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="3">
                                                    客户姓名： <input id="name" type="text" name="name" value="${(clients.name)!}" style="width:150px;"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="3">
                                                    客户电话： <input id="phone" type="text" name="phone" value="${(clients.phone)!}" style="width:150px;"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="3">客户公司： <input id="company" type="text" name="company" value="${(clients.company)!}" style="width:150px;"/></td>
                                            </tr>
                                            <tr> <td colspan="3">客户来源： <input id="source" type="text" name="source" value="${(clients.source)!}" style="width:150px;"/></td></tr>
                                            <tr> <td colspan="3">客户需求： <input id="demand" type="text" name="demand" value="${(clients.demand)!}" style="width:150px;"/></td></tr>
                                            <tr>
                                                <td width="250px">跟进时间： <input id="createTime" type="text" name="createTime" value="${.now?string("yyyy-MM-dd")}" style="width:150px;"/></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    客户状态： <select name="status" id="status" onchange="loadChildren()">
                                                    <option value="UNDERWAY" selected='selected'>跟进中</option>
                                                    <option value="NOT_START">未启动</option>
                                                    <option value="WIN">已完成</option>
                                                    <option value="FAILED">已放弃</option>
                                                </select>
                                                </td>
                                                <td></td>
                                            </tr>
                                            <br>
                                            <tr>
                                               <td>  详情描述： <textarea class="" rows="6" cols="50" id="details" name="details"
                                              placeholder="输入备注"></textarea></td>
                                            </tr>
                                      <td></td>
                                            <tr>
                                                <td colspan="2">
                                                    <input onclick="editForm()" type="button" id="editBtn" class="btn" value="保　　存">
                                                    <#--<input onclick="delForm()" type="button" name="method" id="delBtn" class="btn" value="删　　除">-->
                                                </td>
                                                <td></td>
                                            </tr>
                                        </table>
                                    </div>
                                </form>
                            </div>
    <script src="${ctx!}/web-static/js/jquery-1.5.1.js" ></script>
    <script src="${ctx!}/web-static/js/jquery-1.7.2.min.js" ></script>
    <script src="${ctx!}/web-static/js/plugins/distpicker/Jqueryplugs.js"></script>
    <script src="${ctx!}/web-static/js/_layout.js"></script>
    <script src="${ctx!}/web-static/js/plugins/distpicker/jquery.SuperSlide.source.js"></script>
    <script src="${ctx!}/web-static/js/jquery.datepick.js"></script>
    <script src="${ctx!}/web-static/js/desc.js"></script>
<script type="text/javascript">

    $(function() {
        $("#box").attr("checked", false);
        $("#formDiv").css("display", "none");
        $("#show").css("display", "");

        // 操作和显示切换
        $("#box").click(function() {
            if($(this).attr("checked")) {
                $("#show").css("display", "none");
                $("#formDiv").css("display", "");
            } else {
                $("#formDiv").css("display", "none");
                $("#show").css("display", "");
            }
        });
    });

</script>
</div>
</body>

</html>