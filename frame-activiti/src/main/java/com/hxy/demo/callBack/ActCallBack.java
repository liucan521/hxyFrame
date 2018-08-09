package com.hxy.demo.callBack;

import com.hxy.activiti.dto.ProcessTaskDto;
import org.springframework.stereotype.Component;

/**
 * 类的功能描述.
 *
 * @Auther hxy
 * @Date 2017/7/27
 */
@Component
public class ActCallBack {

    public String leaveBack(ProcessTaskDto processTaskDto){
        System.out.println("请假回调成功啦！！！！！！！");
        System.out.println(processTaskDto.getTaskId());
        return "act/deal/myUpcoming";
    }
}
