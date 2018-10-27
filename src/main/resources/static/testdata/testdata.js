var testdata = {
	"items" : [
		{
			"type":"text",
			"label":"经度:",
			"id":"txtItm1",
			"placeholder":"非空，最小长度2",
			"val":"109.66",
			"disabled":null
		},
		{
			"type":"text",
			"label":"文本2:",
			"id":"txtItm2",
			"placeholder":"非空，最大长度5",
			"val":"",
			"disabled":null
		},
		{
			"type":"text",
			"label":"文本3:",
			"id":"txtItm3",
			"placeholder":"数字",
			"val":"",
			"disabled":null
		},
		{
			"type":"text",
			"label":"文本4:",
			"id":"txtItm4",
			"placeholder":"正则表达式电话号码",
			"val":"",
			"disabled":null
		},
		{
			"type":"popupSelect",
			"label":"纬度:",
			"id":"popselItm",
			"placeholder":"请选择纬度",
			"modelId":"#myModal",
			"val":"Larry",
			"disabled":null
		},
		{
			"type":"select",
			"label":"位置精度:",
			"id":"selItm",
			"vals":[{"":""},{"0":"低"},{"1":"高"}],
			"val":"",
			"disabled":true
		},
		{
			"type":"selectPicker",
			"label":"模糊查询下拉:",
			"id":"selpickerItm",
			"placeholder":"请选择值",
			"val":"1",
			"vals":[{"":""},{"0":"低123123"},{"1":"高567567"}]
		}
	],
	"subArea" : {
			"label":"子区域:",
			"modelId":"#myArea"
	},
	"checkRules": {
			txtItm1: {
				required: true,
				minlength: 2
			},
			txtItm2: {
				required: true,
				maxlength: 5
			},
			txtItm3: {
				number: true,
				dataTypeCheck : {dataType : "N4,3"}
			},
			txtItm4: {
				checkReg:{reg : "^(((13[0-9]{1})|(15[0-9]{1}))+\\d{8})$"}
			}
	},
	"checkMessages": {
			txtItm1: {
				required: "",
				minlength: "最少录入2位"
			},
			txtItm2: {
				required: "",
				maxlength: "最多录入5位"
			},
			txtItm3: {
				number: "请录入数字",
				dataTypeCheck:"请录入整数4位小数3位以内的数字"
			},
			txtItm4: {
				checkReg: "请录入电话号码"
			},
	},
	"events":[
			{
				"id":"txtItm1",
				"eventType":"blur",
				"method":"itemTxtLostFouse"
			}
		]
	
}
