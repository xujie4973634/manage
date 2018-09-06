<#assign ctx=request.contextPath/>
<!DOCTYPE html>
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
    <link rel="stylesheet" href="${ctx!}/web-static/lib/pagination.css"/>
</head>

<body>
<div class="tabs">
    <div class="hd">
        <ul style="">
            <li style="box-sizing: initial;-webkit-box-sizing: initial;" class="on">历史记录</li>
        </ul>
    </div>

        <div class="bd">
            <ul style="display: block;padding: 20px;">
                <li>
                    <!--分页显示角色信息 start-->
                    <div id="dv1">
                        <input name="id" type="hidden" value="${id!}" id="put">
                        <table class="table" id="tbRecord">
                            <thead>
                            <tr>
                                <th>跟进时间</th>
                                <th>客户姓名</th>
                                <th>客户状态</th>
                                <th>跟进详情</th>
                            </tr>
                            </thead>
                            <tbody id="tbody">
                            </tbody>
                        </table>
                        <div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
                    </div>
</body>
<script src="${ctx!}/web-static/js/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="${ctx!}/web-static/lib/jquery.pagination.js"></script>
<script src="${ctx!}/web-static/js/moment-with-locales.js"></script>
<script>
    $(function () {
        var id = $("#put").val() ;
        function  judge(data) {
            if (data == "UNDERWAY") {
                return "跟进中";
            }
            if (data == "NOT_START") {
                return "未启动";
            }
            if (data == "WIN") {
                return "已完成";
            }
            if (data == "FAILED") {
                return "已放弃";
            }

            return data ;

        }



        var type={
            pageNo:1,
            pageSize:5,

            init:function () {
                this.search();
            },


            initPagination:function (total) {
                $("#Pagination").pagination(total,{
                    num_edge_entries: 1, //边缘页数
                    items_per_page: type.pageSize, //主体页数
                    current_page: (type.pageNo - 1),
                    callback:function (pageNo) {
                        if ((type.pageNo -1) === pageNo){
                            return false ;
                        }
                        type.pageNo = pageNo +1 ;
                        type.search() ;
                    },
                    prev_text: "前一页",
                    next_text: "后一页",
                });
            },

            search:function () {
                $.ajax({
                   url:"${ctx!}/details/ajax/history?id="+id,
                   data:{page:type.pageNo,pageSize:type.pageSize},
                   type:"post",
                   dataType:"json",
                    success:function (data) {
                        var html = "" ;
                        $.each(data.rows,function (i, e) {
                            e.createTime =  moment().format("YYYY-MM-DD");
                            e.clientStatus = judge(e.clientStatus) ;
                            html += "<tr>";
                            html += "<td>" + e.createTime; + "</td>" ;
                            html += "<td>" + e.clientName; + "</td>" ;
                            html += "<td>" + e.clientStatus; + "</td>" ;
                            html += "<td>" + e.clientDetails; + "</td>" ;
                            html += "</tr>";
                        });
                        $("#tbody").html(html);
                        type.initPagination(data.total) ;

                    }
                });
            }
        }
        return type.init() ;

    });
</script>

</html>