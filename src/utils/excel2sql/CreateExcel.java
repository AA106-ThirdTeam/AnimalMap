package utils.excel2sql;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;


import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class CreateExcel {
    public static void main(String args[]) {
        try {
            // 打開文件
            WritableWorkbook book = Workbook.createWorkbook(new File("c:/test.xls"));
            
            
            Excel_to_SQL.main(args);
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            // 生成名為“第一頁”的工作表，參數0表示這是第一頁
            WritableSheet sheet = book.createSheet(" 第一頁 ", 0);
            // 在Label對象的構造子中指名單元格位置是第一列第一行(0,0)
            // 以及單元格內容為test
            Label label = new Label(0, 0, " test ");
            // 將定義好的單元格添加到工作表中
            sheet.addCell(label);

            // 生成一個保存數字的單元格，必須使用Number的完整包路徑，否則有語法歧義。
            //單元格位置是第二列，第一行，值為123.456
            jxl.write.Number number = new jxl.write.Number(1, 0, 123.456);
            sheet.addCell(number);

            // 寫入數據並關閉文件
            book.write();
            book.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

