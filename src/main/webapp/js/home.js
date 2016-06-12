/**
 * Created by tan on 16/6/10.
 */
$(function(){
    $("#input_up").change(function(){
        if($("#img_info").find("li").length<8){
            var $imgPath = $(this).val();
            $.ajax({
                "type":"POST",
                "url":"",
                "data":{"imgPath":$imgPath},
                "dataType":"json",
                "beforeSend":function(){
                    var $strExtension = $imgPath.substr($imgPath.lastIndexOf('.') + 1);
                    if ($strExtension != 'jpg' && $strExtension != 'gif'
                        && $strExtension != 'png' && $strExtension != 'bmp') {
                        alert("请选择图片文件");
                        return false;
                    }
                },
                "success":function(data){
                    var data = $.parseJSON(data);
                    $("#img_info").append("<li><img src='"+data.src+"'></li>")
                }
            })
        }
    });
    $("#up").on('click',function(){
       $("#input_up").trigger('click');
   });
    $("#img_info").on('click','.delete',function(){
        $(this).parent().remove();
    });
    $("#img_info").on('mouseenter','li',function(){
        $(this).append("<div class='delete'>删除</div>");
        $(this).find(".delete").slideDown();
    });
    $("#img_info").on('mouseleave','li',function(){
        var $this = $(this);
        $(this).find(".delete").slideUp(function(){
            $this.find(".delete").remove();
        });
    });
    $("#publish_up").on('click', function(){
        var $words = $("#words");
        $.ajax({
            "type":"POST",
            "url":"",
            "data":{"Words":$words},
            "dataType":"json",
            "success":function(data){
                var data = $.parseJSON(data);

            }
        })
    })
});