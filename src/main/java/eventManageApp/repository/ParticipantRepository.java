package eventManageApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eventManageApp.entity.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
}
