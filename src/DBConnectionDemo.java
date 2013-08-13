import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* 
 * �b�ϥ�getConnection()���ɭԡA�]�i�H��user & password���}�Ӽg 
 * String url = "jdbc:mysql://localhost:3306/matchman";
 * String user = "root";
 * String password = "such0720";
 * Connection conn = DriverManager.getConnection(url, user, password);
 */
public class DBConnectionDemo {
	public static void main(String[] args) {
		// �C�@��driver�r�곣���Ӥ@��
		String driver = "com.mysql.jdbc.Driver";
		// �]���n�Τ���A�ҥH�N��Ҧ�����T����url�Ӫ�ܡA���Nuser & password���}
		String url = "jdbc:mysql://localhost:3306/matchman?user=root&password=such0720&useUnicode=true&characterEncoding=UTF-8";
		try {
			/* 
			 * �z�Ljava.lang.Class���O��forName()�Ӹ��J�æVDriverManager���UJDBC�X�ʵ{��
			 * �]�X�ʵ{���|�۰ʳz�LDriverManager.registerDriver()��k���U�^
			 */
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url);

			if (conn != null && !conn.isClosed()) {
				System.out.println("��Ʈw�s�u���զ��\�I");
				conn.close();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("�䤣���X�ʵ{�����O");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
