//设置按钮不可见
function setbtnnone(elementid) {
    try{
        document.getElementById(elementid).style.display = "none";
    }catch (e) {}

}
//设置按钮可见
function setbtnblock(elementid) {
    try{
        document.getElementById(elementid).style.display = "block";
    }catch (e) {}
}