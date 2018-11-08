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

// 校验数据类型
function dataTypeCheck(value, type) {
	if (!isNotNull(value)) {
		return true;
	}
	if (!isNumber(value)) {
		return false;
	}
	
	if (value.substr(0, 1) == "-1") {
		value = value.substring(1);
	}
	
	if (isNotNull(type)) {
		// 数字情况
		if (type.substr(0, 1) == "N") {
			var temp = type.substring(1).split(",");
			if (Math.pow(10, temp[0]) <= value) {
				return false;
			}
			if (temp.length >1) {
				var strValue = value + "";
				if (strValue.indexOf(".") > 0) {
					if (strValue.split(".")[1] >= Math.pow(10, temp[1])) {
						return false;
					}
				}
			}
		}
		
		// 字符串的情况
		if (type.substr(0, 1) == "V") {
			var len = type.substring(1);
			if (value.length > len) {
				return false;
			}
		}
	}
	return true;
}
