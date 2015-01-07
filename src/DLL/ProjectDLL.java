package DLL;

import DAL.ProjectDAL;
import Entity.Project;
import java.util.ArrayList;

/**
 *
 * @author TOAN
 */
public class ProjectDLL {
    ProjectDAL dal = new ProjectDAL();
    
    public ArrayList<Project> getByID(int id){
        return dal.getByID(id);
    }
    
    public ArrayList<Project> getAll(){
        return dal.getAll();
    }
  
}
