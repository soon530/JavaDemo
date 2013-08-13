import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * JVM會自動在Classpath中尋找適當的驅動程式，在包裝有JDBC驅動程式的JAR檔案中，
 * 必須有一個 "META-INF/services/java.sql.Driver"檔案，當中撰寫驅動程式類別名稱
 */
public class DBConnectionDemo2 {
	public static void main(String[] args) {
		// String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/matchman?user=root&password=such0720&useUnicode=true&characterEncoding=UTF-8";
		try {
			/*
			 * 在JDBC 4.0之前，如果您要連接資料庫的話，必須使用Class.forName()並指定驅動程式類別名稱，以載入JDBC驅動，
			 * 在JDBC 4.0之中，不需要再呼叫Class.forName()並指定驅動程式了
			 */
			// Class.forName(driver);
			Connection conn = DriverManager.getConnection(url);

			if (conn != null && !conn.isClosed()) {
				System.out.println("資料庫連線測試成功！");
				conn.close();
			}
			// 不使用Class.forName的話，就不須要這個Exception，不然會compile error
			/*
			 * } catch (ClassNotFoundException e) {
			 * System.out.println("找不到驅動程式類別"); e.printStackTrace();
			 */} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
