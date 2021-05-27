package jecy.test.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReaderUtil {
    public static List<List<String>> readExcel(String path){
        String fileType = path.substring(path.lastIndexOf(".") + 1);
        List<List<String>> lists = new ArrayList<>();
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            Workbook wb = null;
            if ("xls".equals(fileType)) {
                wb = new HSSFWorkbook(is);
            } else if ("xlsx".equals(fileType)) {
                wb = new XSSFWorkbook(is);
            } else {
                return null;
            }

            Sheet sheet = wb.getSheet("规则测试");
            if(sheet!=null){
                for (Row row : sheet) {
                    List<String> list = new ArrayList<>();
                    for (Cell cell : row) {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        list.add(cell.getStringCellValue());
                    }
                    lists.add(list);
                }
            } else {
                sheet = wb.getSheet("规则");
                if(sheet!=null){
                    for (Row row : sheet) {
                        List<String> list = new ArrayList<>();
                        for (Cell cell : row) {
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            list.add(cell.getStringCellValue());
                        }
                        lists.add(list);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lists;
    }
}
