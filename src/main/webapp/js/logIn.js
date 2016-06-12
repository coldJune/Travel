/**
 * Created by tan on 16/6/7.
 */
$(function(){
    $("#login_button").on('click',function(){
        var $username = $("#username").val();
        var $userpw = $("#userpw").val();
        if($username==""){
            $(".error").css("visibility","visible").text("请输入用户名");
        }
        else if($userpw==""){
            $(".error").css("visibility","visible").text("请输入密码");
        }
        else {
            $.ajax({
                "type":"POST",
                "url":"地址",
                "data":{"UserName":$username,"UserPw":$userpw},
                "success":function(data){
                    var data = $.parseJSON(data);
                    if(data.status==1){
                        $(".error").css("visibility","visible").text("用户名与密码不匹配 , 请重新输入");
                        return false;
                    }
                    else{
                        window.location.href = "home.html";
                    }
                },
                "error":function(){
                    alert("网络错误!");
                }
            })
        }
    })
})