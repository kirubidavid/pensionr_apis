package com.genesysafrica.pensionr.scheme.dto;

import lombok.Data;

@Data
public class CreatePensionSchemeDto {

    private String txtSchemeName;

    private String txtTaxPin;

    private String txtFundType;
}
