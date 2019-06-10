package com.ash.workorder.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Created by Ash on 2019/6/9 18:24
 */
@Service
public class FileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileService.class);

    public boolean uploadFile(MultipartFile file, Integer uid, Integer oid){
        File dest = new File("/Users/zhaoyizhu/file/u" + uid + "o" + oid);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            return false;
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return true;
    }
}
