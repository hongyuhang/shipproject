// 创建一个装有两个控件的输入项行
function createFormGroup(inputItem1, inputItem2) {
	
}

// 创建输入项
function createInputItem(jsonData) {
	var inputItem;
	switch (jsonData.type) {
		case 'text':
			inputItem = $('<label class="col-sm-2 control-label"></label>\
		                 <div class="col-sm-3">\
		                    	<input type="text" id="" class="form-control" placeholder="">\
		                 </div>');
			inputItem.first().html(jsonData.label);
			inputItem.find("input:first").attr("id", jsonData.id);
			inputItem.find("input:first").attr("placeholder", jsonData.placeholder);
			break;
		case 'select':
			inputItem = $('<label class="col-sm-2 control-label"></label>\
		                   <div class="col-sm-3">\
			                   <select id="" class="form-control">\
							   </select>\
		                   </div>');
		    inputItem.first().html(jsonData.label);
		    inputItem.find("select:first").attr("id", jsonData.id);
		    $.each(jsonData.vals, function(i,val){      
			    for (var key in val) {
			    		inputItem.find("select:first").append($('<option value="'+ key +'">' + val[key] + '</option>'));
			    	}
			});  
			break;
		case 'popupSelect':
			inputItem = $('<label class="col-sm-2 control-label"></label>\
	                       <div class="col-sm-3">\
		                        <div class="input-group">\
		                            <input id="" type="text" disabled class="form-control" placeholder="">\
		                            <span class="input-group-btn">\
		                                <button class="btn btn-default" type="button" data-toggle="modal" data-target="#myModal"><i class="fa fa-search"></i>\
		                                </button>\
		                            </span>\
		                        </div>\
	                        </div>');
	        inputItem.first().html(jsonData.label);
	        inputItem.find("input:first").attr("id", jsonData.id);
	        inputItem.find("input:first").attr("placeholder", jsonData.placeholder);
	        inputItem.find("button:first").attr("data-target", jsonData.modelId);
			break;
		case 'selectPicker':
			break;
	}
	return inputItem;
}

// 创建popup
function createModelDialog() {
	
}