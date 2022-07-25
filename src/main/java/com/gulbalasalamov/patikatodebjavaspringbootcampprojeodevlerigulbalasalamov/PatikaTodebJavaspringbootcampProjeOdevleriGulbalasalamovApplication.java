package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Buyer;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.repository.BuyerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatikaTodebJavaspringbootcampProjeOdevleriGulbalasalamovApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatikaTodebJavaspringbootcampProjeOdevleriGulbalasalamovApplication.class, args);
    }

//    //Uygulama ayaga kalkarken bir veriye ihtiyacim var.
//    //Gidip servise createCustomer() metodu acmaya gerek yok.
//    //Sadece 2 buyer olusturup veri tabanina kaydetmek.
//    // H2 in memory database de mesela herseferinde veri girmektense burdan ceksin.
//    // Normalde resource altinda sql ile bu yapilir ama su an pratik olsun diye main den create yapiyoruz
//    @Override
//    public void run(String... args) throws Exception {
//        Buyer buyer = buyerRepository.save(new Buyer(1L,"Gulbala","Salamov","gulbala@gmail.com",fal));
//        System.out.println(buyer);
//
//    }
}
