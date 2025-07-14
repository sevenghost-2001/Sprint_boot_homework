package com.cybersoft.demospringboot09.controller;

import com.cybersoft.demospringboot09.entity.BaiViet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bai-viet")
public class BaiVietController {
    @GetMapping
    public ResponseEntity<?> getAllBaiViet() {
        BaiViet baiViet = new BaiViet();
        baiViet.setTieuDe("Bài viết đầu tiên");
        baiViet.setNoiDung("Nội dung của bài viết đầu tiên");
        baiViet.setHinhAnh("https://example.com/image1.jpg");

        BaiViet baiViet2 = new BaiViet();
        baiViet2.setTieuDe("Bài viết thứ hai");
        baiViet2.setNoiDung("Nội dung của bài viết thứ hai");
        baiViet2.setHinhAnh("https://example.com/image2.jpg");

        List<BaiViet> baiVietList =new ArrayList<>();
        baiVietList.add(baiViet);
        baiVietList.add(baiViet2);
        return ResponseEntity.ok().body(baiVietList);
    }
}
