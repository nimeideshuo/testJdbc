package test_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcMain {

	public static void main(String[] args) {
		//ע������
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbName = "test";//���ݿ�����
		String userName = "sa";//�û���
		String passwrod = "";//�û�����
		//���ӵ�ַ
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=" + dbName;
		//sql  ���
		String sql = "select * from sz_user";
		Statement st;
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, userName, passwrod);
			conn.setAutoCommit(true);
			System.out.println("���ӳɹ�~");
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				System.out.println(id + ">>>" + name);
			}
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
