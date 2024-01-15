package dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T> {
    boolean save(T dto);
    List<T> getAll() throws SQLException, ClassNotFoundException;
    boolean update(T dto);
    boolean delete(String data);
}
