package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    List<Post> posts = new ArrayList<Post>(){
        {
            add(new Post(1, "Post 1", "This is my first post!"));
            add(new Post(2, "Post 2", "This is my second post!"));
            add(new Post(3, "Post 3", "This is my third post!"));
        }
    };


    @GetMapping("/posts")
    public String posts(Model model) {

        model.addAttribute("allPosts", posts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsId(@PathVariable long id, Model model) {
//        Post post = new Post(id, "Blog Post #" + id, "This is a very long and detailed description");
//
//        model.addAttribute("post", post);
//  OR!!!!!

        for (Post post : posts) {
            if(post.getId() == id) {
                model.addAttribute("post", post);
            }
        }

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postsCreate() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postsCreate2() {
        return "create a new post";
    }
}
