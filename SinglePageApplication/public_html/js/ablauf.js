$(window).scroll(function () {
    var ergebnis = isScrolledIntoView($('#ablauf_start_braeutigam'));
    if (ergebnis) {
        $('#ablauf_start_braeutigam').animate({opacity: 1}, 1500);
        $('#punkt_start_braeutigam').animate({opacity: 1}, 1500);
    }
});

$(window).scroll(function () {
    var ergebnis = isScrolledIntoView($('#ablauf_start_braut'));
    if (ergebnis) {
        $('#ablauf_start_braut').animate({opacity: 1}, 1500);
        $('#punkt_start_braut').animate({opacity: 1}, 1500);
    }
});

$(window).scroll(function () {
    var ergebnis = isScrolledIntoView($('#ablauf_abfahrt_braeutigam'));
    if (ergebnis) {
        $('#ablauf_abfahrt_braeutigam').animate({opacity: 1}, 1500);
        $('#punkt_abfahrt_braeutigam').animate({opacity: 1}, 1500);
    }
});

$(window).scroll(function () {
    var ergebnis = isScrolledIntoView($('#ablauf_eintreffen_braut'));
    if (ergebnis) {
        $('#ablauf_eintreffen_braut').animate({opacity: 1}, 1500);
        $('#punkt_eintreffen_braut').animate({opacity: 1}, 1500);
    }
});

$(window).scroll(function () {
    var ergebnis = isScrolledIntoView($('#ablauf_standesamt'));
    if (ergebnis) {
        $('#ablauf_standesamt').animate({opacity: 1}, 1500);
        $('#punkt_standesamt').animate({opacity: 1}, 1500);
    }
});

$(window).scroll(function () {
    var ergebnis = isScrolledIntoView($('#ablauf_trauung'));
    if (ergebnis) {
        $('#ablauf_trauung').animate({opacity: 1}, 1500);
        $('#punkt_trauung').animate({opacity: 1}, 1500);
    }
});

$(window).scroll(function () {
    var ergebnis = isScrolledIntoView($('#ablauf_agape'));
    if (ergebnis) {
        $('#ablauf_agape').animate({opacity: 1}, 1500);
        $('#punkt_agape').animate({opacity: 1}, 1500);
    }
});

$(window).scroll(function () {
    var ergebnis = isScrolledIntoView($('#ablauf_gasthaus'));
    if (ergebnis) {
        $('#ablauf_gasthaus').animate({opacity: 1}, 1500);
        $('#punkt_gasthaus').animate({opacity: 1}, 1500);
    }
});