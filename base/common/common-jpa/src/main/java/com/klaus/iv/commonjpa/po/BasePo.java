package com.klaus.iv.commonjpa.po;


import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private Date createDt;

    @LastModifiedDate
    private Date updateDt;

    @CreatedBy
    private Long createBy;

    @LastModifiedBy
    private Long updateBy;

    private DeleteFlag isDelete;

    @Getter
    public static enum DeleteFlag {
        N(0), Y(1);
        private int value;
        private DeleteFlag(int value) {
            this.value = value;
        }
    }

    @PrePersist
    public void onCreate() {
        isDelete = DeleteFlag.N;
    }



}
