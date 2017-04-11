<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/common/common.jsp"%>
<TITLE>Welcome Page</TITLE>
<body>
	<div class="view">
		<a id="myModalLink" href="#myModalContainer" role="button" class="btn"
			data-toggle="modal">触发遮罩窗体</a>
		<div class="modal fade" id="myModalContainer" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel" contenteditable="true">标题</h4>
					</div>
					<div class="modal-body" contenteditable="true">内容...</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal"
							contenteditable="true">关闭</button>
						<button type="button" class="btn btn-primary"
							contenteditable="true">保存</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>