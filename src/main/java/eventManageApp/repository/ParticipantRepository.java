package eventManageApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eventManageApp.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
}
