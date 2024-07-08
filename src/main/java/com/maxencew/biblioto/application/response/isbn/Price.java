package com.maxencew.biblioto.application.response.isbn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    private String condition;
    private String merchant;
    private String merchantLogo;
    private MerchantLogoOffset merchantLogoOffset;
    private String shipping;
    private String price;
    private String total;
    private String link;
}
