$('#password, #confirmPassword').on('keyup', function () {
    if ($('#password').val() == $('#confirmPassword').val()) {
        $('#message').html('Matching').css('color', 'green');
        $('#btn-registration').removeAttr('disabled');
    } else {
        $('#message').html('Not Matching').css('color', 'red');
        $('#btn-registration').attr('disabled', true);
    }
});