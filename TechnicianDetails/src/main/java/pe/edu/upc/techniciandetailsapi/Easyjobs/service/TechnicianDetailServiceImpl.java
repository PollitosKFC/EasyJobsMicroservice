package pe.edu.upc.techniciandetailsapi.Easyjobs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.Technician;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.TechnicianDetail;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.TechnicianFile;
import pe.edu.upc.techniciandetailsapi.Easyjobs.repository.TechnicianDetailRepository;
import pe.edu.upc.techniciandetailsapi.Easyjobs.repository.TechnicianFileRepository;
import pe.edu.upc.techniciandetailsapi.Easyjobs.repository.TechnicianRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnicianDetailServiceImpl  implements TechnicianDetailService {
    @Autowired
    private final TechnicianDetailRepository technicianDetailRepository;
    @Autowired
    private final TechnicianFileRepository technicianFileRepository;
    @Autowired
    private final TechnicianRepository technicianRepository;


    @Override
    public TechnicianDetail createTechnicianDetail(TechnicianDetail technicianDetails, Long id) {
        Technician technician = technicianRepository.findById(id).orElse(null);
        if (technician == null) {
            return null;
        }
        TechnicianDetail technicianDetail = new TechnicianDetail();
        technicianDetail.setId(id);
        technicianDetail.setYearsExperience(technicianDetails.getYearsExperience());
        technicianDetail.setMaritalStatus(technicianDetails.getMaritalStatus());
        technicianDetail.setPresentation(technicianDetails.getPresentation());
        technicianDetail.setYearsExperience(technicianDetails.getYearsExperience());
        technicianDetail.setEducationLevel(technicianDetails.getEducationLevel());
        technicianDetail.setNationality(technicianDetails.getNationality());
        technicianDetail.setEnglishLevel(technicianDetails.getEnglishLevel());
        technician.setTechnician_detail(null);
        technicianDetail.setTechnician(technician);
        return technicianDetailRepository.save(technicianDetail);
    }

    @Override
    public TechnicianFile createTechnicianFile(TechnicianFile technicianFiles, Long id){
        if (technicianRepository.findById(id).orElse(null) == null) {
            return null;
        }
        TechnicianFile technicianFile = new TechnicianFile();
        technicianFile.setNameFile(technicianFiles.getNameFile());
        technicianFile.setType(technicianFiles.getType());
        technicianFile.setUrlFile(technicianFiles.getUrlFile());
        technicianFile.setActive(true);
        technicianFile.setTechnician(technicianRepository.findById(id).orElse(null));
        return technicianFileRepository.save(technicianFile);
    }

    @Override
    public TechnicianDetail updateTechnicianDetailById(Long id, TechnicianDetail technicianDetails) {
        TechnicianDetail technicianDetail = technicianDetailRepository.findTechnicianDetailById(id);
        if (technicianDetail == null) {
            return null;
        }
        technicianDetail.setYearsExperience(technicianDetails.getYearsExperience());
        technicianDetail.setPresentation(technicianDetails.getPresentation());
        technicianDetail.setYearsExperience(technicianDetails.getYearsExperience());
        technicianDetail.setEducationLevel(technicianDetails.getEducationLevel());
        technicianDetail.setNationality(technicianDetails.getNationality());
        technicianDetail.setEnglishLevel(technicianDetails.getEnglishLevel());
        return technicianDetailRepository.save(technicianDetail);
    }

    @Override
    public TechnicianFile updateTechnicianFileByFileIdAndTechnicianId(Long technicianId, Long fileId, TechnicianFile technicianFiles) {
        TechnicianFile technicianFile = technicianFileRepository.findTechnicianFileByFileIdAndTechnicianId(technicianId,fileId);
        if (technicianFile == null) {
            return null;
        }
        technicianFile.setNameFile(technicianFiles.getNameFile());
        technicianFile.setType(technicianFiles.getType());
        technicianFile.setUrlFile(technicianFiles.getUrlFile());
        return technicianFileRepository.save(technicianFile);
    }

    @Override
    public List<TechnicianFile> findAllTechnicianFilesByTechnicianId(Long id) {
        return technicianFileRepository.findTechnicianFilesByTechnicianId(id);
    }

    @Override
    public TechnicianDetail findTechnicianDetailById(Long id) {
        return technicianDetailRepository.findTechnicianDetailById(id);
    }

    @Override
    public TechnicianFile findTechnicianFileByFileIdAndTechnicianId(Long technicianId, Long fileId) {
        return technicianFileRepository.findTechnicianFileByFileIdAndTechnicianId(technicianId, fileId);
    }

    @Override
    public TechnicianFile deleteTechnicianFileByFileIdAndTechnicianId(Long technicianId, Long fileId) {
        TechnicianFile technicianFile = technicianFileRepository.findTechnicianFileByFileIdAndTechnicianId(technicianId, fileId);
        if (technicianFile == null) {
            return null;
        }
        technicianFile.setActive(false);
        return technicianFileRepository.save(technicianFile);
    }
}
