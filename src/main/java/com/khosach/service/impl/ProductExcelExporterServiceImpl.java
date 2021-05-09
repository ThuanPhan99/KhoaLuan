package com.khosach.service.impl;

import com.khosach.dto.ProductDTO;
import com.khosach.dto.RevenueReportDto;
import com.khosach.entity.OrderEntity;
import com.khosach.repository.IOrderRepository;
import com.khosach.service.IProductExcelExporterService;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ProductExcelExporterServiceImpl implements IProductExcelExporterService {

    private static final List<String> HEADER_EXPORT_PRODUCT = Arrays.asList("Mã sản phẩm", "Tên sản phẩm", "Nhóm sản phẩm", "Trạng thái", "Giá Trung Bình", "Phầm trăm KM", "Số lượng tồn kho", "Tác giả", "Nhà xuất bản", "Ngày nhập gần nhất");
    private static final List<String> HEADER_EXPORT_REVENUE = Arrays.asList("Mã sản phẩm", "Tên sản phẩm", "Nhóm sản phẩm", "Trạng thái",  "Số lượng bán", "doanh số", "Lợi nhuận");
    private static final List<String> HEADER_EXPORT_PRODUCT_LIKE = Arrays.asList("Mã sản phẩm", "Tên sản phẩm", "Tác giả",  "Nhà xuất bản", "Số lượng bán");
    private static final List<String> HEADER_EXPORT_AUTHOR_LIKE = Arrays.asList("Mã tác giả", "Tên", "Tên khác",  "Ngày Sinh","Số sách bán");
    private static final List<String> HEADER_EXPORT_PUBLISHER_LIKE = Arrays.asList("Mã nhà xuất bản", "Tên", "Thành phố",  "Quốc gia","Số sách bán");
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    @Autowired
    IOrderRepository orderRepository;

    private void writeHeaderTop(XSSFSheet sheet, String headerName, int rowNum, String from, String to) {
        sheet.addMergedRegion(CellRangeAddress.valueOf(from+":"+to));
        Row row = sheet.createRow(rowNum);
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, headerName, style);
    }

    private void writeHeaderLine(XSSFSheet sheet, List<String> headers, String nameSheet, int rowNum) {
        Row row = sheet.createRow(rowNum);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        for (int i = 0; i < headers.size(); i++) {
            createCell(row, i, headers.get(i), style);
        }
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);

        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue(StringUtils.trimToEmpty((String) value).toUpperCase().equals("NULL") ? StringUtils.EMPTY : StringUtils.trimToEmpty((String) value));
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines(List<ProductDTO> productDTOList) {
        int rowCount = 2;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        CellStyle styleNum = workbook.createCellStyle();
        DataFormat format = workbook.createDataFormat();
        font.setFontHeight(14);
        styleNum.setFont(font);
        styleNum.setDataFormat(format.getFormat("#"));

        SimpleDateFormat day = new SimpleDateFormat("dd-MM-yyyy");
        try {
            for (ProductDTO product : productDTOList) {
                Row row = sheet.createRow(rowCount++);
                int columnCount = 0;
                createCell(row, columnCount++, product.getProductID().toString(), style);
                createCell(row, columnCount++, product.getProductName(), style);
                createCell(row, columnCount++, product.getGroupProductName(), style);
                createCell(row, columnCount++, product.getStatus() == 1 ? "Còn hàng" : "Hết hàng", style);
                createCell(row, columnCount++, Objects.nonNull(product.getPrice()) ? product.getPrice().intValue() : "0", styleNum);

                createCell(row, columnCount++, Objects.nonNull(product.getSalePrice()) ? product.getSalePrice().intValue() + "%" : "", styleNum);
                createCell(row, columnCount++, Objects.nonNull(product.getQuantity()) ?  product.getQuantity().intValue() : "0", styleNum);
                createCell(row, columnCount++, product.getAuthor(), style);
                createCell(row, columnCount++, product.getPublisher(), style);
                createCell(row, columnCount++, Objects.nonNull(product.getDateAdded()) ? day.format(product.getDateAdded()): "", style);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param response
     * @param productDTOList
     * @throws IOException
     */
    public void exportProduct(HttpServletResponse response, List<ProductDTO> productDTOList) throws IOException {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Thống Kê Sản Phẩm");
        writeHeaderTop(sheet, "Thống Kê Sản Phẩm", 0, "A1", "K1");
        writeHeaderLine(sheet, HEADER_EXPORT_PRODUCT, "Thống Kê Sản Phẩm", 1);
        writeDataLines(productDTOList);
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    /**
     *
     * @param response
     * @throws IOException
     */
    public void exportRevenue(HttpServletResponse response, String fromDate, String toDate) throws IOException {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Thống Kê Doanh Thu");

        String headerName = "Thống Kê Doanh Thu";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        List<OrderEntity> orderEntities = new LinkedList<>();
        try {
            if (StringUtils.isNotBlank(fromDate) && StringUtils.isNotBlank(toDate)) {
                headerName = headerName.concat(" từ ngày " + fromDate + " đến ngày " + toDate);
                Date fromDateFilter = formatter.parse(fromDate);
                Date toDateFilter = formatter.parse(toDate);
                orderEntities = orderRepository.findAllByStatusAndDeliveryDateGreaterThanEqualAndDeliveryDateLessThanEqual(6, fromDateFilter, toDateFilter);
            } else if (StringUtils.isNotBlank(fromDate)) {
                Date fromDateFilter = formatter.parse(fromDate);
                headerName = headerName.concat(" từ ngày " + fromDate);
                orderEntities = orderRepository.findAllByStatusAndDeliveryDateGreaterThanEqual(6, fromDateFilter);
            } else if (StringUtils.isNotBlank(toDate)) {
                Date toDateFilter = formatter.parse(toDate);
                headerName = headerName.concat(" đến ngày " + toDate);
                orderEntities = orderRepository.findAllByStatusAndDeliveryDateLessThanEqual(6, toDateFilter);
            } else {
                orderEntities = orderRepository.findAllByStatus(6);
            }
        } catch (Exception e) {
            orderEntities = orderRepository.findAllByStatus(6);
        }

        writeHeaderTop(sheet, headerName, 0, "A1", "G1");
        writeHeaderLine(sheet, HEADER_EXPORT_REVENUE, "Thống Kê Doanh Thu", 1);
        writeRevenueDataLines(convertToRevenueReportDto(orderEntities));
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    private List<RevenueReportDto> convertToRevenueReportDto(List<OrderEntity> orderEntities){
        List<RevenueReportDto> revenueReportDtos = new LinkedList<>();
        orderEntities.forEach(orderEntity -> {
            orderEntity.getOrderDetails().forEach(orderDetailEntity -> {
                Optional<RevenueReportDto> revenueReportDtoExits = revenueReportDtos.stream().filter(revenueReportDto -> revenueReportDto.getProductID() == orderDetailEntity.getProducts().getProductID()).findFirst();
                if(revenueReportDtoExits.isPresent()){
                    revenueReportDtoExits.get().setQuantity(revenueReportDtoExits.get().getQuantity() + orderDetailEntity.getQuantity());
                    revenueReportDtoExits.get().setPrice(revenueReportDtoExits.get().getPrice() + orderDetailEntity.getPrice());
                } else {
                    RevenueReportDto revenueReportDto = new RevenueReportDto();
                    revenueReportDto.setProductID(orderDetailEntity.getProducts().getProductID());
                    revenueReportDto.setProductName(orderDetailEntity.getProducts().getProductName());
                    revenueReportDto.setGroupProductName(orderDetailEntity.getProducts().getGroupProductEntity().getGroupProductName());
                    revenueReportDto.setStatus(orderDetailEntity.getProducts().getStatus() == 1 ? "Còn hàng" : "Hết hàng");
                    revenueReportDto.setQuantity(orderDetailEntity.getQuantity());
                    revenueReportDto.setPrice(orderDetailEntity.getPrice());
                    revenueReportDto.setRevenue(orderDetailEntity.getProducts().getProductPrice().getPrice());
                    revenueReportDtos.add(revenueReportDto);
                }

            });
        });
        return revenueReportDtos;
    }

    private void writeRevenueDataLines(List<RevenueReportDto> revenueReportDtos) {
        int rowCount = 2;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        CellStyle styleNum = workbook.createCellStyle();
        DataFormat format = workbook.createDataFormat();
        font.setFontHeight(14);
        styleNum.setFont(font);
        styleNum.setDataFormat(format.getFormat("#"));
        SimpleDateFormat day = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Long totalQuantity = 0L;
            Long totalPrice = 0L;
            Long totalRevenue = 0L;
            for (RevenueReportDto revenueReportDto : revenueReportDtos) {
                Row row = sheet.createRow(rowCount++);
                int columnCount = 0;
                createCell(row, columnCount++, revenueReportDto.getProductID().toString(), style);
                createCell(row, columnCount++, revenueReportDto.getProductName(), style);
                createCell(row, columnCount++, revenueReportDto.getGroupProductName(), style);
                createCell(row, columnCount++, revenueReportDto.getStatus(), style);
                totalQuantity = totalQuantity + revenueReportDto.getQuantity();
                createCell(row, columnCount++, Objects.nonNull(revenueReportDto.getQuantity()) ?  revenueReportDto.getQuantity().intValue() : 0, styleNum);
                totalPrice = totalPrice + revenueReportDto.getPrice();
                createCell(row, columnCount++, Objects.nonNull(revenueReportDto.getPrice()) ? revenueReportDto.getPrice().intValue() : 0, styleNum);
                totalRevenue = totalRevenue + revenueReportDto.getRevenue();
                createCell(row, columnCount++, Objects.nonNull(revenueReportDto.getRevenue()) ? revenueReportDto.getRevenue().intValue() : 0, styleNum);
            }
            Row row = sheet.createRow(rowCount++);
            createCell(row, 3, "Tổng số: ", style);
            createCell(row, 4, totalQuantity.intValue(), styleNum);
            createCell(row, 5, totalPrice.intValue(), styleNum);
            createCell(row, 6, totalRevenue.intValue(), styleNum);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void exportProductLike(HttpServletResponse response, String fromDate, String toDate) throws IOException {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Thống Kê Sản Phẩm Yêu Thích");

        String headerName = "Thống Kê Sản Phẩm Yêu Thích";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        List<Object[]> productLikeModels = new LinkedList<>();
        try {
            if (StringUtils.isNotBlank(fromDate) && StringUtils.isNotBlank(toDate)) {
                headerName = headerName.concat(" từ ngày " + fromDate + " đến ngày " + toDate);
                Date fromDateFilter = formatter.parse(fromDate);
                Date toDateFilter = formatter.parse(toDate);
                productLikeModels = orderRepository.findProductLikeFromDateToDate(fromDateFilter, toDateFilter);
            } else if (StringUtils.isNotBlank(fromDate)) {
                Date fromDateFilter = formatter.parse(fromDate);
                headerName = headerName.concat(" từ ngày " + fromDate);
                productLikeModels = orderRepository.findProductLikeFromDate(fromDateFilter);
            } else if (StringUtils.isNotBlank(toDate)) {
                Date toDateFilter = formatter.parse(toDate);
                headerName = headerName.concat(" đến ngày " + toDate);
                productLikeModels = orderRepository.findProductLikeToDate(toDateFilter);
            } else {
                productLikeModels = orderRepository.findProductLike();
            }
        } catch (Exception e) {
            productLikeModels = orderRepository.findProductLike();
        }

        writeHeaderTop(sheet, headerName, 0, "A1", "E1");
        writeHeaderLine(sheet, HEADER_EXPORT_PRODUCT_LIKE, "Thống Kê Sản Phẩm Yêu Thích", 1);
        writeProductLike(productLikeModels);

        reportAuthor(fromDate, toDate);
        reportPublisher(fromDate, toDate);
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    private void reportAuthor(String fromDate, String toDate){

        String headerName = "Thống Kê Tác Giả Yêu Thích";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        sheet = workbook.createSheet("Thống Kê Tác Giả Yêu Thích");

        List<Object[]> authorLikeModels = new LinkedList<>();
        try {
            if (StringUtils.isNotBlank(fromDate) && StringUtils.isNotBlank(toDate)) {
                headerName = headerName.concat(" từ ngày " + fromDate + " đến ngày " + toDate);
                Date fromDateFilter = formatter.parse(fromDate);
                Date toDateFilter = formatter.parse(toDate);
                authorLikeModels = orderRepository.findAuthorLikeFromDateToDate(fromDateFilter, toDateFilter);
            } else if (StringUtils.isNotBlank(fromDate)) {
                Date fromDateFilter = formatter.parse(fromDate);
                headerName = headerName.concat(" từ ngày " + fromDate);
                authorLikeModels = orderRepository.findAuthorLikeFromDate(fromDateFilter);
            } else if (StringUtils.isNotBlank(toDate)) {
                Date toDateFilter = formatter.parse(toDate);
                headerName = headerName.concat(" đến ngày " + toDate);
                authorLikeModels = orderRepository.findAuthorLikeToDate(toDateFilter);
            } else {
                authorLikeModels = orderRepository.findAuthorLike();
            }
        } catch (Exception e) {
            authorLikeModels = orderRepository.findAuthorLike();
        }

        writeHeaderTop(sheet, headerName, 0, "A1", "E1");
        writeHeaderLine(sheet, HEADER_EXPORT_AUTHOR_LIKE, "Thống Kê Tác Giả Yêu Thích", 1);
        writeProductLike(authorLikeModels);
    }

    private void reportPublisher(String fromDate, String toDate){

        String headerName = "Thống Kê Nhà Xuất Bản Yêu Thích";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        sheet = workbook.createSheet("Thống Kê Nhà Xuất Bản Yêu Thích");

        List<Object[]> publisherLikeModels = new LinkedList<>();
        try {
            if (StringUtils.isNotBlank(fromDate) && StringUtils.isNotBlank(toDate)) {
                headerName = headerName.concat(" từ ngày " + fromDate + " đến ngày " + toDate);
                Date fromDateFilter = formatter.parse(fromDate);
                Date toDateFilter = formatter.parse(toDate);
                publisherLikeModels = orderRepository.findPublisherLikeFromDateToDate(fromDateFilter, toDateFilter);
            } else if (StringUtils.isNotBlank(fromDate)) {
                Date fromDateFilter = formatter.parse(fromDate);
                headerName = headerName.concat(" từ ngày " + fromDate);
                publisherLikeModels = orderRepository.findPublisherLikeFromDate(fromDateFilter);
            } else if (StringUtils.isNotBlank(toDate)) {
                Date toDateFilter = formatter.parse(toDate);
                headerName = headerName.concat(" đến ngày " + toDate);
                publisherLikeModels = orderRepository.findPublisherLikeToDate(toDateFilter);
            } else {
                publisherLikeModels = orderRepository.findPublisherLike();
            }
        } catch (Exception e) {
            publisherLikeModels = orderRepository.findPublisherLike();
        }

        writeHeaderTop(sheet, headerName, 0, "A1", "E1");
        writeHeaderLine(sheet, HEADER_EXPORT_PUBLISHER_LIKE, "Thống Kê Nhà Xuất Bản Yêu Thích", 1);
        writeProductLike(publisherLikeModels);
    }


    private void writeProductLike(List<Object[]> productLikes) {
        int rowCount = 2;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        CellStyle styleNum = workbook.createCellStyle();
        DataFormat format = workbook.createDataFormat();
        font.setFontHeight(14);
        styleNum.setFont(font);
        styleNum.setDataFormat(format.getFormat("#"));
        try {
            for (Object[] produtInfo : productLikes) {
                Row row = sheet.createRow(rowCount++);
                int columnCount = 0;
                createCell(row, columnCount++, String.valueOf(produtInfo[0]), style);
                createCell(row, columnCount++, String.valueOf(produtInfo[1]), style);
                createCell(row, columnCount++, String.valueOf(produtInfo[2]), style);
                createCell(row, columnCount++, String.valueOf(produtInfo[3]), style);
                createCell(row, columnCount++, Integer.valueOf(String.valueOf(produtInfo[4])), styleNum);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
