package io.seq.astro.utils.common;

import javax.inject.Singleton;
import java.util.Map;
import java.util.stream.Collectors;

@Singleton
public class CollectionUtil {

    public static Map<String, Object> removeNullValues(Map<String, Object> map){
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
