// 创建一个装有两个控件的输入项行
function createFormGroup(inputItem1, inputItem2) {
	var formGroup = $('<div class="form-group"></div>');
	formGroup.append(inputItem1);
	if (inputItem2) {
		formGroup.append(inputItem2);
	}
	
	return formGroup;
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
		                                <button class="btn btn-default" id="" type="button" data-toggle="modal" data-target="#myModal"><i class="fa fa-search"></i>\
		                                </button>\
		                            </span>\
		                        </div>\
	                        </div>');
	        inputItem.first().html(jsonData.label);
	        inputItem.find("input:first").attr("id", jsonData.id);
	        inputItem.find("input:first").attr("placeholder", jsonData.placeholder);
	        inputItem.find("button:first").attr("data-target", jsonData.modelId);
	        inputItem.find("button:first").attr("id", jsonData.modelId + "Btn");
			break;
		case 'selectPicker':
			inputItem = $('<label class="col-sm-2 control-label"></label>\
		                   <div class="col-sm-3">\
			                   <select id="" class="form-control selectpicker" data-live-search="true">\
							   </select>\
		                   </div>');
		    inputItem.first().html(jsonData.label);
		    inputItem.find("select:first").attr("id", jsonData.id);
		    inputItem.find("input:first").attr("placeholder", jsonData.placeholder);
		    $.each(jsonData.vals, function(i,val){      
			    for (var key in val) {
			    		inputItem.find("select:first").append($('<option value="'+ key +'">' + val[key] + '</option>'));
			    	}
			});  
			break;
			break;
	}
	return inputItem;
}

// 创建子区域
function createSubArea(jsonData){
	var inputItem = $('<div class="form-group" id="subAreaRow">\
		                    	<label class="col-sm-2 control-label">子区域:</label>\
			                <div class="col-sm-8" id="subArea">\
			                    	<button type="button" class="btn btn-default btn-circle btn-xl" data-toggle="modal" data-target="#myArea"><i class="fa fa-plus"></i>\
			                </div>\
	                    </div>');
	inputItem.find('label:first').html(jsonData.label);
	inputItem.find("button:first").attr("data-target", jsonData.modelId);
	return inputItem;
}

// 创建popup
function createModelDialog() {
	
}