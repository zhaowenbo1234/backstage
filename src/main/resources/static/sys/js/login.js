function login() {

    /*用户名*/
    var username = $("input[name='username']").val();
    /*密码*/
    var password =$("input[name='password']").val();
    /*记住我*/
    var rememberme = $("input[name='rememberme']").is(':checked');
    /*验证码*/
    var validateCode = $("input[name='validateCode']").val();
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