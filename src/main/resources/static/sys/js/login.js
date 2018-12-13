function login() {

    /*用户名*/
    var username = "";
    /*密码*/
    var password = "";
    /*记住我*/
    var rememberme = "";
    /*验证码*/
    var validateCode = "";
    $.ajax({
        type: "post",
        url: "/loginUser",
        data:{
            "username":username,
            "password":password,
            "rememberme":rememberme,
            "validateCode":validateCode
        },
        success:function (r) {
            if (r.code == 0){
                location.href = "index";
            } else {
                // TODO
                alert("暂时弹出一个错误窗口");
            }
        }

    });
}