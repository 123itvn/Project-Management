package DLL;

import DAL.EmployeesDAL;
import Entity.Employees;
import java.util.ArrayList;

/**
 *
 * @author TOAN
 */
public class EmployeesDLL {
    EmployeesDAL dal = new EmployeesDAL();
    public boolean getLogin(String u, String p){
        return dal.getLogin(u, p);
    }
    
    public ArrayList<Employees> getAll(){
        return dal.getAll();
    }
    
    public boolean AddData(Employees emp){
        return dal.AddData(emp);
    }
    
    public boolean delete(String u){
        return dal.DeleteData(u);
    }
    
    public boolean update(Employees emp){
        return dal.UpdateData(emp);
    }
}
