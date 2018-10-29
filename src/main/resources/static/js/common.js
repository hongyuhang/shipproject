// 判断是否数字
function isNumber(val){
    var regPos = /^\d+(\.\d+)?$/; //非负浮点数
    var regNeg = /^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/; //负浮点数
    if(regPos.test(val) || regNeg.test(val)){
        return true;
    }else{
        return false;
    }

}

// 获取html页面的参数
function getParams(key) {
    var reg = new RegExp("(^|&)" + key + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
};

// 正则表达式校验
function checkReg(value, rule){
	if (!isNotNull(value)) {
		return true;
	}
	var patt1=new RegExp(rule);
	return value.match(patt1);
}

// 判断是否为空
function isNotNull(data) {
	if (data && data != "" && data != null) {
		return true;
	}
	return false;
}
