package com.apsd.yujing.controller;

import com.apsd.yujing.entiy.*;
import com.apsd.yujing.service.ProductService;
import com.apsd.yujing.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2019:28
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @PutMapping("/updateProductTypeState")
    public ResultVo updateProductTypeState(Integer id,boolean state){
        Integer integer = productService.updateProductTypeState(!state,id);
        if(integer!=null){
            return ResultVo.ok();
        }else {
            return ResultVo.build(403,"操作失败~！");
        }
    }
    @PutMapping("/updateProduct")
    public ResultVo updateProduct(Product product, ProductDetails productDetails, Integer did) {
        productDetails.setId(did);
        Product p = productService.addProduct(product, productDetails);
        if (p != null) {
            return ResultVo.ok();
        } else {
            return ResultVo.build(403, "操作失败！");
        }
    }

    @GetMapping("/getProductList")
    public ResultVo getProductList(Integer page, Integer size, Integer flag) {
        if (flag == 0) {
            return ResultVo.ok(productService.getProductListByFlag(page, size, false));
        } else {
            return ResultVo.ok(productService.getProductListByFlag(page, size, true));
        }
    }

    @PostMapping("/addInstallation")
    public ResultVo addInstallation(InstallationProcess installationProcess) {
        InstallationProcess ip = productService.addInstallationProcess(installationProcess);
        if (ip != null) {
            return ResultVo.ok();
        } else {
            return ResultVo.build(403, "操作失败！");
        }
    }

    @PostMapping("/addApplicationGuide")
    public ResultVo addApplicationGuide(ApplicationGuide applicationGuide) {
        ApplicationGuide a = productService.addApplicationGuide(applicationGuide);
        if (a != null) {
            return ResultVo.ok();
        } else {
            return ResultVo.build(403, "操作失败！");
        }
    }



    @PutMapping("/updateSpecification")
    public ResultVo updateSpecification(SpecificationParameter specificationParameter) {
        SpecificationParameter sp = productService.updateSpecification(specificationParameter);
        if (sp != null) {
            return ResultVo.ok();
        } else {
            return ResultVo.build(403, "操作失败！");
        }
    }
    @DeleteMapping("/deleteInstallation")
    public ResultVo deleteInstallation(Integer id) {
        try {
            productService.deleteInstallationProcessById(id);
            return ResultVo.ok();
        } catch (Exception e) {
            return ResultVo.build(403, "操作失败！");
        }
    }

    @DeleteMapping("/deleteSpecification")
    public ResultVo deleteSpecification(Integer id) {
        try {
            productService.deleteSpecificationParameterById(id);
            return ResultVo.ok();
        } catch (Exception e) {
            return ResultVo.build(403, "操作失败！");
        }
    }

    @PostMapping("/addSpecification")
    public ResultVo addSpecification(SpecificationParameter specificationParameter) {
        List<SpecificationParameter> sps = productService.addSpecification(specificationParameter);
        if (sps != null) {
            return ResultVo.ok(sps);
        } else {
            return ResultVo.build(403, "操作失败！");
        }
    }


    @DeleteMapping("/deleteProduct")
    public ResultVo deleteProduct(Integer id) {
        try {
            productService.deleteProductById(id);
            return ResultVo.ok();
        } catch (Exception e) {
            return ResultVo.build(403, "操作失败！");
        }
    }

    @DeleteMapping("/deleteProductType")
    public ResultVo deleteProductType(Integer id) {
        try {
            productService.deleteProductTypeById(id);
            return ResultVo.ok();
        } catch (Exception e) {
            return ResultVo.build(403, "操作失败！");
        }
    }

    @PostMapping("/addProduct")
    public ResultVo addProduct(Product product, ProductDetails productDetails) {
        Product p = productService.addProduct(product, productDetails);
        if (p != null) {
            return ResultVo.ok();
        } else {
            return ResultVo.build(403, "操作失败！");
        }
    }

    @PostMapping("/addProductType")
    public ResultVo addProductType(ProductType productType) {
        ProductType p = productService.addProductType(productType);
        if (p != null) {
            return ResultVo.ok();
        } else {
            return ResultVo.build(403, "操作失败！");
        }
    }

}
