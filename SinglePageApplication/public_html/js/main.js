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

function selectGeschenke() {
    resetNavUnderline();
    $('#geschenke_item').addClass('navtext_selected');
}

function resetNavUnderline(){
    $('#home_item').removeClass( 'navtext_selected' );
    $('#brautpaar_item').removeClass( 'navtext_selected' );
    $('#ablauf_item').removeClass( 'navtext_selected' );
    $('#route_item').removeClass( 'navtext_selected' );
    $('#unterkuenfte_item').removeClass( 'navtext_selected' );
    $('#upload_item').removeClass('navtext_selected');
    $('#geschenke_item').removeClass('navtext_selected');
}

function selectGasthausBilder() {
    $('#bilder_gasthaus').show();
    $('#bilder_stuben').hide();
    $('#bilder_mannersdorf').hide();
    $('#bilder_standesamt').hide();
    $('#bilder_kirche').hide();
    $('#bilder_agape').hide();
    $('#bilder_brautstehlen').hide();
}

function selectStubenBilder() {
    $('#bilder_stuben').show();
    $('#bilder_gasthaus').hide();
    $('#bilder_mannersdorf').hide();
    $('#bilder_standesamt').hide();
    $('#bilder_kirche').hide();
    $('#bilder_agape').hide();
    $('#bilder_brautstehlen').hide();
}

function selectMannersdorfBilder() {
    $('#bilder_mannersdorf').show();
    $('#bilder_gasthaus').hide();
    $('#bilder_stuben').hide();
    $('#bilder_standesamt').hide();
    $('#bilder_kirche').hide();
    $('#bilder_agape').hide();
    $('#bilder_brautstehlen').hide();
}

function selectStandesamtBilder() {
    $('#bilder_standesamt').show();
    $('#bilder_gasthaus').hide();
    $('#bilder_stuben').hide();
    $('#bilder_mannersdorf').hide();
    $('#bilder_kirche').hide();
    $('#bilder_agape').hide();
    $('#bilder_brautstehlen').hide();
}

function selectKircheBilder() {
    $('#bilder_kirche').show();
    $('#bilder_gasthaus').hide();
    $('#bilder_stuben').hide();
    $('#bilder_mannersdorf').hide();
    $('#bilder_standesamt').hide();
    $('#bilder_agape').hide();
    $('#bilder_brautstehlen').hide();
}
function selectAgapeBilder() {
    $('#bilder_agape').show();
    $('#bilder_gasthaus').hide();
    $('#bilder_stuben').hide();
    $('#bilder_mannersdorf').hide();
    $('#bilder_standesamt').hide();
    $('#bilder_kirche').hide();
    $('#bilder_brautstehlen').hide();
}

function selectBrautStehlenBilder() {
    $('#bilder_brautstehlen').show();
    $('#bilder_gasthaus').hide();
    $('#bilder_stuben').hide();
    $('#bilder_mannersdorf').hide();
    $('#bilder_standesamt').hide();
    $('#bilder_kirche').hide();
    $('#bilder_agape').hide();
}