package com.apsd.yujing.service;

import com.apsd.yujing.entiy.*;
import com.apsd.yujing.vo.InfoVo;
import com.apsd.yujing.vo.ProductVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2019:49
 */
public interface ProductService{

    Product addProduct(Product product, ProductDetails productDetails);
    ProductType addProductType(ProductType productType);
    List<ProductType> getProductTypeListByFlag(boolean flag);
    Page<Product> getProductListByFlag(Integer page,Integer size, boolean flag);
    ProductVo getProductListByFlagAndType(Integer page, Integer size, boolean flag, String type)throws Exception;
    void deleteProductById(Integer id);
    void deleteProductTypeById(Integer id);
    InfoVo getProductInfoByIdAndFlagAndType(Integer id,boolean flag,String type);
    Product getProductById(Integer id);
    ProductDetails getProductDetailsByPid(Integer Pid);
    List<SpecificationParameter> addSpecification(SpecificationParameter specificationParameter);
    List<SpecificationParameter> getSpecification(Integer pid);
    SpecificationParameter updateSpecification(SpecificationParameter specificationParameter);
    void deleteSpecificationParameterById(Integer id);
    void deleteInstallationProcessById(Integer id);
    ApplicationGuide getApplicationGuideByPid(Integer pid);
    ApplicationGuide addApplicationGuide(ApplicationGuide applicationGuide);
    ApplicationGuide updateApplicationGuide(ApplicationGuide applicationGuide);
    List<InstallationProcess> getInstallationProcessListByPid(Integer pid);
    InstallationProcess addInstallationProcess(InstallationProcess installationProcess);
    InstallationProcess updateInstallationProcess(InstallationProcess installationProcess);

}
