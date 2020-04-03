package com.wwf.user;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;

@SpringBootTest
class UserApplicationTests {
    @Autowired
    private FastFileStorageClient client;

    @Test
    void contextLoads() {
        File file = new File("C:\\Users\\Administrator\\Desktop\\bg.jpg");
        try {
            StorePath storePath = client.uploadFile(new FileInputStream(file), file.length(), "jpg", null);
            System.out.println(storePath.getFullPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
