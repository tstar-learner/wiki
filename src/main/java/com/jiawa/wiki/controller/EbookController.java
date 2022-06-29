package com.jiawa.wiki.controller;

import com.jiawa.wiki.req.EbookSaveReq;
import com.jiawa.wiki.resp.PageResp;
import com.jiawa.wiki.service.EbookService;
import com.jiawa.wiki.req.EbookQueryReq;
import com.jiawa.wiki.resp.CommonResp;
import com.jiawa.wiki.resp.EbookQueryResp;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(@Valid EbookQueryReq ebook){
        CommonResp<PageResp<EbookQueryResp>> commonResp=new CommonResp<>();
        PageResp<EbookQueryResp> ebooks=ebookService.list(ebook);
        commonResp.setContent(ebooks);
        return commonResp;
    }

    @PostMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq ebook){
        CommonResp commonResp=new CommonResp<>();
        ebookService.save(ebook);
        return commonResp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id){
        CommonResp commonResp=new CommonResp<>();
        ebookService.delete(id);
        return commonResp;
    }
}
