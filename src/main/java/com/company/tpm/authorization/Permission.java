package com.company.tpm.authorization; import com.company.tpm.common.BaseEntity; import jakarta.persistence.*;
@Entity @Table(name="permissions") public class Permission extends BaseEntity { @Column(nullable=false,unique=true,length=100) private String code; private String description; protected Permission(){} public String getCode(){return code;} }
