package com.ash.workorder.dao;

import com.ash.workorder.dao.po.OrderPo;
import com.ash.workorder.enums.OrderTypeEnum;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created by Ash on 2019/6/10 11:03
 */
@Repository
@Mapper
public interface OrderDao {

    List<OrderPo> selectAll();

    int updateOrderInfo(OrderPo orderPo);

    int updateApprovalStatus(OrderPo orderPo);

    int deleteOrder(int id);

    int insert(OrderPo orderPo);

    List<OrderPo> selectByStatus(OrderTypeEnum orderTypeEnum);

}
