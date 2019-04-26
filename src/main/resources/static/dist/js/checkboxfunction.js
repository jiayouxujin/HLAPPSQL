//全选函数
function chooseall() {
    $("input:checkbox").prop("checked","checked");
}
//取消全选函数
function cancelchooseall() {
    $("input:checkbox").each(function () {
        if(this.checked)
            this.checked=!this.checked;
    });
}
//反选函数
function reversechoose() {
    $("input:checkbox").each(function(){
        this.checked=!this.checked;
    });
}
