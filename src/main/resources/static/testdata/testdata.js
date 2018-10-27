var testdata = {
	"items" : [
		{
			"type":"text",
			"label":"经度:",
			"id":"txtItm",
			"placeholder":"请录入-180到181之间的值"
		},
		{
			"type":"popupSelect",
			"label":"纬度:",
			"id":"popselItm",
			"placeholder":"请选择纬度",
			"modelId":"#myModal"
		},
		{
			"type":"select",
			"label":"位置精度:",
			"id":"selItm",
			"vals":[{"":""},{"0":"低"},{"1":"高"}]
		},
		{
			"type":"selectPicker",
			"label":"模糊查询下拉:",
			"id":"selpickerItm",
			"placeholder":"请选择值",
			"vals":[{"":""},{"0":"低123123"},{"1":"高567567"}]
		}
	],
	"subArea" : {
			"label":"子区域:",
			"modelId":"#myArea"
	}
}
