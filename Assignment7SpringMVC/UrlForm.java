import javax.validation.constraints.NotBlank;

public class UrlForm {
    private String originalUrl;

    @NotBlank(message = "Please enter a URL")
    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}

