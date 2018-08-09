function queryPersonExam(urlObj){
    $("#jqGrid").jqGrid({
        url: urlObj,
        datatype: "json",
        colModel: [
			{ label: '姓名', name: 'name', width: 100},
			{ label: '身份证号', name: 'card', width: 70},
			{ label: '出生地', name: 'birthplace', width: 100},
			{ label: '学历', name: 'education', width: 100}
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50,100,200],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
};

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			name: null
		}
	},
	methods: {
		query: function () {
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'name': vm.q.pName},
                page:1
            }).trigger("reloadGrid");
		}
		// generator: function() {
		// 	var tableNames = getSelectedRows();
		// 	if(tableNames == null){
		// 		return ;
		// 	}
		// 	console.log(tableNames);
		// 	window.location.href = '../sys/generator/code?tables='+ tableNames;
		// }
	}
});

