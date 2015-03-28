package org.nightschool.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.nightschool.model.CartItem;

import java.util.List;

/**
 * Created by luchen on 3/26/15.
 */
public interface CartItemMapper {

    @Select("Select * from cart_item where username = 'blacksea.chen@hotmail.com'")
    public List<CartItem> getCartItems();

    @Insert("Insert into cart_item(username, itemid, number) values ('blacksea.chen@hotmail.com', #{itemid}, #{number})")
    public int add(CartItem cartItem);

    @Select("Select count(*) from cart_item where username = 'blacksea.chen@hotmail.com' and itemid = #{itemid}")
    public int getCount(@Param("itemid") int itemid);

}
