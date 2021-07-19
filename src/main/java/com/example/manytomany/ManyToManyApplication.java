package com.example.manytomany;

import com.example.manytomany.entity.Post;
import com.example.manytomany.entity.Tag;
import com.example.manytomany.repository.PostRepository;
import com.example.manytomany.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManyToManyApplication implements CommandLineRunner {



    @Autowired
    private PostRepository postRepository;



    public static void main(String[] args) {
        SpringApplication.run(ManyToManyApplication.class, args);
    }



    @Autowired
    private TagRepository tagRepository;



    @Override
    public void run(String... args) throws Exception {


        Post post=new Post("Many to many boglanish","Many to many boglanish","Many to many boglanish");
        Post post1=new Post("Many to many boglanish1","Many to many boglanish1","Many to many boglanish");


        Tag hibernate=new Tag("hibernate");
        Tag springBoot=new Tag("springBoot");


        post.getTags().add(hibernate);
        post.getTags().add(springBoot);


        post1.getTags().add(springBoot);
        springBoot.getPosts().add(post1);


        springBoot.getPosts().add(post);
        hibernate.getPosts().add(post);

        this.postRepository.save(post);
        this.postRepository.save(post1);





    }
}
