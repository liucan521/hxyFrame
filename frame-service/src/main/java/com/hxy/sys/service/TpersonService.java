package com.hxy.sys.service;

import com.hxy.sys.entity.TpersonEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author hxy
 * @email huangxianyuan@gmail.com
 * @date 2018-08-04 14:56:52
 */
public interface TpersonService {
	
	TpersonEntity queryObject(String pId);
	
	List<TpersonEntity> queryList(Map<String, Object> map);

    List<TpersonEntity> queryListByBean(TpersonEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(TpersonEntity tperson);
	
	int update(TpersonEntity tperson);
	
	int delete(String pId);
	
	int deleteBatch(String[] pIds);
}
