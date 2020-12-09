package com.gupao.springbootdemo.test;

import com.deepoove.poi.XWPFTemplate;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 功能描述:
 *
 * @Author: zhouzhou
 * @Date: 2020/11/6$ 10:25$
 */
public class ExamTest {

    public static final String BLANK = "  ";
    public static final String PLACE_HOLDER = "formula";


    @Test
    public void testRenderMap() throws Exception {
        Set<String> hundredExamSet = getHundredExamSet();
        Map<String, Object> datas = new HashMap<String, Object>();
        int index = 1;
        for (String formula : hundredExamSet) {
            datas.put(PLACE_HOLDER + index, formula);
            index++;
        }

        XWPFTemplate template = XWPFTemplate.compile("D:\\project\\springboot-demo\\src\\test\\java\\com\\gupao\\springbootdemo\\test\\exam_template.docx")
                .render(datas);
        ;

        FileOutputStream out = new FileOutputStream("out_template.docx");
        template.write(out);
        out.flush();
        out.close();
        template.close();
    }

    @Test
    public Set<String> getHundredExamSet() {
        //一共要生产50个算式,不能相同,100以内2位数加减法,结果要大于0

        //step1: 生成1个50大小的set容器
        Set<String> set = Sets.newSet();


        // 循环50次生成
        for (int i = 0; i < 50; i++) {
            while (true) {
                // 生成算式
                String formula = getFormula();
                // 如果容器中有就继续, 没有添加进去
                if (!set.contains(formula)) {
                    set.add(formula);
                    break;
                }
            }
        }


        return set;
    }

    // 生成表达式
    private String getFormula() {
        String formula = "";

        // 先随机生成算数符号
        String symbol = new Random().nextInt(2) > 0 ? "+" : "-";

        if (symbol.equals("+")) {
            // 生成第一位
            int firstNum = new Random().nextInt(90) + 10;
            // 生成第二位
            int secondNum = new Random().nextInt(90) + 10;
            formula = firstNum + BLANK + symbol + BLANK + secondNum + BLANK + "=";
            return formula;
        } else {
            while (true) {
                // 生成第一位
                int firstNum = new Random().nextInt(90) + 10;
                // 生成第二位
                int secondNum = new Random().nextInt(90) + 10;
                if (firstNum > secondNum) {
                    formula = firstNum + BLANK + symbol + BLANK + secondNum + BLANK + "=";
                    return formula;
                }
            }
        }

    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            int result = new Random().nextInt(90) + 10;
            System.out.println(result);
        }
    }


}
