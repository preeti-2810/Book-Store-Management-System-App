package com.book.store.management.app.controllers;

import java.util.List;

import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.management.app.entities.Book;
import com.book.store.management.app.entities.Customer;
import com.book.store.management.app.entities.Review;
import com.book.store.management.app.exceptions.BookNotFoundException;
import com.book.store.management.app.exceptions.ReviewAlreadyExistException;
import com.book.store.management.app.exceptions.ReviewNotFoundException;
import com.book.store.management.app.repo.IBookRepository;
import com.book.store.management.app.repo.IReviewRepository;
import com.book.store.management.app.services.BookService;
import com.book.store.management.app.services.CustomerService;
import com.book.store.management.app.services.ReviewService;

@RestController
public class ReviewController {
	private static final Logger log = LoggerFactory.getLogger(ReviewController.class);
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/reviews/list")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Review> listAllReviews() {
		log.info("Listing all reviews");
			return reviewService.listAllReviews();
	}

	@PostMapping("/reviews")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Review addReview(@RequestBody Review review) {
		log.info("Adding reviews");
		return reviewService.addReview(review);
	}

	@PutMapping("/reviews/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@Transactional
	public Review updateReview(@RequestBody Review review) {
		log.info("Updating review");
       return reviewService.updateReview(review);
	}

	@DeleteMapping("/reviews/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Review deleteReview(@RequestBody Review review) {
		log.info("Deleting the reviews");
		return reviewService.deleteReview(review);
	}

	@GetMapping("/reviews/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public Review viewReview(@RequestBody Review review) {
		log.info("Viewing the review");
			return reviewService.viewReview(review);
	}

	@GetMapping("/reviews/book/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Review> listAllReviewsByBook(@RequestBody Book book) {
		log.info("Listing all reviews by book");
		return reviewService.listAllReviewsByBook(book);
	}

	@GetMapping("/reviews/customer/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Review> listAllReviewByCustomer(@RequestBody Customer customer) {
		log.info("Listing all review by customer");
		return reviewService.listAllReviewByCustomer(customer);
	}

	@GetMapping("/reviews/fav")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Book> listMostFavoredBooks() {
		log.info("Listing most favoured books");
		return reviewService.listMostFavoredBooks();
	}
}