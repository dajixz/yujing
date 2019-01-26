package com.apsd.yujing.service.impl;

import com.apsd.yujing.entiy.*;
import com.apsd.yujing.repository.*;
import com.apsd.yujing.service.ProductService;
import com.apsd.yujing.vo.InfoVo;
import com.apsd.yujing.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


import java.util.ArrayList;
import java.util.List;

/**
 * @author 大稽
 * @date2019/1/2019:52
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDetailsRepository productDetailsRepository;
    @Autowired
    private SpecificationParameterRepository specificationParameterRepository;
    @Autowired
    private ApplicationGuideRepository applicationGuideRepository;
    @Autowired
    private InstallationProcessRepository installationProcessRepository;

    @Override
    @Transactional
    public ProductVo getProductListByFlagAndType(Integer page, Integer size, boolean flag, String type) throws Exception {
        Pageable pageable = PageRequest.of(page - 1, size,Sort.Direction.DESC,"id");
        String previous = null;
        String next = null;
        Page<Product> productPage = productRepository.findAllByFlagAndType(pageable, flag, type);
        if (size == 1) {
            if (productPage.hasPrevious()) {
                Pageable pageable0 = PageRequest.of(page - 2, size);
                Page<Product> productPage0 = productRepository.findAllByFlagAndType(pageable0, flag, type);
                previous = productPage0.getContent().get(0).getName();
            }
            if (productPage.hasNext()) {
                Pageable pageable1 = PageRequest.of(page, size);
                Page<Product> productPage0 = productRepository.findAllByFlagAndType(pageable1, flag, type);
                next = productPage0.getContent().get(0).getName();
            }
        }
        return new ProductVo(productPage, previous, next);
    }

    @Override
    public ApplicationGuide getApplicationGuideByPid(Integer pid) {
        return applicationGuideRepository.getApplicationGuideByPid(pid);
    }

    @Override
    public ApplicationGuide addApplicationGuide(ApplicationGuide applicationGuide) {
        return applicationGuideRepository.save(applicationGuide);
    }

    @Override
    public ApplicationGuide updateApplicationGuide(ApplicationGuide applicationGuide) {
        return applicationGuideRepository.save(applicationGuide);
    }

    @Override
    public List<InstallationProcess> getInstallationProcessListByPid(Integer pid) {
        return installationProcessRepository.findInstallationListByPid(pid);
    }

    @Override
    public InstallationProcess addInstallationProcess(InstallationProcess installationProcess) {
        return installationProcessRepository.save(installationProcess);
    }

    @Override
    public InstallationProcess updateInstallationProcess(InstallationProcess installationProcess) {
        return installationProcessRepository.save(installationProcess);
    }

    @Override
    public void deleteInstallationProcessById(Integer id) {
        installationProcessRepository.deleteById(id);
    }

    @Override
    public void deleteSpecificationParameterById(Integer id) {
        specificationParameterRepository.deleteById(id);
    }

    @Override
    public SpecificationParameter updateSpecification(SpecificationParameter specificationParameter) {
        System.out.println(specificationParameter);
        return specificationParameterRepository.save(specificationParameter);
    }

    @Override
    public List<SpecificationParameter> getSpecification(Integer pid) {
        return specificationParameterRepository.findAllByPid(pid);
    }

    @Override
    public List<SpecificationParameter> addSpecification(SpecificationParameter specificationParameter) {
        System.out.println(specificationParameter);
        int len = specificationParameter.getHandlingNumList().size();
        List<SpecificationParameter> specificationParameterList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            SpecificationParameter sp = new SpecificationParameter();
            sp.setSerialNum(specificationParameter.getSerialNumList().get(i));
            sp.setModelId(specificationParameter.getModelIdList().get(i));
            sp.setSpecifications(specificationParameter.getSpecificationsList().get(i));
            sp.setHandlingNum(specificationParameter.getHandlingNumList().get(i));
            sp.setTime(specificationParameter.getTimeList().get(i));
            sp.setPid(specificationParameter.getPid());
            specificationParameterList.add(sp);
        }
        return specificationParameterRepository.saveAll(specificationParameterList);
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteProductTypeById(Integer id) {
        productTypeRepository.deleteById(id);
    }

    @Override
    public InfoVo getProductInfoByIdAndFlagAndType(Integer id,boolean flag,String type) {
        InfoVo infoVo = new InfoVo();
        infoVo.setInfo(productRepository.findById(id).get());
        infoVo.setPrevInfo(productRepository.getPrevProductByNowId(id,flag,type));
        infoVo.setNextInfo(productRepository.getNextProductByNowId(id,flag,type));
        return infoVo;
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public ProductDetails getProductDetailsByPid(Integer pid) {
        return productDetailsRepository.findProductDetailsByPid(pid);
    }


    @Override
    @Transactional
    public Product addProduct(Product product, ProductDetails productDetails) {
        try {
            if (product.getImgList() != null) {
                product.setImgs(String.join(",", product.getImgList()));
            }
            Product save = productRepository.save(product);
            productDetails.setPid(save.getId());
            productDetailsRepository.save(productDetails);
            return save;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }
    }

    @Override
    public ProductType addProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    @Override
    public List<ProductType> getProductTypeListByFlag(boolean flag) {
        return productTypeRepository.findAllByFlag(flag);
    }

    @Override
    public Page<Product> getProductListByFlag(Integer page, Integer size, boolean flag) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.Direction.DESC,"id");
        return productRepository.findAllByFlag(pageable, flag);
    }
}
