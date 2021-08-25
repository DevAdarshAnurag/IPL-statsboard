function selectOptions()
{
    $("select").on('focus', function () {
        $previousValue = $(this).val();
    }).change(function() {
        $("select").not(this).find("option[value='"+ $(this).val() + "']").attr('disabled', true);
        $("select").not(this).find("option[value='"+ $previousValue + "']").attr('disabled', false);
    });
}

$(document).ready(function(){
    selectOptions();
});