package com.apsd.yujing.controller;

import com.apsd.yujing.entiy.*;

import com.apsd.yujing.service.*;
import com.apsd.yujing.vo.InfoVo;
import com.apsd.yujing.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2014:14
 */
@RestController
@RequestMapping("/get")
@CrossOrigin
public class GetController {
    @Autowired
    private CaseService caseService;
    @Autowired
    private ProblemService problemService;
    @Autowired
    private SolutionService solutionService;
    @Autowired
    private ProcessService processService;
    @Autowired
    private SupportService supportService;
    @Autowired
    private IntroductionService introductionService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SeniorityService seniorityService;
    @Autowired
    private CultureService cultureService;
    @Autowired
    private EnvironmentalService environmentalService;
    @Autowired VideoService videoService;
    @GetMapping("/support")
    public ResultVo getSupport(Integer flag){
        try {
            if(flag==0){
                return ResultVo.ok(supportService.getSupport(false,true)) ;
            }else {
                return ResultVo.ok(supportService.getSupport(true,true)) ;
            }
        }catch (Exception e){
            return ResultVo.build(403,"发生未知错误~");
        }
    }
    @GetMapping("/introduction")
    public ResultVo getIntroduction(Integer flag){
        try {
            if(flag==0){
                return ResultVo.ok(introductionService.getIntroduction(false,true)) ;
            }else {
                return ResultVo.ok(introductionService.getIntroduction(true,true)) ;
            }
        }catch (Exception e){
            return ResultVo.build(403,"发生未知错误~");
        }
    }
    @GetMapping("/culture")
    public ResultVo getCulture(Integer flag){
        try {
            if(flag==0){
                return ResultVo.ok(cultureService.getCulture(false,true)) ;
            }else {
                return ResultVo.ok(cultureService.getCulture(true,true)) ;
            }
        }catch (Exception e){
            return ResultVo.build(403,"发生未知错误~");
        }
    }
    @GetMapping("/product")
    public ResultVo getProduct(Integer id) {
        Product p = productService.getProductById(id);
        if (p != null) {
            if (p.getImgs() != null) {
                p.setImgList(Arrays.asList(p.getImgs().split(",")));
            }
            return ResultVo.ok(p);
        } else {
            return ResultVo.build(403, "操作失败！");
        }
    }
    @GetMapping("/productDetails")
    public ResultVo getProductDetails(Integer id) {
        ProductDetails p = productService.getProductDetailsByPid(id);
        if (p != null) {
            return ResultVo.ok(p);
        } else {
            return ResultVo.build(403, "操作失败！");
        }
    }
    @GetMapping("/newsList")
    public Page<News> getNewsList(Integer page,Integer size,Integer flag,Integer type){
        if(flag==0){
            return newsService.getNewsListByFlagAndType(page,size,false,type);
        }else {
            return newsService.getNewsListByFlagAndType(page,size,true,type);
        }
    }


    @GetMapping("/caseKindList")
    public Page<CaseKind> getCaseKindList(Integer page,Integer size, Integer flag, Integer type){
        if(flag==0){
            return caseService.getCaseKindListByFlag(page,size,false,type);
        }else{
            return caseService.getCaseKindListByFlag(page,size,true,type);
        }
    }
    @GetMapping("/installationProcessList")
    public ResultVo getInstallationProcessList(Integer pid){
        List<InstallationProcess> ips = productService.getInstallationProcessListByPid(pid);
        if(ips.size()!=0){
            return ResultVo.ok(ips);
        }else {
            return ResultVo.build(403,"暂无数据请添加~");
        }
    }
    @GetMapping("/applicationGuide")
    public ResultVo getApplicationGuide(Integer pid){
        ApplicationGuide a = productService.getApplicationGuideByPid(pid);
        if(a!=null){
            return ResultVo.ok(a);
        }else {
            return ResultVo.build(403,"暂无数据请添加~");
        }
    }
    @GetMapping("/specificationList")
    public ResultVo getSpecificationList(Integer pid){
        List<SpecificationParameter> spList = productService.getSpecification(pid);
        if(spList.size()!=0){
            return ResultVo.ok(spList);
        }else {
            return ResultVo.build(403,"暂无数据请添加~");
        }
    }

    @GetMapping("/videoList")
    public Page<Video> getVideoList(Integer page,Integer size){
        return videoService.getVideoList(page,size);
    }
    @GetMapping("/environmentalList")
    public Page<Environmental> getEnvironmentalList(Integer page,Integer size){
        return environmentalService.getEnvironmentalList(page,size);
    }

    @GetMapping("/seniorityList")
    public Page<Seniority> getSeniorityList(Integer page,Integer size,Integer flag){
        if(flag==0){
            return seniorityService.getSeniorityListByFlag(page,size,false);
        }else {
            return seniorityService.getSeniorityListByFlag(page,size,true);
        }
    }

    @GetMapping("/productList")
    public ResultVo getProductList(Integer page,Integer size,Integer flag,Integer type){
        try {
            if(flag==0){
                return ResultVo.ok(productService.getProductListByFlagAndType(page,size,false,type));
            }else{
                return ResultVo.ok(productService.getProductListByFlagAndType(page,size,true,type));
            }
        }catch (Exception e){
            return ResultVo.build(403,"发生未知错误~");
        }
    }
    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public ResultVo getSearch(String key,Integer flag){
        return ResultVo.ok(searchService.getSearch(key,flag));

    }
    @GetMapping("/productTypeShowList")
    public ResultVo getProductTypeShowList(Integer flag){
        if(flag==0){
            return ResultVo.ok(productService.getProductTypeListByFlagAndState(false,true));
        }else{
            return ResultVo.ok(productService.getProductTypeListByFlagAndState(true,true));
        }
    }
    @GetMapping("/productTypeList")
    public ResultVo getProductType(Integer flag){
        if(flag==0){
            return ResultVo.ok(productService.getProductTypeListByFlag(false));
        }else{
            return ResultVo.ok(productService.getProductTypeListByFlag(true));
        }
    }


    @GetMapping("/caseTypeList")
    public ResultVo getCaseTypeListByFlag(Integer flag){
        if(flag==0){
            return ResultVo.ok(caseService.getCaseTypeListByFlag(false));
        }else{
            return ResultVo.ok(caseService.getCaseTypeListByFlag(true));
        }
    }


    @GetMapping("/problemList")
    public Page<Problem> getProblemList(Integer page,Integer size,Integer flag){
        if(flag==0){
            return problemService.getProblemListByFlag(page,size,false);
        }else {
            return problemService.getProblemListByFlag(page,size,true);
        }
    }
    @GetMapping("/newsInfo")
    public ResultVo getNewsInfoByIdAndFlagAndType(Integer id,Integer flag,Integer type){
        InfoVo info=null;
        if(flag==0){
            info = newsService.getNewsInfoByIdAndFlagAndType(id,false,type);
        }else {
            info = newsService.getNewsInfoByIdAndFlagAndType(id,true,type);
        }
        if(info!=null){
            return ResultVo.ok(info);
        }else {
            return ResultVo.build(403,"操作失败~！");
        }
    }
    @GetMapping("/caseKindInfo")
    public ResultVo getCaseKindById(Integer id,Integer flag,Integer type){
        InfoVo info=null;
        if(flag==0){
            info = caseService.getCaseKindInfoByIdAndFlag(id,false,type);
        }else {
            info = caseService.getCaseKindInfoByIdAndFlag(id,true,type);
        }
        if(info!=null){
            return ResultVo.ok(info);
        }else {
            return ResultVo.build(403,"操作失败~！");
        }
    }
    @GetMapping("/productInfo")
    public ResultVo getProductByIdAndFlagAndType(Integer id,Integer flag,Integer type){
        InfoVo info=null;
        if(flag==0){
            info = productService.getProductInfoByIdAndFlagAndType(id,false,type);
        }else {
            info = productService.getProductInfoByIdAndFlagAndType(id,true,type);
        }
        if(info!=null){
            return ResultVo.ok(info);
        }else {
            return ResultVo.build(403,"操作失败~！");
        }
    }
    @GetMapping("/solutionInfo")
    public ResultVo getSolutionById(Integer id,Integer flag,Integer type){
        InfoVo info=null;
        if(flag==0){
            info = solutionService.getSolutionInfoByIdAndFlagAndType(id,false,type);
        }else {
            info = solutionService.getSolutionInfoByIdAndFlagAndType(id,true,type);
        }
        if(info!=null){
            return ResultVo.ok(info);
        }else {
            return ResultVo.build(403,"操作失败~！");
        }
    }
    @GetMapping("/solutionList")
    public Page<Solution> getSolutionList(Integer page,Integer size, Integer flag,Integer type){
        if(flag==0){
            return solutionService.getSolutionListByFlagAndType(page,size,false,type);
        }else {
            return solutionService.getSolutionListByFlagAndType(page,size,true,type);
        }
    }
    @GetMapping("/processList")
    public ResultVo getProcessList(Integer flag){
        if(flag==0){
            return ResultVo.ok(processService.getProcessListByFlag(false));
        }else {
            return ResultVo.ok(processService.getProcessListByFlag(true));
        }
    }
    @Autowired
    private ContactService contactService;
    @PostMapping("/addContact")
    public ResultVo addContact(@Valid Contact contact, BindingResult br){
        if(br.hasErrors()){
            return ResultVo.build(403,"操作失败！");
        }
        Contact c = contactService.addContact(contact);
        if(c!=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403,"操作失败！");
        }
    }
}
