layui.use(['layer', 'laypage'], function () {
    var layer = layui.layer,
        laypage = layui.laypage;

    var app = new Vue({
        el: '#layui',
        data: {
            problemList: [],
            totalElements: ''
        },
        created: function () {
            this.getProblemList(1,10,0)
        },
        methods: {
            getProblemList: function (page,size,flag) {
                $.ajax({
                    type: 'GET',
                    url: '/get/problemList',
                    dataType: 'json',
                    data: {
                        page: page,
                        size:size,
                        flag:flag
                    },
                    async: true,
                    success: function (res) {
                        if (res.code == 403) {
                            layer.msg(res.msg)
                            return;
                        }
                        app.problemList = res.content
                        app.totalElements = res.totalElements
                        laypage.render({
                            elem: 'laypage',
                            count: res.totalElements,//数据总数，从服务端得到
                            curr: res.number + 1,
                            limit: res.size,
                            jump: function (obj, first) {
                                if (!first) {
                                    app.problemList(obj.curr,size,flag)
                                }
                            }
                        });
                    }
                })
            }
        }
    })
});
