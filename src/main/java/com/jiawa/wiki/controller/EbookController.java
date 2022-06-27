package com.jiawa.wiki.controller;

import com.jiawa.wiki.service.EbookService;
import com.jiawa.wiki.req.EbookReq;
import com.jiawa.wiki.resp.CommonResp;
import com.jiawa.wiki.resp.EbookResp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(EbookReq ebook){
        CommonResp<List<EbookResp>> commonResp=new CommonResp<>();
        List<EbookResp> ebooks=ebookService.list(ebook);
        commonResp.setContent(ebooks);
        return commonResp;
    }
}
