package com.mmall.dao;

import com.mmall.pojo.Cart;
import com.mmall.vo.CartVo;
import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    Cart selectByPrimaryKey(Integer id);

    List<Cart> selectAll();

    int updateByPrimaryKey(Cart record);

    List<Cart> selectCartByUserId(Integer userId);

    int updateByPrimaryKeySelective(Cart cartForQuantity);

    int selectCartProductCheckedStatusByUserId(Integer userId);
}