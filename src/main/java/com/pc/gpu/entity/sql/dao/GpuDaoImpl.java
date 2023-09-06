package com.pc.gpu.entity.sql.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pc.gpu.config.DBConfig;
import com.pc.gpu.entity.gpudetails;
import com.pc.gpu.entity.gpuinfo;

import jakarta.persistence.Query;

@Component
public class GpuDaoImpl implements GpuDao {
	
	private Logger logger = LogManager.getLogger(GpuDaoImpl.class);

	@Autowired
	DBConfig dbConfig;		
	
	@Override
	public List<String> getCompany() {
		List<String> companylist = new ArrayList<>();
		SessionFactory sessionFactory = new Configuration().addProperties(dbConfig.jdbcProperties()).addAnnotatedClass(gpuinfo.class).addAnnotatedClass(gpudetails.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {					
			session.beginTransaction();			
			Query query = session.createNativeQuery("select distinct(company) from gpuinfo");			
			companylist = query.getResultList();			
			logger.info("Company List : "+companylist.toString());			
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			logger.error("ERROR!!!");
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
		return companylist;
	}

	@Override
	public List<String> getGpuNames(String company) {
		List<String> gpuList = new ArrayList<>();
		SessionFactory sessionFactory = new Configuration().addProperties(dbConfig.jdbcProperties()).addAnnotatedClass(gpuinfo.class).addAnnotatedClass(gpudetails.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {				
			session.beginTransaction();			
			Query query = session.createNativeQuery("select gpuname from gpuinfo where company = :company");
			query.setParameter("company", company);			
			gpuList = query.getResultList();
			
			logger.info("GPU List : "+gpuList.toString());
			
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			logger.error("ERROR!!!");
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
		
		return gpuList;
	}

	@Override
	public gpudetails getGpuDetails(String gpuName) {
		gpudetails gpu = null;
		SessionFactory sessionFactory = new Configuration().addProperties(dbConfig.jdbcProperties()).addAnnotatedClass(gpuinfo.class).addAnnotatedClass(gpudetails.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {					
			session.beginTransaction();				
			Query query = session.createNativeQuery("select * from gpudetails where gpuname = :gpuname", gpudetails.class);
			query.setParameter("gpuname", gpuName);			
			gpu = (gpudetails) query.getResultList().get(0);			
			logger.info("GPU : "+gpu.toString());
			session.getTransaction().commit();			
		}
		catch(Exception e)
		{
			logger.error("ERROR!!!");
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
		return gpu;
	}

}
