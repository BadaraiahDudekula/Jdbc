<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:tx="http://www.springframework.org/schema/tx"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd
        http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx-3.0.xsd">


	<bean id="dataSource"
		class="org.apache.commons.dbcp.BasicDataSource">
		<property name="driverClassName"
			value="com.mysql.cj.jdbc.Driver"></property>
		<property name="url"
			value="jdbc:mysql://localhost:3306/spring_orm1?createDatabaseIfNotExist=true"></property>
		<property name="username" value="root"></property>
		<property name="password" value="admin"></property>
	</bean>

	<bean id="sessionFactory"
		class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
		<property name="dataSource" ref="dataSource"></property>

		<property name="hibernateProperties">
			<props>
				<prop key="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</prop>
				<prop key="hibernate.hbm2ddl.auto">update</prop>
				<prop key="hibernate.show_sql">true</prop>
				<prop key="hibernate.format_sql">true</prop>

			</props>
		</property>

		<!-- Information about template classes -->
		<property name="packagesToScan">
			<list>
				<value>org.jsp.hibtemplate.dto</value>
			</list>
		</property>
	</bean>

	<bean id="hibernateTemplate"
		class="org.springframework.orm.hibernate5.HibernateTemplate">
		<property name="sessionFactory" ref="sessionFactory"></property>
		<property name="checkWriteOperations" value="false"></property>
	</bean>


	<tx:annotation-driven />
	<bean id="transactionManager"
		class="org.springframework.orm.hibernate5.HibernateTransactionManager">
		<property name="sessionFactory" ref="sessionFactory" />
	</bean>

	<bean id="dao" class="org.jsp.hibtemplate.dao.DepartmentDao">
		<property name="template" ref="hibernateTemplate"></property>
	</bean>
	<bean id="dao1" class="org.jsp.hibtemplate.dao.EmployeeDao">
		<property name="template" ref="hibernateTemplate"></property>
	</bean>
</beans>