package com.khosach.controller.admin;

import com.khosach.dto.ProductDTO;
import com.khosach.service.ICRUDService;
import com.khosach.service.IProductExcelExporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ReportController {

    @Autowired
    ICRUDService<ProductDTO> productService;

    @Autowired
    IProductExcelExporterService productExcelExporterService;

    @RequestMapping(value = "/quan-tri/thong-ke/products", method = RequestMethod.GET)
    public ModelAndView getProducts() {
        ModelAndView mav = new ModelAndView("admin/report/products");
        mav.addObject("listProduct",productService.findAll());
        return mav;
    }

    @RequestMapping(value = "/quan-tri/thong-ke/products/report", method = RequestMethod.GET)
    public void report(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Products_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        productExcelExporterService.exportProduct(response, productService.findAll());
    }

    @RequestMapping(value = "/quan-tri/thong-ke/revenue", method = RequestMethod.GET)
    public ModelAndView revenue() {
        ModelAndView mav = new ModelAndView("admin/report/revenue");
        return mav;
    }

    @RequestMapping(value = "/quan-tri/thong-ke/revenue/report", method = RequestMethod.GET)
    public void reportRevenue(HttpServletResponse response, @RequestParam(value="fromDate",required = false) String fromDate, @RequestParam(value="toDate",required = false) String toDate ) throws IOException {
        System.out.println(fromDate);
        System.out.println(toDate);
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Thong_Ke_Doanh_Thu_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        productExcelExporterService.exportRevenue(response, fromDate, toDate);
    }

    @RequestMapping(value = "/quan-tri/thong-ke/productLike", method = RequestMethod.GET)
    public ModelAndView reportLike() {
        ModelAndView mav = new ModelAndView("admin/report/productLike");
        return mav;
    }
    @RequestMapping(value = "/quan-tri/thong-ke/productLike/report", method = RequestMethod.GET)
    public void reportProductLike(HttpServletResponse response, @RequestParam(value="fromDate",required = false) String fromDate, @RequestParam(value="toDate",required = false) String toDate ) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Thong_Ke_San_Pham_Yeu_Thich" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        productExcelExporterService.exportProductLike(response, fromDate, toDate);
    }
}
