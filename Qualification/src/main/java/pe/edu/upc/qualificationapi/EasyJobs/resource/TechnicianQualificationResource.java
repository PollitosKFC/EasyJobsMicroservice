package pe.edu.upc.qualificationapi.EasyJobs.resource;

import lombok.Data;

@Data
public class TechnicianQualificationResource {
    private Long id;
    private Integer numberOfReviews;
    private Double qualificationAverage;
}
