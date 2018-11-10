function renderCell(data, type, row, meta) {
	var htmlContext = "";
	// 有link的字段的情况
	if (data.linkFlg) {
		htmlContext = '<a href="' + data.url + '?' + data.linkField + '=' + data.linkParamValue + '"><span>' + data.value + '</span>';
	} else {
		htmlContext = '<span>' + data.value + '</span>';
	}
	
//	htmlContext = htmlContext + data + '</span>';
//	// 处理内容的左右对齐
//	if (data) {
//		if ((typeof data) == 'number') {
//			htmlContext = htmlContext + 'text-right">' + data + '</span>';
//		}
//		
//		if ((typeof data) == 'string') {
//			htmlContext = htmlContext + 'text-left">' + data + '</span>';
//		}
//	} else {
//		return "";
//	}
	// 有link的特殊处理
	if (htmlContext.indexOf('<a') == 0) {
		htmlContext = htmlContext + '</a>';
	}
	return htmlContext;
} 

/**
 * 设置对齐
 * @param {Object} td
 * @param {Object} cellData
 * @param {Object} rowData
 * @param {Object} row
 * @param {Object} col
 */
function setAlign(td, cellData, rowData, row, col) {
	if (cellData.value) {
		if ((typeof cellData.value) == 'number') {
			$(td).css('text-align', 'right')
		}
		
		if ((typeof cellData.value) == 'string') {
			$(td).css('text-align', 'left')
		}
	}
}
