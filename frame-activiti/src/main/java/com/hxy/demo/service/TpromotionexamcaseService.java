package com.hxy.demo.service;

import com.hxy.base.page.Page;
import com.hxy.demo.entity.LeaveEntity;
import com.hxy.demo.entity.TpromotionexamcaseEntity;


import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author hxy
 * @email huangxianyuan@gmail.com
 * @date 2018-08-04 14:56:52
 */
public interface TpromotionexamcaseService {
	
	TpromotionexamcaseEntity queryObject(String caseId);
	
	List<TpromotionexamcaseEntity> queryList(Map<String, Object> map);

    List<TpromotionexamcaseEntity> queryListByBean(TpromotionexamcaseEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(TpromotionexamcaseEntity tpromotionexamcase);
	
	int update(TpromotionexamcaseEntity tpromotionexamcase);
	
	int delete(String caseId);
	
	int deleteBatch(String[] caseIds);

	Page<TpromotionexamcaseEntity> findPage(TpromotionexamcaseEntity tpromotionexamcaseEntity, int pageNum);
}
