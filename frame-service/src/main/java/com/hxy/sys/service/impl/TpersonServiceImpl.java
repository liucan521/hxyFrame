package com.hxy.sys.service.impl;

import com.hxy.base.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hxy.sys.dao.TpersonDao;
import com.hxy.sys.entity.TpersonEntity;
import com.hxy.sys.service.TpersonService;



@Service("tpersonService")
public class TpersonServiceImpl implements TpersonService {
	@Autowired
	private TpersonDao tpersonDao;
	
	@Override
	public TpersonEntity queryObject(String pId){
		return tpersonDao.queryObject(pId);
	}
	
	@Override
	public List<TpersonEntity> queryList(Map<String, Object> map){
		return tpersonDao.queryList(map);
	}

    @Override
    public List<TpersonEntity> queryListByBean(TpersonEntity entity) {
        return tpersonDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tpersonDao.queryTotal(map);
	}
	
	@Override
	public int save(TpersonEntity tperson){
	    tperson.setPId(Utils.uuid());
		return tpersonDao.save(tperson);
	}
	
	@Override
	public int update(TpersonEntity tperson){
        return tpersonDao.update(tperson);
	}
	
	@Override
	public int delete(String pId){
        return tpersonDao.delete(pId);
	}
	
	@Override
	public int deleteBatch(String[] pIds){
        return tpersonDao.deleteBatch(pIds);
	}
	
}
