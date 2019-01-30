layui.use(['layer', 'form', 'laypage'], function () {
    var layer = layui.layer,
        laypage = layui.laypage,
        form = layui.form;
    getProductTypeList(form, 0)
    form.on('select(on)', function (res) {
        var type = res.value;
        if (type != "") {
            app.getProductListByType(1, 9, 0, type)
        }

    })
    var app = new Vue({
        el: '#layui',
        data: {
            productList: [],
            totalElements: ''
        },
        created: function () {
            this.getProductList(1, 9, 0)
        },
        methods: {
            getProductList: function (page, size, flag) {
                $.ajax({
                    type: 'GET',
                    url: '/product/getProductList',
                    dataType: 'json',
                    data: {
                        page: page,
                        size: size,
                        flag: flag
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
                                    app.getProductList(obj.curr, size, flag)
                                }
                            }
                        });
                    }
                })
            },
            getProductListByType: function (page, size, flag, type) {
                $.ajax({
                    type: 'GET',
                    url: '/get/productList',
                    dataType: 'json',
                    data: {
                        page: page,
                        size: size,
                        flag: flag,
                        type: type
                    },
                    async: true,
                    success: function (res) {
                        if (res.code == 403) {
                            layer.msg(res.msg)
                            return;
                        }
                        var pageInfo = res.data.pageInfo;
                        app.productList = pageInfo.content
                        app.totalElements = pageInfo.totalElements
                        laypage.render({
                            elem: 'laypage',
                            count: pageInfo.totalElements,//数据总数，从服务端得到
                            curr: pageInfo.number + 1,
                            limit: pageInfo.size,
                            jump: function (obj, first) {
                                if (!first) {
                                    app.getProductListByType(obj.curr, size, flag, type)
                                }
                            }
                        });
                    }
                })
            }
        }

    })
})