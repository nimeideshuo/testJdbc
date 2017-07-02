package test_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcMain {

	public static void main(String[] args) {
		//注册驱动
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbName = "test";//数据库名称
		String userName = "sa";//用户名
		String passwrod = "";//用户密码
		//连接地址
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=" + dbName;
		//sql  语句
		String sql = "select * from sz_user";
		Statement st;
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, userName, passwrod);
			conn.setAutoCommit(true);
			System.out.println("连接成功~");
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
