import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 在使用getConnection()的時候，也可以把user & password分開來寫 
 * String url = "jdbc:mysql://localhost:3306/matchman";
 * String user = "root";
 * String password = "such0720";
 * Connection conn = DriverManager.getConnection(url, user, password);
 */
public class DBConnectionDemo {
	public static void main(String[] args) {
		// 每一個driver字串都不太一樣
		String driver = "com.mysql.jdbc.Driver";
		// 因為要用中文，所以就把所有的資訊都用url來表示，不將user & password分開
		String url = "jdbc:mysql://192.168.0.33:3306/tasker?user=root&password=such0720&useUnicode=true&characterEncoding=UTF-8";
		try {
			/*
			 * 透過java.lang.Class類別的forName()來載入並向DriverManager註冊JDBC驅動程式
			 * （驅動程式會自動透過DriverManager.registerDriver()方法註冊）
			 */
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url);

			if (conn != null && !conn.isClosed()) {
				System.out.println("資料庫連線測試成功！");
				conn.close();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驅動程式類別");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
