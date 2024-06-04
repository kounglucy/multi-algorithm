/*- 모든 부서 정보 검색 : getAllDept()
- 부서번호로 특정 부서 검색 : getDeptByDeptno(int deptno)
- 새로운 부서 생성 : insertDept(new Dept(deptno, dname, loc))
- 부서번호로 검색한 특정 부서의 위치 수정 : updateDeptLocByDeptno(int deptno, String newDeptLoc)
- 부서번호로 검색한 특정 부서를 삭제 : deleteDeptByDeptno(int deptno)
 */

package dept.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dept.dto.Dept;
import dept.util.DBUtil;

public class DeptDAO {
	// 모든 부서 정보 검색 : SELECT * FROM DEPT;
	public static ArrayList<Dept> getAllDept() throws SQLException {
		ArrayList<Dept> allDepts = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
		// 1단계 : driver 로딩               		- static{}
		// 2단계 : DB접속 - ip/id/pw 		- Connection
		// conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "tiger");
		   conn = DBUtil.getConnection();
			
		// 3단계 : sql 문장 실행 객체			- Statement / PreparedStatement 
		stmt = conn.createStatement();
		
		// 4단계 : sql 문장 실행			    - ResultSet executeQuery(String query)
		rset = stmt.executeQuery("SELECT * FROM DEPT");
		
		// 5단계 : 데이터 활용                                  - select인 경우 ResultSet 객체 분해
		allDepts = new ArrayList<Dept>();
		while(rset.next()) {
			allDepts.add(new Dept(rset.getInt("deptno"), rset.getNString("dname"), rset.getNString("loc")));
		}
		
		// 6단계 : 종료-자원반환				- finally{}
		} finally {
			// rset.close();
			// stmt.close();
			// conn.close();
			DBUtil.close(rset, stmt, conn);
		}
		
		return allDepts;
		
	}

	// 부서번호로 특정 부서 검색 : "SELECT * FROM DEPT WHERE deptno = " + deptno
    public static Dept getDeptByDeptno(int deptno) throws SQLException {
       Dept dept = null;
	   Connection conn = null;
	   Statement stmt = null;
	   ResultSet rset = null;
			
		try {
			conn = DBUtil.getConnection();
				
			stmt = conn.createStatement();
				
			rset = stmt.executeQuery("SELECT * FROM DEPT WHERE deptno = " + deptno);
				
			if(rset.next()) {
				dept = new Dept(rset.getInt("deptno"), rset.getString("dname"), rset.getString("loc"));
				}
			
			} finally {
				// rset.close();
				// stmt.close();
				// conn.close();
				DBUtil.close(rset, stmt, conn);
			}
			
			return dept;
		}  
    
      // 새로운 부서 생성 v1 : "INSERT INTO DEPT VALUES (" + deptno + ", " + dname + " ," + loc + " )"
      public static boolean insertDept(Dept dept) throws SQLException {
       Connection conn = null;
   	   Statement stmt = null;
   	   ResultSet rset = null;
   			
   		try {
   			conn = DBUtil.getConnection();
   			stmt = conn.createStatement();
   			int result = stmt.executeUpdate("INSERT INTO DEPT VALUES(" + dept.getDeptno() + ", '" + dept.getDname() + "', '" + dept.getLoc() + "')");
   			
   			if(result!=0) {
   				return true;
   			}
   			
   		} finally {
   			// stmt.close();
   			// conn.close(); 
   			DBUtil.close(stmt, conn);
   
   		}
    	  
    	  return false;
      }
    
   // 새로운 부서 생성 v2 : "INSERT INTO DEPT VALUES (?,?,?)"
      public static boolean insertDept2(Dept dept) throws SQLException {
       Connection conn = null;
   	   PreparedStatement pstmt = null;
   			
   		try {
   			conn = DBUtil.getConnection();
   			pstmt = conn.prepareStatement("INSERT INTO DEPT VALUES (?,?,?)");
   			
   			pstmt.setInt(1, dept.getDeptno());
   			pstmt.setString(2, dept.getDname());
   			pstmt.setString(3, dept.getLoc());
   			
   			int result = pstmt.executeUpdate();
   			
   			if(result!=0) {
   				return true;
   			}
   			
   		} finally {
   			// pstmt.close();
   		    // conn.close(); 
   			DBUtil.close(pstmt, conn);
   			
   			
   		}
    	  
    	  return false;
      }
    
    
   // 부서번호로 검색한 특정 부서의 위치 수정 : UPDATE DEPT SET loc = ? WHERE deptno = ?
   		public static boolean updateDeptLocByDeptno(int deptno, String newDeptLoc) throws SQLException {
   			Connection conn = null;
   			PreparedStatement pstmt = null;
   			
   			try {
   				conn = DBUtil.getConnection();
   				pstmt = conn.prepareStatement("UPDATE DEPT SET loc = ? WHERE deptno = ?");
   				
   				pstmt.setString(1, newDeptLoc);
   				pstmt.setInt(2, deptno);
   				
   				int result = pstmt.executeUpdate();
   				
   				if(result != 0) {
   					return true;
   				}
   				
   			}finally {
   				// pstmt.close();
   			    // conn.close();
   				DBUtil.close(pstmt, conn);
   			}
   			
   			return false;
   		}
      
      
   	// 부서번호로 검색한 특정 부서를 삭제 : DELETE FROM DEPT WHERE deptno = ?
   			public static boolean deleteDeptByDeptno(int deptno) throws SQLException {
   				Connection conn = null;
   				PreparedStatement pstmt = null;
   				
   				try {
   					conn = DBUtil.getConnection();
   					pstmt = conn.prepareStatement("DELETE FROM DEPT WHERE deptno = ?");
   					
   					pstmt.setInt(1, deptno);
   					
   					int result = pstmt.executeUpdate();
   					
   					if(result != 0) {
   						return true;
   					}
   					
   				}finally {
   					// pstmt.close();
   					// conn.close();
   					DBUtil.close(pstmt, conn);
   				}
   				
   				return false;
   			}
   	}
