layui.use(['layer', 'laypage'], function () {
    var layer = layui.layer,
        laypage = layui.laypage;

    var app = new Vue({
        el: '#layui',
        data: {
            processList: [],
        },
        created: function () {
            this.getProcessList(0)
        },
        methods: {
            getProcessList: function (flag) {
                var flag=flag;
                $.ajax({
                    type: 'GET',
                    url: '/get/processList',
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
                        app.processList = res.data
                    }
                })
            }
        }
    })
});
