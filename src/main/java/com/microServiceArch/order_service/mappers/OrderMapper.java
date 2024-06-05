package com.microServiceArch.order_service.mappers;


import com.microServiceArch.order_service.dto.OrderLineItemsReq;
import com.microServiceArch.order_service.dto.OrderReq;
import com.microServiceArch.order_service.entity.Order;
import com.microServiceArch.order_service.entity.OrderLineItems;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Mapping(source = "orderLineItemsReq" , target = "orderLineItems")
     Order toOrder (OrderReq orderReq);

    @Mapping(target = "id" , ignore = true)
    @Named("toOrderLineItem")
    OrderLineItems toOrderLineItem (OrderLineItemsReq orderLineItemReq);

    @IterableMapping(qualifiedByName = "toOrderLineItem")
    List<OrderLineItems> toOrderLineItems(List<OrderLineItemsReq> orderLineItemsReq);

}
