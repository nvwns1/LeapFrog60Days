package org.suman.documentweb.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.suman.documentweb.entities.Document;
import org.suman.documentweb.repos.DocumentRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class DocumentController {
    @Autowired
    DocumentRepository documentRepository;

    @RequestMapping("/displayUpload")
    public String displayUpload(Model model) {

        List<Document> documents=  documentRepository.findAll();
        model.addAttribute("documents", documents);
        return "documentUpload";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String uploadDocument(@RequestParam("document") MultipartFile multipartFile,
                                 @RequestParam("id") long id, Model model
    ) {
        Document newDocument = new Document();
        newDocument.setId(id);
        newDocument.setName(multipartFile.getOriginalFilename());
        try {
            newDocument.setData(multipartFile.getBytes());
        } catch (IOException e) {
            System.err.println(e);
        }
        documentRepository.save(newDocument);

        List<Document> documents=  documentRepository.findAll();
        model.addAttribute("documents", documents);
        return "documentUpload";
    }

    @RequestMapping("download")
    public StreamingResponseBody download(@RequestParam("id") long id, HttpServletResponse response) {
        Optional<Document> optionalDocument = documentRepository.findById(id);
        if (optionalDocument.isPresent()) {
            Document document = optionalDocument.get();
            byte[] data = document.getData();

            response.setHeader("Content-Disposition", "attachment; filename=download.jpeg");

            return outputStream -> {
                outputStream.write(data);
                outputStream.flush();  // Ensure data is sent to the client

            };
        } else {
            // Handle the case where the document is not found, e.g., set an appropriate status code
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
    }
}
