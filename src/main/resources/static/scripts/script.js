$("#show_all_lecturers").click(event => {
    event.preventDefault();
    $.ajax({
        url: "/getAllLecturers",
        type: "GET",
        success: function (result) {
            var jsonObject = JSON.parse(result);
            console.log(jsonObject);
            buildTable(jsonObject, "showAllLecturers");
        }
    });
});

$("#list_of_lecturers_for_each_course").click(event => {
    event.preventDefault();
    $.ajax({
        url: "/showListOfLecturersForEachCourse",
        type: "GET",
        success: function (result) {
            var jsonObject = JSON.parse(result);
            console.log(jsonObject);
            buildTable(jsonObject, "showListOfLecturersForEachCourse");
        }
    });
});

$("#courses_for_each_lecturer_with_workload").click(event => {
    event.preventDefault();
    $.ajax({
        url: "/getCoursesForEachLecturerWithWorkLoad",
        type: "GET",
        success: function (result) {
            var jsonObject = JSON.parse(result);
            console.log(jsonObject);
            buildTable(jsonObject, "showCoursesForEachLecturerWithWorkload");
        }
    });
});

$("#courses_for_each_depart").click(event => {
    event.preventDefault();
    $.ajax({
        url: "/getListOfCoursesForEachDepartment",
        type: "GET",
        success: function (result) {
            var jsonObject = JSON.parse(result);
            console.log(jsonObject);
            buildTable(jsonObject, "showCoursesForEachDepartment");
        }
    });
});

function buildTable(json, objectToPutData) {
    var col = [];
    for (var i = 0; i < json.length; i++) {
        for (var key in json[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }

    // CREATE DYNAMIC TABLE.
    var table = document.createElement("table");

    // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

    var tr = table.insertRow(-1);                   // TABLE ROW.

    for (var i = 0; i < col.length; i++) {
        var th = document.createElement("th");      // TABLE HEADER.
        th.innerHTML = col[i];
        tr.appendChild(th);
    }

    // ADD JSON DATA TO THE TABLE AS ROWS.
    for (var i = 0; i < json.length; i++) {

        tr = table.insertRow(-1);

        for (var j = 0; j < col.length; j++) {
            var tabCell = tr.insertCell(-1);
            tabCell.innerHTML = json[i][col[j]];
        }
    }

    // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
    var divContainer = document.getElementById(objectToPutData);
    divContainer.innerHTML = "";
    divContainer.appendChild(table);
}