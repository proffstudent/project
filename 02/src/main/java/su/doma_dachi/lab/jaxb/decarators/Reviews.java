package su.doma_dachi.lab.jaxb.decarators;

import su.doma_dachi.lab.domain.Level;
import su.doma_dachi.lab.domain.Review;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Reviews {
    List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
