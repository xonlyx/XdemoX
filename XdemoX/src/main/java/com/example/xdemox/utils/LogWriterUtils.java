package com.example.xdemox.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LogWriterUtils {


    public void writeLog(String log) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\新建文件夹\\XdemoX\\src\\main\\java\\com\\example\\xdemox\\log.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            String now = LocalDateTime.parse(LocalDateTime.now().toString()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            fileWriter.write(now + "\n");
            fileWriter.write(log+"\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
