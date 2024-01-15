package bo.Impl;

import bo.ItemBo;
import dao.Custm.Impl.ItemDaoImpl;
import dao.Custm.ItemDao;
import dto.ItemDto;
import entity.Item;

public class ItemBoImpl implements ItemBo {
    private ItemDao itemDao=new ItemDaoImpl();
    @Override
    public boolean saveItem(ItemDto dto) {
        return itemDao.save(dto);
    }
}
