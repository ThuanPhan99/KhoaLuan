package com.khosach.service;

import com.khosach.dto.ProductDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface IProductExcelExporterService {

    /**
     *
     * @param response
     * @param productDTOList
     * @throws IOException
     */
    void exportProduct(HttpServletResponse response, List<ProductDTO> productDTOList) throws IOException;

    /**
     *
     * @param response
     * @throws IOException
     */
    void exportRevenue(HttpServletResponse response, String fromDate, String toDate) throws IOException;

    /**
     *
     * @param response
     * @throws IOException
     */
    void exportProductLike(HttpServletResponse response, String fromDate, String toDate) throws IOException;
}
