function hideDelete() {
    var del = jQuery("#delete");
    del.hide();
}

jQuery(document).ready(function()
{hideDelete();
    var check_box = jQuery(".check-box");
        check_box.click(function(event) {

            if($("input:checkbox:checked").length == 0){
                hideDelete();
            } else {
                jQuery("#delete").show();
            }

    });;

    var btn = jQuery(".btn.btn-info");

    btn.click(function(event) {

        event.stopPropagation();
        var A_UL = jQuery(this).find("a");
        jQuery(location).attr('href',A_UL.attr("href"));
    });
});


