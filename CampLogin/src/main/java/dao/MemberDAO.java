package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
         System.out.println("joinMember ¿¡·¯: " + ex);         
      }finally{
         close(pstmt);
      }
      
      return insertCount;
   }
}