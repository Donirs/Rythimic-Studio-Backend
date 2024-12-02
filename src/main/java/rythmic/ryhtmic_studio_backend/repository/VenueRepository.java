package rythmic.ryhtmic_studio_backend.repository;

import rythmic.ryhtmic_studio_backend.entity.User;
import rythmic.ryhtmic_studio_backend.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VenueRepository extends JpaRepository<Venue, String> {
    Optional<Venue> findFirstByOwnerAndId(User owner, int id);
    List<Venue> findAllByOwner(User owner);
}
