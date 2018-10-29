// 子区域各个形状本地数据缓存
var subAreaShapeDataCache;
// 菜单缓存
var menuCache;
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
		                    	<input type="text" id="" name="" class="form-control" placeholder="">\
		                 </div>');
			inputItem.first().html(jsonData.label);
			inputItem.find("input:first").attr("id", jsonData.id);
			inputItem.find("input:first").attr("name", jsonData.id);
			if (isNotNull(jsonData.placeholder)) {
				inputItem.find("input:first").attr("placeholder", jsonData.placeholder);
			}
			
			if (isNotNull(jsonData.disabled)) {
				inputItem.find("input:first").attr("disabled", jsonData.disabled);
			}
			
			if (isNotNull(jsonData.val)) {
				inputItem.find("input:first").val(jsonData.val);
			}
			break;
		case 'select':
			inputItem = $('<label class="col-sm-2 control-label"></label>\
		                   <div class="col-sm-3">\
			                   <select id="" class="form-control">\
							   </select>\
		                   </div>');
		    inputItem.first().html(jsonData.label);
		    inputItem.find("select:first").attr("id", jsonData.id);
		    inputItem.find("select:first").attr("name", jsonData.id);
		    $.each(jsonData.vals, function(i,val){      
			    for (var key in val) {
			    		inputItem.find("select:first").append($('<option value="'+ key +'">' + val[key] + '</option>'));
			    	}
			});  
			if (isNotNull(jsonData.disabled)) {
				inputItem.find("select:first").attr("disabled", jsonData.disabled);
			}
			if (isNotNull(jsonData.val)) {
				inputItem.find("select:first").val(jsonData.val);
			}
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
	        inputItem.find("input:first").attr("name", jsonData.id);
	        	if (isNotNull(jsonData.placeholder)) {
				inputItem.find("input:first").attr("placeholder", jsonData.placeholder);
			}
	        inputItem.find("button:first").attr("data-target", jsonData.modelId);
	        inputItem.find("button:first").attr("id", jsonData.modelId + "Btn");
	        	if (isNotNull(jsonData.disabled)) {
				inputItem.find("button:first").attr("disabled", jsonData.disabled);
			}
	        	if (isNotNull(jsonData.val)) {
				inputItem.find("input:first").val(jsonData.val);
			}
			break;
		case 'selectPicker':
			inputItem = $('<label class="col-sm-2 control-label"></label>\
		                   <div class="col-sm-3">\
			                   <select id="" class="form-control selectpicker" data-live-search="true">\
							   </select>\
		                   </div>');
		    inputItem.first().html(jsonData.label);
		    inputItem.find("select:first").attr("id", jsonData.id);
		    inputItem.find("select:first").attr("name", jsonData.id);
		    inputItem.find("input:first").attr("placeholder", jsonData.placeholder);
		    $.each(jsonData.vals, function(i,val){      
			    for (var key in val) {
			    		inputItem.find("select:first").append($('<option value="'+ key +'">' + val[key] + '</option>'));
			    	}
			});  
			if (isNotNull(jsonData.disabled)) {
				inputItem.find("select:first").attr("disabled", jsonData.disabled);
			}
			if (isNotNull(jsonData.val)) {
				inputItem.find("select:first").val(jsonData.val);
			}
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
	if (isNotNull(jsonData.disabled)) {
		inputItem.find("button:first").attr("disabled", jsonData.disabled);
	}
	return inputItem;
}

// 初始化各个控件
function initialInputItems(jsonData) {
	if (jsonData.items) {
		var inputItem1;
		var inputItem2;
		$.each(jsonData.items, function(i,val){      
	    		if ((i % 2) == 0) {
	    			inputItem1 = createInputItem(val);
	    		} else {
	    			inputItem2 = createInputItem(val);
	    			$('form').first().append(createFormGroup(inputItem1, inputItem2));
	    		}
		});
		if ((jsonData.items.length % 2) > 0) {
			$('form').first().append(createFormGroup(inputItem1));
		}
	}
	$('.selectpicker').selectpicker({"noneSelectedText":"请选择"});
	
	if (jsonData.subArea) {
		$('form').first().append(createSubArea(jsonData.subArea))
	}
}

// 初始化画面check
function initialChecks(formId, jsonData) {
	$.validator.setDefaults( {
		submitHandler: function () {
			if ($('#subAreaRow')) {
				if ($('#subAreaRow').find('.panel').length == 0) {
					alert('必须添加一个子区域');
					return;
				}
			}
			
			alert( "submitted!" );
		}
	} );
	
	if (!$.isEmptyObject(jsonData.checkRules)) {
		// 加入校验
		$( formId ).validate( {
		  	onfocusin: function(element) { $(element).valid(); },
		  	onfocusout: function(element) { $(element).valid(); },
		  	onclick: function(element) { $(element).valid(); },
		  	onkeyup: function(element) { $(element).valid(); },
			rules: jsonData.checkRules,
			messages: jsonData.checkMessages,
			errorElement: "em",
			errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );
	
					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}
				},
			highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-3" ).addClass( "has-error" ).removeClass( "has-success" );
//					$( element ).parent().parents( ".col-sm-3" ).addClass( "has-error" ).removeClass( "has-success" );	
				},
			unhighlight: function (element, errorClass, validClass) {
					$( element ).parents( ".col-sm-3" ).addClass( "has-success" ).removeClass( "has-error" );
//					$( element ).parent().parents( ".col-sm-3" ).addClass( "has-success" ).removeClass( "has-error" );
				}
		});
	}
	
	$.validator.addMethod("checkReg", function(value, element,param) {     
		if(typeof(param.reg)!="undefined"){
		    return checkReg(value, param.reg);
		} 
	});
	
	$.validator.addMethod("dataTypeCheck", function(value, element,param) {     
		if(typeof(param.dataType)!="undefined"){
		    return dataTypeCheck(value, param.dataType);
		} 
	});
}

// 初始化事件处理
function initialEvents(jsonData) {
	if (!$.isEmptyObject(jsonData.events)) {
		$.each(jsonData.events, function(i,val){      
		    if (val.eventType == 'blur') {
		    		$('#' + val.id).blur(eval(val.method));
		    }
		    // TODO:还需要添加其他的事件
		    if (val.eventType == 'click') {
		    		$('#' + val.id).click(eval(val.method));
		    } 
		}); 
	}
}

// 创建popup
function createModelDialog() {
	
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
	}
	return true;
}

// 创建菜单
function createMenu(jsonData, activeMenuCode) {
	var navSidebar = $('<!-- /.navbar-header -->\
            <div class="navbar-default sidebar" role="navigation">\
                <div class="sidebar-nav navbar-collapse">\
                    <ul class="nav" id="side-menu">\
                    </ul>\
                </div>\
                <!-- /.sidebar-collapse -->\
            </div>\
            <!-- /.navbar-static-side -->');
    $.each(jsonData, function(i,val){ 
    		var item;
		if (isNotNull(val.subMenu)) {
			var flag = false;
			item = $('<li><a href="#"><i class="fa fa-files-o fa-fw"></i> ' + val.menuName + '<span class="fa arrow"></span></a>\
                      <ul class="nav nav-second-level">\
                      </ul></li>');
            $.each(val.subMenu, function(i, subval){
            		var active = ''; 
				if (activeMenuCode == subval.menuCode) {
					active = ' class="active"';
					flag = true;
				}
            		var subItem = $('<li>\
                                    <a href="' + subval.url + '?menuCode=' + subval.menuCode + '" ' + active + '>' + subval.menuName + '</a>\
                                </li>');
                item.find('ul').append(subItem);
            });
            
            if (flag) {
            		item.addClass('active');
            }
		} else {
			var active = '';
			if (activeMenuCode == val.menuCode) {
				active = ' class="active"';
			}
			item = $('<li>\
                        <a href="' + val.url + '?menuCode=' + val.menuCode + '" ' + active + '><i class="fa fa-dashboard fa-fw"></i> ' + val.menuName + '</a>\
                    </li>');
		}
		navSidebar.find('#side-menu').append(item);
	}); 
    
    $('.navbar-header').after(navSidebar);
    $("#side-menu").metisMenu();
}
