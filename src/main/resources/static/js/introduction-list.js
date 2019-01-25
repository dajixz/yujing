layui.use(['layer', 'laypage'], function () {
    var layer = layui.layer,
        laypage = layui.laypage;

    var app = new Vue({
        el: '#layui',
        data: {
            introductionList: [],
        },
        created: function () {
            this.getIntroductionList(0)
        },
        methods: {
            getIntroductionList: function (flag) {
                var flag=flag;
                $.ajax({
                    type: 'GET',
                    url: '/introduction/getIntroductionList',
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
                        app.introductionList = res.data
                    }
                })
            }
        }
    })
})
