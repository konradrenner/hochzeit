function selectHome(){
    resetNavUnderline();
    $('#home_item').addClass( 'navtext_selected' );
}

function selectBrautpaar(){
    resetNavUnderline();
    $('#brautpaar_item').addClass( 'navtext_selected' );
}

function selectAblauf(){
    resetNavUnderline();
    $('#ablauf_item').addClass( 'navtext_selected' );
}

function selectRoute(){
    resetNavUnderline();
    $('#route_item').addClass( 'navtext_selected' );
}

function selectUnterkuenfte(){
    resetNavUnderline();
    $('#unterkuenfte_item').addClass( 'navtext_selected' );
}

function resetNavUnderline(){
    $('#home_item').removeClass( 'navtext_selected' );
    $('#brautpaar_item').removeClass( 'navtext_selected' );
    $('#ablauf_item').removeClass( 'navtext_selected' );
    $('#route_item').removeClass( 'navtext_selected' );
    $('#unterkuenfte_item').removeClass( 'navtext_selected' );
    $('#upload_item').removeClass( 'navtext_selected' );
}