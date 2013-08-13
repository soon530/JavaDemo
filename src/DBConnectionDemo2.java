import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * JVM�|�۰ʦbClasspath���M��A���X�ʵ{���A�b�]�˦�JDBC�X�ʵ{����JAR�ɮפ��A
 * �������@�� "META-INF/services/java.sql.Driver"�ɮסA�����g�X�ʵ{�����O�W��
 */
public class DBConnectionDemo2 {
	public static void main(String[] args) {
		// String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/matchman?user=root&password=such0720&useUnicode=true&characterEncoding=UTF-8";
		try {
			/*
			 * �bJDBC 4.0���e�A�p�G�z�n�s����Ʈw���ܡA�����ϥ�Class.forName()�ë��w�X�ʵ{�����O�W�١A�H���JJDBC�X�ʡA
			 * �bJDBC 4.0�����A���ݭn�A�I�sClass.forName()�ë��w�X�ʵ{���F
			 */
			// Class.forName(driver);
			Connection conn = DriverManager.getConnection(url);

			if (conn != null && !conn.isClosed()) {
				System.out.println("��Ʈw�s�u���զ��\�I");
				conn.close();
			}
			// ���ϥ�Class.forName���ܡA�N�����n�o��Exception�A���M�|compile error.
			/*
			 * } catch (ClassNotFoundException e) {
			 * System.out.println("�䤣���X�ʵ{�����O"); e.printStackTrace();
			 */} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
