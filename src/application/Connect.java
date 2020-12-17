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
    
    // �ر����ݿ���Դ
 	public void close() {
 		// �ر�
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
			// 1.��������
			Class.forName(driver);
			// 2.�õ�����
			ct = DriverManager.getConnection(URL, User, Passwrd);
			// 3.����ps
			ps = ct.prepareStatement(sql);

			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ

		}
		return rs;
	}
 	
 	//ģ����ѯ
 	public ResultSet queryLikeExecute(String sql, String[] paras) {
		try {
			// 1.��������
			Class.forName(driver);
			// 2.�õ�����
			ct = DriverManager.getConnection(URL, User, Passwrd);
			// 3.����ps
			ps = ct.prepareStatement(sql);
			// ��ps�ģ���ֵ
			for (int i = 0; i < paras.length; i++) {
				ps.setString(i + 1, "%" + paras[i] + "%");
			}

			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ

		}
		return rs;
	}
 	
    // ��ѯ���ݿ�Ĳ���
 	public ResultSet queryExecute(String sql, String[] paras) {
 		try {
 			// 1.��������
 			Class.forName(driver);
 			// 2.�õ�����
 			ct = DriverManager.getConnection(URL, User, Passwrd);
 			// 3.����ps
 			ps = ct.prepareStatement(sql);
 			// ��ps�ģ���ֵ
 			for (int i = 0; i < paras.length; i++) {
 				ps.setString(i + 1, paras[i]);
 			}

 			rs = ps.executeQuery();

 		}catch (Exception e) {
 			e.printStackTrace();
 		}finally {
 			// �ر���Դ
 			
 		}
 		return rs;
 	}
 	
 	public boolean updExecute(String sql, String[] paras) {
		boolean b = true;

		try {
			// 1.��������
			Class.forName(driver);
			// 2.�õ�����
			ct = DriverManager.getConnection(URL, User, Passwrd);
			// 3.����ps
			ps = ct.prepareStatement(sql);
			// ��ps�ģ���ֵ
			for (int i = 0; i < paras.length; i++) {
				ps.setString(i + 1, paras[i]);
			}
			// 4.ִ�в���
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
 		//����queryExcecute����		
		Connect cnt = new Connect();
		String sql = "select * from Users";
		ResultSet rs = cnt.queryExcecute(sql);
		//�������ֻ��1��1�еģ���һ���������Ƿ��������ļ�¼��
		while(rs.next()) {
			System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
		}
		cnt.close();
 	}
}
