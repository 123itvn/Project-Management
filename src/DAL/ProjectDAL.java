/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Department;
import Entity.Project;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author TOAN
 */
public class ProjectDAL extends DataAccessHelper{
    private final String GET_BY_ID = "SELECT * FROM Project WHERE prID=?";
    private final String GET_ALL = "SELECT * FROM Project";
    
    public ArrayList<Project> getByID(int id){
        ArrayList<Project> objs = new ArrayList<Project>();
        
        try{
            getConnect();
            PreparedStatement ps = conn.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                Project item =  new Project();
                item.setPrID(rs.getInt("prID"));
                item.setPrName(rs.getString("PrName"));
                objs.add(item);
            }
            getClose();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return objs;
    }
    
    public ArrayList<Project> getAll(){
        ArrayList<Project> objs = new ArrayList<>();
        
        try{
            getConnect();
            PreparedStatement ps = conn.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    Project item = new Project();
                    item.setPrID(rs.getInt("PrID"));
                    item.setPrName(rs.getString("PrName"));
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
