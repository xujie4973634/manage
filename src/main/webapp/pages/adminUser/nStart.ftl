<#assign ctx=request.contextPath/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link rel="stylesheet"/>
    <link rel="stylesheet" href="${ctx!}/web-static/css/Site.css"/>
    <link rel="stylesheet" href="${ctx!}/web-static/css/zy.all.css"/>
    <link rel="stylesheet" href="${ctx!}/web-static/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${ctx!}/web-static/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${ctx!}/web-static/css/admin.css"/>
    <link rel="stylesheet" href="${ctx!}/web-static/css/type.css"/>
    <link rel="stylesheet" href="${ctx!}/web-static/lib/pagination.css"/>
    <style>

    </style>
</head>
<body>
<div class="dvcontent">

    <div>
        <!--tab start-->
        <div class="tabs">
            <div class="hd">
                <ul style="">
                    <li style="box-sizing: initial;-webkit-box-sizing: initial;" class="on">查看客户</li>
                    <li class="" style="box-sizing: initial;-webkit-box-sizing: initial;">添加客户</li>
                </ul>
            </div>
            <div class="bd">
                <ul style="display: block;padding: 20px;">
                    <li>
                        <!--分页显示角色信息 start-->
                        <div id="dv1">
                            <table class="table" id="tbRecord">
                                <thead>
                                <tr>
                                    <th>客户姓名</th>
                                    <th>客户电话</th>
                                    <th>客户来源</th>
                                    <th>客户需求</th>
                                    <th>客户状态</th>
                                    <th>详情</th>
                                </tr>
                                </thead>
                                <tbody id="tbody">
                                </tbody>

                            </table>
                            <div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
                        </div>                        <!--分页显示角色信息 end-->
                    </li>
                </ul>
                <ul class="theme-popbod dform" style="display: none;">
                    <div class="am-cf admin-main" style="padding-top: 0px;">
                        <!-- content start -->

                        <div class="am-cf admin-main" style="padding-top: 0px;">
                            <!-- content start -->
                            <div class="admin-content">
                                <div class="admin-content-body">

                                    <div class="am-g">
                                        <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">

                                        </div>
                                        <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4"
                                             style="padding-top: 30px;">
                                            <form class="am-form am-form-horizontal" action="${ctx!}/client/save"
                                                  method="post" id="clientForm">

                                                <div class="am-form-group">
                                                    <label for="user-name" class="am-u-sm-3 am-form-label">
                                                        客户姓名</label>
                                                    <div class="am-u-sm-9">
                                                        <input type="text" id="user-name" required
                                                               placeholder="   " name="name">
                                                    </div>
                                                    <div class="am-form-group">
                                                        <label for="user-name" class="am-u-sm-3 am-form-label">
                                                            客户公司</label>
                                                        <div class="am-u-sm-9">
                                                            <input type="text" id="user-name" required
                                                                   placeholder="    " name="company">
                                                        </div>
                                                        <div class="am-form-group">
                                                            <label for="user-name" class="am-u-sm-3 am-form-label">
                                                                客户需求</label>
                                                            <div class="am-u-sm-9">
                                                                <input type="text" id="user-name" required
                                                                       placeholder="   " name="demand">
                                                            </div>
                                                            <div class="am-form-group">
                                                                <label for="user-name" class="am-u-sm-3 am-form-label">
                                                                    客户电话</label>
                                                                <div class="am-u-sm-9">
                                                                    <input type="text" id="user-name" required
                                                                           placeholder="   " name="phone">
                                                                </div>
                                                                <div class="am-form-group">
                                                                    <label for="user-name"
                                                                           class="am-u-sm-3 am-form-label">
                                                                        客户来源</label>
                                                                    <div class="am-u-sm-9">
                                                                        <input type="text" id="user-name" required
                                                                               placeholder="    " name="source">
                                                                    </div>

                                                                    <div class="am-form-group">
                                                                        <label for="user-name"
                                                                               class="am-u-sm-3 am-form-label">
                                                                            客户状态</label>
                                                                        <div class="am-u-sm-9">
                                                                            <select name="status">
                                                                                <option value="NOT_START">&nbsp;&nbsp;&nbsp;未启动</option>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                                    <div class="am-form-group">

                                                                        <label for="user-intro"
                                                                               class="am-u-sm-3 am-form-label">
                                                                            备注</label>
                                                                        <div class="am-u-sm-9">
									<textarea class="" rows="5" id="user-intro" name="details"
                                              placeholder="输入备注"></textarea>
                                                                            <small>250字以内...</small>
                                                                        </div>
                                                                    </div>
                                                                    <div class="am-form-group">
                                                                        <div class="am-u-sm-9 am-u-sm-push-3">
                                                                            <input type="submit"
                                                                                   class="am-btn am-btn-success"
                                                                                   value="添加客户"/>
                                                                        </div>
                                                                    </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <!-- content end -->
                        </div>
                        <!-- end-->
                </ul>
            </div>
        </div>
        <!--tab end-->

    </div>

    <script src="${ctx!}/web-static/js/jquery-1.7.2.min.js"></script>
    <script src="${ctx!}/web-static/js/plugins/distpicker/Jqueryplugs.js"></script>
    <script src="${ctx!}/web-static/js/_layout.js"></script>
    <script src="${ctx!}/web-static/js/plugins/distpicker/jquery.SuperSlide.source.js"></script>
    <script type="text/javascript" src="${ctx!}/web-static/lib/jquery.pagination.js"></script>
    <script>
        var num = 1;
        $(function() {

            $(".tabs").slide({ trigger: "click" });

        });

        $(function () {
            var type = {
                pageNo: 1,
                pageSize: 5,
                init: function () {
                    this.search();
                },
                initPagination: function (total) {
                    $("#Pagination").pagination(total, {
                        num_edge_entries: 1, //边缘页数
                        items_per_page: type.pageSize, //主体页数
                        current_page: (type.pageNo - 1),
                        callback: function (pageNo) {
                            if((type.pageNo -1) === pageNo){
                                return false;
                            }

                            type.pageNo = pageNo + 1;
                            type.search();
                        },
                        prev_text: "前一页",
                        next_text: "后一页"
                    });
                },
                search: function () {
                    $.ajax({
                        url: "${ctx!}/client/ajax/nStart",
                        data: {page: type.pageNo, pageSize: type.pageSize},
                        type: 'post',
                        dataType: 'json',
                        success: function (data) {
                            var html = "";
                            $.each(data.rows, function (i, e) {
                                html += '<tr>';
                                html += "<td>" + e.name + "</td>";
                                html += "<td>" + e.phone + "</td>";
                                html += "<td>" + e.source + "</td>";
                                html += "<td>" + e.demand + "</td>";
                                html += "<td>" + "未启动" + "</td>";
                                html += "<td>";
                                html += "<a href='${ctx!}/details/client?id=" + e.id + "'>" + "详情" + "</a>";
                                html += "</td>";
                                html += "</tr>";
                            });

                            $('#tbody').html(html);
                            type.initPagination(data.total);
                        }
                    });
                }
            };

            type.init();
        });

    </script>

</div>
</body>

</html>