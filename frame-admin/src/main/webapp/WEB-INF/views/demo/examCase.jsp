<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>请假</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/views/include/taglib.jsp" %>
</head>

<body>
    <div class="main-container" id="main-container">
        <div class="row" style="margin-top: 20px;">
            <div class="col-md-12">
                <form class="layui-form" id="search-from" action="${webRoot}/demo/exam/list">
                    <div class="layui-form-item">
                        <label class="layui-form-label" style="width:6%;">方案名:</label>
                        <div class="layui-input-inline">
                            <input type="text" name="caseName" value="${examCase.caseName}"  placeholder="请输入方案名"  class="layui-input" >
                        </div>
                        <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索</button>
                        <button class="layui-btn layui-btn-warm" type="button" id="refresh">重 置</button>
                        <a class="layui-btn" href="${webRoot}/demo/exam/info"><i class="layui-icon">&#xe61f;</i> 新 增</a>
                    </div>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <table id="table-list" class="layui-table">
                    <thead>
                        <tr>
                            <th>序号</th>
                            <th>方案名</th>
                            <%--<th>发起人</th>--%>
                            <%--<th>方案内容</th>--%>
                            <th>审批结果</th>
                            <th>流程状态</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${page.result}" var="examCase" varStatus="i">
                            <tr id="leave_${examCase.caseId }">
                                <td>${i.index+1 }</td>
                                <td>${examCase.caseName}</td>
                                <%--<td>${examCase.userId}</td>--%>
                                <%--<td>${examCase.caseContent}</td>--%>

                                <td>${fns:getCodeName("act_result",examCase.actResult)}</td>
                                <td>${fns:getCodeName("act_process_status",examCase.status)}</td>
                                <td><fmt:formatDate value="${examCase.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td>
                                    <div class="btn-group ">
                                        <c:if test="${examCase.status == 1}">
                                            <a class="layui-btn layui-btn-small" href="${webRoot}/demo/exam/info?id=${examCase.caseId}" ><i class="layui-icon">&#xe642;</i>编辑</a>
                                            <button class="layui-btn layui-btn-small" type="button" onclick="flowSumbit('exam','${examCase.caseId}')"><i class="layui-icon">&#xe604;</i>提交</button>
                                            <button class="layui-btn layui-btn-danger layui-btn-small" type="button" onclick="deleteById('${examCase.caseId}')"><i class="layui-icon">&#xe640;</i>删除</button>
                                        </c:if>
                                        <c:if test="${(examCase.status == 2 || examCase.status == 3) && examCase.actResult !=2}">
                                            <button class="layui-btn layui-btn-small" type="button" onclick="doTaskTab_('${examCase.actKey}','${examCase.caseId}','${examCase.instanceId}','${examCase.taskId}','${examCase.defid}','${examCase.nodeType}','${examCase.url}')"><i class="layui-icon">&#xe60a;</i>继续办理</button>
                                            <%--<button class="layui-btn layui-btn-small" type="button" onclick="doTaskTab('exam','${examCase.caseId}','${examCase.instanceId}')"><i class="layui-icon">&#xe705;</i>审批记录</button>--%>
                                            <button class="layui-btn layui-btn-small layui-btn-warm" type="button" onclick="showFlowImg('${examCase.instanceId}')"><i class="layui-icon">&#xe60d;</i>查看流程图</button>
                                        </c:if>
                                        <c:if test="${(examCase.status == 2 || examCase.status == 3) && examCase.actResult == 2}">
                                            <a class="layui-btn layui-btn-small" href="${webRoot}/demo/exam/info?id=${examCase.caseId}" ><i class="layui-icon">&#xe642;</i>编辑</a>
                                            <button class="layui-btn layui-btn-small" type="button" onclick="flowSumbit('exam','${examCase.caseId}')"><i class="layui-icon">&#xe604;</i>提交</button>
                                            <%--<button class="layui-btn layui-btn-small" type="button" onclick="doTaskTab('exam','${examCase.caseId}','${examCase.instanceId}')"><i class="layui-icon">&#xe705;</i>审批记录</button>--%>
                                            <button class="layui-btn layui-btn-small layui-btn-warm" type="button" onclick="showFlowImg('${examCase.instanceId}')"><i class="layui-icon">&#xe60d;</i>查看流程图</button>
                                        </c:if>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <sys:page page="${page}"></sys:page>
            </div>

        </div>
    </div>
</body>
<script src="${webRoot}/statics/js/activiti/actSumbit.js"></script>
<script>

    function deleteById(id) {
        var url ="${webRoot}/demo/exam/delete";
        confirm('确定要删除选中的记录？', function(){
            $.post(url,"id="+id,function (r) {
                if(r.code=='0'){
                    toast(r.msg);
                    $("#leave_"+id+"").remove();
                }else {
                    alertMsg(r.msg);
                }
            });
        });
    }
</script>

</html>