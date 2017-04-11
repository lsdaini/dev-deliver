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