
function login() {
    var username = $("input[name='username']").val();
    var password = $("input[name='password']").val();
    var validateCode = $("input[name='validateCode']").val();
    var rememberMe = $("input[name='rememberme']").is(':checked');
    $.ajax({
        type: "post",
        url: ctx + "login",
        data: {
            "username": username,
            "password": password,
            "validateCode" : validateCode,
            "rememberMe": rememberMe
        },
        success: function(r) {
            if (r.code == 200) {
                window.location.href = ctx + 'index';
            } else {
                // $.modal.closeLoading();
                // $('.imgcode').click();
                // $.modal.msg(r.msg);
            }
        }

    });
}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signUpForm").validate({
        rules: {
            username: {
                required: true
            },
            password: {
                required: true
            }
        },
        messages: {
            username: {
                required: icon + "请输入您的用户名",
            },
            password: {
                required: icon + "请输入您的密码",
            }
        }
    })
}
