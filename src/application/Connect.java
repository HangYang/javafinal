package application;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {
	PreparedStatement ps = null;
	Connection ct = null;
	ResultSet rs = null;
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String URL = "jdbc:sqlserver://localhost:1433;DatabaseName = Final";
    String User = "sa";
    String Passwrd = "123456";
    
    // 关闭数据库资源
 	public void close() {
 		// 关闭
 		try {
 			if (rs != null)
 				rs.close();
 			if (ps != null)
 				ps.close();
 			if (ct != null)
 				ct.close();
 		}catch (Exception e) {
 			e.printStackTrace();
 		}
 	}
 	
 	public  ResultSet queryExcecute(String sql) {
		try {
			// 1.加载驱动
			Class.forName(driver);
			// 2.得到连接
			ct = DriverManager.getConnection(URL, User, Passwrd);
			// 3.创建ps
			ps = ct.prepareStatement(sql);

			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源

		}
		return rs;
	}
 	
 	//模糊查询
 	public ResultSet queryLikeExecute(String sql, String[] paras) {
		try {
			// 1.加载驱动
			Class.forName(driver);
			// 2.得到连接
			ct = DriverManager.getConnection(URL, User, Passwrd);
			// 3.创建ps
			ps = ct.prepareStatement(sql);
			// 给ps的？赋值
			for (int i = 0; i < paras.length; i++) {
				ps.setString(i + 1, "%" + paras[i] + "%");
			}

			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源

		}
		return rs;
	}
 	
    // 查询数据库的操作
 	public ResultSet queryExecute(String sql, String[] paras) {
 		try {
 			// 1.加载驱动
 			Class.forName(driver);
 			// 2.得到连接
 			ct = DriverManager.getConnection(URL, User, Passwrd);
 			// 3.创建ps
 			ps = ct.prepareStatement(sql);
 			// 给ps的？赋值
 			for (int i = 0; i < paras.length; i++) {
 				ps.setString(i + 1, paras[i]);
 			}

 			rs = ps.executeQuery();

 		}catch (Exception e) {
 			e.printStackTrace();
 		}finally {
 			// 关闭资源
 			
 		}
 		return rs;
 	}
 	
 	public boolean updExecute(String sql, String[] paras) {
		boolean b = true;

		try {
			// 1.加载驱动
			Class.forName(driver);
			// 2.得到连接
			ct = DriverManager.getConnection(URL, User, Passwrd);
			// 3.创建ps
			ps = ct.prepareStatement(sql);
			// 给ps的？赋值
			for (int i = 0; i < paras.length; i++) {
				ps.setString(i + 1, paras[i]);
			}
			// 4.执行操作
			if (ps.executeUpdate() != 1) {
				b = false;
			}

		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		} finally {
			this.close();
		}
		return b;
	}
 	
 	public static void main(String[] args) throws UnsupportedEncodingException, SQLException {
 		//测试queryExcecute方法		
		Connect cnt = new Connect();
		String sql = "select * from Users";
		ResultSet rs = cnt.queryExcecute(sql);
		//结果集中只有1行1列的，是一个整数，是符合条件的记录数
		while(rs.next()) {
			System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
		}
		cnt.close();
 	}
}
