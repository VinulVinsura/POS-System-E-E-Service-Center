package dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T> {
    boolean save(T entity);
    List<T> getAll() throws SQLException, ClassNotFoundException;
    boolean update(T entity);
    boolean delete(String data);
}
