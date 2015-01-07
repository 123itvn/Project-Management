/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Department;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author TOAN
 */
public class DepartmentDAL extends DataAccessHelper{
    private final String GET_BY_ID = "SELECT * FROM Department WHERE depID=?";
    private final String GET_ALL = "SELECT * FROM Department";
    
    public ArrayList<Department> getByID(int id){
        ArrayList<Department> objs = new ArrayList<Department>();
        
        try{
            getConnect();
            PreparedStatement ps = conn.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                Department item =  new Department();
                item.setDepID(rs.getInt("depID"));
                item.setDepName(rs.getString("depName"));
                objs.add(item);
            }
            getClose();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return objs;
    }
    
    public ArrayList<Department> getAll(){
        ArrayList<Department> objs = new ArrayList<>();
        
        try{
            getConnect();
            PreparedStatement ps = conn.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    Department item = new Department();
                    item.setDepID(rs.getInt("DepID"));
                    item.setDepName(rs.getString("DepName"));
                    objs.add(item);
                }
            }
            getClose();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return objs;
    }
}
