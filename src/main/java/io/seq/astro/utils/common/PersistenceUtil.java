package io.seq.astro.utils.common;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Singleton
public class PersistenceUtil {

    public static String buildAndQuery(Map<String, Object> queryParams) {
        return queryParams.entrySet().stream()
                .map(entry -> entry.getKey() + "=:" + entry.getKey())
                .collect(Collectors.joining(" and "));
    }

    public static String buildSortQuery(List<String> sortParams) {
        return "order by " + String.join(",", sortParams);
    }
}
