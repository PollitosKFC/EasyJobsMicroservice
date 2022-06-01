package pe.edu.upc.techniciandetailsapi.Easyjobs.controller;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.generic.RET;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.Technician;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.TechnicianDetail;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.TechnicianFile;
import pe.edu.upc.techniciandetailsapi.Easyjobs.resource.*;
import pe.edu.upc.techniciandetailsapi.Easyjobs.service.TechnicianDetailService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping(value="/TechnicianDetail")
public class TechnicianDetailController {

    @Autowired
    private TechnicianDetailService technicianDetailService;

    @Autowired
    private ModelMapper modelMapper;

   // @PostMapping("/createTechnicianDetail")
    //public ResponseEntity<TechnicianDetail> createTechnicianDetail(@RequestBody TechnicianDetail technicianDetail) {
     //   TechnicianDetail technicianDetailCreated = technicianDetailService.createTechnicianDetail(technicianDetail);
     //   return ResponseEntity.ok(technicianDetailCreated);
   // }
   // @PostMapping("/createTechnicianDetail")
    //public ResponseEntity<TechnicianDetail> createTechnicianDetail(@RequestBody SaveTechnicianDetailResource resource) {
       // TechnicianDetail technician = technicianDetailService.createTechnicianDetail(convertToEntity(resource));
        //return ResponseEntity.ok(technician);
   //}

    @PostMapping("/createTechnicianDetail/{id}")
    public TechnicianDetailResource createTechnicianDetail(@RequestBody SaveTechnicianDetailResource resource, @PathVariable Long id) {
        TechnicianDetail technician = technicianDetailService.createTechnicianDetail(convertToEntityDetail(resource),id);
        return convertToResourceDetail(technician);
    }

    @PostMapping("/createTechnicianFile/{id}")
    public TechnicianFileResource createTechnicianFile(@RequestBody SaveTechnicianFileResource technicianFile, @PathVariable Long id) {
        TechnicianFile technicianFileCreated = technicianDetailService.createTechnicianFile(convertToEntityFile(technicianFile),id);
        return convertToResourceFile(technicianFileCreated);
    }

    @PutMapping("/updateTechnicianDetailById/{id}")
    public TechnicianDetailResource updateTechnicianDetailById(@PathVariable Long id, @RequestBody SaveTechnicianDetailResource technicianDetail) {
        TechnicianDetail technicianDetailUpdated = technicianDetailService.updateTechnicianDetailById(id, convertToEntityDetail(technicianDetail));
        return convertToResourceDetail(technicianDetailUpdated);
    }

    @PutMapping("/updateTechnicianFileByFileIdAndTechnicianId/{id}")
    public TechnicianFileResource updateTechnicianFileByFileIdAndTechnicianId(@RequestParam(name = "fileId") Long fileId, @RequestParam(name = "technicianId") Long technicianId ,@RequestBody SaveTechnicianFileResource technicianFile) {
        TechnicianFile technicianFileUpdated = technicianDetailService.updateTechnicianFileByFileIdAndTechnicianId(technicianId,fileId, convertToEntityFile(technicianFile));
        return convertToResourceFile(technicianFileUpdated);
    }

    @GetMapping("/technicianDetailByTechnicianId/{id}")
    public TechnicianDetailResource findTechnicianDetailByTechnicianId(@PathVariable Long id) {
        TechnicianDetail technicianDetail = technicianDetailService.findTechnicianDetailById(id);
        return convertToResourceDetail(technicianDetail);
    }


    @GetMapping("/technicianFileByFileIdAndTechnicianId")
    public TechnicianFileResource findTechnicianFileByFileIdAndTechnicianId(@RequestParam(name = "fileId") Long fileId,
                                                                                     @RequestParam(name = "technicianId") Long technicianId) {
        TechnicianFile technicianFile = technicianDetailService.findTechnicianFileByFileIdAndTechnicianId(technicianId,fileId);
        if (technicianFile == null) {
            return null;
        }
        return convertToResourceFile(technicianFile);
    }

        @GetMapping("/findTechnicianFilesByTechnicianId")
        public List<TechnicianFileResource> findAllTechnicianFilesByTechnicianId(@RequestParam(name = "technicianId",required = false) Long technicianId) {
            List<TechnicianFile> technicianFiles = technicianDetailService.findAllTechnicianFilesByTechnicianId(technicianId);
            if (technicianFiles == null) {
                return null;
            }
            List<TechnicianFileResource> technicianResourceList =technicianFiles.stream().map(technicianFile -> {
                return convertToResourceFile(technicianFile);
            }).collect(Collectors.toList());
            return technicianResourceList;
        }


    @DeleteMapping("/technicianFileByFileIdAndTechnicianId")
    public TechnicianFileResource deleteTechnicianFileByFileIdAndTechnicianId(@RequestParam(name = "fileId",required = false) Long fileId,
                                                                                     @RequestParam(name = "technicianId",required = false) Long technicianId) {
        TechnicianFile technicianFile = technicianDetailService.deleteTechnicianFileByFileIdAndTechnicianId(technicianId, fileId);
        if (technicianFile == null) {
            return null;
        }
        return convertToResourceFile(technicianFile);
    }

    private TechnicianDetail convertToEntityDetail(SaveTechnicianDetailResource resource) {
        return modelMapper.map(resource, TechnicianDetail.class);
    }

    private TechnicianFile convertToEntityFile(SaveTechnicianFileResource resource) {
        return modelMapper.map(resource, TechnicianFile.class);
    }

    private TechnicianDetailResource convertToResourceDetail(TechnicianDetail entity) {
        return modelMapper.map(entity, TechnicianDetailResource.class);
    }
    private TechnicianFileResource convertToResourceFile(TechnicianFile entity) {
        return modelMapper.map(entity, TechnicianFileResource.class);
    }
}
