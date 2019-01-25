layui.use(['layer','laypage'], function () {
    var layer = layui.layer,
        laypage = layui.laypage;
    var app = new Vue({
        el: '#layui',
        data: {
            userList: [],
            totalElements:''
        },
        created: function () {
            this.getUserList(1,5)
        },
        methods: {
            getUserList: function (page,size) {
                var page = page
                $.ajax({
                    type: 'GET',
                    url: '/user/getUserList',
                    dataType: 'json',
                    data: {
                        page: page,
                        size:size
                    },
                    async: true,
                    success: function (res) {
                        if (res.code == 403) {
                            layer.msg(res.msg)
                            return;
                        }
                        app.userList = res.content
                        app.totalElements =res.totalElements
                        laypage.render({
                            elem: 'laypage',
                            count: res.totalElements,
                            curr: res.number + 1,
                            limit: res.size,
                            jump: function (obj, first) {
                                if (!first) {
                                    app.getUserList(obj.curr,size)
                                }

                            }
                        });
                    }
                })
            }
        }
    })
})
function toEditShow(url,obj) {
    if(obj!=null){
        var id= $(obj).attr("lay-id");
        url+="/"+id;
    }
    layer.open({
        type: 2,
        area: ['100%', '100%'],
        fix: false,
        maxmin: true,
        shadeClose: true,
        shade:0.4,
        title: '编辑用户',
        content: url
    });
}
