package com.william.SpringBootPlay.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final BookRepository bookRepository;

    public AppRunner(BookRepository bookRepository) {
        this.bookRepository  = bookRepository;
    }

    /*
     * Each time an advised method is invoked,
     * caching behavior will be applied,
     * checking whether the method has been already invoked for the given arguments.
     */

//    @Override
//    public void run(String... args) throws Exception {
//        logger.info(".... Fetching books");
//        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
//        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
//        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
//        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
//        logger.info("isbn-99 -->" + bookRepository.getByIsbn("isbn-99"));
//        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
//    }
}
