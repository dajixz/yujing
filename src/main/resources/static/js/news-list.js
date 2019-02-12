layui.use(['layer', 'laypage'], function () {
    var layer = layui.layer,
        laypage = layui.laypage;

    var app = new Vue({
        el: '#layui',
        data: {
            newsList: [],
            totalElements: ''
        },
        created: function () {
            this.getNewsList(1,3,0)
        },
        methods: {
            getNewsList: function (page,size,flag) {
                $.ajax({
                    type: 'GET',
                    url: '/news/getNewsList',
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
                        app.newsList = res.content
                        for(var i=0;i<app.newsList.length;i++){
                            if(app.newsList[i].type==1){
                                app.newsList[i].type='公司新闻'
                            }else if(app.newsList[i].type==2){
                                app.newsList[i].type='行业新闻'
                            }else if(app.newsList[i].type==3){
                                app.newsList[i].type='客户反响'
                            }
                        }
                        app.totalElements = res.totalElements
                        laypage.render({
                            elem: 'laypage',
                            count: res.totalElements,//数据总数，从服务端得到
                            curr: res.number + 1,
                            limit: res.size,
                            jump: function (obj, first) {
                                if (!first) {
                                    app.getNewsList(obj.curr,size,flag)
                                }
                            }
                        });
                    }
                })
            },
            getNewsListByType: function (page,size,flag,type) {
                $.ajax({
                    type: 'GET',
                    url: '/get/newsList',
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
                        app.newsList = res.content
                        for(var i=0;i<app.newsList.length;i++){
                            if(app.newsList[i].type==1){
                                app.newsList[i].type='公司新闻'
                            }else if(app.newsList[i].type==2){
                                app.newsList[i].type='行业新闻'
                            }else if(app.newsList[i].type==3){
                                app.newsList[i].type='客户反响'
                            }
                        }
                        app.totalElements = res.totalElements
                        laypage.render({
                            elem: 'laypage',
                            count: res.totalElements,//数据总数，从服务端得到
                            curr: res.number + 1,
                            limit: res.size,
                            jump: function (obj, first) {
                                if (!first) {
                                    app.getNewsListByType(obj.curr,size,flag,type)
                                }
                            }
                        });
                    }
                })
            }
        }
    })
})
