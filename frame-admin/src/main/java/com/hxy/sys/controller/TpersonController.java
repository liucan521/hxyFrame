package com.hxy.sys.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.hxy.sys.entity.TpersonEntity;
import com.hxy.sys.service.TpersonService;
import com.hxy.base.utils.PageUtils;
import com.hxy.base.utils.Query;
import com.hxy.base.utils.Result;


/**
 * 
 * 
 * @author hxy
 * @email huangxianyuan@gmail.com
 * @date 2018-08-04 14:56:52
 */
@Controller
@RequestMapping("/sys/tperson")
public class TpersonController{
	@Autowired
	private TpersonService tpersonService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
//	@RequiresPermissions("sys:person:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TpersonEntity> tpersonList = tpersonService.queryList(query);
		int total = tpersonService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tpersonList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{pId}")
	@RequiresPermissions("tperson:info")
	public Result info(@PathVariable("pId") String pId){
		TpersonEntity tperson = tpersonService.queryObject(pId);
		
		return Result.ok().put("tperson", tperson);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("tperson:save")
	public Result save(@RequestBody TpersonEntity tperson){
		tpersonService.save(tperson);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("tperson:update")
	public Result update(@RequestBody TpersonEntity tperson){
		tpersonService.update(tperson);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("tperson:delete")
	public Result delete(@RequestBody String[] pIds){
		tpersonService.deleteBatch(pIds);
		
		return Result.ok();
	}
	
}
