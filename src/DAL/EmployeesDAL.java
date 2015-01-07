package DAL;

import Entity.Employees;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author TOAN
 */
public class EmployeesDAL extends DataAccessHelper{
    private final String GET_LOGIN = "SELECT * FROM Employees WHERE username = ? AND password = ?";
    private final String GET_ALL = "SELECT * FROM Employees";
    private final String ADD_NEW = "INSERT INTO "
            + "Employees (username, password, FullName, age, address, phone, depID, prID)"
            + "VALUES (?,?,?,?,?,?,?,?)";
    private final String UPDATE_DATA = "UPDATE "
            + "Employees SET password = ?, FullName=?, age=?, address=?, phone=?,depID=?,prID=? WHERE username=?";
    private final String REMOVE_DATA = "DELETE FROM Employees WHERE username=?";
    
    public boolean getLogin(String u, String p){
        boolean check = false;
        try{
            getConnect();
            PreparedStatement ps = conn.prepareStatement(GET_LOGIN);
            ps.setString(1, u);
            ps.setString(2, p);
            ResultSet rs =  ps.executeQuery();
            if (rs != null && rs.next()) {
                check = true;
            }
            getClose();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return check;
    }
    
    public ArrayList<Employees> getAll(){
        ArrayList<Employees> objs = new ArrayList<Employees>();
        try{
            getConnect();
            PreparedStatement ps = conn.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Employees item = new Employees();
                    item.setUsername(rs.getString("username"));
                    item.setPassword(rs.getString("Password"));
                    item.setFullName(rs.getString("FullName"));
                    item.setAge(rs.getString("Age"));
                    item.setAddress(rs.getString("Address"));
                    item.setPhone(rs.getString("Phone"));
                    item.setPrID(rs.getInt("prID"));
                    item.setDepID(rs.getInt("depID"));
                    objs.add(item);
                }
            }
            getClose();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddData(Employees emp){
        boolean check = false;
        try{
            getConnect();
            PreparedStatement ps = conn.prepareStatement(ADD_NEW);
            ps.setString(1, emp.getUsername());
            ps.setString(2, emp.getPassword());
            ps.setString(3, emp.getFullName());
            ps.setString(4, emp.getAge());
            ps.setString(5, emp.getAddress());
            ps.setString(6, emp.getPhone());
            ps.setInt(7, emp.getDepID());
            ps.setInt(8, emp.getPrID());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return check;
    }
    
    public boolean DeleteData(String u){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(REMOVE_DATA);
            ps.setString(1, u);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
        }
        return check;
    }
    
    public boolean UpdateData(Employees emp){
        boolean check = false;
        try{
            getConnect();
            PreparedStatement ps = conn.prepareStatement(UPDATE_DATA);
            ps.setString(1, emp.getPassword());
            ps.setString(2, emp.getFullName());
            ps.setString(3, emp.getAge());
            ps.setString(4, emp.getAddress());
            ps.setString(5, emp.getPhone());
            ps.setInt(6, emp.getDepID());
            ps.setInt(7, emp.getPrID());
            
            ps.setString(8, emp.getUsername());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return check;
    }
}
