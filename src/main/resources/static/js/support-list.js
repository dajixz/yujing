layui.use(['layer', 'laypage'], function () {
    var layer = layui.layer,
        laypage = layui.laypage;

    var app = new Vue({
        el: '#layui',
        data: {
            supportList: [],
        },
        created: function () {
            this.getSupportList(0)
        },
        methods: {
            getSupportList: function (flag) {
                var flag=flag;
                $.ajax({
                    type: 'GET',
                    url: '/support/getSupportList',
                    dataType: 'json',
                    data: {
                        flag:flag
                    },
                    async: true,
                    success: function (res) {
                        if (res.code == 403) {
                            layer.msg(res.msg)
                            return;
                        }
                        app.supportList = res.data
                    }
                })
            }
        }
    })
})
