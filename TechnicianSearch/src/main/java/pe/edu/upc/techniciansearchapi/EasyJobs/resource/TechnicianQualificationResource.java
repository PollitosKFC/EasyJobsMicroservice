package pe.edu.upc.techniciansearchapi.EasyJobs.resource;

import lombok.Data;

@Data
public class TechnicianQualificationResource {
    private Long id;
    private Integer numberOfReviews;
    private Double qualificationAverage;
}
