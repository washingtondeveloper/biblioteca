package br.com.wdcode.biblioteca.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "O Titulo é Obrigatorio")
	private String title;
	@Lob
	@NotBlank(message = "Descrição é Obrigatoria")
	private String description;
	@NotNull(message = "Numero de paginas é Obrigatorio")
	private Integer pages;
	
	@DateTimeFormat(iso =ISO.DATE)
	private Calendar releaseDate;

	@ElementCollection
	private List<Price> prices = new ArrayList<Price>();

	public String getTitle() {
		return title;
	}

	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Calendar getReleaseDate() {
		return releaseDate;
	}

	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	public List<Price> getPrices() {
		return prices;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", pages=" + pages + "]";
	}

}
