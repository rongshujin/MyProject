function changepic(obj) {
    //console.log(obj.files[0]);//获取上传文件的name
    var newsrc=getObjectURL(obj.files[0]);
    document.getElementById('show').src=newsrc;
}
//建立一個可存取到該file的url
function getObjectURL(file) {
    var url = null ;
    // 执行的效果一样 针对不同的浏览器执行不同的 js
    if (window.createObjectURL!=undefined) { // basic
        url = window.createObjectURL(file) ;
    } else if (window.URL!=undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file) ;
    } else if (window.webkitURL!=undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file) ;
    }
    return url ;
}