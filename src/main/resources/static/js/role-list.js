layui.use(['layer'], function () {
    var layer = layui.layer;
    var app = new Vue({
        el: '#layui',
        data: {
            roleList: []
        },
        created: function () {
            this.getRoleList()
        },
        methods: {
            getRoleList: function () {
                $.ajax({
                    type: 'GET',
                    url: '/admin/getRoleList',
                    dataType: 'json',
                    async: true,
                    success: function (res) {
                        if (res.code == 403) {
                            layer.msg(res.msg)
                            return;
                        }
                        app.roleList = res.data;
                    }
                })
            }
        }
    })
});

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
        title: '编辑',
        content: url
    });
}