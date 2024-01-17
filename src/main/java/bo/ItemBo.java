package bo;

import dto.ItemDto;

import java.util.List;

public interface ItemBo {
    boolean saveItem(ItemDto dto);
    String genertItemId();
    List<ItemDto> getAllItem();
}
