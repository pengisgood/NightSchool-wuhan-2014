package org.nightschool.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.nightschool.model.CartItem;
import org.nightschool.model.Item;

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

    @Select("Select * from cart_item where username = #{username} and itemid=#{itemid}")
    CartItem queryByKey(@Param("username") String username, @Param("itemid")int itemid);

    @Update("Update cart_item set number = #{number} where username = #{username} and itemid =#{itemid}")
    int update(CartItem cartItem);

    @Select("Select * from cart_item")
    List<CartItem> all();
}
