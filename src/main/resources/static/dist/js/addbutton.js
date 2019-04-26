//动态添加按钮
function addbutton(div_id,value,id,btn_class,onclidkfunction) {
    var MyDiv =document.getElementById(div_id);
    var button = document.createElement("input");
    button.setAttribute("type", "button");
    button.setAttribute("value", value);
    button.setAttribute("id", id);
    button.setAttribute("class", btn_class);
    button.setAttribute("onclick",onclidkfunction);
    button.style.width = "auto";
    button.style.float="right";
    button.style.marginRight="5px";
    MyDiv.appendChild(button);
}

//添加checkbox的按钮
function addcheckboxbtn(){
    addbutton("table-foot","返回","cancel","btn btn-success","cancel()");
    addbutton("table-foot","全选","chooseall","btn btn-default","chooseall()");
    addbutton("table-foot","取消全选","cancelchooseall","btn btn-default","cancelchooseall()");
    addbutton("table-foot","反选","reversechoose","btn btn-default","reversechoose()");
    addbutton("table-foot","删除","deletechoose","btn btn-danger","deletechoose()");
}