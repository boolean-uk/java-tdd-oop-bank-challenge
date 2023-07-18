package com.booleanuk.extension.account;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SwiftCode {
    CITIUS33XXX("United States"),
    CITIGB2L("United Kingdom"),
    CITIPLPX("Poland");

    private final String country;
}
