package com.khosach.api.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.khosach.dto.OrderDTO;
import com.khosach.service.ICRUDService;
import com.khosach.service.IOrderDetailService;
import com.khosach.service.IOrderService;

@RestController(value = "orderAPIOfAdmin")
public class OrderAPI {
    @Autowired
    ICRUDService<OrderDTO> orderService;

    @Autowired
    IOrderService orderService2;

    @Autowired
    IOrderDetailService orderDetailService;
    @DeleteMapping("/api/orderadmin")
    public ResponseEntity<?> deleteOder(@RequestBody long[] ids) {
        orderService.delete(ids);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/api/orderadmin/{orderID}/{status}")
    public ResponseEntity<?> updateOrder(@PathVariable(value = "orderID", required = false) long orderID,
                                         @PathVariable(value = "status", required = false) int status) {
        List<Long> listProductID = new ArrayList<Long>();
        if(status==2) {
            listProductID = orderDetailService.checkOrderApprovaled(orderID);
            if(listProductID.size()>0) {
                return ResponseEntity.ok(listProductID);
            }
        }
        if(status==4) {
            orderDetailService.updateQuantityOrderDetaill(orderID);
        }
        orderService2.updateOrder(orderID, status);
        return ResponseEntity.ok(listProductID);
    }

}
