package com.example.bootbooks;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BookListerRawJdbc extends BookLister {
	
	DataSource dataSource;

	public BookListerRawJdbc(Logger logger, DataSource dataSource) {
		super(logger);
		this.dataSource = dataSource;
	}
	
	@Override
	public void listAllBooksToLogger() {
		super.logger.info("ALL THE BOOKS: ");
		
		try (Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM book;")) {

			while (rs.next()) {
				StringBuilder sb = new StringBuilder();
				sb.append(" id = ").append(rs.getInt(1));
				sb.append(" title = ").append(rs.getString(2));
				sb.append(" price = ").append(rs.getDouble(3));
				logger.info(sb.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
