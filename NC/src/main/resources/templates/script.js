let nextPage, nameA;
function nextQuestion(nextPage, nameA){
    event.preventDefault();
    let qInputs = document.getElementsByName(nameA);
    let checkedValue = '';
    qInputs.forEach(function (input) {
        if (input.checked) checkedValue = input.value;
    });
    localStorage.setItem(nameA, checkedValue);
    document.location.href=nextPage;
}
