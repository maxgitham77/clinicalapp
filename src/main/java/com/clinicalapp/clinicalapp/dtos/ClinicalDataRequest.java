package com.clinicalapp.clinicalapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClinicalDataRequest {
    private String componentName;
    private String componentValue;
    private Long patientId;
}
