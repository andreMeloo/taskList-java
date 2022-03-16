package model.dao;

import java.util.List;


public interface DAOInterface <ClassVO> {
    public void create(ClassVO objectVO);
    public void delete(ClassVO objectVO);
    public List<ClassVO> list();
    public void update(ClassVO objectVO);
}
