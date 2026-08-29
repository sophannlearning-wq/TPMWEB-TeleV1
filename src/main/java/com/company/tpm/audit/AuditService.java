package com.company.tpm.audit;

import java.util.Map;
import java.util.UUID;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tools.jackson.databind.ObjectMapper;

@Service
public class AuditService {
    private final JdbcClient db;
    private final ObjectMapper json;

    public AuditService(JdbcClient d, ObjectMapper j) {
        db = d;
        json = j;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void record(String actor, String action, String target, UUID id, Map<String, ?> metadata) {
        try {
            db.sql("insert into audit_logs(actor,action,target,target_id,metadata) values(:a,:x,:t,:id,cast(:m as jsonb))")
                .param("a", actor)
                .param("x", action)
                .param("t", target)
                .param("id", id)
                .param("m", json.writeValueAsString(metadata))
                .update();
        } catch (Exception e) {
            throw new IllegalStateException("Audit write failed", e);
        }
    }
}

