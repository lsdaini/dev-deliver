package net.luis.common.utils.dialect;

import org.hibernate.dialect.SQLServer2012Dialect;

public class SQLServerDialect extends SQLServer2012Dialect {
	public SQLServerDialect() {
		registerColumnType(12, "nvarchar($l)");
		registerColumnType(2005, "nvarchar(max)");
	}
}
