package com.hxy.demo.service.impl;

import com.hxy.base.common.Constant;
import com.hxy.base.exception.MyException;
import com.hxy.base.page.Page;
import com.hxy.base.page.PageHelper;
import com.hxy.base.utils.StringUtils;
import com.hxy.base.utils.Utils;
import com.hxy.demo.dao.TpromotionexamcaseDao;
import com.hxy.demo.entity.LeaveEntity;
import com.hxy.demo.entity.TpromotionexamcaseEntity;
import com.hxy.demo.service.TpromotionexamcaseService;
import com.hxy.sys.entity.UserEntity;
import com.hxy.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;




@Service("tpromotionexamcaseService")
public class TpromotionexamcaseServiceImpl implements TpromotionexamcaseService {
	@Autowired
	private TpromotionexamcaseDao tpromotionexamcaseDao;
	
	@Override
	public TpromotionexamcaseEntity queryObject(String caseId){
		if(StringUtils.isEmpty(caseId)){
			new MyException("id不为空!");
		}

		return tpromotionexamcaseDao.queryObject(caseId);
	}
	
	@Override
	public List<TpromotionexamcaseEntity> queryList(Map<String, Object> map){
		return tpromotionexamcaseDao.queryList(map);
	}

    @Override
    public List<TpromotionexamcaseEntity> queryListByBean(TpromotionexamcaseEntity entity) {
        return tpromotionexamcaseDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tpromotionexamcaseDao.queryTotal(map);
	}
	
	@Override
	public int save(TpromotionexamcaseEntity tpromotionexamcase){
	    tpromotionexamcase.setCaseId(Utils.uuid());
		UserEntity currentUser = UserUtils.getCurrentUser();
		tpromotionexamcase.setCode(Utils.getCode("D"));
		tpromotionexamcase.setStatus(Constant.ActStauts.DRAFT.getValue());
		tpromotionexamcase.setCreateId(currentUser.getId());
		tpromotionexamcase.setCreateTime(new Date());
		tpromotionexamcase.setStatus(Constant.ActStauts.DRAFT.getValue());
		tpromotionexamcase.setUserId(UserUtils.getCurrentUserId());
		tpromotionexamcase.setBapid(currentUser.getBapid());
		tpromotionexamcase.setBaid(currentUser.getBaid());

		int i = tpromotionexamcaseDao.save(tpromotionexamcase);
		return i;
	}
	
	@Override
	public int update(TpromotionexamcaseEntity tpromotionexamcase){
		if(StringUtils.isEmpty(tpromotionexamcase.getCaseId())){
			throw new MyException("请假id不能为空");
		}
        return tpromotionexamcaseDao.update(tpromotionexamcase);
	}
	
	@Override
	public int delete(String caseId){
		if(StringUtils.isEmpty(caseId)){
			throw new MyException("请假id不能为空");
		}
        return tpromotionexamcaseDao.delete(caseId);
	}
	
	@Override
	public int deleteBatch(String[] caseIds){
        return tpromotionexamcaseDao.deleteBatch(caseIds);
	}
	@Override
	public Page<TpromotionexamcaseEntity> findPage(TpromotionexamcaseEntity tpromotionexamcaseEntity, int pageNum) {
		PageHelper.startPage(pageNum, Constant.pageSize);
		tpromotionexamcaseDao.queryList(tpromotionexamcaseEntity);
		return PageHelper.endPage();
	}
}
