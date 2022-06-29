package com.jiawa.wiki.controller;

import com.jiawa.wiki.req.CategoryQueryReq;
import com.jiawa.wiki.req.CategorySaveReq;
import com.jiawa.wiki.resp.CommonResp;
import com.jiawa.wiki.resp.CategoryQueryResp;
import com.jiawa.wiki.resp.PageResp;
import com.jiawa.wiki.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/list")
    public CommonResp list(@Valid CategoryQueryReq category){
        CommonResp<PageResp<CategoryQueryResp>> commonResp=new CommonResp<>();
        PageResp<CategoryQueryResp> categorys=categoryService.list(category);
        commonResp.setContent(categorys);
        return commonResp;
    }

    @GetMapping("/all")
    public CommonResp all(){
        CommonResp<List<CategoryQueryResp>> commonResp=new CommonResp<>();
        List<CategoryQueryResp> categorys=categoryService.all();
        commonResp.setContent(categorys);
        return commonResp;
    }

    @PostMapping("/save")
    public CommonResp save(@RequestBody @Valid CategorySaveReq category){
        CommonResp commonResp=new CommonResp<>();
        categoryService.save(category);
        return commonResp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id){
        CommonResp commonResp=new CommonResp<>();
        categoryService.delete(id);
        return commonResp;
    }
}
