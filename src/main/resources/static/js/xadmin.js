$(function () {
    //加载弹出层
    layui.use(['form','element'],
        function() {
            layer = layui.layer;
            element = layui.element;
        });

    //触发事件
    var tab = {
        tabAdd: function(title,url,id){
            //新增一个Tab项
            element.tabAdd('xbs_tab', {
                title: title
                ,content: '<iframe tab-id="'+id+'" frameborder="0" src="'+url+'" scrolling="yes" class="x-iframe"></iframe>'
                ,id: id
            })
        }
        ,tabDelete: function(othis){
            //删除指定Tab项
            element.tabDelete('xbs_tab', '44'); //删除：“商品管理”


            othis.addClass('layui-btn-disabled');
        }
        ,tabChange: function(id){
            //切换到指定Tab项
            element.tabChange('xbs_tab', id); //切换到：用户管理
        }
    };


    tableCheck = {
        init:function  () {
            $(".layui-form-checkbox").click(function(event) {
                if($(this).hasClass('layui-form-checked')){
                    $(this).removeClass('layui-form-checked');
                    if($(this).hasClass('header')){
                        $(".layui-form-checkbox").removeClass('layui-form-checked');
                    }
                }else{
                    $(this).addClass('layui-form-checked');
                    console.log("+++++++++")
                    if($(this).hasClass('header')){
                        $(".layui-form-checkbox").addClass('layui-form-checked');
                    }
                }

            });
        },
        getData:function  () {
            var obj = $(".layui-form-checked").not('.header');
            var arr=[];
            obj.each(function(index, el) {
                arr.push(obj.eq(index).attr('data-id'));
            });
            return arr;
        }
    }

    //开启表格多选
    tableCheck.init();


    $('.container .left_open i').click(function(event) {
        if($('.left-nav').css('left')=='0px'){
            $('.left-nav').animate({left: '-171px'}, 100);
            $('.page-content').animate({left: '0px'}, 100);
            $('.page-content-bg').hide();
        }else{
            $('.left-nav').animate({left: '0px'}, 100);
            $('.page-content').animate({left: '171px'}, 100);
            if($(window).width()<768){
                $('.page-content-bg').show();
            }
        }

    });

    $('.page-content-bg').click(function(event) {
        $('.left-nav').animate({left: '-171px'}, 100);
        $('.page-content').animate({left: '0px'}, 100);
        $(this).hide();
    });

    $('.layui-tab-close').click(function(event) {
        $('.layui-tab-title li').eq(0).find('i').remove();
    });

    $("tbody.x-cate tr[fid!='0']").hide();
    // 栏目多级显示效果
    $('.x-show').click(function () {
        if($(this).attr('status')=='true'){
            $(this).html('&#xe625;');
            $(this).attr('status','false');
            cateId = $(this).parents('tr').attr('cate-id');
            $("tbody tr[fid="+cateId+"]").show();
        }else{
            cateIds = [];
            $(this).html('&#xe623;');
            $(this).attr('status','true');
            cateId = $(this).parents('tr').attr('cate-id');
            getCateId(cateId);
            for (var i in cateIds) {
                $("tbody tr[cate-id="+cateIds[i]+"]").hide().find('.x-show').html('&#xe623;').attr('status','true');
            }
        }
    })

    //左侧菜单效果
    // $('#content').bind("click",function(event){
    $('.left-nav #nav li').click(function (event) {

        if($(this).children('.sub-menu').length){
            if($(this).hasClass('open')){
                $(this).removeClass('open');
                $(this).find('.nav_right').html('&#xe697;');
                $(this).children('.sub-menu').stop().slideUp();
                $(this).siblings().children('.sub-menu').slideUp();
            }else{
                $(this).addClass('open');
                $(this).children('a').find('.nav_right').html('&#xe6a6;');
                $(this).children('.sub-menu').stop().slideDown();
                $(this).siblings().children('.sub-menu').stop().slideUp();
                $(this).siblings().find('.nav_right').html('&#xe697;');
                $(this).siblings().removeClass('open');
            }
        }else{

            var url = $(this).children('a').attr('_href');
            var title = $(this).find('cite').html();
            var index  = $('.left-nav #nav li').index($(this));
            for (var i = 0; i <$('.x-iframe').length; i++) {
                if($('.x-iframe').eq(i).attr('tab-id')==index+1){
                    tab.tabChange(index+1);
                    event.stopPropagation();
                    return;
                }
            };

            tab.tabAdd(title,url,index+1);
            tab.tabChange(index+1);
        }

        event.stopPropagation();

    })

})
function toDel(url, obj) {
    if (obj != null) {
        var id = $(obj).attr("lay-id");
    }
    layer.open({
        content: "确认删除",
        btn: ['确定', '取消'],
        yes: function () {
            $.ajax({
                type: 'delete',
                url: url,
                dataType: 'json',
                data: {
                    id: id
                },
                async: true,
                success: function (res) {
                    if (res.code == 200) {
                        layer.alert(res.msg, {icon: 6});
                        window.location.reload();
                    }else if(res.code=403){
                        layer.msg(res.msg)
                    }
                }
            })
        },
        btn2: function () {
        }
    })
}
function toOpen(url, obj) {
    if (obj != null) {
        var id = $(obj).attr("lay-id");
        var state =$(obj).attr("lay-data");
        if(state ==null){
            state=false;
        }
    }
    layer.open({
        content: "确认改变状态",
        btn: ['确定', '取消'],
        yes: function () {
            $.ajax({
                type: 'PUT',
                url: url,
                dataType: 'json',
                data: {
                    id: id,
                    state:state
                },
                async: true,
                success: function (res) {
                    if (res.code == 200) {
                        layer.alert(res.msg, {icon: 6});
                        window.location.reload();
                    }else if(res.code=403){
                        layer.msg(res.msg)
                    }
                }
            })
        },
        btn2: function () {
        }
    })
}
function toShow(url, obj) {
    var id = $(obj).attr("lay-id");
    parent.layer.idnum=id;
    parent.layer.open({
        type: 2,
        area: ['100%', '100%'],
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
        shade: 0.4,
        title: '详情信息',
        content: url,
    });
}

function getCaseTypeList(form,flag) {
    $.ajax({
        type: 'GET',
        url: '/get/caseTypeList',
        data:{
            flag:flag
        },
        async: true,
        success: function (res) {
            if (res.code == 200) {
                for (var index in res.data){
                    var body="<option value=\""+res.data[index].id+"\">"+res.data[index].type_name+"</option>"
                    $("#type").append(body);
                }
                form.render();
            }
        }
    })
}
function getProductTypeList(form, flag) {
    $.ajax({
        type: 'GET',
        url: '/get/productTypeList',
        data: {
            flag: flag
        },
        async: true,
        success: function (res) {
            if (res.code == 200) {
                for (var index in res.data) {
                    var body = "<option value=\"" + res.data[index].id + "\">" + res.data[index].typeName + "</option>"
                    $("#type").append(body);
                }
                form.render();
            }
        }
    })
}
/*弹出层*/
/*
    参数解释：
    title   标题
    url     请求的url
    id      需要操作的数据id
    w       弹出层宽度（缺省调默认值）
    h       弹出层高度（缺省调默认值）
*/
function x_admin_show(title,url,w,h,obj){
    if (title == null || title == '') {
        title=false;
    };
    if (url == null || url == '') {
        url="404.html";
    };
    if (w == null || w == '') {
        w=($(window).width()*0.9);
    };
    if (h == null || h == '') {
        h=($(window).height() - 50);
    };
    if(obj!=null){

    };
    layer.open({
        type: 2,
        area: ['100%', '100%'],
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
        shade:0.4,
        title: title,
        content: url
    });
}

/*关闭弹出框口*/
function x_admin_close(){
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}
