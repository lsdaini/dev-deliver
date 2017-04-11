package net.luis.common.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @CreateTime：2017年3月28日 下午4:47:06
 * @Author sai.liu
 * @ProjectPackage：net.luis.base.dao.RowMapper.java @Description：
 */

public interface RowMapper {
	public abstract Object mapRow(ResultSet paramResultSet, int paramInt) throws SQLException;
}
