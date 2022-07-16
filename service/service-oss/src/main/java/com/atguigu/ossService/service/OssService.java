package com.atguigu.ossService.service;

import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    String updateAvatar(MultipartFile file);
}
