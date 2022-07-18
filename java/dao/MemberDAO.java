package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;
import vo.MemberBean;
import static db.JdbcUtil.*;

public class MemberDAO {
	public static MemberDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	private MemberDAO() {
		
	}
	public static MemberDAO getInstance(){
		if(instance == null){
			instance = new MemberDAO();
		}
		return instance;
	}
	public void setConnection(Connection con){
		this.con = con;
	}
	
	public String selectLoginId(MemberBean member){
		String loginId = null;
		String sql="SELECT ID FROM MEMBER WHERE ID=? AND PASSWD=?";
		
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getID());
			pstmt.setString(2, member.getPASSWD());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				loginId = rs.getString("ID");
			}
		}catch(Exception ex){
			System.out.println(" 에러: " + ex);			
		}finally{
			close(rs);
			close(pstmt);
		}
		
		return loginId;
	}
	
	public int insertMember(MemberBean member){
		String sql="INSERT INTO MEMBER VALUES (member_seq.nextval,?,?,?,?,?,?,?,?,?)";
		int insertCount=0;
		
		try{

			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getID());
			pstmt.setString(2, member.getPASSWD());
			pstmt.setString(3, member.getNAME());
			pstmt.setString(4, member.getNICKNAME());
			pstmt.setString(5, member.getPHONE());
			pstmt.setString(6, member.getBIRTH());
			pstmt.setString(7, member.getEMAIL());
			pstmt.setString(8, member.getADDRESS());
			pstmt.setString(9, member.getGENDER());
			insertCount=pstmt.executeUpdate();
			
		}catch(Exception ex){
			System.out.println("joinMember 에러: " + ex);			
		}finally{
			close(pstmt);
		}
		
		return insertCount;
	}
	
	public ArrayList<MemberBean> selectMemberList(){
		String sql="SELECT * FROM MEMBER";
		ArrayList<MemberBean> memberList=new ArrayList<MemberBean>();
		MemberBean mb = null;
		try{
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				do{
				mb=new MemberBean();
				mb.setID(rs.getString("ID"));
				mb.setPASSWD(rs.getString("PASSWD"));
				mb.setNAME(rs.getString("NAME"));
				mb.setNICKNAME(rs.getString("NICKNAME"));
				mb.setPHONE(rs.getString("PHONE"));
				mb.setBIRTH(rs.getString("BIRTH"));
				mb.setEMAIL(rs.getString("EMAIL"));
				mb.setADDRESS(rs.getString("ADDRESS"));
				mb.setGENDER(rs.getString("GENDER"));
				memberList.add(mb);
				}while(rs.next());
			}
		}catch(Exception ex){
			System.out.println("getDeatilMember 에러: " + ex);			
		}finally{
			close(rs);
			close(pstmt);
		}
		return memberList;
	}
	
	public MemberBean selectMember(String id){
		String sql="SELECT * FROM MEMBER WHERE ID=?";
		MemberBean mb = null;
		try{
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
			mb=new MemberBean();
			mb.setID(rs.getString("ID"));
			mb.setPASSWD(rs.getString("PASSWD"));
			mb.setNAME(rs.getString("NAME"));
			mb.setNICKNAME(rs.getString("NICKNAME"));
			mb.setPHONE(rs.getString("PHONE"));
			mb.setBIRTH(rs.getString("BIRTH"));
			mb.setEMAIL(rs.getString("EMAIL"));
			mb.setADDRESS(rs.getString("ADDRESS"));
			mb.setGENDER(rs.getString("GENDER"));
			}
		}catch(Exception ex){
			System.out.println("getDeatilMember 에러: " + ex);			
		}finally{
			close(rs);
			close(pstmt);
		}
		
		return mb;
	}
	public int deleteMember(String id){
		String sql="DELETE MEMBER WHERE ID=?";
		int deleteCount = 0;

		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			deleteCount = pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("deleteMember 에러: " + ex);	
		}finally{
			close(pstmt);
		}
		
		return deleteCount;
	}
}