package com.hxy.sys.service.impl;

import com.hxy.base.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hxy.sys.dao.TrecommendofficerDao;
import com.hxy.sys.entity.TrecommendofficerEntity;
import com.hxy.sys.service.TrecommendofficerService;



@Service("trecommendofficerService")
public class TrecommendofficerServiceImpl implements TrecommendofficerService {
	@Autowired
	private TrecommendofficerDao trecommendofficerDao;
	
	@Override
	public TrecommendofficerEntity queryObject(String id){
		return trecommendofficerDao.queryObject(id);
	}
	
	@Override
	public List<TrecommendofficerEntity> queryList(Map<String, Object> map){
		return trecommendofficerDao.queryList(map);
	}

    @Override
    public List<TrecommendofficerEntity> queryListByBean(TrecommendofficerEntity entity) {
        return trecommendofficerDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return trecommendofficerDao.queryTotal(map);
	}
	
	@Override
	public int save(TrecommendofficerEntity trecommendofficer){
	    trecommendofficer.setId(Utils.uuid());
		return trecommendofficerDao.save(trecommendofficer);
	}
	
	@Override
	public int update(TrecommendofficerEntity trecommendofficer){
        return trecommendofficerDao.update(trecommendofficer);
	}
	
	@Override
	public int delete(String id){
        return trecommendofficerDao.delete(id);
	}
	
	@Override
	public int deleteBatch(String[] ids){
        return trecommendofficerDao.deleteBatch(ids);
	}
	
}
