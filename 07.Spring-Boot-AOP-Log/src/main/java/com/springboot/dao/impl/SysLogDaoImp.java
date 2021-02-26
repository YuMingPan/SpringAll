package com.springboot.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.dao.SysLogDao;
import com.springboot.domain.SysLog;

@Repository
public class SysLogDaoImp implements SysLogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveSysLog(SysLog syslog) {
		StringBuffer sql = new StringBuffer("insert into sys_log ");
		// 主键已设置自增的情况下
		sql.append("(username,operation,time,method,params,ip,create_time) ");
		sql.append("values(:username,:operation,:time,:method,");
		sql.append(":params,:ip,:createTime)");

		NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
		npjt.update(sql.toString(), new BeanPropertySqlParameterSource(syslog));
	}

}
