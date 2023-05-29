import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UrlController {

    @Autowired
    private UsingHash urlService;

    @GetMapping("/")
    public String showUrlForm(Model model) {
        model.addAttribute("urlForm", new UrlForm());
        return "urlForm";
    }

    @PostMapping("/shortenUrl")
    public String shortenUrl(@ModelAttribute("urlForm") UrlForm urlForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "urlForm";
        }

        String originalUrl = urlForm.getOriginalUrl();
        String shortenedUrl = urlService.getShortenedUrl(originalUrl);

        if (shortenedUrl == null) {
            shortenedUrl = urlService.generateUrl();
            urlService.addUrl(originalUrl, shortenedUrl);
        }

        model.addAttribute("originalUrl", originalUrl);
        model.addAttribute("shortenedUrl", shortenedUrl);
        return "result";
    }
}
