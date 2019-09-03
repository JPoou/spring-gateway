package com.codeaches.carinventoryservice.access;

import lombok.Data;

@Data
public class DomainObjectReference {

    private final String type;

    private final String id;
}
