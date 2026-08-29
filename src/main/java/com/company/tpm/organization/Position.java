package com.company.tpm.organization; import com.company.tpm.common.BaseEntity; import jakarta.persistence.*;
@Entity @Table(name="positions") public class Position extends BaseEntity{@Column(nullable=false,unique=true)private String code;@Column(nullable=false)private String name;protected Position(){}public String getName(){return name;}}
