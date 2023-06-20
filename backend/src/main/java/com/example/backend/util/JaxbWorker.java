package com.example.backend.util;

import com.example.backend.entity.EmailMessage;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;

public class JaxbWorker {

    public static EmailMessage fromXmlToObject(MultipartFile file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EmailMessage.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            return ((EmailMessage)un.unmarshal(saveFileOnServer(file)));
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static File saveFileOnServer(MultipartFile multiFile){
        File file = new File("backend/src/main/resources/file/" + multiFile.getOriginalFilename());
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(multiFile.getInputStream().readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return file;
    }
}
