

layui.use(['form', 'layer','upload'], function () {
    $ = layui.jquery;
    var form = layui.form,layer = layui.layer,upload=layui.upload;
    getCaseTypeList(form,0);
    form.on('radio(on)',function (res) {
        $("#type").html("<option value=\"\"></option>");
        getCaseTypeList(form,res.value);
    })
    var upload = upload.render({
        elem: '#upload'
        , url: '/upload'
        ,acceptMime:'image/*'
        , multiple: true
        , done: function (res, index, upload) {
            if (res.code == 0) {//上传成功
                $('#div').append("<img style='height:120px;width: 120px' src=\"" + res.data.src + "\" >")
                $('#form').append("<input hidden name='imgList[]' value='"+res.data.src+"'>");
            }
        } //code为后台传回来的数据，具体多少自己定，
        //后台只能传回json格式数据，不然会走error函数；
        , error: function (index, upload) {
            console.log("index:" + index)
            console.log("upload:" + upload)
        }
    });
    //监听提交
    form.on('submit(add)', function (res) {

        $.ajax({
            type: 'POST',
            url: '/case/addCaseKind',
            data: res.field,
            async: true,
            success: function (res) {
                if (res.code == 200) {
                    layer.alert(res.msg, {icon: 6}, function () {
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        parent.layer.close(index);
                        window.parent.location.reload();
                    });
                } else if (res.code == 403) {
                    layer.msg(res.msg);
                    return;
                }
            }
        })
        return false;
    });
});