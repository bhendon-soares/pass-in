package bhendonsoares.com.passin.dto.event;

public record EventDetailDTO
        (String id,
         String tile,
         String details,
         String slug,
         Integer maximumAttendees,
         Integer attendeesAmount
) {
}
