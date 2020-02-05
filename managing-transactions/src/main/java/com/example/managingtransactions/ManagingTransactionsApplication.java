package com.example.managingtransactions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;


@SpringBootApplication
public class ManagingTransactionsApplication {
    private static final Logger log = LoggerFactory.getLogger(ManagingTransactionsApplication.class);

    private BookingService bookingService;

    public ManagingTransactionsApplication(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ManagingTransactionsApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            // valid entries
            bookingService.book("Alice", "Bob", "Carol");
            Assert.isTrue(bookingService.findAllBookings().size() == 3,
                    "First booking should work with no problem");

            log.info("Alice, Bob and Carol have been booked");

            // constraint violation
            try {
                bookingService.book("Chris", "Samuel");    // Samuel is 6 character

            } catch (RuntimeException e) {
                Assert.isTrue(bookingService.findAllBookings().size() == 3,
                        "The booking did not happen as a whole even tho Chris is valid");
                log.error("Second Booking didn't work, rolled back to previous state");
            }

            // null entry
            try {
                bookingService.book("Buddy", null);    // first_name is not null
            } catch (RuntimeException e) {
                Assert.isTrue(bookingService.findAllBookings().size() == 3,
                        "The booking did not happen as a whole even tho Buddy is valid");
				log.error("Third Booking didn't work, rolled back to previous state");
            }
        };
    }

}
