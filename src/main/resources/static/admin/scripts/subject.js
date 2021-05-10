function getListOfSubjects(selectName) {
    let dropdown = document.getElementById(selectName);
    dropdown.length = 0;
    console.log("It works");

    let defaultOption = document.createElement('option');
    //defaultOption.text = 'Choose State/Province';

    dropdown.add(defaultOption);
    dropdown.selectedIndex = 0;

    const url = '/getAllSubjects';

    const request = new XMLHttpRequest();
    request.open('GET', url, true);

    request.onload = function() {
        console.log("Smth");
        if (request.status === 200) {
            const data = JSON.parse(request.responseText);
            console.log(data);
            let option;
            for (let i = 0; i < data.length; i++) {
                option = document.createElement('option');
                option.text = data[i].title;
                option.value = data[i].id;
                dropdown.add(option);
            }
        } else {
            // Reached the server, but it returned an error
            console.log("Bad");
        }
    }

    request.onerror = function() {
        console.error('An error occurred fetching the JSON from ' + url);
    };

    request.send();
}

getListOfSubjects("courses");
getListOfSubjects("courses_to_delete");

$("#adding_subject").submit(event => {
    event.preventDefault();
    var title = $("#title").val();
    var volumeInCredits = $("#volume_in_credits").val();

    $.ajax({
        url: "/addNewSubject",
        type: "POST",
        data: {title: title, volumeInCredits: volumeInCredits}
    });
});

$("#update_subject").submit(event => {
    event.preventDefault();
    var id = $("#courses").val();
    var title = $("#update_title").val();
    var volumeInCredits = $("#volume_in_credits_update").val();

    $.ajax({
        url: "/updateSubject",
        type: "POST",
        data: {id: id, title: title, volumeInCredits: volumeInCredits}
    });
});
$("#deleting_subject").submit(event => {
    event.preventDefault();
    var id = $("#courses_to_delete").val();

    $.ajax({
        url: "/deleteSubject",
        type: "POST",
        data: {id: id}
    });
});
