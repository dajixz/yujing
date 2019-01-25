layui.use(['layer', 'laypage'], function () {
    var layer = layui.layer,
    laypage = layui.laypage;

    var app = new Vue({
        el: '#layui',
        data: {
            productList: [],
            totalElements: ''
        },
        created: function () {
            this.getProductList(1,9,0)
        },
        methods: {
            getProductList: function (page,size,flag) {
                $.ajax({
                    type: 'GET',
                    url: '/product/getProductList',
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
                        app.productList = res.data.content
                        app.totalElements = res.data.totalElements
                        laypage.render({
                            elem: 'laypage',
                            count: res.data.totalElements,//数据总数，从服务端得到
                            curr: res.data.number + 1,
                            limit: res.data.size,
                            jump: function (obj, first) {
                                if (!first) {
                                    app.getProductList(obj.curr,size,flag)
                                }
                            }
                        });
                    }
                })
            }
        }

    })
})