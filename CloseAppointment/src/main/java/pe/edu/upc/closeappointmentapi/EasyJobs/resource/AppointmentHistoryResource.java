package pe.edu.upc.closeappointmentapi.EasyJobs.resource;

import lombok.Data;

import java.util.Date;

@Data
public class AppointmentHistoryResource {
    private Long id;
    private Date finishDate;
    private Double qualification;
    private String qualificationComment;
}
