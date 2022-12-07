package org.example.mappers;

import org.example.domain.Image;

import java.util.Map;

import static org.example.mappers.BaseModelMapper.mapToOtherData;

public class ImageMapper {

    private static final String EXTERNAL_ID = "external_id";
    private static final String PRODUCT_IMAGE = "images:GS1_A_Product_Image_Web";

    public static Image mapToImage(Map<String, String> data) {
        if (data == null) {
            return null;
        } else {
            Image.ImageBuilder<?, ?> image = Image.builder();

            if (data.containsKey(EXTERNAL_ID)) {
                image.externalId(data.get(EXTERNAL_ID));
                data.remove(EXTERNAL_ID);
            }

            if (data.containsKey(PRODUCT_IMAGE)) {
                image.productImage(data.get(PRODUCT_IMAGE));
                data.remove(PRODUCT_IMAGE);
            }

            image.otherData(mapToOtherData(data));

            return image.build();
        }
    }
}
