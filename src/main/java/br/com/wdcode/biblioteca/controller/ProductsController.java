package br.com.wdcode.biblioteca.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.wdcode.biblioteca.daos.ProductDAO;
import br.com.wdcode.biblioteca.models.BookType;
import br.com.wdcode.biblioteca.models.Product;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProductsController {

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Product product, BindingResult bindingResult, RedirectAttributes attributes) {
		if(bindingResult.hasErrors()) {
			return form();
		}
		productDAO.save(product);
		attributes.addFlashAttribute("sucesso", "Produto cadastro com sucesso!");
		return new ModelAndView("redirect:produtos");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("products/list");
		mv.addObject("products", productDAO.list());
		return mv;
	}

	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("products/form");
		mv.addObject("types", BookType.values());
		return mv;
	}
}
