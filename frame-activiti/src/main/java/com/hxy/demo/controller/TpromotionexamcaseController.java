package com.hxy.demo.controller;


import com.hxy.base.page.Page;
import com.hxy.base.utils.StringUtils;
import com.hxy.base.utils.Utils;
import com.hxy.demo.entity.LeaveEntity;
import com.hxy.demo.entity.TpromotionexamcaseEntity;
import com.hxy.demo.service.TpromotionexamcaseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hxy.base.utils.Result;

import javax.servlet.http.HttpServletRequest;


/**
 * @author hxy
 * @email huangxianyuan@gmail.com
 * @date 2018-08-04 14:56:52
 */
@Controller
@RequestMapping("demo/exam")
public class TpromotionexamcaseController {
    @Autowired
    private TpromotionexamcaseService tpromotionexamcaseService;

    /**
     * 列表
     */
    @RequestMapping("list")
    @RequiresPermissions("act:model:all")
    public String list(Model model, TpromotionexamcaseEntity tpromotionexamcaseEntity, HttpServletRequest request) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page<TpromotionexamcaseEntity> page = tpromotionexamcaseService.findPage(tpromotionexamcaseEntity, pageNum);
        model.addAttribute("page", page);
        model.addAttribute("examCase", tpromotionexamcaseEntity);
        return "demo/examCase.jsp";
    }


    /**
     * 信息
     */
    @RequestMapping("info")
    @RequiresPermissions("act:model:all")
    public String info(Model model, String id, HttpServletRequest request) {
        if (!StringUtils.isEmpty(id)) {
            TpromotionexamcaseEntity tpromotionexamcaseEntity = tpromotionexamcaseService.queryObject(id);
            model.addAttribute("examCase", tpromotionexamcaseEntity);
        }
        return "demo/examCaseEdit.jsp";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @RequiresPermissions("act:model:all")
    @ResponseBody
    public Result edit(TpromotionexamcaseEntity tpromotionexamcaseEntity) {
        int i = 0;
//        TpromotionexamcaseEntity tpromotionexamcaseEntity = new TpromotionexamcaseEntity();
//        tpromotionexamcaseEntity.setCaseId(request.getParameter("caseId"));
//        tpromotionexamcaseEntity.setCaseName(request.getParameter("caseName"));
//        tpromotionexamcaseEntity.setCaseContent(request.getParameter("caseContent"));
        if (StringUtils.isEmpty(tpromotionexamcaseEntity.getCaseId())) {
            i = tpromotionexamcaseService.save(tpromotionexamcaseEntity);
        } else {
            i = tpromotionexamcaseService.update(tpromotionexamcaseEntity);
        }
        if (i > 0) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    /**
     * 删除
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @RequiresPermissions("act:model:all")
    @ResponseBody
    public Result delete(String id) {
        if (tpromotionexamcaseService.delete(id) < 1) {
            return Result.error("删除晋职考试推荐方案失败");
        }
        return Result.ok("删除晋职考试推荐方案成功");
    }

}
