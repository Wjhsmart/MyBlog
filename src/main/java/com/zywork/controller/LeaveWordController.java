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
import com.zywork.dto.LeaveWordDTO;
import com.zywork.query.LeaveWordQuery;
import com.zywork.service.LeaveWordService;
import com.zywork.vo.ResponseStatusVO;
import com.zywork.vo.PagerVO;
import com.zywork.vo.LeaveWordVO;

import java.util.List;

/**
 * LeaveWordController控制器类<br/>
 *
 * 创建于2019-03-06<br/>
 *
 * @author http://wjhsmart.vip 危锦辉
 * @version 1.0
 */
@RestController
@RequestMapping("/leave-word")
public class LeaveWordController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(LeaveWordController.class);

    private LeaveWordService leaveWordService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated LeaveWordVO leaveWordVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        leaveWordService.save(BeanUtils.copy(leaveWordVO, LeaveWordDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("user/save")
    public ResponseStatusVO userSave(@RequestBody @Validated LeaveWordVO leaveWordVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        leaveWordService.save(BeanUtils.copy(leaveWordVO, LeaveWordDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<LeaveWordVO> leaveWordVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        leaveWordService.saveBatch(BeanUtils.copyListObj(leaveWordVOList, LeaveWordDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        leaveWordService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        leaveWordService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated LeaveWordVO leaveWordVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = leaveWordService.update(BeanUtils.copy(leaveWordVO, LeaveWordDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<LeaveWordVO> leaveWordVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        leaveWordService.updateBatch(BeanUtils.copyListObj(leaveWordVOList, LeaveWordDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody LeaveWordVO leaveWordVO) {
        leaveWordService.update(BeanUtils.copy(leaveWordVO, LeaveWordDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<LeaveWordVO> leaveWordVOList) {
        leaveWordService.updateBatch(BeanUtils.copyListObj(leaveWordVOList, LeaveWordDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        LeaveWordVO leaveWordVO = new LeaveWordVO();
        Object obj = leaveWordService.getById(id);
        if (obj != null) {
            leaveWordVO = BeanUtils.copy(obj, LeaveWordVO.class);
        }
        return ResponseStatusVO.ok("查询成功", leaveWordVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = leaveWordService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), LeaveWordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody LeaveWordQuery leaveWordQuery) {
        PagerDTO pagerDTO = leaveWordService.listAllByCondition(leaveWordQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), LeaveWordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody LeaveWordQuery leaveWordQuery) {
        PagerDTO pagerDTO = leaveWordService.listPageByCondition(leaveWordQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), LeaveWordVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setLeaveWordService(LeaveWordService leaveWordService) {
        this.leaveWordService = leaveWordService;
    }
}
