package pe.com.easyjobs.accountsapi.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import pe.com.easyjobs.accountsapi.entity.Technician;

import java.util.List;
@Qualifier("technicianRepository")
@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {
    @Query(value ="SELECT t FROM Technician t WHERE t.activated = true")
     List<Technician> getAllTechnicians();
    Technician findTechnicianById(Long id);
}
