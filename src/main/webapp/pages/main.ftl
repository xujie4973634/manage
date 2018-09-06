<#assign ctx=request.contextPath/>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="${ctx!}/web-static/css/Site.css" />
    <link rel="stylesheet" href="${ctx!}/web-static/css/zy.all.css" />
    <link rel="stylesheet" href="${ctx!}/web-static/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${ctx!}/web-static/css/amazeui.min.css" />
    <link rel="stylesheet" href="${ctx!}/web-static/css/admin.css" />
</head>
<body>
<div style="color: midnightblue">
<h1 style="color: #0a318d">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;禾麦员工加班绩效</h1>
<div id="window-header">
    <span class="headerspantitle">禾麦用户管理系统</span>

<form method="POST"  enctype="multipart/form-data" id="form1" action="${ctx!}/uploadExcel/upload">
    <table class="table" id="tbRecord">
        <tr>
            <td>小燕子</td>
            <td>禾麦信息有限公司</td>
            <td>${aa!}</td>
        </tr>
        <tr>
            <td>小娟子</td>
            <td>禾麦信息有限公司</td>
            <td>${juan!}</td>
        </tr>
        <tr>
            <td>小瓶子</td>
            <td>禾麦信息有限公司</td>
            <td>${ping!}</td>
        </tr>
        <tr>
            <td>杰</td>
            <td>禾麦信息有限公司</td>
            <td>${jie!}</td>
        </tr>
        <tr>
            <td>上传文件:</td>
            <td><input id="upfile" type="file" name="upfile" ></td>
            <td><input type="button" value="上传表格" id="btn" name="btn"   class="am-btn am-btn-success"></td>
        </tr>
    </table>
</form>
</div>
</div>
<script src="${ctx!}/web-static/js/jquery-1.7.2.min.js" ></script>
<script src="${ctx!}/web-static/js/jquery.form.js" ></script>
<script>
    //ajax 方式上传文件操作
    $(document).ready(function(){
        $('#btn').click(function(){
            if(checkData()){
                $('#form1').ajaxSubmit({
                    url:'uploadExcel/ajaxUpload',
                    dataType: 'text',
                    success: resutlMsg,
                    error: errorMsg
                });
                function resutlMsg(msg){
                    alert(msg);
                    $("#upfile").val("");
                }
                function errorMsg(){
                    alert("导入excel出错！");
                }
            }
        });
    });

    //JS校验form表单信息
    function checkData(){
        var fileDir = $("#upfile").val();
        var suffix = fileDir.substr(fileDir.lastIndexOf("."));
        if("" == fileDir){
            alert("选择需要导入的Excel文件！");
            return false;
        }
        if(".xls" != suffix && ".xlsx" != suffix ){
            alert("选择Excel格式的文件导入！");
            return false;
        }
        return true;
    }
</script>

</body>
</html>