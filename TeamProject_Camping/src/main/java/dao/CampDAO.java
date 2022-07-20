package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.member;

public class CampDAO {
	private Connection con;
	private static CampDAO campDAO;

	private CampDAO() {

	}

	public static CampDAO getInstance() {
		if (campDAO == null) {
			campDAO = new CampDAO();
		}
		return campDAO;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	
	public member Mainlogin(String id, String passwd) {
		member loginMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM MEMBER WHERE ID = ? AND PASSWD = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				loginMember = new member();
				loginMember.setUser_num(rs.getInt(1));
				loginMember.setId(rs.getString(2));
				loginMember.setPasswd(rs.getString(3));
				loginMember.setName(rs.getString(4));
				loginMember.setNickname(rs.getString(5));
				loginMember.setPhone(rs.getString(6));
				loginMember.setBirth(rs.getString(7));
				loginMember.setEmail(rs.getString(8));
				loginMember.setAddress(rs.getString(9));
				loginMember.setGender(rs.getString(10));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return loginMember;
	}
	
}
