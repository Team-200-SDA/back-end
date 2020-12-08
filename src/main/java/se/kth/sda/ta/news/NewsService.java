package se.kth.sda.ta.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    @Autowired
    private NewsRepository repository;

    public List<News> getAll() {
        return repository.findAll();
    }

    public Optional<News> getById(Long id) {
        return repository.findById(id);
    }

    public News create(News newNews) {
        return repository.save(newNews);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public News update(News updateNews) {
        return repository.save(updateNews);
    }
}
