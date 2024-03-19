package com.mutpio.pfe.Controllers;

import com.mutpio.pfe.Entities.Devis;
import com.mutpio.pfe.Services.ISignatureServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/signature")
@CrossOrigin(origins = "*")
public class SignatureController {

    @Autowired
    private ISignatureServices signatureServices;

    @GetMapping("/devis")
    public ResponseEntity<byte[]> generatePdf(@RequestBody Devis devis) throws IOException{
        byte[] pdfContent = signatureServices.generatePdf(devis);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "generated.pdf");
        headers.setContentLength(pdfContent.length);
        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }

}
