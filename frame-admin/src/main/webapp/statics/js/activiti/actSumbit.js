function flowSumbit(actKey,busId) {
    var url=webRoot+"/act/deal/queryFlowsByActKey?actKey="+actKey+"&busId="+busId;
    //弹框层
    layer.open({
        scrollbar: false,
        type: 2,
        title : ["流程提交" , true],
        area: ['70%', '70%'], //宽高
        content: [url,'yes'],
        shadeClose : false,
    });
}
/**
 * 查看流程图片
 */
function showFlowImg(instanceId) {
    var url=webRoot+"/act/deal/showFlowImg?processInstanceId="+instanceId+"&r="+new Date().getTime();
    var html ="<img src ='"+url+"'/>";
    //弹框层
    layer.open({
        type: 1,
        area: ['70%', '70%'], //宽高
        content: html,
        title:['查看流程图',true],
        shadeClose: true, //开启遮罩关闭
    });
}
/**
 * 办理业务
 */
function doTaskTab_(actKey,busId,instanceId,taskId,defid,nodeType,url) {

    var url=webRoot+"/act/deal/flowInfoTab1?flag=2&actKey="+actKey+"&busId="+busId+"&instanceId="+instanceId+"&taskId="+taskId+"&defId="+defid+"&nodeType="+nodeType+"&url="+url ;
    console.log(url);
    //弹框层
    layer.open({
        //scrollbar: false,
        //type: 2,
        title : ["办理任务" , true],
        // area: ['90%', '90%'], //宽高
        // content: ['yes'],
        //shadeClose : false,
        content: '跳转至上次办理页面',
        skin: 'msg',
        time: 1000,//2秒后自动关闭
        end: function () {
            window.location.href=url;
        }
    });
}
/**
 * 审批记录
 */
function doTaskTab(actKey,busId,instanceId) {
    var url=webRoot+"/act/deal/flowInfoTab?flag=1&actKey="+actKey+"&busId="+busId+"&instanceId="+instanceId;
    //弹框层
    layer.open({
        scrollbar: true,
        type: 2,
        title : ["审批记录" , true],
        area: ['90%', '90%'], //宽高
        content: [url,'yes'],
        shadeClose : false,
    });
}