package com.mutpio.pfe.Dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.mutpio.pfe.Entities.Signature}
 */
@Value
public class SignatureDto implements Serializable {
    Long idSignature;
    String numSignature;
    Boolean isSigned;
    LocalDate dateSignature;
}