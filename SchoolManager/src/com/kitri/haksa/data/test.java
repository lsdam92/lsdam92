//package com.kitri.haksa.data;
//
//public class test {
//	  String quary = "SELECT * FROM SCHOOL";
//      con = DBConnection.getConnection();
//      pstm = con.prepareStatement(quary);
//      rs = pstm.executeQuery();
//      
//      System.out.println("name \tage \tkey \tvalue");
//      System.out.println("==============================");
//      
//      while(rs.next()) {
//         
//         String name = rs.getString(1);
//         int age = rs.getInt(2);
//         int key = rs.getInt(3);
//         String value = rs.getString(4);
//         
//         String result = name + " \t" + age + " \t" + key + " \t" + value;
//         System.out.println(result);
//      }
//
//   } catch (SQLException e) {
//      System.out.println("에러 발생");
//   }finally {
//      try {
//         if (rs != null) {
//            rs.close();
//         }
//         if (pstm != null) {
//            pstm.close();
//         }
//         if (con != null) {
//            con.close();
//         }
//         
//      }catch (Exception e) {
//         throw new RuntimeException(e.getMessage());
//      }
//   }
//}
