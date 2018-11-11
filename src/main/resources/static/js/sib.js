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
		case 'textarea':
			inputItem = $('<label class="col-sm-2 control-label"></label>\
		                 <div class="col-sm-8">\
		                    	<textarea id="" name="" rows="4" class="form-control" placeholder=""></textarea>\
		                 </div>');
			inputItem.first().html(jsonData.label);
			inputItem.find("textarea:first").attr("id", jsonData.id);
			inputItem.find("textarea:first").attr("name", jsonData.id);
			if (isNotNull(jsonData.placeholder)) {
				inputItem.find("textarea:first").attr("placeholder", jsonData.placeholder);
			}
			
			if (isNotNull(jsonData.disabled)) {
				inputItem.find("textarea:first").attr("disabled", jsonData.disabled);
			}
			
			if (isNotNull(jsonData.val)) {
				inputItem.find("textarea:first").val(jsonData.val);
			}
			break;
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
		case 'blank':
			inputItem = $('<label class="col-sm-2 control-label"></label>\
		                   <div class="col-sm-3">\
		                   </div>');
		    break;
	}
	return inputItem;
}

// 创建子区域
function createSubArea(jsonData){
	var inputItem = $('<div class="form-group" id="subAreaRow">\
		                    	<label class="col-sm-2 control-label">子区域:</label>\
			                <div class="col-sm-8" id="subArea">\
			                    	<button type="button" id="subAreaBtn" class="btn btn-default btn-circle btn-xl" data-toggle="modal" data-target="#myArea"><i class="fa fa-plus"></i>\
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
	$('.page-header').text(jsonData.title);
	if (jsonData.items) {
		var inputItem1;
		var inputItem2;
		var inputItemArrays1 = new Array();
		var inputItemArrays2 = new Array();
		$.each(jsonData.items, function(i,val){  
			inputItem = createInputItem(val);
			if (val.type != 'textarea') {
				if (inputItemArrays1.length == inputItemArrays2.length) {
					inputItemArrays1.push(inputItem);
				} else {
					inputItemArrays2.push(inputItem);
				}
			} else {
				if (inputItemArrays1.length == inputItemArrays2.length) {
					inputItemArrays1.push(inputItem);
					inputItemArrays2.push(null);
				} else {
					inputItemArrays2.push(null);
					inputItemArrays1.push(inputItem);
					inputItemArrays2.push(null);
				}
			}
		});
		
		for (idx = 0; idx < inputItemArrays1.length; idx++) {
			$('form').first().append(createFormGroup(inputItemArrays1[idx], inputItemArrays2[idx]));
		}
		
		if ((jsonData.items.length % 2) > 0) {
			$('form').first().append(createFormGroup(inputItem1));
		}
	}
	$('.selectpicker').selectpicker({"noneSelectedText":"请选择"});
	
	if (jsonData.subArea) {
		$('form').first().append(createSubArea(jsonData.subArea))
	}
}
var validatorObj;
// 初始化画面check
function initialChecks(formId, jsonData) {	
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
					$( element ).parents( ".col-sm-8" ).addClass( "has-error" ).removeClass( "has-success" );
//					$( element ).parent().parents( ".col-sm-3" ).addClass( "has-error" ).removeClass( "has-success" );	
				},
			unhighlight: function (element, errorClass, validClass) {
					$( element ).parents( ".col-sm-3" ).addClass( "has-success" ).removeClass( "has-error" );
					$( element ).parents( ".col-sm-8" ).addClass( "has-success" ).removeClass( "has-error" );
//					$( element ).parent().parents( ".col-sm-3" ).addClass( "has-success" ).removeClass( "has-error" );
				}
		});
	}
	

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
		    
		    if (val.eventType == 'change') {
		    		$('#' + val.id).change(eval(val.method));
		    }
		}); 
	}
}

// 创建popup
function createModelDialog() {
	
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
                                    <a onclick="removeCookie();" href="' + subval.url + '?menuCode=' + subval.menuCode + '" ' + active + '>' + subval.menuName + '</a>\
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
                        <a onclick="removeCookie();" href="' + val.url + '?menuCode=' + val.menuCode + '" ' + active + '><i class="fa fa-dashboard fa-fw"></i> ' + val.menuName + '</a>\
                    </li>');
		}
		navSidebar.find('#side-menu').append(item);
	}); 
    
    $('.navbar-header').after(navSidebar);
    $("#side-menu").metisMenu();
}

function removeCookie() {
   	  $.cookie('lists_iorder', '', { expires: -1 }); 
	  $.cookie('lists_idir', '', { expires: -1 }); 
	  $.cookie('lists_iDisplayStart', '', { expires: -1 }); 
	  $.cookie('lists_iDisplayLength', '', { expires: -1 }); 
}

	/**
	 * 拼发送给后台的json字符串
	 */
	function buildSendData() {
		var sendData = {};
		// 抛去子区域部分的数据
		$.each($('#form1').find('input'), function(i, item) {
			item = $(item);
			if (item.attr('id')) {
				if (item.attr('id').indexOf('_') <= 0) {
					sendData[item.attr("id")] = item.val();
				}
			}
		});
		$.each($('#form1').find('textarea'), function(i, item) {
			item = $(item);
			if (item.attr('id')) {
				if (item.attr('id').indexOf('_') <= 0) {
					sendData[item.attr("id")] = item.val();
				}
			}
		});
		$.each($('#form1').find('select'), function(i, item) {
			item = $(item);
			if (item.attr('id')) {
				if (item.attr('id').indexOf('_') <= 0) {
					sendData[item.attr("id")] = item.val();
				}
			}
		});
		$.each($('#form1').find('.selectpicker'), function(i, item) {
			item = $(item);
			if (item.attr('id')) {
				if (item.attr('id').indexOf('_') <= 0) {
					sendData[item.attr("id")] = item.val();
				}
			}
		});
		// 子区域部分的数据
		console.log(sendData);
		var subAreaData = [];
		$('subArea').find('.panel');
		$.each($('#subArea').find('.panel'), function(i, panel) {
			panel = $(panel);
			var temp = {};
			$.each(panel.find('input'), function(i, item) {
				item = $(item);
				if (item.attr('id')) {
					temp[item.attr("id").substring(0, item.attr("id").indexOf('_'))] = item.val();
				}
			});
			$.each(panel.find('textarea'), function(i, item) {
				item = $(item);
				if (item.attr('id')) {
					temp[item.attr("id").substring(0, item.attr("id").indexOf('_'))] = item.val();
				}
			});
			$.each(panel.find('select'), function(i, item) {
				item = $(item);
				if (item.attr('id')) {
					temp[item.attr("id").substring(0, item.attr("id").indexOf('_'))] = item.val();
				}
			});
			$.each(panel.find('.selectpicker'), function(i, item) {
				item = $(item);
				if (item.attr('id')) {
					temp[item.attr("id").substring(0, item.attr("id").indexOf('_'))] = item.val();
				}
			});
			subAreaData.push(temp);
		});
		sendData["subAreas"] = subAreaData;
		
		return sendData;
	}
	
	/**
	 * 控制控件状态
	 */
	function controlStatusInB9() {
		if ($('#servicesAvailability')) {
			if ($('#servicesAvailability').val() == '1') {
				for(i = 1; i <= 22 ;i++) {
					$('#typeOfServicesAvailable_' + i).removeAttr("disabled");
				}
			} else {
				for(i = 1; i <= 22 ;i++) {
					$('#typeOfServicesAvailable_' + i).attr("disabled", true);
				}
			}
		}
	}
