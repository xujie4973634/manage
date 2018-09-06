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
    <style>

    </style>
<body>

        <div class="tabs">
            <div class="hd">
                <ul style="">
                    <li style="box-sizing: initial;-webkit-box-sizing: initial;" class="on">查看客户</li>
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
                        </div>
                        <!--分页显示角色信息 end-->
                    </li>
                </ul>
            </div>
        </div>

</body>
<script src="${ctx!}/web-static/js/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="${ctx!}/web-static/lib/jquery.pagination.js"></script>
<script>
   $(function () {

       var type = {
           pageNo: 1,
           pageSize: 5,
           init: function () {
               this.search();
           },

           initPagination:function (total) {
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

           search:function () {
               $.ajax({
                   url: "${ctx!}/client/ajax/win",
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
                           html += "<td>" + e.demand+ "</td>";
                           html += "<td>" + "已成功" + "</td>";
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
       }
          type.init()
   });

</script>


</html>