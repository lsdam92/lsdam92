package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
 
public class dbtest
{
    public static void main(String args[])
    {   
       Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
        
        try {
            // SQL ������ ����� ���� ������ ���Ǿ�(SELECT��)���
            // �� ����� ���� ResulSet ��ü�� �غ��� �� �����Ų��.
            String quary = "SELECT * FROM FOOK_MANAGER";
            
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(quary);
            rs = pstm.executeQuery();
            
            
            /*  COUNTRIES ���̺��� ������ Ÿ��
                 
                 school
                name varchar2(10) -- String
                age number(3) -- number
             key number(1) -- number
             value varchar2(20) -- String
             
             job
             key number(1) -- number
             key_name varchar2(10) -- String
            
            */
            
//          System.out.println("EMPNO ENAME JOB MGR HIREDATE SAL COMM DEPTNO");
            System.out.println("name \tage \tkey \tvalue");
            System.out.println("================================");
            
            while(rs.next()){
//                int empno = rs.getInt(1);
//                //int empno = rs.getInt("empno"); ���� ��� �÷� �̸��� ��� �ȴ�.
//                String ename = rs.getString(2);
//                String job = rs.getString(3);
//                int mgr = rs.getInt(4);
//                java.sql.Date hiredate = rs.getDate(5); // Date Ÿ�� ó��
//                int sal = rs.getInt(6);
//                int comm = rs.getInt(7);
//                int deptno = rs.getInt(8);
               String name = rs.getString("name");
               Number age = rs.getInt("age");
               Number key = rs.getInt("key");
               String value = rs.getString("value");
               
               
                String result = name+" "+age+" "+key+" "+value;
                System.out.println(result);
            }
            
        } catch (SQLException sqle) {
            System.out.println("SELECT������ ���� �߻�");
            sqle.printStackTrace();
            
        }finally{
            // DB ������ �����Ѵ�.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            
        }
    }
}