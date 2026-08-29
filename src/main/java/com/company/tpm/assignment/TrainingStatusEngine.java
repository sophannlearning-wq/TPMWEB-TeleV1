package com.company.tpm.assignment; import java.util.*; import org.springframework.stereotype.Component;
@Component public class TrainingStatusEngine { private static final Map<TrainingAssignment.Status,Set<TrainingAssignment.Status>> ALLOWED=Map.of(
 TrainingAssignment.Status.NOT_STARTED,Set.of(TrainingAssignment.Status.ASSIGNED,TrainingAssignment.Status.CANCELLED),
 TrainingAssignment.Status.ASSIGNED,Set.of(TrainingAssignment.Status.SCHEDULED,TrainingAssignment.Status.OVERDUE,TrainingAssignment.Status.CANCELLED),
 TrainingAssignment.Status.SCHEDULED,Set.of(TrainingAssignment.Status.IN_PROGRESS,TrainingAssignment.Status.OVERDUE,TrainingAssignment.Status.CANCELLED),
 TrainingAssignment.Status.IN_PROGRESS,Set.of(TrainingAssignment.Status.COMPLETED,TrainingAssignment.Status.FAILED),
 TrainingAssignment.Status.FAILED,Set.of(TrainingAssignment.Status.ASSIGNED,TrainingAssignment.Status.CANCELLED),
 TrainingAssignment.Status.COMPLETED,Set.of(TrainingAssignment.Status.EXPIRED),
 TrainingAssignment.Status.OVERDUE,Set.of(TrainingAssignment.Status.SCHEDULED,TrainingAssignment.Status.CANCELLED),
 TrainingAssignment.Status.EXPIRED,Set.of(TrainingAssignment.Status.ASSIGNED), TrainingAssignment.Status.CANCELLED,Set.of());
 public void validate(TrainingAssignment.Status from,TrainingAssignment.Status to){if(!ALLOWED.getOrDefault(from,Set.of()).contains(to))throw new IllegalStateException("Invalid training status transition: "+from+" -> "+to);}}
