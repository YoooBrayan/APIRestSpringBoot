package com.bytecode.core.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bytecode.core.configuration.Pages;
//import com.bytecode.core.model.Post;

@Controller
@RequestMapping("/home")
public class ControllerBasic {

	/*public List<Post> getPosts() {
		
		ArrayList<Post> posts = new ArrayList<>();
		posts.add(new Post(1, "Post 3", "Publication 3", new Date()));
		posts.add(new Post(2, "Post 4", "Publication 4", new Date()));
		
		return posts;
	}
	
	
	@GetMapping(path = {"/bienvenida", "/"})
	public String saludar(Model model) {
		
		model.addAttribute("posts", getPosts());
		return "index";
	}
	
	/*@GetMapping(path = "/public")
	public ModelAndView response() {
		
		ModelAndView response = new ModelAndView(Pages.HOME);
		response.addObject("posts", getPosts());
		return response;
	}
	
	@GetMapping(path = "/post/{id}")
	public ModelAndView getPost(@PathVariable(required = true, name = "id") int id) {
		
		List<Post> post = getPosts().stream().filter((p) -> p.getId() ==id).collect(Collectors.toList());
		
		ModelAndView response = new ModelAndView(Pages.POST);
		response.addObject("post", post);
		
		return response;
	}
	
	@GetMapping(path = "/addPost")
	public ModelAndView addPost() {
		return new ModelAndView("addPost").addObject("post", new Post(11, "Rocky", "Perro", null));
	}
	
	@PostMapping("/addNewPost")
	public String addNewPost(Post post, Model model) {
		
		List<Post> posts = this.getPosts();
		posts.add(post);
		model.addAttribute("posts", posts);
		
		return "index";
	}*/
	
}
