package com.Library.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
public class Book {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotEmpty
	    private String title;

	    @NotEmpty
	    private String author;

	    private String genre;

	    @NotEmpty
	    private String availabilityStatus;
	    
	    

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getAvailabilityStatus() {
			return availabilityStatus;
		}

		public void setAvailabilityStatus(String availabilityStatus) {
			this.availabilityStatus = availabilityStatus;
		}

		
		public Book(Long id, @NotEmpty String title, @NotEmpty String author, String genre,
				@NotEmpty String availabilityStatus) {
			super();
			this.id = id;
			this.title = title;
			this.author = author;
			this.genre = genre;
			this.availabilityStatus = availabilityStatus;
		}

		public Book() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", genre=" + genre
					+ ", availabilityStatus=" + availabilityStatus + "]";
		}
	    
	    
		
		
		
	    
	    
		
		
		
		
		
		
	    
		
		
	    
	    
	
	    
}
