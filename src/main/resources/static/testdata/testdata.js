var testdata = {
	"title":"abcd",
	"items" : [
		{
			"type":"text",
			"label":"经度:",
			"id":"txtItm1",
			"placeholder":"非空，最小长度2",
			"val":"109.66",
			"disabled":true
		},
		{
			"type":"textarea",
			"label":"文本2:",
			"id":"txtItm2",
			"placeholder":"非空，最大长度5",
			"val":"aaaaaa",
			"disabled":true
		},
		{
			"type":"blank"
		},
		{
			"type":"text",
			"label":"文本3:",
			"id":"txtItm3",
			"placeholder":"数字",
			"val":"aaa",
			"disabled":true
		},
		{
			"type":"textarea",
			"label":"文本4:",
			"id":"txtItm4",
			"placeholder":"正则表达式电话号码",
			"val":"",
			"disabled":true
		},
		{
			"type":"popupSelect",
			"label":"纬度:",
			"id":"popselItm",
			"placeholder":"请选择纬度",
			"modelId":"#myModal",
			"val":"Larry",
			"disabled":true
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
			"vals":[{"":""},{"0":"低123123"},{"1":"高567567"}],
			"disabled":true
		}
	],
	"subArea" : {
			"label":"子区域:",
			"modelId":"#myArea",
			"disabled":true
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
		],
	"subAreaData":[
		{
			"type":"0",
			"scaleFactor":20,
			"longitude":-90
		},
		{
			"type":"0",
			"scaleFactor":10,
			"longitude":160,
			"precision":4
		},
		{
			"type":"1",
			"scaleFactor":10,
			"latitude":-45,
			"dimensionE":211
		}
		,
		{
			"type":"5",
			"text":"aadfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdf"
		}
	]
}


var menuData = [
		{
			"menuCode":"aa",
			"menuName":"历史数据",
			"url":"history.html"
		},
		{
			"menuCode":"aa",
			"menuName":"菜单1",
			"subMenu" :[
				{
					"menuCode":"bb",
					"menuName":"子菜单1",
					"url":"index.html",
				},
				{
					"menuCode":"cc",
					"menuName":"子菜单2",
					"url":"blank.html",
				}
			]
		}
	]

var tableData = {
	columns:[
	    { data: 'engine', title : 'engine' },
        { data: 'browser', title: 'browser' },
        { data: 'platform', title: 'platform' },
        { data: 'version', title: 'version' },
        { data: 'grade', title: 'grade' }
	],
	datas:[
		{
			engine : "aaaa",
			browser : "bbbb",
			platform : "cccc",
			version : "dddd",
			grade : "eeee"
		},
		{	
			engine : "aaaa",
			browser : "bbbb",
			platform : "cccc",
			version : "dddd",
			grade : "eeee"
		}
	]
}
