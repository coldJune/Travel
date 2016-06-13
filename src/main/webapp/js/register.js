/**
 * Created by tan on 16/6/9.
 */
$(function(){
    var check = {
        "type": "POST",
        "url": "createCheckRegisteAction",
        "dataType": "json",
        "success": function (data) {
            var data = $.parseJSON(data);
            $("#checkcode").attr("src", data.src);
        }
    };
    $.ajax(check);//页面打开就加载一个验证码
    $("#checkcode").on('click',function(){
        $.ajax(check);
    });//点击验证码图标可以更换验证码
    $("#checkcode_input").on('blur',function(){
        var $checkcode = $(this).val();
        var $pass_length = $(this).siblings(".pass").length;
        var $error_length = $(this).siblings(".error").length;
        $.ajax({
            "type":"POST",
            "url":"checkCodeRegisteAction",
            "data":{"checkcode":$checkcode},
            "dataType":"json",
            "success":function(data){
                var data = $.parseJSON(data);
                if(data.status==2&&$pass_length==0){
                    $("#error_checkcode").remove();
                    $("#checkcode_input").after("<span class='pass' id='pass_checkcode'>√<span>");
                }
                else if(data.status==1&&$error_length==0){
                    $("#pass_checkcode").remove();
                    $("#checkcode_input").after("<span class='error' id='error_checkcode'>验证码错误<span>");
                }
            }
        })
    });//验证码输入框失去焦点检验验证码是否正确
    $("#username").on('blur',function(){
        var $username = $(this).val();
        var $pass_length = $(this).siblings(".pass").length;
        var $error_length = $(this).siblings(".error").length;
        $.ajax({
            "type":"POST",
            "url":"checkNameRegisteAction",
            "dataType":"json",
            "data":{"UserName":$username},
            "success":function(data){
                var data = $.parseJSON(data);
                if(data.status==2&&$pass_length==0){
                    $("#error_name").remove();
                    $("#username").after("<span class='pass' id='pass_name'>√<span>");
                }
                else if(data.status==1&&$error_length==0){
                    $("#pass_name").remove();
                    $("#username").after("<span class='error' id='error_name'>昵称已存在<span>");
                }
            }
        })
    });//用户名输入框失去焦点检验用户名是否合格
    $("#userpw_cf").on('blur',function(){
        var $this = $(this).val();
        var $that = $("#userpw").val();
        if($this==$that&&$("#pass_password").length==0){
           $("#error_password").remove();
           $(this).after("<span class='pass' id='pass_password'>√<span>");
        }
        else if($(this).val()!=$("#userpw").val()&&$("#error_password").length==0){
           $("#pass_password").remove();
           $(this).after("<span class='error' id='error_password'>密码不一致<span>");
        }
    });//检测密码是否一致
    $("#register_button").on('click',function(){
        if($(".error").length!=0){
            return false
        }
    });//若无error则可提交
});