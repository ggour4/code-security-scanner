package io.github.ggour4.scanner.scan;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateScanRequest(

        @NotBlank
        @Pattern(regexp = "python", message = "only python is supported")
        String language,

        @NotBlank
        @Size(max = 50000, message = "code must be at most 50000 characters")
        String code
) {
}