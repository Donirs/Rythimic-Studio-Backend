package rythmic.ryhtmic_studio_backend.repository;

import rythmic.ryhtmic_studio_backend.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
}
