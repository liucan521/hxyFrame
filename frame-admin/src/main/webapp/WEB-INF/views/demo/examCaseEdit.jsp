<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>请假详情</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@ include file="/WEB-INF/views/include/taglib.jsp" %>
    <%--<script src="${webRoot}/statics/js/jquery.min.js"></script>--%>

</head>
<body>
<div class="main-container" id="main-container">
    <form class="form-horizontal  bv-form" id="caseForm">
        <div style="display: none">
            <input id="caseId" name="caseId" value="${examCase.caseId}"/>
        </div>
        <div class="row">
            <div class="form-group col-xs-12 ">
                <label class="col-xs-3 control-label no-padding-right"><i class="red"> * </i>晋职考试推荐方案:</label>
                <div class="col-xs-9">
							<span class="col-xs-11 block input-icon input-icon-right">
								<input id="caseName" name="caseName" type="text" class="form-control"
                                       value="${examCase.caseName}"/>
							</span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-xs-12">
                <label class="col-xs-3 control-label no-padding-right">考试推荐规则设定:</label>
                <div class="col-xs-9">
							<span class="col-xs-11 block input-icon input-icon-right">
								<textarea id="caseContent" name="caseContent" class="form-control"
                                          rows="3">${examCase.caseContent}</textarea>
							</span>
                </div>
            </div>
        </div>
        <div class="row" style="margin-left: 40%;padding-bottom: 28px;margin-top: 25px;">
            <button class="layui-btn" type="button" id="submitBtn">筛 选</button>
            <a class="layui-btn layui-btn-normal" href="${webRoot}/demo/exam/list">返 回</a>
        </div>
    </form>
    <div class="row">
        <div class="col-xs-12">
            <div id="rrapp">
                <div class="grid-btn">
                    <center><h1>满足晋职考试推荐条件的人员信息列表</h1></center>
                    <%--<div class="form-group col-sm-3">--%>
                        <%--<input type="text" class="form-control" v-model="q.pName" @keyup.enter="query"--%>
                               <%--placeholder="表名">--%>
                    <%--</div>--%>
                    <%--<button class="layui-btn" id="searchSubmit" @click="query"><i class="layui-icon">&#xe615;</i>查 询--%>
                    <%--</button>--%>
                    <%--#if($shiro.hasPermission("sys:generator:code"))--%>
                    <%--<button class="layui-btn" @click="generator" @click="query"><i class="layui-icon">&#xe635;</i>生成代码</button>--%>
                    <%--#end--%>
                </div>
                <table id="jqGrid"></table>
                <div id="jqGridPager"></div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <button class="layui-btn layui-btn-small" type="button" onclick="nextSteep('exam','${examCase.caseId}')" style="position:fixed;right: 10px;bottom: 10px;">
                <i class="layui-icon"></i>下一步
            </button>
        </div>
    </div>

</div>
<script src="${webRoot}/statics/js/vue.min.js"></script>
<link rel="stylesheet" href="${webRoot}/statics/plugins/jqgrid/ui.jqgrid-bootstrap.css">
<script src="${webRoot}/statics/plugins/jqgrid/grid.locale-cn.js"></script>
<%--<script src="${webRoot}/statics/plugins/jqgrid/jquery.jqGrid.min.js"></script>--%>
<script src="${webRoot}/statics/js/common.js"></script>
<script src="${webRoot}/statics/js/demo/case.js"></script>
</body>
<script>
    //提交
    $("#submitBtn").click(function () {
        var url = "${webRoot}/demo/exam/edit";
        //console.log($("#caseForm").serialize());
        $.post(url, $("#caseForm").serialize(), function (result) {
            if (result.code == '0') {
                if ($("#caseId").val() == '') {
                    alert(result, function () {
                        <%--queryPersonExam("${webRoot}/sys/tperson/list");--%>
                        <%--location.href = '${webRoot}/demo/exam/list';--%>
                    }, function () {
                        $("#submitBtn").reset();
                    });
                } else {
                    //更新成功，返回List页面
                    toast(result.msg);
                    <%--queryPersonExam("${webRoot}/sys/tperson/list");--%>
                    <%--location.href = '${webRoot}/demo/exam/list';--%>
                }
            } else {
                alertMsg(result.msg);
            }

        });
    });
</script>
</html>