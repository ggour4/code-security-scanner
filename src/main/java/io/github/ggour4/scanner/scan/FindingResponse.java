package io.github.ggour4.scanner.scan;

public record FindingResponse(
        Long id,
        String ruleId,
        String severity,
        String message,
        int startLine,
        int endLine
) {

    public static FindingResponse from(Finding finding) {
        return new FindingResponse(
                finding.getId(),
                finding.getRuleId(),
                finding.getSeverity(),
                finding.getMessage(),
                finding.getStartLine(),
                finding.getEndLine()
        );
    }
}