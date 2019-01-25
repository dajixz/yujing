layui.use(['form', 'layer', 'laydate','layedit'], function () {
    $ = layui.jquery;
    var form = layui.form;
    var laydate = layui.laydate;
    var layer = layui.layer;
    var layedit = layui.layedit;
    layedit.set({
        uploadImage: {
            url: '/upload' //接口url
            ,type: 'POST' //默认post
        }
    })
    var text = layedit.build('text');
    laydate.render({
        elem: "#date"
    });

    //监听提交
    form.on('submit(add)', function (res) {
        res.field.date = new Date(res.field.date)
        res.field.stage =layedit.getText(text)
        res.field.text = layedit.getContent(text)
        // 发异步，把数据提交
        $.ajax({
            type: 'POST',
            url: '/news/addNews',
            data: res.field,
            async: true,
            success: function (res) {
                if(res.code==200){
                    layer.alert(res.msg, {icon: 6}, function () {
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        parent.layer.close(index);
                        window.parent.location.reload();
                    });
                }else if(res.code==403){
                    layer.msg(res.msg);
                    return;
                }
            }
        })
        return false;
    });
});