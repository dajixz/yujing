layui.use(['layer','form', 'laypage'], function () {
    var layer = layui.layer,
    laypage = layui.laypage;
    form=layui.form;
    getCaseTypeList(form,0);
    form.on('select(on)',function (res) {
        var type = res.value;
        if(type!=""){
            app.geCaseListByType(1,6,0,type)
        }
    })
    var app = new Vue({
        el: '#layui',
        data: {
            caseKindList: [],
            totalElements: ''
        },
        created: function () {
            this.getCaseKindList(1,6,0)
        },
        methods: {
            geCaseListByType: function (page,size,flag,type) {
                $.ajax({
                    type: 'GET',
                    url: '/get/caseKindList',
                    dataType: 'json',
                    data: {
                        page: page,
                        size:size,
                        flag:flag,
                        type:type
                    },
                    async: true,
                    success: function (res) {
                        if (res.code == 403) {
                            layer.msg(res.msg)
                            return;
                        }
                        app.caseKindList = res.content
                        app.totalElements = res.totalElements
                        laypage.render({
                            elem: 'laypage',
                            count: res.totalElements,//数据总数，从服务端得到
                            curr: res.number + 1,
                            limit: res.size,
                            jump: function (obj, first) {
                                if (!first) {
                                    app.getProductListByType(obj.curr,size,flag,type)
                                }
                            }
                        });
                    }
                })
            },
            getCaseKindList: function (page,size,flag) {
                $.ajax({
                    type: 'GET',
                    url: '/case/getCaseKindList',
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
                        app.caseKindList = res.content
                        app.totalElements = res.totalElements
                        laypage.render({
                            elem: 'laypage',
                            count: res.totalElements,//数据总数，从服务端得到
                            curr: res.number + 1,
                            limit: res.size,
                            jump: function (obj, first) {
                                if (!first) {
                                    app.getCaseKindList(obj.curr,size,flag)
                                }
                            }
                        });
                    }
                })
            }
        }

    })
})
