package com.gupao.springbootdemo.test;

import com.deepoove.poi.XWPFTemplate;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

/**
 * 功能描述:303专供多位数乘个位数特训
 *
 * @Author: zhouzhou
 * @Date: 2020/11/6$ 10:25$
 */
public class ExamTest3 {

    public static final String BLANK = "  ";
    public static final String PLACE_HOLDER = "formula";
    public static final String XPLACE_HOLDER = "xformula";


    @Test
    public void testRenderMap() throws Exception {
        HashMap<String, String> map = getChengJiaExamSet();
        HashMap<String, String> map2 = getQianChengExamSet();
        map.putAll(map2);


        XWPFTemplate template = XWPFTemplate.compile("D:\\project\\springboot-demo\\src\\test\\java\\com\\gupao\\springbootdemo\\test\\exam_template3.docx")
                .render(map);
        ;

        FileOutputStream out = new FileOutputStream("out_template3.docx");
        template.write(out);
        out.flush();
        out.close();
        template.close();
    }

    @Test
    public HashMap<String, String> getChengJiaExamSet() {
        //一共要生产30个乘加算式,不能相同,个位数乘加

        //step1: 生成1个30大小的set容器
        Set<String> set = Sets.newSet();

        HashMap<String, String> map = new HashMap<>();

        // 循环50次生成
        for (int i = 1; i <= 30; i++) {
            while (true) {
                // 生成算式
                String formula = getFormula();
                // 如果容器中有就继续, 没有添加进去
                if (!set.contains(formula)) {
                    set.add(formula);
                    map.put(PLACE_HOLDER + i, formula);
                    break;
                }
            }
        }


        return map;
    }

    public HashMap<String, String> getQianChengExamSet() {
        //一共要生产30个千乘算式,首位不能为0,乘数不能为0和1

        //step1: 生成1个30大小的set容器
        Set<String> set = Sets.newSet();

        HashMap<String, String> map = new HashMap<>();

        // 循环50次生成
        for (int i = 0; i < 30; i++) {
            while (true) {
                // 生成算式
                String formula = getXFormula();
                // 如果容器中有就继续, 没有添加进去
                if (!set.contains(formula)) {
                    set.add(formula);
                    map.put(XPLACE_HOLDER + (i + 1), formula);

                    break;
                }
            }
        }


        return map;
    }

    // 生成乘加表达式
    private static String getFormula() {
        String formula = "";

        // 生成第一位
        int firstNum = new Random().nextInt(8) + 2;
        // 生成第二位
        int secondNum = new Random().nextInt(8) + 2;
        // 生成第三位
        int thirdNum = new Random().nextInt(9) + 1;
        formula = firstNum + "×" + secondNum + "+" + thirdNum + "=";
        return formula;


    }


    // 生成百位数乘法表达式
    private static String getXFormula() {
        String formula = "";

        // 生成第一位
        int firstNum = new Random().nextInt(800) + 100;
        // 生成第二位
        int secondNum = new Random().nextInt(8) + 2;
        formula = firstNum + "×" + secondNum + "=";
        return formula;


    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String formula = getXFormula();
            System.out.println(formula);
        }
    }


}
