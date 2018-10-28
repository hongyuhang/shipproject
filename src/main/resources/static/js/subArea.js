	
	// 创建圆形区域
	function createCircleArea(title) {
		var index = $('#subAreaRow').find('.panel').length + 1;
		var area = $('<div class="panel panel-default">\
                    <div class="panel-heading">\
                        <span>title</span>\
                        <button type="button" name="closeSubArea" style="float:right"><i class="fa fa-times"></i>\
                    </div>\
                    <div class="panel-body">\
	                    <div class="form-group">\
	                    		<input type="hidden" id="areaShape" name="areaShape" value="0"></input>\
		                    <label class="col-sm-2 control-label">比例因子:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="scaleFactor" name="scaleFactor" class="form-control" placeholder="">\
		                    </div>\
	                        <label class="col-sm-2 control-label">经度:</label>\
	                        <div class="col-sm-3">\
	                        		<input type="text" id="longitude" name="longitude" class="form-control" placeholder="">\
	                        </div>\
	                    </div>\
	                    <div class="form-group">\
		                    <label class="col-sm-2 control-label">纬度:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="latitude" name="latitude" type="text" class="form-control" placeholder="">\
		                    </div>\
	                        <label class="col-sm-2 control-label">精度:</label>\
	                        <div class="col-sm-3">\
	                        		<select id="precision" name="precision" class="form-control">\
	                        			<option value="0">0</option>\
	                        			<option value="1">1</option>\
	                        			<option value="2">2</option>\
	                        			<option value="3">3</option>\
	                        			<option value="4">4</option>\
							    </select>\
	                        </div>\
	                    </div>\
	                    	<div class="form-group">\
		                    <label class="col-sm-2 control-label">半径:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="radius" name="radius" type="text" class="form-control" placeholder="">\
		                    </div>\
	                    </div>\
                    </div>\
                </div>');
                
		area.find('#areaShape').attr("id", "areaShape" + "_" + index).attr("name", "areaShape" + "_" + index);
		area.find('#scaleFactor').attr("id", "scaleFactor" + "_" + index).attr("name", "scaleFactor" + "_" + index);
		area.find('#longitude').attr("id", "longitude" + "_" + index).attr("name", "longitude" + "_" + index);
		area.find('#latitude').attr("id", "latitude" + "_" + index).attr("name", "latitude" + "_" + index);
		area.find('#precision').attr("id", "precision" + "_" + index).attr("name", "precision" + "_" + index);
		area.find('#radius').attr("id", "radius" + "_" + index).attr("name", "radius" + "_" + index);
		
		area.find('div span:first').text(title);
		area.find('button:first').click(function(e) {
			$(e.target).parents(".panel:first").remove();
		});
		return area;
	}
	// 注册圆形区域的校验规则
	function registCheckForCircle() {
		var index = $('#subAreaRow').find('.panel').length;
		$("#scaleFactor" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N2"},
					messages:{
					dataTypeCheck: "请录入2位以内的数字"
				}
		});
		$("#longitude" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N3,3"},
					range: [-180, 180],
					messages:{
					dataTypeCheck: "请录入3位整数3位小数以内的数字",
					range: "请录入-180到180之间的数字"
				}
		});
		$("#latitude" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N3,3"},
					range: [-90, 90],
					messages:{
					dataTypeCheck: "请录入3位整数3位小数以内的数字",
					range: "请录入-90到90之间的数字"
				}
		});
		$("#radius" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N12"},
					range: [0, 4095],
					messages:{
					dataTypeCheck: "请录入12位以内的数字",
					range: "请录入0到4095之间的整数"
				}
		});
	}
	
	// 创建矩形区域
	function createRectangleArea(title) {
		var index = $('#subAreaRow').find('.panel').length + 1;
		var area = $('<div class="panel panel-default">\
                    <div class="panel-heading">\
                        <span>title</span>\
                        <button type="button" name="closeSubArea" style="float:right"><i class="fa fa-times"></i>\
                    </div>\
                    <div class="panel-body">\
	                    <div class="form-group">\
	                    		<input type="hidden" id="areaShape" name="areaShape" value="1"></input>\
		                    <label class="col-sm-2 control-label">比例因子:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="scaleFactor" name="scaleFactor" class="form-control" placeholder="">\
		                    </div>\
	                        <label class="col-sm-2 control-label">经度:</label>\
	                        <div class="col-sm-3">\
	                        		<input type="text" id="longitude" name="longitude" class="form-control" placeholder="">\
	                        </div>\
	                    </div>\
	                    <div class="form-group">\
		                    <label class="col-sm-2 control-label">纬度:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="latitude" name="latitude" type="text" class="form-control" placeholder="">\
		                    </div>\
	                        <label class="col-sm-2 control-label">精度:</label>\
	                        <div class="col-sm-3">\
	                        		<select id="precision" name="precision" class="form-control">\
	                        			<option value="0">0</option>\
	                        			<option value="1">1</option>\
	                        			<option value="2">2</option>\
	                        			<option value="3">3</option>\
	                        			<option value="4">4</option>\
							    </select>\
	                        </div>\
	                    </div>\
	                    	<div class="form-group">\
		                    <label class="col-sm-2 control-label">dimension E:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="dimensionE" name="dimensionE" type="text" class="form-control" placeholder="">\
		                    </div>\
		                    	<label class="col-sm-2 control-label">dimension N:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="dimensionN" name="dimensionN" type="text" class="form-control" placeholder="">\
		                    </div>\
	                    </div>\
	                    	<div class="form-group">\
		                    <label class="col-sm-2 control-label">Orientation:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="orientation" name="orientation" type="text" class="form-control" placeholder="">\
		                    </div>\
	                    </div>\
                    </div>\
                </div>');
                
		area.find('#areaShape').attr("id", "areaShape" + "_" + index).attr("name", "areaShape" + "_" + index);
		area.find('#scaleFactor').attr("id", "scaleFactor" + "_" + index).attr("name", "scaleFactor" + "_" + index);
		area.find('#longitude').attr("id", "longitude" + "_" + index).attr("name", "longitude" + "_" + index);
		area.find('#latitude').attr("id", "latitude" + "_" + index).attr("name", "latitude" + "_" + index);
		area.find('#precision').attr("id", "precision" + "_" + index).attr("name", "precision" + "_" + index);
		area.find('#dimensionE').attr("id", "dimensionE" + "_" + index).attr("name", "dimensionE" + "_" + index);
		area.find('#dimensionN').attr("id", "dimensionN" + "_" + index).attr("name", "dimensionN" + "_" + index);
		area.find('#orientation').attr("id", "orientation" + "_" + index).attr("name", "orientation" + "_" + index);
		
		area.find('div span:first').text(title);
		area.find('button:first').click(function(e) {
			$(e.target).parents(".panel:first").remove();
		});
		return area;
	}
	// 注册矩形区域的校验规则
	function registCheckForRectangle() {
		var index = $('#subAreaRow').find('.panel').length;
		$("#scaleFactor" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N2"},
					messages:{
					dataTypeCheck: "请录入2位以内的数字"
				}
		});
		$("#longitude" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N3,3"},
					range: [-180, 180],
					messages:{
					dataTypeCheck: "请录入3位整数3位小数以内的数字",
					range: "请录入-180到180之间的数字"
				}
		});
		$("#latitude" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N3,3"},
					range: [-90, 90],
					messages:{
					dataTypeCheck: "请录入3位整数3位小数以内的数字",
					range: "请录入-90到90之间的数字"
				}
		});
		$("#dimensionE" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N8"},
					range: [0, 255],
					messages:{
					dataTypeCheck: "请录入8位以内的数字",
					range: "请录入0到255之间的整数"
				}
		});
		$("#dimensionN" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N8"},
					range: [0, 255],
					messages:{
					dataTypeCheck: "请录入8位以内的数字",
					range: "请录入0到255之间的整数"
				}
		});
		$("#orientation" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N9"},
					range: [0, 359],
					messages:{
					dataTypeCheck: "请录入9位以内的数字",
					range: "请录入0到359之间的整数"
				}
		});
	}
	
	// 创建扇形区域
	function createFanArea(title) {
		var index = $('#subAreaRow').find('.panel').length + 1;
		var area = $('<div class="panel panel-default">\
                    <div class="panel-heading">\
                        <span>title</span>\
                        <button type="button" name="closeSubArea" style="float:right"><i class="fa fa-times"></i>\
                    </div>\
                    <div class="panel-body">\
	                    <div class="form-group">\
	                    		<input type="hidden" id="areaShape" name="areaShape" value="2"></input>\
		                    <label class="col-sm-2 control-label">比例因子:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="scaleFactor" name="scaleFactor" class="form-control" placeholder="">\
		                    </div>\
	                        <label class="col-sm-2 control-label">经度:</label>\
	                        <div class="col-sm-3">\
	                        		<input type="text" id="longitude" name="longitude" class="form-control" placeholder="">\
	                        </div>\
	                    </div>\
	                    <div class="form-group">\
		                    <label class="col-sm-2 control-label">纬度:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="latitude" name="latitude" type="text" class="form-control" placeholder="">\
		                    </div>\
	                        <label class="col-sm-2 control-label">精度:</label>\
	                        <div class="col-sm-3">\
	                        		<select id="precision" name="precision" class="form-control">\
	                        			<option value="0">0</option>\
	                        			<option value="1">1</option>\
	                        			<option value="2">2</option>\
	                        			<option value="3">3</option>\
	                        			<option value="4">4</option>\
							    </select>\
	                        </div>\
	                    </div>\
	                    	<div class="form-group">\
		                    <label class="col-sm-2 control-label">半径:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="radius" name="radius" type="text" class="form-control" placeholder="">\
		                    </div>\
		                    	<label class="col-sm-2 control-label">左边界:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="leftBoundary" name="leftBoundary" type="text" class="form-control" placeholder="">\
		                    </div>\
	                    </div>\
	                    	<div class="form-group">\
		                    <label class="col-sm-2 control-label">右边界:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="rightBoundary" name="rightBoundary" type="text" class="form-control" placeholder="">\
		                    </div>\
	                    </div>\
                    </div>\
                </div>');
                
		area.find('#areaShape').attr("id", "areaShape" + "_" + index).attr("name", "areaShape" + "_" + index);
		area.find('#scaleFactor').attr("id", "scaleFactor" + "_" + index).attr("name", "scaleFactor" + "_" + index);
		area.find('#longitude').attr("id", "longitude" + "_" + index).attr("name", "longitude" + "_" + index);
		area.find('#latitude').attr("id", "latitude" + "_" + index).attr("name", "latitude" + "_" + index);
		area.find('#precision').attr("id", "precision" + "_" + index).attr("name", "precision" + "_" + index);
		area.find('#radius').attr("id", "radius" + "_" + index).attr("name", "radius" + "_" + index);
		area.find('#leftBoundary').attr("id", "leftBoundary" + "_" + index).attr("name", "leftBoundary" + "_" + index);
		area.find('#rightBoundary').attr("id", "rightBoundary" + "_" + index).attr("name", "rightBoundary" + "_" + index);
		
		area.find('div span:first').text(title);
		area.find('button:first').click(function(e) {
			$(e.target).parents(".panel:first").remove();
		});
		return area;
	}
	// 注册扇形区域的校验规则
	function registCheckForFan() {
		var index = $('#subAreaRow').find('.panel').length;
		$("#scaleFactor" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N2"},
					messages:{
					dataTypeCheck: "请录入2位以内的数字"
				}
		});
		$("#longitude" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N3,3"},
					range: [-180, 180],
					messages:{
					dataTypeCheck: "请录入3位整数3位小数以内的数字",
					range: "请录入-180到180之间的数字"
				}
		});
		$("#latitude" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N3,3"},
					range: [-90, 90],
					messages:{
					dataTypeCheck: "请录入3位整数3位小数以内的数字",
					range: "请录入-90到90之间的数字"
				}
		});
		$("#radius" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N12"},
					range: [0, 4095],
					messages:{
					dataTypeCheck: "请录入12位以内的数字",
					range: "请录入0到255之间的整数"
				}
		});
		$("#leftBoundary" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N9"},
					range: [0, 359],
					messages:{
					dataTypeCheck: "请录入9位以内的数字",
					range: "请录入0到359之间的整数"
				}
		});
		$("#rightBoundary" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N9"},
					range: [0, 359],
					messages:{
					dataTypeCheck: "请录入9位以内的数字",
					range: "请录入0到359之间的整数"
				}
		});
	}
	
	// 创建折线区域
	function createLineArea(title) {
		var index = $('#subAreaRow').find('.panel').length + 1;
		var area = $('<div class="panel panel-default">\
                    <div class="panel-heading">\
                        <span>title</span>\
                        <button type="button" name="closeSubArea" style="float:right"><i class="fa fa-times"></i>\
                    </div>\
                    <div class="panel-body">\
	                    <div class="form-group">\
	                    		<input type="hidden" id="areaShape" name="areaShape" value="3"></input>\
		                    <label class="col-sm-2 control-label">比例因子:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="scaleFactor" name="scaleFactor" class="form-control" placeholder="">\
		                    </div>\
	                        <label class="col-sm-2 control-label">位置1倾角:</label>\
	                        <div class="col-sm-3">\
	                        		<input type="text" id="pointAngle1" name="pointAngle1" class="form-control" placeholder="">\
	                        </div>\
	                    </div>\
	                    <div class="form-group">\
		                    <label class="col-sm-2 control-label">位置1距离:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="pointDistance1" name="pointDistance1" type="text" class="form-control" placeholder="">\
		                    </div>\
	                        <label class="col-sm-2 control-label">位置2倾角:</label>\
							<div class="col-sm-3">\
		                    		<input type="text" id="pointAngle2" name="pointAngle2" type="text" class="form-control" placeholder="">\
		                    </div>\
	                    </div>\
	                    	<div class="form-group">\
		                    <label class="col-sm-2 control-label">位置2距离:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="pointDistance2" name="pointDistance2" type="text" class="form-control" placeholder="">\
		                    </div>\
		                    	<label class="col-sm-2 control-label">位置3倾角:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="pointAngle3" name="pointAngle3" type="text" class="form-control" placeholder="">\
		                    </div>\
	                    </div>\
	                    	<div class="form-group">\
		                    <label class="col-sm-2 control-label">位置3距离:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="pointDistance3" name="pointDistance3" type="text" class="form-control" placeholder="">\
		                    </div>\
		                    <label class="col-sm-2 control-label">位置4倾角:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="pointAngle4" name="pointAngle4" type="text" class="form-control" placeholder="">\
		                    </div>\
	                    </div>\
	                    <div class="form-group">\
		                    <label class="col-sm-2 control-label">位置4距离:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="pointDistance4" name="pointDistance4" type="text" class="form-control" placeholder="">\
		                    </div>\
	                    </div>\
                    </div>\
                </div>');
                
		area.find('#areaShape').attr("id", "areaShape" + "_" + index).attr("name", "areaShape" + "_" + index);
		area.find('#scaleFactor').attr("id", "scaleFactor" + "_" + index).attr("name", "scaleFactor" + "_" + index);
		area.find('#pointAngle1').attr("id", "pointAngle1" + "_" + index).attr("name", "pointAngle1" + "_" + index);
		area.find('#pointDistance1').attr("id", "pointDistance1" + "_" + index).attr("name", "pointDistance1" + "_" + index);
		area.find('#pointAngle2').attr("id", "pointAngle2" + "_" + index).attr("name", "pointAngle2" + "_" + index);
		area.find('#pointDistance2').attr("id", "pointDistance2" + "_" + index).attr("name", "pointDistance2" + "_" + index);
		area.find('#pointAngle3').attr("id", "pointAngle3" + "_" + index).attr("name", "pointAngle3" + "_" + index);
		area.find('#pointDistance3').attr("id", "pointDistance3" + "_" + index).attr("name", "pointDistance3" + "_" + index);
		area.find('#pointAngle4').attr("id", "pointAngle4" + "_" + index).attr("name", "pointAngle4" + "_" + index);
		area.find('#pointDistance4').attr("id", "pointDistance4" + "_" + index).attr("name", "pointDistance4" + "_" + index);
		
		area.find('div span:first').text(title);
		area.find('button:first').click(function(e) {
			$(e.target).parents(".panel:first").remove();
		});
		return area;
	}
	// 注册扇形区域的校验规则
	function registCheckForLine() {
		var index = $('#subAreaRow').find('.panel').length;
		$("#scaleFactor" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N2"},
					messages:{
					dataTypeCheck: "请录入2位以内的数字"
				}
		});
		$("#pointAngle1" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N3,1"},
					range: [0, 719],
					messages:{
					dataTypeCheck: "请录入3位整数1位小数以内的数字",
					range: "请录入0到719之间的整数"
				}
		});
		$("#pointDistance1" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N10"},
					range: [0, 1023],
					messages:{
					dataTypeCheck: "请录入10位以内的数字",
					range: "请录入0到1023之间的整数"
				}
		});
		$("#pointAngle2" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N3,1"},
					range: [0, 719],
					messages:{
					dataTypeCheck: "请录入3位整数1位小数以内的数字",
					range: "请录入0到719之间的整数"
				}
		});
		$("#pointDistance2" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N10"},
					range: [0, 1023],
					messages:{
					dataTypeCheck: "请录入10位以内的数字",
					range: "请录入0到1023之间的整数"
				}
		});
		$("#pointAngle3" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N3,1"},
					range: [0, 719],
					messages:{
					dataTypeCheck: "请录入3位整数1位小数以内的数字",
					range: "请录入0到719之间的整数"
				}
		});
		$("#pointDistance3" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N10"},
					range: [0, 1023],
					messages:{
					dataTypeCheck: "请录入10位以内的数字",
					range: "请录入0到1023之间的整数"
				}
		});
		$("#pointAngle4" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N3,1"},
					range: [0, 719],
					messages:{
					dataTypeCheck: "请录入3位整数1位小数以内的数字",
					range: "请录入0到719之间的整数"
				}
		});
		$("#pointDistance4" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N10"},
					range: [0, 1023],
					messages:{
					dataTypeCheck: "请录入10位以内的数字",
					range: "请录入0到1023之间的整数"
				}
		});
	}

	// 创建多边形区域
	function createPolygonArea(title) {
		var index = $('#subAreaRow').find('.panel').length + 1;
		var area = $('<div class="panel panel-default">\
                    <div class="panel-heading">\
                        <span>title</span>\
                        <button type="button" name="closeSubArea" style="float:right"><i class="fa fa-times"></i>\
                    </div>\
                    <div class="panel-body">\
	                    <div class="form-group">\
	                    		<input type="hidden" id="areaShape" name="areaShape" value="4"></input>\
		                    <label class="col-sm-2 control-label">比例因子:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="scaleFactor" name="scaleFactor" class="form-control" placeholder="">\
		                    </div>\
	                        <label class="col-sm-2 control-label">位置1倾角:</label>\
	                        <div class="col-sm-3">\
	                        		<input type="text" id="pointAngle1" name="pointAngle1" class="form-control" placeholder="">\
	                        </div>\
	                    </div>\
	                    <div class="form-group">\
		                    <label class="col-sm-2 control-label">位置1距离:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="pointDistance1" name="pointDistance1" type="text" class="form-control" placeholder="">\
		                    </div>\
	                        <label class="col-sm-2 control-label">位置2倾角:</label>\
							<div class="col-sm-3">\
		                    		<input type="text" id="pointAngle2" name="pointAngle2" type="text" class="form-control" placeholder="">\
		                    </div>\
	                    </div>\
	                    	<div class="form-group">\
		                    <label class="col-sm-2 control-label">位置2距离:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="pointDistance2" name="pointDistance2" type="text" class="form-control" placeholder="">\
		                    </div>\
		                    	<label class="col-sm-2 control-label">位置3倾角:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="pointAngle3" name="pointAngle3" type="text" class="form-control" placeholder="">\
		                    </div>\
	                    </div>\
	                    	<div class="form-group">\
		                    <label class="col-sm-2 control-label">位置3距离:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="pointDistance3" name="pointDistance3" type="text" class="form-control" placeholder="">\
		                    </div>\
		                    <label class="col-sm-2 control-label">位置4倾角:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="pointAngle4" name="pointAngle4" type="text" class="form-control" placeholder="">\
		                    </div>\
	                    </div>\
	                    <div class="form-group">\
		                    <label class="col-sm-2 control-label">位置4距离:</label>\
		                    <div class="col-sm-3">\
		                    		<input type="text" id="pointDistance4" name="pointDistance4" type="text" class="form-control" placeholder="">\
		                    </div>\
	                    </div>\
                    </div>\
                </div>');
                
		area.find('#areaShape').attr("id", "areaShape" + "_" + index).attr("name", "areaShape" + "_" + index);
		area.find('#scaleFactor').attr("id", "scaleFactor" + "_" + index).attr("name", "scaleFactor" + "_" + index);
		area.find('#pointAngle1').attr("id", "pointAngle1" + "_" + index).attr("name", "pointAngle1" + "_" + index);
		area.find('#pointDistance1').attr("id", "pointDistance1" + "_" + index).attr("name", "pointDistance1" + "_" + index);
		area.find('#pointAngle2').attr("id", "pointAngle2" + "_" + index).attr("name", "pointAngle2" + "_" + index);
		area.find('#pointDistance2').attr("id", "pointDistance2" + "_" + index).attr("name", "pointDistance2" + "_" + index);
		area.find('#pointAngle3').attr("id", "pointAngle3" + "_" + index).attr("name", "pointAngle3" + "_" + index);
		area.find('#pointDistance3').attr("id", "pointDistance3" + "_" + index).attr("name", "pointDistance3" + "_" + index);
		area.find('#pointAngle4').attr("id", "pointAngle4" + "_" + index).attr("name", "pointAngle4" + "_" + index);
		area.find('#pointDistance4').attr("id", "pointDistance4" + "_" + index).attr("name", "pointDistance4" + "_" + index);
		
		area.find('div span:first').text(title);
		area.find('button:first').click(function(e) {
			$(e.target).parents(".panel:first").remove();
		});
		return area;
	}
	// 注册多边形区域的校验规则
	function registCheckForPolygon() {
		var index = $('#subAreaRow').find('.panel').length;
		$("#scaleFactor" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N2"},
					messages:{
					dataTypeCheck: "请录入2位以内的数字"
				}
		});
		$("#pointAngle1" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N3,1"},
					range: [0, 719],
					messages:{
					dataTypeCheck: "请录入3位整数1位小数以内的数字",
					range: "请录入0到719之间的整数"
				}
		});
		$("#pointDistance1" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N10"},
					range: [0, 1023],
					messages:{
					dataTypeCheck: "请录入10位以内的数字",
					range: "请录入0到1023之间的整数"
				}
		});
		$("#pointAngle2" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N3,1"},
					range: [0, 719],
					messages:{
					dataTypeCheck: "请录入3位整数1位小数以内的数字",
					range: "请录入0到719之间的整数"
				}
		});
		$("#pointDistance2" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N10"},
					range: [0, 1023],
					messages:{
					dataTypeCheck: "请录入10位以内的数字",
					range: "请录入0到1023之间的整数"
				}
		});
		$("#pointAngle3" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N3,1"},
					range: [0, 719],
					messages:{
					dataTypeCheck: "请录入3位整数1位小数以内的数字",
					range: "请录入0到719之间的整数"
				}
		});
		$("#pointDistance3" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N10"},
					range: [0, 1023],
					messages:{
					dataTypeCheck: "请录入10位以内的数字",
					range: "请录入0到1023之间的整数"
				}
		});
		$("#pointAngle4" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N3,1"},
					range: [0, 719],
					messages:{
					dataTypeCheck: "请录入3位整数1位小数以内的数字",
					range: "请录入0到719之间的整数"
				}
		});
		$("#pointDistance4" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N10"},
					range: [0, 1023],
					messages:{
					dataTypeCheck: "请录入10位以内的数字",
					range: "请录入0到1023之间的整数"
				}
		});
	}

	// 创建关联文本区域
	function createTextArea(title) {
		var index = $('#subAreaRow').find('.panel').length + 1;
		var area = $('<div class="panel panel-default">\
                    <div class="panel-heading">\
                        <span>title</span>\
                        <button type="button" name="closeSubArea" style="float:right"><i class="fa fa-times"></i>\
                    </div>\
                    <div class="panel-body">\
	                    <div class="form-group">\
	                    		<input type="hidden" id="areaShape" name="areaShape" value="5"></input>\
		                    <label class="col-sm-2 control-label">文本:</label>\
		                    <div class="col-sm-3">\
		                    		<textarea id="text" name="text" rows="5" class="form-control" placeholder=""></textarea>\
		                    </div>\
	                    </div>\
                    </div>\
                </div>');
                
		area.find('#areaShape').attr("id", "areaShape" + "_" + index).attr("name", "areaShape" + "_" + index);
		area.find('#scaleFactor').attr("id", "scaleFactor" + "_" + index).attr("name", "scaleFactor" + "_" + index);
		area.find('#text').attr("id", "text" + "_" + index).attr("name", "text" + "_" + index);

		area.find('div span:first').text(title);
		area.find('button:first').click(function(e) {
			$(e.target).parents(".panel:first").remove();
		});
		return area;
	}
	// 注册多边形区域的校验规则
	function registCheckForText() {
		var index = $('#subAreaRow').find('.panel').length;
		$("#scaleFactor" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N2"},
					messages:{
					dataTypeCheck: "请录入2位以内的数字"
				}
		});
		$("#text" + "_" + index).rules("add",{
					maxlength : 84,
					messages:{
					maxlength: "请录入84位以内的内容"
				}
		});
		$("#pointDistance1" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N10"},
					range: [0, 1023],
					messages:{
					dataTypeCheck: "请录入10位以内的数字",
					range: "请录入0到1023之间的整数"
				}
		});
		$("#pointAngle2" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N3,1"},
					range: [0, 719],
					messages:{
					dataTypeCheck: "请录入3位整数1位小数以内的数字",
					range: "请录入0到719之间的整数"
				}
		});
		$("#pointDistance2" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N10"},
					range: [0, 1023],
					messages:{
					dataTypeCheck: "请录入10位以内的数字",
					range: "请录入0到1023之间的整数"
				}
		});
		$("#pointAngle3" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N3,1"},
					range: [0, 719],
					messages:{
					dataTypeCheck: "请录入3位整数1位小数以内的数字",
					range: "请录入0到719之间的整数"
				}
		});
		$("#pointDistance3" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N10"},
					range: [0, 1023],
					messages:{
					dataTypeCheck: "请录入10位以内的数字",
					range: "请录入0到1023之间的整数"
				}
		});
		$("#pointAngle4" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N3,1"},
					range: [0, 719],
					messages:{
					dataTypeCheck: "请录入3位整数1位小数以内的数字",
					range: "请录入0到719之间的整数"
				}
		});
		$("#pointDistance4" + "_" + index).rules("add",{
					dataTypeCheck : {dataType : "N10"},
					range: [0, 1023],
					messages:{
					dataTypeCheck: "请录入10位以内的数字",
					range: "请录入0到1023之间的整数"
				}
		});
	}

	// 注册子区域项目的校验规则
	function registCheckForSubArea(dataType) {
		switch (dataType) {
			case "0":
				registCheckForCircle();
				break;
			case "1":
				registCheckForRectangle();
				break;
			case "2":
				registCheckForFan();
				break;
			case "3":
				registCheckForLine();
				break;
			case "4":
				registCheckForPolygon();
				break;
			case "5":
				registCheckForText();
				break;
		}
	}
		
		//创建子区域
	function createArea(dataType) {
			var title = "";
			var subArea;
			switch (dataType) {
				case "0":
					title = "区域类型:0:圆形或点";
					subArea = createCircleArea(title);
					break;
				case "1":
					title = "区域类型:1:矩形";
					subArea = createRectangleArea(title);
					break;
				case "2":
					title = "区域类型:2:扇形";
					subArea = createFanArea(title);
					break;
				case "3":
					title = "区域类型:3:折线";
					subArea = createLineArea(title);
					break;
				case "4":
					title = "区域类型:4:多边形";
					subArea = createPolygonArea(title);
					break;
				case "5":
					title = "区域类型:5:关联文本";
					subArea = createTextArea(title);
					break;
			}


		subArea.find('div span:first').text(title);
		subArea.find('button:first').click(function(e) {
			$(e.target).parents(".panel:first").remove();
		});
		return subArea;
	}