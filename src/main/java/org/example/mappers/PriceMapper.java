package org.example.mappers;

import org.apache.commons.lang3.math.NumberUtils;
import org.example.domain.Price;

import java.util.Map;

import static org.example.mappers.BaseModelMapper.mapToOtherData;

public class PriceMapper {

    private static final String EXTERNAL_ID = "external_id";
    private static final String PRICE_EUR = "price:EUR";
    private static final String PRICE_GBP = "price:GBP";

    public static Price mapToPrice(Map<String, String> data) {
        if (data == null) {
            return null;
        } else {
            Price.PriceBuilder<?, ?> price = Price.builder();

            if (data.containsKey(EXTERNAL_ID)) {
                price.externalId(data.get(EXTERNAL_ID));
                data.remove(EXTERNAL_ID);
            }

            if (data.containsKey(PRICE_EUR)) {
                price.eur(NumberUtils.toDouble(data.get(PRICE_EUR)));
                data.remove(PRICE_EUR);
            }

            if (data.containsKey(PRICE_GBP)) {
                price.gbp(NumberUtils.toDouble(data.get(PRICE_GBP)));
                data.remove(PRICE_GBP);
            }

            price.otherData(mapToOtherData(data));

            return price.build();
        }
    }
}
