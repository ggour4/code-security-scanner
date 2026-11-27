package io.github.ggour4.scanner.scan;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public record ScanResponse(
        Long id,
        String language,
        String code,
        ScanStatus status,
        Instant createdAt,
        List<FindingResponse> findings
) {

    public static ScanResponse from(Scan scan, List<Finding> findings) {
        List<FindingResponse> findingResponses = new ArrayList<>();
        for (Finding finding : findings) {
            findingResponses.add(FindingResponse.from(finding));
        }

        return new ScanResponse(
                scan.getId(),
                scan.getLanguage(),
                scan.getCode(),
                scan.getStatus(),
                scan.getCreatedAt(),
                findingResponses
        );
    }
}