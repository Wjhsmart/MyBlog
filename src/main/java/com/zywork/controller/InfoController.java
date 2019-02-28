package com.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.zywork.common.BeanUtils;
import com.zywork.common.BindingResultUtils;
import com.zywork.common.StringUtils;
import com.zywork.dto.PagerDTO;
import com.zywork.dto.InfoDTO;
import com.zywork.query.InfoQuery;
import com.zywork.service.InfoService;
import com.zywork.vo.ResponseStatusVO;
import com.zywork.vo.PagerVO;
import com.zywork.vo.InfoVO;

import java.util.List;

/**
 * InfoController控制器类<br/>
 *
 * 创建于2019-02-27<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
@RestController
@RequestMapping("/info")
public class InfoController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(InfoController.class);

    private InfoService infoService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated InfoVO infoVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        infoService.save(BeanUtils.copy(infoVO, InfoDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<InfoVO> infoVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        infoService.saveBatch(BeanUtils.copyListObj(infoVOList, InfoDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        infoService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        infoService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated InfoVO infoVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = infoService.update(BeanUtils.copy(infoVO, InfoDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<InfoVO> infoVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        infoService.updateBatch(BeanUtils.copyListObj(infoVOList, InfoDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody InfoVO infoVO) {
        infoService.update(BeanUtils.copy(infoVO, InfoDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<InfoVO> infoVOList) {
        infoService.updateBatch(BeanUtils.copyListObj(infoVOList, InfoDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        InfoVO infoVO = new InfoVO();
        Object obj = infoService.getById(id);
        if (obj != null) {
            infoVO = BeanUtils.copy(obj, InfoVO.class);
        }
        return ResponseStatusVO.ok("查询成功", infoVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = infoService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), InfoVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody InfoQuery infoQuery) {
        PagerDTO pagerDTO = infoService.listAllByCondition(infoQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), InfoVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody InfoQuery infoQuery) {
        PagerDTO pagerDTO = infoService.listPageByCondition(infoQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), InfoVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }
}
