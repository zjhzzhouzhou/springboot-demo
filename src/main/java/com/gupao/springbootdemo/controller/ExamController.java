package com.gupao.springbootdemo.controller;

import com.gupao.springbootdemo.service.ExamService;
import com.gupao.springbootdemo.service.ExamService3;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述:
 *
 * @Author: zhouzhou
 * @Date: 2020/11/6$ 14:46$
 */
@Api(tags = "试卷生成器")
@RestController
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private ExamService3 examService3;

    @ApiOperation("生成百位内加减法100题")
    @PostMapping("/exam100")
    public void getHandredExam(Integer count) throws Exception {
        examService.testHundredRenderMap();
    }

    @ApiOperation("生成千位内加减法1000题")
    @PostMapping("/exam1000")
    public void getThousandExam(Integer count) throws Exception {
        examService.testThousandRenderMap();
    }

    @ApiOperation("乘法60题")
    @PostMapping("/xexam60")
    public void getXExam(Integer count) throws Exception {
        examService3.testRenderMap();
    }


}
