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

(function ($) {
    $.fn.serializeFormJSON = function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
})(jQuery);

function initialDataTable(id, columns, searchFormId, url) {
	// 初始化表格对象
	return $('#' + id).DataTable({
        responsive: true,
        searching: false,
        serverSide: true,
        ajax: {
		    url: url,
           "type": "POST",
           "contentType" : "application/json; charset=utf-8",
           "data": function (d) {
           		  var orderColumn = d.columns[d.order[0].column].data;
           		  var orderDirection = d.order[0].dir;
	              //删除多余请求参数
	              for(var key in d){
	                  if(key.indexOf("order")==0||key.indexOf("columns")==0||key.indexOf("search")==0){ //以columns开头的参数删除
	                      delete d[key];
	                  }
	              }
	              var orderParams = {
	               "orderColumn":orderColumn,
	               "orderDirection":orderDirection
	              };
	              
	              var searchParams= $('#' + searchFormId).serializeFormJSON();
	              var token = {"token" : $('#token').val()};
	              $.extend(searchParams,token);
	              // 重置token
	              $('#token').val("0");
	              //附加查询参数
	              if(searchCondition){
	                  $.extend(d,searchParams); //给d扩展参数
	                  $.extend(d,orderParams); //给d扩展参数
	              }
	              d=JSON.stringify( d );
	              return d;
	           },
	           "dataType" : "json",
	           "dataFilter": function (json) {//json是服务器端返回的数据
	               json = JSON.parse(json);
	               var returnData = {};
	               returnData.draw = json.data.draw;
	               returnData.recordsTotal = json.data.total;//返回数据全部记录
	               returnData.recordsFiltered = json.data.total;//后台不实现过滤功能，每次查询均视作全部结果
	               returnData.data = json.data.data;//返回的数据列表
	               return JSON.stringify(returnData);//这几个参数都是datatable需要的，必须要
	           }
		  },
		  "columnDefs": [ {
	    		  "targets": '_all',
		      "createdCell": setAlign
		  	}
		  ],
		  columns: columns
    });
}
