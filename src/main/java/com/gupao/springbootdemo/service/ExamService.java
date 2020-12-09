package com.gupao.springbootdemo.service;

import com.deepoove.poi.XWPFTemplate;
import com.google.common.collect.Sets;
import com.gupao.springbootdemo.util.DateUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 功能描述:
 *
 * @Author: zhouzhou
 * @Date: 2020/11/6$ 14:48$
 */
@Service
public class ExamService {

    public static final String BLANK = "  ";
    public static final String PLACE_HOLDER = "formula";
    public static final String HUNDRED_DIGITS = "100";
    public static final String THOUSAND_DIGITS = "1000";



    /**
     * 生成百位数加减法
     *
     * @throws Exception
     */
    public void testHundredRenderMap() throws Exception {
        Set<String> hundredExamSet = getExamSet(HUNDRED_DIGITS);
        Map<String, Object> datas = new HashMap<String, Object>();
        int index = 1;
        for (String formula : hundredExamSet) {
            datas.put(PLACE_HOLDER + index, formula);
            index++;
        }
        XWPFTemplate template = XWPFTemplate.compile(new ClassPathResource("/exam_template.docx").getInputStream())
                .render(datas);

        HttpServletResponse httpServletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        OutputStream outputStream = httpServletResponse.getOutputStream();

        String fileName = "303Hundred-" + DateUtil.getDate(new Date()) + ".docx";
        //得请求头中的User-Agent
        httpServletResponse.setContentType("application/" + "docx");
        // 告诉客户端该文件不是直接解析，而是以附件形式打开（下载）
        httpServletResponse.setHeader("Content-Disposition", "attachment"
                + ";filename=" + URLEncoder.encode(fileName, "UTF-8"));

        template.write(outputStream);
        // 关闭流
        outputStream.flush();
        outputStream.close();
        template.close();
    }

    /**
     * 生成千位数加减法
     *
     * @throws Exception
     */
    public void testThousandRenderMap() throws Exception {
        Set<String> thousand = getExamSet(THOUSAND_DIGITS);
        Map<String, Object> datas = new HashMap<String, Object>();
        int index = 1;
        for (String formula : thousand) {
            datas.put(PLACE_HOLDER + index, formula);
            index++;
        }
        XWPFTemplate template = XWPFTemplate.compile(new ClassPathResource("/exam_template2.docx").getInputStream())
                .render(datas);


        HttpServletResponse httpServletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        OutputStream outputStream = httpServletResponse.getOutputStream();

        String fileName = "303Thousand-" + DateUtil.getDate(new Date()) + ".docx";
        //得请求头中的User-Agent
        httpServletResponse.setContentType("application/" + "docx");
        // 告诉客户端该文件不是直接解析，而是以附件形式打开（下载）
        httpServletResponse.setHeader("Content-Disposition", "attachment"
                + ";filename=" + URLEncoder.encode(fileName, "UTF-8"));

        template.write(outputStream);
        // 关闭流
        outputStream.flush();
        outputStream.close();
        template.close();
    }


    public Set<String> getExamSet(String digits) {
        //一共要生产50个算式,不能相同,100以内2位数加减法,结果要大于0

        //step1: 生成1个50大小的set容器
        Set<String> set = Sets.newHashSet();


        // 循环100次生成
        for (int i = 0; i < 100; i++) {
            while (true) {
                // 生成算式
                String formula = getFormula(digits);
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
    private String getFormula(String digits) {
        String formula = "";

        // 先随机生成算数符号
        String symbol = new Random().nextInt(2) > 0 ? "+" : "-";

        if (symbol.equals("+")) {
            int firstNum = 0;
            int secondNum = 0;
            if (digits.equals(HUNDRED_DIGITS)) {
                // 生成第一位
                 firstNum = new Random().nextInt(90) + 10;
                // 生成第二位
                 secondNum = new Random().nextInt(90) + 10;
            } else if (digits.equals(THOUSAND_DIGITS)) {
                firstNum = new Random().nextInt(900) + 100;
                // 生成第二位
                secondNum = new Random().nextInt(900) + 100;
            }

            formula = firstNum + BLANK + symbol + BLANK + secondNum + BLANK + "=";
            return formula;
        } else {
            while (true) {
                int firstNum = 0;
                int secondNum = 0;
                if (digits.equals(HUNDRED_DIGITS)) {
                    // 生成第一位
                    firstNum = new Random().nextInt(90) + 10;
                    // 生成第二位
                    secondNum = new Random().nextInt(90) + 10;
                } else if (digits.equals(THOUSAND_DIGITS)) {
                    firstNum = new Random().nextInt(900) + 100;
                    // 生成第二位
                    secondNum = new Random().nextInt(900) + 100;
                }
                if (firstNum > secondNum) {
                    formula = firstNum + BLANK + symbol + BLANK + secondNum + BLANK + "=";
                    return formula;
                }
            }
        }

    }

}
