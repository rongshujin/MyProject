window.onload=function(){
    var submitBtn = document.getElementById("submit");
    submitBtn.onclick = function () {
    if(!document.getElementById("checkbox").checked) {
    alert("请认真核对信息,并勾选按钮!");
    return false;
    }};
}