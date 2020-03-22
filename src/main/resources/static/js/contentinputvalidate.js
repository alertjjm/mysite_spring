
function mi_validate(){
    var c_category=document.getElementById('ct').value;
    var c_description=document.getElementById('sd').value;
    var c_title=document.getElementById('tt').value;
    var c_longdescription=document.getElementById('ld').value;
    var categories=new Array("award", "license", "stack", "research", "activities");
    if (c_category == "") {
        alert("카테고리를 입력해주세요!");
        return false;
    } else if (!categories.includes(c_category)) {
        alert("award,license,stack,research,activities중에 입력해주세요");
        return false;
    } else if (c_description == "") {
        alert("짧은 설명 입력해주세요!");
        return false;
    } else if (c_title == "") {
        alert("제목을 입력해주세요!");
        return false;
    } else if (c_longdescription == "") {
        alert("설명을 입력해주세요!");
        return false;
    } else {
        alert("등록성공");
        return true;
    }
}