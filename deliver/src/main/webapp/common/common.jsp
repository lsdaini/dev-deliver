<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" CONTENT="no-cache">
<meta http-equiv="Pragma" CONTENT="no-cache">
<LINK title="default" rel="stylesheet" type="text/css" href="${basePath}/resources/css/common.css">
<LINK title="default" rel="stylesheet" type="text/css" href="${basePath}/resources/javascript/jquery-autocomplete/jquery.autocomplete.css"/>
<LINK title="default" rel="stylesheet" type="text/css" href="${basePath}/resources/bootstrap-3.3.5/css/bootstrap.min.css"/>
<LINK title="default" rel="stylesheet" type="text/css" href="${basePath}/resources/css/font-awesome-3.2.1/css/font-awesome.min.css"/>
<LINK title="default" rel="stylesheet" type="text/css" href="${basePath}/resources/javascript/layui-1.0.9/css/layui.css">

<script type="text/javascript" src="${basePath}/resources/javascript/common.js"></script>
<script type="text/javascript" src="${basePath}/resources/javascript/jquery-3.0.0/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="${basePath}/resources/javascript/jquery-autocomplete/jquery.autocomplete.js"></script>
<script type="text/javascript" src="${basePath}/resources/javascript/jquery-autocomplete/jquery.autocomplete.min.js"></script>
<script type="text/javascript" src="${basePath}/resources/javascript/jquery-autocomplete/jquery.autocomplete.pack.js"></script>
<script type="text/javascript" src="${basePath}/resources/bootstrap-3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript" src="${basePath}/resources/javascript/layui-1.0.9/layui.js"></script>

<script type="text/javascript">
function queryTerms(url){
	var paramObjs = '';
	var allTags = document.getElementsByTagName("INPUT");
	paramObjs += pubTags(allTags);
	var allTags = document.getElementsByTagName("SELECT");
	paramObjs += pubTags(allTags);
	paramObjs += "pageSize:${page.pageSize}"+"|";
	paramObjs += "pageNo:${page.pageNo}";
	$("#paramObjs").val(paramObjs);
	$("#queryForm").attr("action",url);
	$("#queryForm").submit();	
}

function queryTermsByForm(url,formName){
	var paramObjs = '';
	var allTags = document.getElementsByTagName("INPUT");
	paramObjs += pubTags(allTags);
	var allTags = document.getElementsByTagName("SELECT");
	paramObjs += pubTags(allTags);
	paramObjs += "pageSize:${page.pageSize}"+"|";
	paramObjs += "pageNo:${page.pageNo}";
	$("#paramObjs").val(paramObjs);
	$("#"+formName).attr("action",url);
	$("#"+formName).submit();	
}

function pubTags(allTags) {
	var paramObjs = '';
	for(var i = 0; i < allTags.length; i++) {
		if(allTags[i] && allTags[i].id != '') {
			if(allTags[i].id != 'paramObjs') {
				var id = allTags[i].id;
				var value = $("#"+id).val();
				paramObjs+=id+":"+value+"|";
			}
		}
	}
	return paramObjs;
}
function queryPage(){
	var paramObjs = '${paramObjs}';
	var pageNo = '';
	if(paramObjs != '') {
		var paramObj = paramObjs.split("|");
		for(var i = 0; i < paramObj.length; i++) {
			var name = paramObj[i].split(":")[0];
			var value = paramObj[i].split(":")[1];
			var obj = document.getElementById(name);
			if(obj) {
				obj.value = value;
			}
			if(name == 'pageNo') {
				pageNo = value;
			}
		}
		pageURL('','',pageNo);
	}else {
		pageURL('','','1');
	}
}
function queryPage(level){
	var paramObjs = '${paramObjs}';
	var pageNo = '';
	if(paramObjs != '') {
		var paramObj = paramObjs.split("|");
		for(var i = 0; i < paramObj.length; i++) {
			var name = paramObj[i].split(":")[0];
			var value = paramObj[i].split(":")[1];
			var obj = document.getElementById(name);
			if(obj) {
				obj.value = value;
			}
			if(name == 'pageNo') {
				pageNo = value;
			}
		}
		if('levelOne' == level){
			pageURL('','',pageNo);
		} else
			pageURL('','','1');
	}else {
		pageURL('','','1');
	}
}
//使用“paramObjs”参数中文乱码问题的处理
function handleAction(url){
	var $form = $("<form>");
	$form.attr({"method":"post", "action":url});
	$form.append("<input type='hidden' name='paramObjs' value='${paramObjs}' />");
	$("body").append($form);
	$form.submit();
}

function showMsg(str,callback){
	if(!!callback){
		layer.confirm(str, {
			skin: 'layui-layer-lan',
			anim: 4 //动画类型
			  ,btn: ['确认'] //按钮
			}, callback);
	}else{
		layer.alert(str, {
		    skin: 'layui-layer-lan'
		    ,closeBtn: 0
		    ,anim: 4 //动画类型
		    ,time:-1
		  });
	}
}
/**
 * target id or elm
 */
function showTips(target,str){
	if(typeof target==="string"){
		target = "#"+target;
	}
	layer.tips(str,target,{
		tips:[3,'#ff0000'],
		time:5000
	});
	$(target).focus();
}
</script>