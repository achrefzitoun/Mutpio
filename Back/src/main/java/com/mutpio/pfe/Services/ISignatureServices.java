package com.mutpio.pfe.Services;

import com.mutpio.pfe.Entities.Devis;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

public interface ISignatureServices {
    public byte[] generatePdf(Devis devis) throws IOException;

}
