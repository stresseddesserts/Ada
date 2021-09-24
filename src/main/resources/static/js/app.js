function AddCoapplicantForm() {
    if (document.getElementById('addCoapplicantForm').style.display == 'none') {
        document.getElementById('addCoapplicantForm').style.display = 'block';
        document.getElementById('addCoapplicantButton').value = "Ahh don't add it";
        container = document.getElementById("addCoapplicantForm");
        inputs = container.getElementsByTagName('input');
        for (index = 0; index < inputs.length; ++index) {
            if(inputs[index].type =="text" || inputs[index].type =="number")
                inputs[index].disabled = false;
        }
    }
    else {
        document.getElementById('addCoapplicantForm').style.display = 'none';
        document.getElementById('addCoapplicantButton').value = "Add Co-Applicant";

        // remove fields if decided to remove co-applicant
        container = document.getElementById("addCoapplicantForm");
        inputs = container.getElementsByTagName('input');
        for (index = 0; index < inputs.length; ++index) {
            if(inputs[index].type =="text" || inputs[index].type =="number")
                inputs[index].disabled = true;
        }
    }
}

$(document).ready(function() {
    $('li.active').removeClass('active');
    $('a[href="' + location.pathname + '"]').closest('li').addClass('active');
});
