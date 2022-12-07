package org.example.mappers;

import org.example.domain.BaseModel;

import java.util.LinkedHashMap;
import java.util.Map;

public class BaseModelMapper {

    public static BaseModel mapToBaseModel(Map<String, String> data) {
        return BaseModel.builder()
                .otherData(mapToOtherData(data))
                .build();
    }

    public static Map<String, String> mapToOtherData(Map<String, String> data) {
        if (data == null) {
            return null;
        } else {
            Map<String, String> map = new LinkedHashMap<>(Math.max((int) ((float) data.size() / 0.75F) + 1, 16));

            for (Map.Entry<String, String> entry : data.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                map.put(key, value);
            }

            return map;
        }
    }
}
