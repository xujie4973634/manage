;(function ($, window, undefined) {
    window.jhPlugins = {
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
            $.ajax({
                type: defaults.type,
                url: defaults.url,
                dataType: defaults.dataType,
                data: defaults.data,
                async: defaults.async,
                success: defaults.success
            });
        },
        stopPropagation: function (e) {
            e = e || window.event;
            if (e.stopPropagation) {
                e.stopPropagation();
            } else {
                e.cancelBubble = true;
            }
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
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.open(defaults);
            });
        },
        tips: function (content) {
            //layer.js封装的tip提示框
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.msg(content);
            });
        },
        closeAll: function () {
            //layer.js封装的tip提示框
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.closeAll();
            });
        },

        close: function () {
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
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
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.confirm(defaults.content, {
                    btn: defaults.btn//按钮
                }, function () {
                    defaults.success();
                }, function () {
                    defaults.cancel();
                });
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
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.open(defaults);
            });
        }
    };

    $.fn.renderTpl = function (data, success) {
        layui.use('laytpl', function () {
            var laytpl = layui.laytpl;
            laytpl(this.html()).render(data, function (html) {
                if (success) {
                    success(html);
                }
            });
        });
    };

    $.fn.renderTime = function () {

    };
});