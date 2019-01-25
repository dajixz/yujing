layui.use(['layer', 'form', 'upload'], function () {
    var layer = layui.layer, form = layui.form, upload = layui.upload;
    getProductTypeList(form,0);
    form.on('radio(on)',function (res) {
        $("#type").html("<option value=\"\"></option>");
        getProductTypeList(form,res.value);
    })
    var img="";
    var up = upload.render({
        elem: '#up'
        , url: '/upload'
        , multiple: true
        , done: function (res, index, upload) {
            if (res.code == 0) {//上传成功
                $('#div1').append("<img style='height:120px;width: 120px' src=\"" + res.data.src + "\" >")
                $('#form').append("<input hidden name='imgList[]' value='"+res.data.src+"'>");
            }
        } //code为后台传回来的数据，具体多少自己定，
        //后台只能传回json格式数据，不然会走error函数；
        , error: function (index, upload) {
            console.log("index:" + index)
            console.log("upload:" + upload)
        }
    });
    var upload = upload.render({
        elem: '#upload'
        , url: '/upload'
        , done: function (res, index, upload) {
            if (res.code == 0) {//上传成功
                $('#div').html("<img style='height: 120px;width: 120px' src=\"" + res.data.src + "\" >");
                img = res.data.src
            }
        } //code为后台传回来的数据，具体多少自己定，
        //后台只能传回json格式数据，不然会走error函数；
        , error: function (index, upload) {
            console.log("index:" + index)
            console.log("upload:" + upload)
        }
    });
    form.on('submit(add)', function (res) {
        res.field.img=img;
        $.ajax({
            type: 'POST',
            url: '/product/addProduct',
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
        //发异步，把数据提交给php
        return false;
    });
})


