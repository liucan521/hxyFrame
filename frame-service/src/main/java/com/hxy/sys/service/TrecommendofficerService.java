package com.hxy.sys.service;

import com.hxy.sys.entity.TrecommendofficerEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author hxy
 * @email huangxianyuan@gmail.com
 * @date 2018-08-04 14:56:52
 */
public interface TrecommendofficerService {
	
	TrecommendofficerEntity queryObject(String id);
	
	List<TrecommendofficerEntity> queryList(Map<String, Object> map);

    List<TrecommendofficerEntity> queryListByBean(TrecommendofficerEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(TrecommendofficerEntity trecommendofficer);
	
	int update(TrecommendofficerEntity trecommendofficer);
	
	int delete(String id);
	
	int deleteBatch(String[] ids);
}
