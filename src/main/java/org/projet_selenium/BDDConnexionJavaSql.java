package org.projet_selenium;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;

public class BDDConnexionJavaSql {


				//Utilisateur de notre bdd		
				private static final String username = "libreplan";
		
				//Password de notre bdd
				private static final String password = "libreplan";
		
				//URL de notre bdd avec les paramètres nécessaire avec PostGre		
				private static final String url = "jdbc:postgresql://localhost:5432/libreplan";
		
				//Driver JDBC pour PostGre		
				private static final String driver = "org.postgresql.Driver";
				
				
	public static void modifBDD(String path_to_file) throws Exception {
				//Connexion BDD
				Connection con = DriverManager.getConnection(url, username, password);
				//Initialize the script runner
				ScriptRunner sr = new ScriptRunner(con);
				//Creating a reader object
				 Reader reader_insert = new BufferedReader(new FileReader(path_to_file));
				 //Running the script
				 sr.runScript(reader_insert);
				}     
	
     

}
