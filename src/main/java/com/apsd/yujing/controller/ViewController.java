package com.apsd.yujing.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 大稽
 * @date2019/1/1723:26
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    @GetMapping("/environmental-info")
    public String toEnvironmentInfoView(){
        return "environmental-info";
    }
    @GetMapping("/information-info")
    public String toInformationInfoView(){
        return "information-info";
    }
    @GetMapping("/information-list")
    public String toInformationListView(){
        return "information-list";
    }
    @GetMapping("/a")
    public String toAView(){
        return "a";
    }
    @GetMapping("/product-type-info")
    public String toProductTypeInfoView(){
        return "product-type-info";
    }
    @GetMapping("/user-list")
    public String toUserListView(){
        return "user-list";
    }
    @GetMapping("/role-list")
    public String toRoleListView(){
        return "role-list";
    }
    @GetMapping("/permission-list")
    public String toPermissionListView(){
        return "permission-list";
    }
    @GetMapping("/contact-list")
    public String toContactListView(){
        return "contact-list";
    }
    @GetMapping("/login")
    public String toLoginView(){
        return "login";
    }
    @GetMapping("/installation-process-add")
    public String toInstallationProcessAddView(){
        return "installation-process-add";
    }
    @GetMapping("/installation-process-info")
    public String toInstallationProcessInfoView(){
        return "installation-process-info";
    }
    @GetMapping("/application-guide-info")
    public String toApplicationGuideInfoView(){
        return "application-guide-info";
    }
    @GetMapping("/specification-info")
    public String toSpecificationAddView(){
        return "specification-info";
    }

    @GetMapping("/news-info")
    public String toNewsInfoView(){
        return "news-info";
    }
    @GetMapping("/culture-info")
    public String toCultureInfoView(){
        return "culture-info";
    }
    @GetMapping("/introduction-info")
    public String toIntroductionInfoView(){
        return "introduction-info";
    }
    @GetMapping("/support-info")
    public String toSupportInfoView(){
        return "support-info";
    }
    @GetMapping("/process-info")
    public String toProcessInfoView(){
        return "process-info";
    }
    @GetMapping("/problem-info")
    public String toProblemInfoView(){
        return "problem-info";
    }
    @GetMapping("/case-info")
    public String toCaseInfoView(){
        return "case-info";
    }
    @GetMapping("/solution-info")
    public String toSolutionInfoView(){
        return "solution-info";
    }
    @GetMapping("/product-info")
    public String toProductInfoView(){
        return "product-info";
    }
    @GetMapping("/product-type-add")
    public String toProductTypeAddView(){
        return "product-type-add";
    }
    @GetMapping("/product-type-list")
    public String toProductTypeListView(){
        return "product-type-list";
    }

    @GetMapping("/product-add")
    public String toProductAddView(){
        return "product-add";
    }
    @GetMapping("/product-list")
    public String toProductListView(){
        return "product-list";
    }
    @GetMapping("/welcome")
    public String toWelcomeView(){
        return "welcome";
    }
    @GetMapping("/solution-list")
    public String toSolutionListView(){
        return "solution-list";
    }
    @GetMapping("/solution-add")
    public String toSolutionAddView(){
        return "solution-add";
    }

    @GetMapping("/case-list")
    public String toCaseListView(){
        return "case-list";
    }
    @GetMapping("/case-add")
    public String toCaseAddView(){
        return "case-add";
    }
    @GetMapping("/case-type-list")
    public String toCaseTypeListView(){
        return "case-type-list";
    }
    @GetMapping("/case-type-add")
    public String toCaseTypeAddView(){
        return "case-type-add";
    }
    @GetMapping("/culture-list")
    public String toCultureListView(){
        return "culture-list";
    }
    @GetMapping("/culture-add")
    public String toCultureAddView(){
        return "culture-add";
    }
    @GetMapping("/environmental-list")
    public String toEnvironmentalListView(){
        return "environmental-list";
    }
    @GetMapping("/environmental-add")
    public String toEnvironmentalAddView(){
        return "environmental-add";
    }

    @GetMapping("/introduction-list")
    public String toIntroductionListView(){
        return "introduction-list";
    }
    @GetMapping("/introduction-add")
    public String toIntroductionAddView(){
        return "introduction-add";
    }

    @GetMapping("/news-list")
    public String toNewsListView(){
        return "news-list";
    }
    @GetMapping("/news-add")
    public String toNewsAddView(){
        return "news-add";
    }

    @GetMapping("/problem-list")
    public String toProblemListView(){
        return "problem-list";
    }
    @GetMapping("/problem-add")
    public String toProblemAddView(){
        return "problem-add";
    }

    @GetMapping("/process-list")
    public String toProcessListView(){
        return "process-list";
    }
    @GetMapping("/process-add")
    public String toProcessAddView(){
        return "process-add";
    }

    @GetMapping("/seniority-list")
    public String toSeniorityListView(){
        return "seniority-list";
    }
    @GetMapping("/seniority-add")
    public String toSeniorityAddView(){
        return "seniority-add";
    }

    @GetMapping("/support-list")
    public String toSupportListView(){
        return "support-list";
    }
    @GetMapping("/support-add")
    public String toSupportAddView(){
        return "support-add";
    }

    @GetMapping("/video-list")
    public String toVideoListView(){
        return "video-list";
    }
    @GetMapping("/video-add")
    public String toVideoAddView(){
        return "video-add";
    }
}
