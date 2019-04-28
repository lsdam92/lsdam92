package com.kitri.haksa.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.haksa.service.ConnectionMaker;
import com.kitri.haksa.service.OracleConnectionMaker;


public class HaksaDao {
	
	public ConnectionMaker connectionMaker;
	
	public HaksaDao() {
		connectionMaker = new OracleConnectionMaker();
	}
	public int register(HaksaDto haksa) {
		
		PreparedStatement ps = null;
		Connection c = null;
		String sql ="insert into SCHOOL(AGE, NAME, KEY,VALUE) values(?,?,?,?)";
		
		try {
			c = connectionMaker.makeConnection();
			ps = c.prepareStatement(sql);
			ps.setInt(1, haksa.getAge());
			ps.setString(2, haksa.getName());
			ps.setInt(3, haksa.getKey());
			ps.setString(4, haksa.getValue());
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return -1;
	}
	
	
	public List<HaksaDto> findName(String name) {
		return null;
	}
	
	public ArrayList<HaksaDto> selectAllList(){
		ArrayList<HaksaDto> list = new ArrayList<HaksaDto>();
//		return list;
		PreparedStatement ps = null;
		Connection c = null;
		ResultSet rs = null;
		String sql =""; //1´Ü°è
		
		try {
			c = connectionMaker.makeConnection();
			ps = c.prepareStatement("select * from SCHOOL");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				HaksaDto haksaDto = new HaksaDto(0, sql, 0, sql);
				haksaDto.setAge(rs.getInt("age"));
				haksaDto.setName(rs.getString("name"));
				haksaDto.setKey(rs.getInt("key"));
				haksaDto.setValue(rs.getString("value"));
				list.add(haksaDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	public int delete(String name) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete school\r\n" + 
				"where name = ?"; 
		try {
			con = connectionMaker.makeConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
}
