import java.util.*;

class Hotel {
    String name;
    ArrayList<Review> reviews;

    public Hotel(String name) {
        this.name = name;
        this.reviews = new ArrayList<>();
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void printReviews() {
        for (Review review : reviews) {
            System.out.println(review);
        }
    }

    public void sortReviewsByRating() {
        reviews.sort(Comparator.comparingInt(Review::getRating).reversed());
    }

    public void filterReviewsByMinRating(int minRating) {
        reviews.removeIf(review -> review.getRating() < minRating);
    }
}

class Review {
    String author;
    int rating;
    String comment;

    public Review(String author, int rating, String comment) {
        this.author = author;
        this.rating = rating;
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Review by " + author + ", Rating: " + rating + ", Comment: " + comment;
    }
}

public class HotelReviewSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Grand Hotel");

        hotel.addReview(new Review("John", 5, "Excellent service!"));
        hotel.addReview(new Review("Anna", 4, "Nice location."));
        hotel.addReview(new Review("Mike", 3, "Good for the budget."));
        hotel.addReview(new Review("Lucy", 2, "Needs improvement."));

        hotel.printReviews();

        System.out.println("\nReviews sorted by rating:");
        hotel.sortReviewsByRating();
        hotel.printReviews();

        System.out.println("\nReviews with a rating of 4 or higher:");
        hotel.filterReviewsByMinRating(4);
        hotel.printReviews();
    }
}
