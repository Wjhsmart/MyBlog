package com.zywork.controller;

import com.zywork.common.BeanUtils;
import com.zywork.service.InfoService;
import com.zywork.vo.InfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Api("页面跳转的控制器")
@RestController
@RequestMapping("/")
public class PageController {


    private InfoService infoService;

    @Autowired
    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

    @ApiOperation("首页")
    @GetMapping(value = {"index","/"})
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        InfoVO infoVO = BeanUtils.copy(infoService.getInfo(), InfoVO.class);
        mav.addObject("info", infoVO);
        return mav;
    }

    @ApiOperation("关于我")
    @GetMapping("about")
    public ModelAndView about() {
        ModelAndView mav = new ModelAndView("about");
        InfoVO infoVO = BeanUtils.copy(infoService.getInfo(), InfoVO.class);
        mav.addObject("info", infoVO);
        return mav;
    }

    @ApiOperation("资源下载")
    @GetMapping("download")
    public ModelAndView download() {
        ModelAndView mav = new ModelAndView("download");
        InfoVO infoVO = BeanUtils.copy(infoService.getInfo(), InfoVO.class);
        mav.addObject("info", infoVO);
        return mav;
    }

    @ApiOperation("学无止境")
    @GetMapping("list")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("list");
        InfoVO infoVO = BeanUtils.copy(infoService.getInfo(), InfoVO.class);
        mav.addObject("info", infoVO);
        return mav;
    }

    @ApiOperation("时间轴")
    @GetMapping("timeaxis")
    public ModelAndView timeaxis() {
        ModelAndView mav = new ModelAndView("timeaxis");
        InfoVO infoVO = BeanUtils.copy(infoService.getInfo(), InfoVO.class);
        mav.addObject("info", infoVO);
        return mav;
    }

    @ApiOperation("留言")
    @GetMapping("gbook")
    public ModelAndView gbook() {
        ModelAndView mav = new ModelAndView("gbook");
        InfoVO infoVO = BeanUtils.copy(infoService.getInfo(), InfoVO.class);
        mav.addObject("info", infoVO);
        return mav;
    }
}
