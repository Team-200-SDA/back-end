package se.kth.sda.ta.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("")
    public List<News> getAll() {
        return newsService.getAll();
    }
    @GetMapping("/{id}")
    public News getById(@PathVariable Long id) {
        return newsService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping("")
    public News create(@RequestBody News newNews) {
        return newsService.create(newNews);
    }
    @PutMapping("")
    public News update(@RequestBody News updateNews) {
        return newsService.update(updateNews);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        newsService.delete(id);
    }
}
