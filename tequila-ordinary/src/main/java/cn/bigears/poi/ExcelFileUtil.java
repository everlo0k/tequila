package cn.bigears.poi;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * excel文件工具类，用于excel导入导出
 */
public class ExcelFileUtil {
    /**
     * 创建工作薄
     */
    public static Workbook createWorkbook() {
        return new HSSFWorkbook();
    }

    public static void exportFile(Boolean isUseSerialColumn, String downloadFileName, String[] headers, String[] fields, Collection<?> dataList, Map<String, Map> map, String fileUrl) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        setHeaders(isUseSerialColumn, sheet, headers, null);
        fillContent(isUseSerialColumn, sheet, fields, dataList, null, map);
        FileOutputStream fos = new FileOutputStream(fileUrl + downloadFileName);
        workbook.write(fos);
        fos.flush();
    }

    /**
     * 填充表格正文内容
     * @param isSerial 首列是否使用序号
     * @param sheet
     * @param fields   集合元素中要取值的属性
     * @param dataList 表格里要填充的数据
     */
    private static void fillContent(Boolean isSerial, Sheet sheet, String[] fields, Collection dataList, CellStyle cellStyle, Map<String, Map> map) {
        if (fields == null || fields.length == 0 || dataList == null || dataList.size() == 0) {
            return;
        }
        //首序是否使用序号？
        int serialCellIndex = 0;
        int serialNo = 1;
        if (isSerial) {
            serialCellIndex = 1;
        }
        Iterator<?> iterator = dataList.iterator();
        int lastRowNum = sheet.getLastRowNum();
        if (sheet.getRow(0) != null) {
            lastRowNum = 1;
        }
        while (iterator.hasNext()) {
            Row row = sheet.createRow(lastRowNum++);
            if (isSerial) {
                Cell cell = row.createCell(0);
                cell.setCellValue(serialNo++);
                if (cellStyle != null) {
                    cell.setCellStyle(cellStyle);
                }
            }
            Object next = iterator.next();
            for (int i = 0; i < fields.length; i++) {
                String fieldName = fields[i];
                Cell cell = row.createCell(i + serialCellIndex);
                setCellValue(cell, getFieldValue(next, fieldName, map), fieldName, map != null ? map.get(fieldName) : null);
                if (cellStyle != null) {
                    cell.setCellStyle(cellStyle);
                }
            }
        }
    }

    /**
     * 通过输出流写出
     */
    private static void doExport(String downloadFileName, Workbook workBook, HttpServletResponse response) {
        OutputStream outputStream = null;
        try {
            //设置下载响应头
            response.setHeader("Content-Disposition", "attachment;filename=" + downloadFileName);
            response.setContentType("application/vnd.ms-excel");
            outputStream = response.getOutputStream();
            workBook.write(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 设置列宽自适应
     */
    private static void setAutoSizeColumn(Sheet sheet, Boolean isUseSerialColumn, int columnLength) {
        //设置自动列宽
        int cellIndex = columnLength;
        if (isUseSerialColumn) {
            cellIndex += 1;
        }
        for (int i = 0; i < cellIndex; i++) {
            //自动调整每一列宽度，只适用于英文和数字
            sheet.autoSizeColumn(i);
            // 解决自动设置列宽中文失效的问题
            sheet.setColumnWidth(i, Math.min(sheet.getColumnWidth(i) * 17 / 10, 255 << 8));
        }
    }

    // 自适应宽度(中文支持)
    private void setSizeColumn(Sheet sheet, int size) {
        for (int columnNum = 0; columnNum < size; columnNum++) {
            int columnWidth = sheet.getColumnWidth(columnNum) / 256;
            for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                Row currentRow;
                //当前行未被使用过
                if (sheet.getRow(rowNum) == null) {
                    currentRow = sheet.createRow(rowNum);
                } else {
                    currentRow = sheet.getRow(rowNum);
                }

                if (currentRow.getCell(columnNum) != null) {
                    Cell currentCell = currentRow.getCell(columnNum);
                    if (currentCell.getCellType() == Cell.CELL_TYPE_STRING) {
                        int length = currentCell.getStringCellValue().getBytes().length;
                        if (columnWidth < length) {
                            columnWidth = length;
                        }
                    }
                }
            }
            sheet.setColumnWidth(columnNum, columnWidth * 256);
        }
    }

    /**
     * 设置标题行
     * @param isSerial 首列是否使用序号列
     * @param sheet
     * @param headers  标题行
     */
    private static void setHeaders(Boolean isSerial, Sheet sheet, String[] headers, CellStyle cellStyle) {
        sheet.setDefaultColumnWidth(30);
        if (headers != null && headers.length > 0) {
            Row headerRow = sheet.createRow(0);
            int cellIndex = 0;
            int serialNoCellIndex = 0;
            if (isSerial) {
                Cell cell = headerRow.createCell(serialNoCellIndex);
                cell.setCellValue("序号");
                if (cellStyle != null) {
                    cell.setCellStyle(cellStyle);
                }
                serialNoCellIndex = 1;
                cellIndex++;
            }
            for (int i = 0; i < headers.length; i++) {
                cellIndex++;
                Cell cell = headerRow.createCell(i + serialNoCellIndex);
                cell.setCellValue(headers[i]);
                if (cellStyle != null) {
                    cell.setCellStyle(cellStyle);
                }
            }

            if (cellIndex > 0) {
                for (int i = 0; i < cellIndex; i++) {
                    sheet.autoSizeColumn(i);
                    sheet.setColumnWidth(i, sheet.getColumnWidth(i) * 17 / 10);
                }
            }


        }
    }

    /**
     * 设置cell的值
     * @param map   value需要特殊处理,map中存放的是对应关系
     * @param cell
     * @param value 设置的值
     */
    private static void setCellValue(Cell cell, Object value, String fieldName, Map<Object, String> map) {
        if (cell == null || value == null) return;
        boolean flag = false;
        if (map != null && map.keySet().size() > 0) {
            flag = true;
        }
        if (value instanceof Date) {
            //此段代码有bug,最多能设置43个单元格的日期格式
           /* Workbook workbook = cell.getSheet().getWorkbook();
            CellStyle cellStyle = workbook.createCellStyle();
            DataFormat dataFormat = workbook.createDataFormat();
            cellStyle.setDataFormat(dataFormat.getFormat("yyyy-MM-dd HH:mm:ss"));
            cell.setCellStyle(cellStyle);*/
            if (flag && StringUtils.isNotEmpty(fieldName)) {
                String dateString = new SimpleDateFormat(map.get(fieldName)).format((Date) value);
                cell.setCellValue(dateString);
                return;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (fieldName.contains("日期")) {
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            }
            String dateString = simpleDateFormat.format((Date) value);
            cell.setCellValue(dateString);
        } else if (value instanceof String) {
            if (flag) {
                cell.setCellValue(map.get(value));
                return;
            }
            cell.setCellValue((String) value);
        } else if (value instanceof Integer) {
            if (flag) {
                cell.setCellValue(map.get(value));
                return;
            }
            cell.setCellValue(((Integer) value).intValue());
        } else if (value instanceof Double) {
            cell.setCellValue(((Double) value).doubleValue());
        } else if (value instanceof Float) {
            cell.setCellValue(((Float) value).floatValue());
        } else if (value instanceof Long) {
            cell.setCellValue(((Long) value).longValue());
        } else if (value instanceof BigDecimal) {
            cell.setCellValue(((BigDecimal) value).stripTrailingZeros().toPlainString());
        } else {
            cell.setCellType(Cell.CELL_TYPE_BLANK);
        }
    }

    /**
     * 设置cell的值
     * @param cell
     * @param value
     */
    private static void setCellValue(Cell cell, Object value) {
        setCellValue(cell, value, null, null);
    }

    /**
     * 获取属性值
     * @return
     */
    private static Object getFieldValue(Object next, String fieldName, Map map) {
        String[] fieldNames = fieldName.split("\\.");
        Object defaultValue = map != null ? map.get("defaultValue") : null;
        int i = 0;
        do {
            String newFieldName = fieldNames.length != 0 ? fieldNames[i] : fieldName;
            if (next instanceof Map) {
                next = ((Map) next).get(newFieldName);
            } else {
                Class<?> aClass = next.getClass();
                char c = Character.toUpperCase(newFieldName.charAt(0));
                newFieldName = c + newFieldName.substring(1);
                try {
                    Method method = aClass.getMethod("get" + newFieldName, null);
                    next = method.invoke(next, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (next == null) {
                return defaultValue != null ? ((HashMap) defaultValue).get(fieldName) : null;
            }
            i++;
        } while (i < fieldNames.length);
        return next;
    }

    /**
     * 处理下载名的中文乱码问题
     */
    public static String handleFileName(String fileName, HttpServletRequest request) throws Exception {
        String userAgent = request.getHeader("User-Agent");
        if (userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } else {
            fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
        }

        return fileName;
    }


}
