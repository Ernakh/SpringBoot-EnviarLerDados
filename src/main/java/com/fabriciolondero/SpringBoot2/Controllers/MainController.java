package com.fabriciolondero.SpringBoot2.Controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fabriciolondero.SpringBoot2.Models.PessoaModel;

@Controller
public class MainController implements WebMvcConfigurer
{
	@Override
	public void addViewControllers(ViewControllerRegistry registry) 
	{
		registry.addViewController("/results").setViewName("results");
	}

	@GetMapping("/")
	public String showForm(PessoaModel pessoaModel) 
	{
		return "form";
	}

	@PostMapping("/")
	public String checkPersonInfo(@Valid PessoaModel pessoaModel, BindingResult bindingResult) 
	{

		if (bindingResult.hasErrors()) 
		{
			return "form";
		}
		
		System.out.println(pessoaModel.toString());

		return "redirect:/results";
	}
	
	@RequestMapping("/pessoas")
	  @GetMapping
	  public ModelAndView listar() 
	  {
		  Random rand = new Random();
		  ArrayList<PessoaModel> lista = new ArrayList<>();
		  
		 for (int i = 0; i < 10; i++) 
		 {
			 lista.add(new PessoaModel("pessoa " + rand.nextInt(), rand.nextInt(80)));
		 }
		  
		 for (Iterator<PessoaModel> iterator = lista.iterator(); iterator.hasNext();) {
			PessoaModel pessoaModel = (PessoaModel) iterator.next();
			System.out.println(pessoaModel.toString());
		}
	     
	    ModelAndView modelAndView = new ModelAndView("pessoas");
	    modelAndView.addObject("pessoas", lista);
	     
	    return modelAndView;
	  }
}
