package ee.materjalivoog.materjalivoo_kuulutuse_registreerimine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.service.StorageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.example.uploadingfiles.storage.StorageProperties;
import com.example.uploadingfiles.storage.StorageService;




@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class MaterjalivooKuulutuseRegistreerimineApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaterjalivooKuulutuseRegistreerimineApplication.class, args);
    }
    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }

}
