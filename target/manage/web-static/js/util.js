/**
 * Created by Administrator on 2017/6/18.
 * 常用工具类
 */

(function ($) {
    $.fn.serializeJson = function () {
        var serializeObj = {};
        var array = this.serializeArray();
        var str = this.serialize();
        $(array).each(function () {
            if (serializeObj[this.name]) {
                if ($.isArray(serializeObj[this.name])) {
                    serializeObj[this.name].push(this.value);
                } else {
                    serializeObj[this.name] = [serializeObj[this.name], this.value];
                }
            } else {
                serializeObj[this.name] = this.value;
            }
        });
        return serializeObj;
    };
})(jQuery);

var util = {
    pageSize: 10,
    ajaxRequest: function (setting) {
        var defaults = {
            url: '',
            data: '',
            type: 'post',
            success: function (data) {
            },
            async: true,
            dataType: 'json'
        };

        $.extend(defaults, setting);
        if (defaults.isLoading) {
            util.showLoading();
        }
        $.ajax({
            type: defaults.type,
            url: defaults.url,
            dataType: defaults.dataType,
            data: defaults.data,
            async: defaults.async,
            success: defaults.success,
            complete: function () {
                util.hideLoadding();
            }
        });
    },
    table: function (setting) {
        var defaults = {
            url: '',
            elem: '',
            height: 650,
            limit: 20,
            cols: [],
            page: true,
            method: 'post',
            where: {},
            request: {
                limitName: 'pageSize' //每页数据量的参数名，默认：limit
            },
            response: {
                countName: 'total' //数据总数的字段名称，默认：count
                , dataName: 'rows' //数据列表的字段名称，默认：data
                , statusName: 'status' //数据状态的字段名称，默认：code
                , statusCode: 200 //成功的状态码，默认：0
            }
        };

        $.extend(defaults, setting);
        layui.table.render({
            elem: defaults.elem,
            height: defaults.height,
            url: defaults.url,
            page: defaults.page,
            limit: defaults.limit,
            where: defaults.where,
            method: defaults.method,
            request: defaults.request,
            response: defaults.response,
            limits: [10, 20, 50, 100],
            cols: setting.cols,
            id:defaults.id
        });
    },

    alert: function (setting) {
        //layer.js封装的tip提示框
        var defaults = {
            type: 0
            , closeBtn: 1
            , title: ''
            , content: ''
            , area: ['420px']
            , resize: false
            , scrollbar: false
            , move: '.layui-layer-title'
            , shade: [0.3, '#000']
            , yes: function (index) {
                //确认按钮回调函数
                layer.close(index);
            }
        };

        $.extend(defaults, setting);
        layui.layer.open(defaults);
    },

    confirm: function (setting) {
        //确认按钮在左，取消按钮在右(confirm-Layer)
        var defaults = {
            btn: ['确认', '取消'],
            content: '',
            success: function () {

            },
            cancel: function () {

            }
        };

        $.extend(defaults, setting);
        layui.layer.confirm(defaults.content, {
            btn: defaults.btn//按钮
        }, function () {
            defaults.success();
        }, function () {
            defaults.cancel();
        });
    },

    selectorDialog: function (setting) {
        var defaults = {
            type: 2,
            title: false,
            closeBtn: 1, //不显示关闭按钮
            shade: 0.3,
            area: ['900px', '565px'],
            //offset: '30px', //右下角弹出
            time: 0, //2秒后自动关闭
            anim: 2,
            resize: false,
            shadeClose: false,
            scrollbar: false,
            move: '.layui-layer-title',
            content: [], //iframe的url，no代表不显示滚动条
            end: function () {
            },
            success: function () {

            }
        };

        $.extend(defaults, setting);
        layui.layer.open(defaults);
    },

    initPagination: function (total, jump) {
        layui.laypage.render({
            elem: 'pagination',
            count: total,
            limit: util.pageSize,
            jump: function (e, first) {
                if (!first) {
                    jump(e.curr);
                }
            }
        });
    },
    uploadFile: function (setting) {
        var defaults = {
            elem: '#uploadBtn',
            url: urls.common.upload,
            accept: '',
            success: function (res) {
            }
        };

        $.extend(defaults, setting);
        //普通图片上传
        layui.upload.render({
            elem: defaults.elem,
            url: defaults.url,
            accept: defaults.accept,
            done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    util.alert({
                        content: '上传失败，请重新上传'
                    });

                    return false;
                }

                if (defaults.success) {
                    defaults.success(res.url);
                }
            }
        });
    },

    renderTpl: function (elem, data, success) {
        var gettpl = document.getElementById(elem).innerHTML;
        layui.laytpl(gettpl).render(data, function (html) {
            if (success) {
                success(html);
            }
        });
    },
    showLoading: function () {
        var loadDiv = '<div class="sys-loading">' +
            '<div class="loading-box"></div>\n' +
            '</div>';
        if (!$(".sys-loading").length) {
            $("body").append(loadDiv);
        }
    },
    hideLoadding: function () {
        $(".sys-loading").remove();
    }
};
