$('#username').on('keyup', function () {
    var value = $('#username').val();
    console.log(value);
    $.ajax({
        type: "POST",
        url: "/valid/username",
        data: {username: value},
        success: function (data) {
            if(data){
                var span = $('<span class="errorForm">'+data+'</span>');
                $('#div_username').html(span);
                $(span).fadeIn();
            }else{
                $('#div_username').html("");
            }
        }
    });
});
$('#username').on('keyup', function(){
    $(this).children('.errors').html("");
});