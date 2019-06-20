package com.kitri.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.dto.*;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

import NotFoundException.AddException;

public class OrderDao {
	public void insert(OrderInfo info) throws AddException{	//sequnce 떄문에 같은 DB사용
		Connection conn = null;
		try {
			//1~2)JDBC드라이버로드 DB연결
			conn = DBConnection.makeConnection();
			conn.setAutoCommit(false);	//자동오토커밋해제
			
			insertInfo(conn, info);	//주문기본추가하기
			List<OrderLine> lines = info.getLines();
			insertLine(conn, lines);
			conn.commit();
		} catch (Exception e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new AddException("주문추가 오류" + e.getMessage());
		}finally {
			//DB닫기
			DBClose.close(conn);		
		}
	
	}
	public void insertInfo(Connection conn, OrderInfo info) throws SQLException {
		PreparedStatement pstmt = null;
		StringBuffer insertinfosql = new StringBuffer();
		insertinfosql.append("insert into order_info(order_no,order_id) \n");
		insertinfosql.append("values(order_seq.nextval,?) \n");
		
		try {
			pstmt = conn.prepareStatement(insertinfosql.toString());
			pstmt.setString(1, info.getCustomer().getId());
			pstmt.executeUpdate();
			
	//	} catch (SQLException e) {
	//		e.printStackTrace();
		}finally {
			DBClose.close(null, pstmt);
		}
	}
	public void insertLine(Connection conn, List<OrderLine> lines) throws SQLException {
		PreparedStatement pstmt = null;
		StringBuffer insertlinesql = new StringBuffer();
		insertlinesql.append("insert into order_line(order_no, order_prod_no, order_quantity) \n");
		insertlinesql.append("values(order_seq.currval,?,?) \n");
		try {
			
			pstmt = conn.prepareStatement(insertlinesql.toString());
			for(OrderLine line : lines) {
			//	String prod_no = line.getOrder_prod_no();
				String prod_no = line.getProduct().getProd_no();
				pstmt.setString(1, prod_no);
				
				int quantity = line.getOrder_quantity();
				pstmt.setInt(2, quantity);
			//	pstmt.executeUpdate();
				pstmt.addBatch();		//insert작업을 계속 누적해놓음
			}
			pstmt.executeBatch();		// 일괄처리
//		} catch (SQLException e) {
//			e.printStackTrace();
		}finally {
			DBClose.close(null, pstmt);
		}
	}
	public List<OrderInfo> selectById(String id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrderInfo> list = new ArrayList<>();
		try {
			//1~2)JDBC로딩, DB연결
			conn = DBConnection.makeConnection();
			
			//3)SQL송신
			StringBuffer selectByIdsql = new StringBuffer();
			selectByIdsql.append("select info.order_no, order_dt, prod_no, prod_name, prod_price, order_quantity \n");
			selectByIdsql.append("from order_info info join order_line line \n");
			selectByIdsql.append("on info.order_no = line.order_no join product p on p.prod_no = line.order_prod_no \n");
			selectByIdsql.append("where order_id = ? \n");
			selectByIdsql.append("order by order_no desc, prod_no \n");
			
			pstmt = conn.prepareStatement(selectByIdsql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			OrderInfo info = null;
			OrderLine line = null;
			List<OrderLine> lines = null;
			int old_order_no = -1;	//이전주문번호
			while(rs.next()) {
				
				int order_no = rs.getInt("order_no");
				if(old_order_no != order_no) {	//주문번호가 다를때
					
					info = new OrderInfo();
					list.add(info);
					info.setOrder_no(order_no);
					info.setOrder_dt(rs.getDate("order_dt"));
					lines = new ArrayList<>();
					info.setLines(lines);
					old_order_no = order_no;
				}
				
				line = new OrderLine();
				String prod_no = rs.getString("prod_no");
				String prod_name = rs.getString("prod_name");
				int prod_price = rs.getInt("prod_price");
				Product p = new Product();
				
				p.setProd_no(prod_no);
				p.setProd_name(prod_name);
				p.setProd_price(prod_price);
				line.setProduct(p);
				
				line.setOrder_quantity(rs.getInt("order_quantity"));
				lines.add(line);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return list;
		
	}
}
