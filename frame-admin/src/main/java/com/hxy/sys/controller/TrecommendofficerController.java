package com.hxy.sys.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hxy.sys.entity.TrecommendofficerEntity;
import com.hxy.sys.service.TrecommendofficerService;
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
@RestController
@RequestMapping("trecommendofficer")
public class TrecommendofficerController extends BaseController{
	@Autowired
	private TrecommendofficerService trecommendofficerService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("trecommendofficer:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TrecommendofficerEntity> trecommendofficerList = trecommendofficerService.queryList(query);
		int total = trecommendofficerService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(trecommendofficerList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("trecommendofficer:info")
	public Result info(@PathVariable("id") String id){
		TrecommendofficerEntity trecommendofficer = trecommendofficerService.queryObject(id);
		
		return Result.ok().put("trecommendofficer", trecommendofficer);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("trecommendofficer:save")
	public Result save(@RequestBody TrecommendofficerEntity trecommendofficer){
		trecommendofficerService.save(trecommendofficer);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("trecommendofficer:update")
	public Result update(@RequestBody TrecommendofficerEntity trecommendofficer){
		trecommendofficerService.update(trecommendofficer);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("trecommendofficer:delete")
	public Result delete(@RequestBody String[] ids){
		trecommendofficerService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
