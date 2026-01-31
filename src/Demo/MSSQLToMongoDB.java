package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import org.bson.Document;
//
//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;

public class MSSQLToMongoDB {

	public static void main(String[] args) {
		try {
			// MSSQL Connection parameters
			//String mssqlUrl = "jdbc:sqlserver://192.168.0.222:22;databaseName=mssqldb;schema=RHINOCON";
			String mssqlUrl = "jdbc:sqlserver://192.168.0.245:1433;databaseName=mssqldb;schema=RHINOCON";
			String mssqlUser = "SA";
			//String mssqlPassword = "pass@123"; //222 server
			String mssqlPassword = "Passpass12!"; //245 server

			// MongoDB Connection parameters
			String mongoHost = "localhost";
			int mongoPort = 27017;
			String mongoDatabaseName = "deeCollection";

			// MSSQL JDBC Connection
			try (Connection mssqlConnection = DriverManager.getConnection(mssqlUrl, mssqlUser, mssqlPassword)) {

				int cnt = 0;
				String sqlQuery = "SELECT * FROM RHINOCON.RC_RECONCILED_TXN";
//				try (PreparedStatement statement = mssqlConnection.prepareStatement(sqlQuery)) {
//					ResultSet resultSet = statement.executeQuery();
//
//					// MongoDB Connection
//					try (MongoClient mongoClient = new MongoClient(mongoHost, mongoPort)) {
//						MongoDatabase mongoDatabase = mongoClient.getDatabase(mongoDatabaseName);
//
//						// MongoDB Collection
//						String collectionName = "rc_reconciled_txn_tmp";
//						MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(collectionName);
//
//						// Insert data into MongoDB
//						while (resultSet.next()) {
//							cnt++;
//							System.out.println(cnt);
//							Document document = new Document();
//							for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
//								String columnName = resultSet.getMetaData().getColumnName(i);
//								Object value = resultSet.getObject(i);
//								document.append(columnName, value);								
//							}
//							mongoCollection.insertOne(document);
//						}
//
//						System.out.println("Data inserted into MongoDB successfully.");
//					}
//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
