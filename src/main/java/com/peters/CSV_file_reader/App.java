package com.peters.CSV_file_reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;

public class App 
{
    public static void main( String[] args )
    {
        DAO();
    }
    
	@SuppressWarnings("deprecation")
	public static void DAO() {
    	String filePath = "C:\\Users\\ABRAHAM\\Desktop\\People-data.csv";
    	
    	//Query data from CSV file
    	BufferedReader lineReader;
		try {
			//================== Hibernate =====================
			//Create Configuration
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			configuration.addAnnotatedClass(Record.class);
			
			//Create Section Factory
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			
			//Initialize the section object
			Session session = sessionFactory.openSession();
			
			String sql = "SELECT rec.email FROM Record rec";
			Query query = session.createQuery(sql);
			
			List fetchData = query.getResultList();
			
			ArrayList<String> email = (ArrayList<String>)fetchData;
			
			lineReader = new BufferedReader(new FileReader(filePath));
			CSVParser records = CSVParser.parse(lineReader, CSVFormat.EXCEL.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			
			session.getTransaction().begin();
			
			int recordCounter = 0;
						
			for(CSVRecord record: records) {
				if(!email.contains(record.get(9))) {
					Record p = new Record();
					p.setFirst_name(record.get(0));
					p.setLast_name(record.get(1));
					p.setCompany(record.get(2));
					p.setAddress(record.get(3));
					p.setCity(record.get(4));
					p.setPhone(record.get(7));
					p.setEmail(record.get(9));
					
					session.persist(p);
					recordCounter+=1;
				}else {
					System.out.println("Record already Exist!");
				}					
			}
			if(recordCounter!=0) {
				System.out.println("Successfully saved "+recordCounter+" records into database");
			}
						
			session.getTransaction().commit();
			session.close();
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IllegalArgumentException e) {
			System.out.println("Illegal Argument occurred");
		}
    	
    	
    	
    }
}
