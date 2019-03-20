package com.example.excel;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/10/31
 */
public class ExcelWriterTest {

    public static void main(String[] args) throws Exception{
        OutputStream out = new FileOutputStream("write.xlsx");
        ExcelWriter writer = null;
        try {
            writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
            Sheet sheet1 = new Sheet(1, 0);
            sheet1.setSheetName("第一个sheet");
            writer.write0(getListString(), sheet1);
        } catch (Exception e) {

        }
        writer.finish();

    }
    private static List<List<String>> getListString() {
        List<String> list = new ArrayList<String>();
        list.add("ooo1");
        list.add("ooo2");
        list.add("ooo3");
        list.add("ooo4");
        List<String> list1 = new ArrayList<String>();
        list1.add("ooo1");
        list1.add("ooo2");
        list1.add("ooo3");
        list1.add("ooo4");
        List<List<String>> ll = new ArrayList<List<String>>();
        ll.add(list);
        ll.add(list1);
        return ll;
    }
}
