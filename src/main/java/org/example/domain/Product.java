package org.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Product extends BaseModel {

    public static final String MASTER_PRODUCT = "master_product";
    public static final String MARKETS = "markets";
    public static final String NAME = "name";
    public static final String EXTERNAL_ID = "external_id";
    public static final String CERTIFICATION = "certifications";
    public static final String BRAND = "brand";
    @JsonProperty(EXTERNAL_ID)
    private final String externalId;

    @JsonProperty(NAME)
    private final String name;

    @JsonProperty(BRAND)
    private final String brand;

    @JsonProperty(MASTER_PRODUCT)
    private final String masterProduct;

    @JsonUnwrapped
    private final Group group;

    @JsonProperty(CERTIFICATION)
    private final String certification;

    @JsonProperty(MARKETS)
    private final String markets;
    private final Sustainability sustainability;
    private final ConsumerUnit consumerUnit;
    private final DistributionUnit distributionUnit;
    private final TransportationUnit transportationUnit;
    private final Description description;
    private final Document document;
    private final Model model;
    private final Specification specification;
    private final PhysicalMeasurement physicalMeasurement;
    private final IdNumber idNumber;
    private final Classification classification;
}
