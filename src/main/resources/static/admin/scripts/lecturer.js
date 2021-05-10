function getListOfLecturers(url, selectName) {
    let dropdown = document.getElementById(selectName);
    dropdown.length = 0;

    let defaultOption = document.createElement('option');
    dropdown.add(defaultOption);
    dropdown.selectedIndex = 0;

    const request = new XMLHttpRequest();
    request.open('GET', url, true);

    request.onload = function() {
        if (request.status === 200) {
            const data = JSON.parse(request.responseText);
            console.log(data);
            let option;
            for (let i = 0; i < data.length; i++) {
                option = document.createElement('option');
                option.text = data[i].secondName;
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

function getListOfDepartments(url, selectName) {
    let dropdown = document.getElementById(selectName);
    dropdown.length = 0;

    let defaultOption = document.createElement('option');
    dropdown.add(defaultOption);
    dropdown.selectedIndex = 0;

    const request = new XMLHttpRequest();
    request.open('GET', url, true);

    request.onload = function() {
        if (request.status === 200) {
            const data = JSON.parse(request.responseText);
            console.log(data);
            let option;
            for (let i = 0; i < data.length; i++) {
                option = document.createElement('option');
                option.text = data[i].name;
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

getListOfDepartments("/getAllDepartments", "department");

getListOfLecturers("/getAllLecturers","updating_lecturers");
getListOfDepartments("/getAllDepartments", "department_update");

getListOfLecturers("/getAllLecturers", "deleting_lecturer");



