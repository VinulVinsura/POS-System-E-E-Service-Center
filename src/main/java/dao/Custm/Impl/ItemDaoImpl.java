package dao.Custm.Impl;

import dao.Custm.ItemDao;
import entity.Item;

import java.sql.SQLException;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(Item entity) {
        return false;
    }

    @Override
    public List<Item> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Item entity) {
        return false;
    }

    @Override
    public boolean delete(String data) {
        return false;
    }
}
