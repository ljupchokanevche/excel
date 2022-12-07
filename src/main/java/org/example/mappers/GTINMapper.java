package org.example.mappers;

import org.apache.commons.lang3.math.NumberUtils;
import org.example.domain.GTIN;

import java.util.Map;

import static org.example.mappers.BaseModelMapper.mapToOtherData;

public class GTINMapper {

    private static final String EXTERNAL_ID = "external_id";
    private static final String GTIN = "GTIN";

    public static GTIN mapToGTIN(Map<String, String> data) {
        if (data == null) {
            return null;
        } else {
            GTIN.GTINBuilder<?, ?> gtin = org.example.domain.GTIN.builder();

            if (data.containsKey(EXTERNAL_ID)) {
                gtin.externalId(data.get(EXTERNAL_ID));
                data.remove(EXTERNAL_ID);
            }

            if (data.containsKey(GTIN)) {
                gtin.gtin(NumberUtils.toLong(data.get(GTIN)));
                data.remove(GTIN);
            }

            gtin.otherData(mapToOtherData(data));

            return gtin.build();
        }
    }
}
