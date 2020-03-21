
function i_validate(){
    alert("hello");
    var c_category=document.getElementsByName('category');
    var c_description=document.getElementsByName('description');
    var c_title=document.getElementsByName('title');
    var c_longdescription=document.getElementsByName('longdescription');
    if (c_category == "") {
        alert("카테고리를 입력해주세요!");
        return false;
    } else if (!c_category in ["award", "license", "stack", "research", "activities"]) {
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
        return true;
    }
}