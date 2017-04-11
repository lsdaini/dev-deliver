package net.luis.common.utils.dialect;

import org.hibernate.dialect.MySQLInnoDBDialect;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.StringType;

public class MySQLDialect extends MySQLInnoDBDialect {
	public MySQLDialect() {
		registerHibernateType(3, new BigDecimalType().getName());
		registerHibernateType(-1, new StringType().getName());
		registerHibernateType(-2, new StringType().getName());
		registerHibernateType(-1, new StringType().getName());
	}
}