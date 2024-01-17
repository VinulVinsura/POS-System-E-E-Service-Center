package bo.Impl;

import bo.ItemBo;
import dao.Custm.Impl.ItemDaoImpl;
import dao.Custm.ItemDao;
import dto.ItemDto;
import entity.Item;

import java.sql.SQLException;
import java.util.List;

public class ItemBoImpl implements ItemBo {
    private ItemDao itemDao=new ItemDaoImpl();
    @Override
    public boolean saveItem(ItemDto dto) {
        return itemDao.save(dto);
    }

    @Override
    public String genertItemId() {
        if (itemDao.getLastItem()!=null){
            String itemCode = itemDao.getLastItem().getItem_Code();
            int num= Integer.parseInt(itemCode.split("P")[1]);
            num++;
            return String.format("P%03d",num);
        }else{
            return "P001";
        }

    }

    @Override
    public List<ItemDto> getAllItem() {
        try {
            List<ItemDto> dtoList = itemDao.getAll();
            return dtoList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
